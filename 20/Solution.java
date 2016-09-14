import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[') stack.push(c);
            else if(c == '}'){if(stack.size() == 0) return false;char cc = stack.pop(); if(cc != '{') return false;}
            else if(c == ')'){if(stack.size() == 0) return false;char cc = stack.pop(); if(cc != '(') return false;}
            else if(c == ']'){if(stack.size() == 0) return false;char cc = stack.pop(); if(cc != '[') return false;}
            else return false;
        }
        if(stack.size() > 0)
            return false;
        return true;
    }

public static void main(String args[]){
    Solution s = new Solution();
    System.out.println(s.isValid("()"));
    System.out.println(s.isValid("(){}[]"));
}
}