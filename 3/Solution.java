import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;

        Map<Character , Integer>  map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int count = 0;
        int delim = -1;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            int index = ((map.get(c) == null) ? -1 : map.get(c));
            if(index == -1){
                map.put(c, i);
                count++;
            }else{
                if(index < delim){
                     map.put(c, i);
                     count++;
                     continue;
                }
                if(count > maxLength){
                    maxLength = count;               
                }
                delim = index + 1;
                map.put(c, i);
                count= i - index;       
            }
        }
        if(count > maxLength){
            maxLength = count;
        }
        return maxLength;
    }
}
