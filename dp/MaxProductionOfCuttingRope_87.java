package dp;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts
 * with length p[0], p[1], ...,p[m-1], in order to get the maximal product of
 * p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0
 * (at least one cut must be made). Return the max product you can have.
 */
public class MaxProductionOfCuttingRope_87 {
    public int maxProductionOfCuttingRope(int n) {
        // assume n > 1
        // assume at least one cut
        // the element in index means the max production when the rope length is index
        int[] max = new int[n + 1];
        // max[0] and max[1] is not valid cases
        max[1] = 1;	// for calculation consistency
        // i is the length of the rope
        for (int i = 2; i <= n; i++) {
            // cut is the first cut position
            for (int cut = 1; cut <= i / 2; cut++) {
                int curProduction = Math.max(cut, max[cut]) * Math.max(i - cut, max[i - cut]);
                max[i] = Math.max(curProduction, max[i]);
            }
        }
        return max[n];
    }

}
