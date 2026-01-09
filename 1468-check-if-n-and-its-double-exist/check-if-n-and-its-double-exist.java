class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(num%2==0){
                if(set.contains(num*2) || set.contains(num/2)) return true;
            }
            if(num%2==1){
                if(set.contains(num*2)) return true;
            }
            set.add(num);
        }
        return false;
    }
}