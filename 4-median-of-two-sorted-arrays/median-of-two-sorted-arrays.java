class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int i=0,j=0, count = 0,curr=0,prev=0;
        int req = total%2;
        while(i<n1 && j<n2){
            prev = curr;
            if(nums1[i]<=nums2[j]){
                curr = nums1[i];
                i++;
            }
            else{
                curr = nums2[j];
                j++;
            }
            if(count == total/2){
                if(req == 1) return 1.0*curr;
                else{
                    return (curr + prev)/2.0;
                }
            }
            count++;
        }
        while(i<n1){
            prev = curr;
            curr = nums1[i];
            if(count == total/2){
                if(req == 1) return 1.0*curr;
                return (curr + prev)/2.0;
            }
            i++;
            count++;
        }
        while(j<n2){
            prev = curr;
            curr = nums2[j];
            if(count == total/2){
                if(req == 1) return 1.0*curr;
                return (curr + prev)/2.0;
            }
            j++;
            count++;
        }
        return 0;
    }
}