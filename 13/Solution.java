import java.util.*;
public class Solution{
public int romanToInt(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int len = s.length();
        int result = map.get(s.charAt(len-1));
        
        for(int i = 0; i<=len-2; i++){
            int value = map.get(s.charAt(i));
            int nextVal = map.get(s.charAt(i+1));
            
            if(value >= nextVal) {
                result += value;
            }
            else {
                result -= value;
            }
        }
        return result;
}

public static void main(String args[]){
    Solution s = new Solution();
   System.out.println(s.romanToInt("MMCM"));
}
}

//MMCM 2900