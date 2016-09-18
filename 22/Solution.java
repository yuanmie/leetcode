public class Solution {
    /*
    *产生的顺序不对
    */
    // public List<String> generateParenthesis(int n) {
    //     List<String> result = new ArrayList<String>();
    //     if(n == 0){result.add(""); return result;}
    //     String leftp = "(";
    //     String rightp = ")";
    //     List<String> rec = generateParenthesis(n-1);
    //     for(String str : rec){
    //         String middleFirst = leftp + str + rightp;
    //         if(!result.contains(middleFirst)){
    //             result.add(middleFirst);
    //         }
    //     }
    //     for(String str : rec){
    //         String leftFirst = str + leftp + rightp;     
            
    //          if(!result.contains(leftFirst)){
    //             result.add(leftFirst);
    //         }
    //     }
    //     for(String str : rec){          
    //         String rightFirst = leftp + rightp + str;
    //          if(!result.contains(rightFirst)){
    //             result.add(rightFirst);
    //         }
    //     }
    //     return result;
    // }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}