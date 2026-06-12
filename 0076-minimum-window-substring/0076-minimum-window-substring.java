class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i=0;i<t.length();i++){  // Store the frequency of chars that is needed
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0)+1);
        }
        int left=0, matched=0;
        int minLen = Integer.MAX_VALUE, start = 0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);
            if(need.containsKey(ch) && window.get(ch)<=need.get(ch)){   // If curr char is in NEED and it satisfies the requirement
                matched++;                                              // Increment matched
            }
            while(matched == t.length()){   // requirements is fulfilled
                if(right-left+1 < minLen){  // calculate the length and check if its less than prev window that satisfied the requirements
                    minLen = right-left+1;  // store it
                    start = left;           // the moment we discover a better window , the left boundary is exactly where that candidate answer begins.
                }
                char leftChar = s.charAt(left);                                               //    ---|
                if(need.containsKey(leftChar) && window.get(leftChar)<=need.get(leftChar)){   //       |
                    matched--;                                                                //       |
                }                                                                             //       |---->> The moment we get valid window we need to shrink window size to 
                window.put(leftChar, window.get(leftChar)-1);                                 //       |       get the min window substring, and during that if requirement is 
                left++;                                                                       //    ---|       also deleted, then decrement 'matched' & then freq of char in window
            }                                                                                 //               is also decreased
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}