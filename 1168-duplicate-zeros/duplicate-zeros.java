class Solution {
    public void duplicateZeros(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : arr){
            al.add(num);
            if(num == 0) al.add(0);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = al.get(i);
        }
    }
}