package dp;

/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser {
    private int[] stampDenominations;

    /**
     * Constructs a new StampDispenser that will be able to dispense the given
     * types of stamps.
     * 
     * @param stampDenominations
     *            The values of the types of stamps that the
     *            machine should have. Should be sorted in descending order and
     *            contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations) {
        this.stampDenominations = new int[stampDenominations.length];
        System.arraycopy(stampDenominations, 0, this.stampDenominations, 0, stampDenominations.length);
    }

    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     * 
     * @param request
     *            The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request) {
        //if stampDenominations only have 1 element, it must be 1. So the func should return the request directly for speed.
        if (this.stampDenominations.length == 1 && this.stampDenominations[0] == 1) {
            return request;
        }
        int max = Integer.MIN_VALUE;//max is the maximum stamp denomination value less than request 
        for (int i = 0; i < this.stampDenominations.length; i++) {
            max = this.stampDenominations[i] >= max && this.stampDenominations[i] <= request ? this.stampDenominations[i]
                    : max;
        }
        int[] minValue = new int[max];//create array with size of max to be used as circular array. By doing this, it decreases the space complexity from O(request) to O(max)
        for (int i = 1; i > 0 && i <= request; i += 1) {
            int curMin = -1;
            for (int j = 0; j < this.stampDenominations.length; j++) {
                int temp = (i - this.stampDenominations[j]) % max;
                if (i - this.stampDenominations[j] >= 0 && minValue[temp] != -1) {// f(i) = Min{f(i - stampDe[0]) + 1, f(i - stampDe[1]) + 1, ..., f(i - stampDe[length - 1]) + 1}
                    curMin = curMin != -1 ? Math.min(curMin, minValue[temp] + 1) : minValue[temp] + 1;
                }
            }
            minValue[i % max] = curMin;//update minValue[i] using circular array.
        }
        return minValue[request % max];
    }

    public static void main(String[] args) {
        //unit test
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
        int[] denominations2 = { 1 };
        StampDispenser stampDispenser2 = new StampDispenser(denominations2);
        assert stampDispenser2.calcMinNumStampsToFillRequest(Integer.MAX_VALUE) == Integer.MAX_VALUE;
        int[] denominations3 = { 9000, 5000, 3000, 200, 1, 2, 10 };
        StampDispenser stampDispenser3 = new StampDispenser(denominations3);
        assert stampDispenser3.calcMinNumStampsToFillRequest(30013) == 7;
        int[] denominations4 = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser4 = new StampDispenser(denominations4);
        assert stampDispenser4.calcMinNumStampsToFillRequest(108) == 4;
        System.out.println("Test finished!");
    }
}
