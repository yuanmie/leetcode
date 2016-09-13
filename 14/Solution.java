public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String LCP = "";
        int index = 0;
        String str = "";
        if(strs.length > 0) LCP = strs[0];

        for(int i = 1; i < strs.length; i++){
            if(LCP.length() < 1) break;
            str = strs[i];
            while(index < str.length() && index < LCP.length() && str.charAt(index) == LCP.charAt(index) ) index++;
            LCP = LCP.substring(0, index);
            index = 0;
        }

        return LCP;
    }
}