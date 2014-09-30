/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ProducerConsumer.java
 *         Created:   Sep 30, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   A producer thread enumerates all files in all subdirectories
 *                    a large number of consumer search threads
 *                    We uses a trick to terminate the application when no further work is required.
 *                    
 * All rights reserved.
 ******************************************************************************/
package java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
    static class FileEnumerationTask implements Runnable {
        public static File DUMMY = new File("");
        private ArrayBlockingQueue<File> queue;
        private File startingDir;

        public FileEnumerationTask(ArrayBlockingQueue<File> queue, File startingDir) {
            this.queue = queue;
            this.startingDir = startingDir;
        }

        @Override
        public void run() {
            try {
                enumerate(startingDir);
                queue.put(DUMMY);
            } catch (InterruptedException e) {

            }
        }

        public void enumerate(File dir) throws InterruptedException {
            File[] files = dir.listFiles();
            for (File iter : files) {
                if (iter.isDirectory()) {
                    enumerate(iter);
                } else {
                    queue.put(iter);
                }
            }
        }
    }

    static class SearchTask implements Runnable {
        private ArrayBlockingQueue<File> queue;
        private String keyword;

        public SearchTask(ArrayBlockingQueue<File> queue, String keyword) {
            this.queue = queue;
            this.keyword = keyword;
        }

        @Override
        public void run() {
            try {
                File file = this.queue.take();
                while (file != FileEnumerationTask.DUMMY) {
                    search(file);
                    file = this.queue.take();
                }
                this.queue.put(file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }
        }

        public void search(File file) throws IOException {
            try (Scanner in = new Scanner(file)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(this.keyword)) {
                        System.out.println(file.getPath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();
        String keyword = in.nextLine();
        in.close();
        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;
        ArrayBlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
        FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(dir));
        new Thread(enumerator).start();
        for (int i = 1; i < SEARCH_THREADS; i++) {
            new Thread(new SearchTask(queue, keyword)).start();
        }
    }
}
