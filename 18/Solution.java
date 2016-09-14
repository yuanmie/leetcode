import java.util.*;
public class Solution {
public List<List<Integer>> fourSum(int[] A, int target) {
	List<List<Integer>>res = new ArrayList<List<Integer>>();
	if (A == null || A.length == 0)
		return res;
    if(A.length < 3) return res;

    //sort, equal elements will be continuous
	Arrays.sort(A);
	for (int i = 0; i < A.length; i++) {
		if (i - 1 >= 0 && A[i] == A[i - 1]) continue;// Skip equal elements to avoid duplicates
		for(int j = i+1; j < A.length; j++){
            if (j - 1 >= i+1 && A[j] == A[j - 1]) continue;// Skip equal elements to avoid duplicates
		int left = j + 1, right = A.length - 1; 
		while (left < right) {// Two Pointers
			int sum = A[i] + A[left] + A[right]+A[j];
			if (sum == target) { 
				res.add(Arrays.asList(A[i],A[j],A[left], A[right]));
				while (left + 1 < right && A[left] == A[left+1])// Skip equal elements to avoid duplicates
					left++;
				while (right -1 > left && A[right] == A[right-1])// Skip equal elements to avoid duplicates
					right--;
				left++; 
				right--;
			} else if (sum < target) { 
				left++;
			} else {
				right--;
			}
		}
        }
	}
	return res;
}
}