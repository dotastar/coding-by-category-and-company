package Parasoft;

public class question2 {

    /**
     * find nth prime; eg. 5th is 11
     * 
     * @param n
     * @return
     */
    public static int getNthPrimeNumber(int n) {
        if(n == 0)
            return 0;
        int candidate = 2;
        int i = 0;
        while (i < n) {
            boolean isPrime = true;
            for (int j = 2; j < candidate; j++) {
                if (candidate % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                i++;
            }
            candidate += i < n ? 1 : 0;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(question2.getNthPrimeNumber(5));
    }
}
