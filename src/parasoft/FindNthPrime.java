package parasoft;

import java.io.IOException;

public class FindNthPrime {

    /**
     * eg. 5th is 11
     * this is Dynamic Programming + only the prime which is less than square root of candidate whether can be divided by candidate
     * time complexity is m * n (we assume square root increase very slowly, so it approximate to a fixed number)
     * this is one form of sieveOfEratosthenes which time complexity is O(n * logn * logn)
     * be divided with no remainder;
     * cause given n, the less than n will get n/logn prime approximatlly  so the approximate tc is n^(1+e)
     * @param n
     * @return
     * @throws IOException
     */
    public static int findNthPrime(int n) throws IOException {
        if (n < 1)
            throw new IOException("parameter is not invalid!");
        if (n == 1)
            return 2;
        int[] cache = new int[n];
        int count = 2;
        cache[0] = 2;
        cache[1] = 3;
        int candidate = 4;
        while (count < n) {
            if (isPrime(cache, count, candidate)) {
                cache[count] = candidate;
                count++;
            }
            candidate++;
        }
        return cache[n - 1];
    }

    public static boolean isPrime(int[] cache, int count, int candidate) {
        for (int i = 0; i < count; i++) {
            if (cache[i] * cache[i] <= candidate) {
                if (candidate % cache[i] == 0) {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FindNthPrime.findNthPrime(5));
    }
}
