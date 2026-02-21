class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        int i=0,j=0;
        int m=nums1.length, n=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                temp.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] a = new int[temp.size()];
        for(int k=0;k<a.length;k++){
            a[k] = temp.get(k);
        }
        return a;
    }
}