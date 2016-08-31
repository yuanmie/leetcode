import java.util.Arrays;
public class Solution {
    // public String longestPalindrome(String s) {
    //     int length = s.length();
    //     if(length <= 1)
    //         return s;
    //     String str;
    //     String maxStr = "";
    //     int maxl = 0;
    //     for(int i = 0; i < length; i++){
    //         for(int j = i+1; j < length; j++){
    //             if(s.charAt(j) == s.charAt(i)){
    //                 str = s.substring(i, j+1);
    //                 if(ispan(str)){
    //                     if(str.length() > maxl){
    //                         maxl = str.length();
    //                         maxStr = str;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return maxStr;
    // }

    // private boolean ispan(String str){
    //     return str.equals(new StringBuilder(str).reverse().toString());
    // } 



    // public String longestPalindrome(String s) {
    //     String res = "";
    //     int currLength = 0;
    //     for(int i=0;i<s.length();i++){
    //         if(isPalindrome(s,i-currLength-1,i)){
    //             res = s.substring(i-currLength-1,i+1);
    //             currLength = currLength+2;
    //         }
    //         else if(isPalindrome(s,i-currLength,i)){
    //             res = s.substring(i-currLength,i+1);
    //             currLength = currLength+1;
    //         }
    //     }
    //     return res;
    // }
    
    // public boolean isPalindrome(String s, int begin, int end){
    //     if(begin<0) return false;
    //     while(begin<end){
    //     	if(s.charAt(begin++)!=s.charAt(end--)) return false;
    //     }
    //     return true;
    // }

    public String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        int maxL = 0;
        boolean[][] p = new boolean[length][length];

        for(int i = 0; i < length; i++){
            p[i][i] = true;
            maxL = 1;
        }

         for(int i = 0; i < length - 1; i++){
             if(s.charAt(i) == s.charAt(i+1)){
                 p[i][i+1] = true;
                 if(maxL < 2){
                     maxL = 2;
                     result = s.substring(i,i+2);
                 }
             }
        }

        for(int offset = 2; offset < length; offset++){
            for(int i = 0; i + offset < length; i++){
                if(p[i+1][i+offset-1] && s.charAt(i) == s.charAt(i+offset)){
                    if(offset+1 > maxL){
                        maxL = offset+1;
                        result = s.substring(i, i+offset+1);
                    }
                    p[i][i+offset] = true;
                }
            }
        }

        if(maxL < 2){
            return s;
        }
         return result;
    }
}

/*
s:  abacba
sr: abcaba
*/