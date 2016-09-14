import java.util.*;
public class Solution {
    String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        return letterCombinationsRecursive(digits);
    }

    public List<String> letterCombinationsRecursive(String str){
       
        List<String> result = new ArrayList<String>();
        if(str.length() < 1) return result;
        String letters = mapping[str.charAt(0) - '0'];
        if(str.length() == 1){
             for(int i = 0; i < letters.length(); i++)
                result.add(letters.charAt(i)+"");
            return result;
        }
       
        List<String> res = letterCombinationsRecursive(str.substring(1));
      
        if(res == null){
           for(int i = 0; i > letters.length(); i++)
                result.add(letters.charAt(i)+"");
            return result;
        }
        for(int i = 0; i < letters.length(); i++){
            for(String s : res){
                result.add(letters.charAt(i)+s);
            }
        }
        return result;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        List<String> list = s.letterCombinations("23");
        for(String str : list) System.out.println(str);
    }
}