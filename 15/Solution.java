import java.util.*;
public class Solution {
public List<List<Integer>> threeSum(int[] A) {
	List<List<Integer>>res = new ArrayList<List<Integer>>();
	if (A == null || A.length == 0)
		return res;
    if(A.length < 3) return res;

    //sort, equal elements will be continuous
	Arrays.sort(A);
	for (int i = 0; i < A.length; i++) {
		if (i - 1 >= 0 && A[i] == A[i - 1]) continue;// Skip equal elements to avoid duplicates
		  
		int left = i + 1, right = A.length - 1; 
		while (left < right) {// Two Pointers
			int sum = A[i] + A[left] + A[right];
			if (sum == 0) { 
				res.add(Arrays.asList(A[i], A[left], A[right]));
				while (left + 1 < right && A[left] == A[left+1])// Skip equal elements to avoid duplicates
					left++;
				while (right -1 > left && A[right] == A[right-1])// Skip equal elements to avoid duplicates
					right--;
				left++; 
				right--;
			} else if (sum < 0) { 
				left++;
			} else {
				right--;
			}
		}
	}
	return res;
}
public static void main(String args[]){
    Solution s = new Solution();
    int[] array = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = s.threeSum(array);
    System.out.println(result.toString());
}

}