class Solution{
    public List<Integer> countSmaller(int[] nums){
        List<Integer> ans=new ArrayList<>();
        int mx=20001;
        ST obj=new ST(mx);

        for(int i=nums.length-1;i>=0;i--){
            int x=nums[i]+10000;
            int smallerThanX=(int)obj.rangeQuery(0,x-1);
            ans.add(smallerThanX);
            obj.incFreq(x);
        }

        Collections.reverse(ans);
        return ans;
    }
}

class ST{
    long[] st;
    int mxVal;

    public ST(int mxVal){
        st=new long[4*(mxVal+1)];
        this.mxVal=mxVal;
    }

    long rangeQuery(int l,int r){
        if(l>r) return 0;
        return rangeHelper(0,0,mxVal,l,r);
    }

    long rangeHelper(int idx,int ss,int se,int qs,int qe){
        if(qe<ss||qs>se) return 0;
        if(qs<=ss&&se<=qe) return st[idx];

        int mid=ss+(se-ss)/2;
        long lhs=rangeHelper(2*idx+1,ss,mid,qs,qe);
        long rhs=rangeHelper(2*idx+2,mid+1,se,qs,qe);

        return lhs+rhs;
    }

    void incFreq(int idx){
        update(0,0,mxVal,idx);
    }

    void update(int node,int ss,int se,int idx){
        if(ss==se){
            st[node]++;
            return;
        }

        int mid=ss+(se-ss)/2;

        if(idx<=mid)
            update(2*node+1,ss,mid,idx);
        else
            update(2*node+2,mid+1,se,idx);

        st[node]=st[2*node+1]+st[2*node+2];
    }
}