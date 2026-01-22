class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int num:nums) list.add(num);
            int operations=0;
            while(!isNonDecreasing(list)){
                int minSum=Integer.MAX_VALUE;
                int index=-1;
                for(int i=0;i<list.size()-1;i++){
                    int sum=list.get(i)+list.get(i+1);
                    if(sum<minSum){
                        minSum=sum;
                        index=i;
                    }
                }
                int sum=list.get(index)+list.get(index+1);
                list.set(index,sum);
                list.remove(index+1);
                operations++;
            }
            return operations;
        }
     private static boolean isNonDecreasing(List<Integer> list){
                for(int i=0;i<list.size()-1;i++){
                    if(list.get(i)>list.get(i+1)) return false;
                }
                return true;
    }
}