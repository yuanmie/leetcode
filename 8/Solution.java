public class Solution {
public class Solution {
    public int myAtoi(String str) {
        //normal case
        char[] a = str.toCharArray();
        int i = -1;
        int length = a.length;
        int negative = 1;
        int result = 0;
        boolean valid = false;
        boolean first = false;
        while(++i < length){
            //erase whitesapce
            if(!first && a[i] == ' ') continue;
            if(a[i] == '-'){
            	if(first == true)
            		break;
            	first = true;
                negative = -1;
            }
            else if(a[i] == '+'){
            	if(first == true)
            		break;
            	first = true;
            }
            else if('0' <= a[i] && a[i] <= '9'){
            	first = true;
                valid = true;
                //overflow
                if(negative == 1 && (result > Integer.MAX_VALUE / 10 || ((result == Integer.MAX_VALUE/10) && (a[i] - '0') > (Integer.MAX_VALUE % 10))) ){
                    return Integer.MAX_VALUE;
                }else if(negative == -1 && (negative * result < Integer.MIN_VALUE / 10 || (negative * result == Integer.MIN_VALUE/10 && negative * (a[i] - '0') < (Integer.MIN_VALUE % 10)))){
                	return Integer.MIN_VALUE;
                }
                result = result * 10 + (a[i] - '0');
            }else{
                    break;
            }
        }
        if(!valid)
            return 0;
        return negative * result;
    }
}
    
    // public static void main(String args[]){
    // 	Solution s = new Solution();
    // 	System.out.println(s.myAtoi("123"));
    // 	System.out.println(s.myAtoi(String.valueOf(Integer.MIN_VALUE)));
    // 	System.out.println(s.myAtoi("-2147483647"));
    // 	System.out.println(s.myAtoi("+2147483647"));
    // 	System.out.println(s.myAtoi("+4147483647"));
    // 	System.out.println(s.myAtoi("2147483647"));
    // 	System.out.println(s.myAtoi("-"));
    // 	System.out.println(s.myAtoi("-a"));
    // 	System.out.println(s.myAtoi("-2a"));
    // 	System.out.println(s.myAtoi("    "));
    // }
}