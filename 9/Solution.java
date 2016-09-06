public class Solution {
   public boolean isPalindrome(int x) {
    //negetive integer and Multiples of 10 is not palidrome
    if (x<0 || (x!=0 && x%10==0)) return false;


    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }

    //x'length is odd or even
    return (x==rev || x==rev/10);
}
}