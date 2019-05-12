package leetcode413;

/**
 * Created by vinitgaikwad on 5/12/19.
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int ret = 0;
        for(int i =0 ; i< A.length-1; i++) {

            int diff = A[i+1] - A[i];
            for(int j = i+2 ; j < A.length; j++) {

                if(diff == A[j] - A[j-1]) {
                    ret++;
                } else
                    break;



            }
        }

        return ret;
    }
}
