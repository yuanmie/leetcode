import java.util.Arrays;
public class Solution {
    // public int threeSumClosest(int[] nums, int target) {
    //     if(nums == null || nums.length < 3) return 0;
    //     int offset = Integer.MAX_VALUE;
    //     int length = nums.length;
    //     int result = 0;
    //     for(int i = 0; i < length; i++){
    //         for(int j = i+1; j < length; j++){
    //             for(int k = j+1; k < length; k++){
    //                 int sum = nums[i] + nums[j] + nums[k];
    //                 if(Math.abs(sum - target) < offset){
    //                     offset = Math.abs(sum - target);
    //                     result = sum;
    //                 }
    //             }
    //         }
    //     }

    //     return result;
    // }
 public int threeSumClosest(int[] nums, int target) {
    int result = Integer.MAX_VALUE;
    int offset = Integer.MAX_VALUE;
	if (nums == null || nums.length == 0)
		return result;
    if(nums.length < 3) return result;

    //sort, equal elements will be continuous
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
		if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;// Skip equal elements to avoid duplicates
		  
		int left = i + 1, right = nums.length - 1; 
		while (left < right) {// Two Pointers
			int sum = nums[i] + nums[left] + nums[right];
            int temp = Math.abs(sum - target);
			if (temp < offset) {
                result = sum;
                offset = temp;
                if(sum == target)
                    break; 	
			} 
            if (sum > target) right--;
            else left++;
		}
	}
	return result;
    }
    public static void main(String args[]){
    Solution s = new Solution();
    int[] array = new int[]{-1 ,2 ,1 ,-4};
    int result = s.threeSumClosest(array, 1);
    System.out.println(result);
}
}