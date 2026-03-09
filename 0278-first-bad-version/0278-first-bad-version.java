/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {            // since the order is like F F F F T T T T T T....
        int low = 1, high = n;                     // So , we can observe that after a certain point all are T...
        while(low<high){                           // So we can apply binary search
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){                 // if the current standing point is T, then it might be our answer or it can be in the LEFT
                high = mid;
            }
            else{                                  // if the current standing point is F, then we can discard the left half as all are T only
                low = mid + 1;                     // and search space reduced to low= mid + 1
            }
        }
        return high;                               // when low crosses high....its for sure that high will be pointing to the first T
    }
}