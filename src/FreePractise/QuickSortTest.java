package FreePractise;

public class QuickSortTest {
    public static int partition(int[] a, int p, int r) {

        int x = a[p];
        int i = p-1 ;
        int j = r+1 ;

        while (true) {
            i++;
            while ( i< r && a[i] < x)
                i++;
            j--;
            while (j>p && a[j] > x)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        int[] test = {3, 4, 2, 3};
        int q = QuickSortTest.partition(test, 0, 3);
        System.out.println(q);
        for(int i = 0; i < test.length; i++)
        System.out.print(test[i] + " ");
    }
}
