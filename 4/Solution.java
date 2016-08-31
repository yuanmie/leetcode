public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;

        if(n == 0)
            return -1.0;

        int imin = 0, imax = m, half_len = (m + n + 1) / 2;
        int i, j, max_of_left = 0, min_of_right = 0;
        while(imin <= imax){
            i = (imax + imin) / 2;
            j = half_len - i;
            //the nums1[i] is too small
            if( j > 0 && i < m && nums2[j-1] > nums1[i]){
                imin = i + 1;

            //the nums1[i-1] is too big
            }else if(i > 0 && j < n && nums1[i-1] > nums2[j]){
                imax = i - 1;
            }
             //find the median, (nums1[i-1] < nums2[j] && nums1[j-1] < nums1[i])
            else{
            //
                if(i == 0){
                    max_of_left = nums2[j-1];
                }else if(j == 0){
                    max_of_left = nums1[i-1];
                }else{
                    max_of_left = Math.max(nums1[i-1], nums2[j-1]);
                }

                if((m + n) % 2 == 1){
                    return max_of_left;
                }

                if(i == m) min_of_right = nums2[j];
                else if (j == n) min_of_right = nums1[i];
                else min_of_right = Math.min(nums1[i], nums2[j]);

                return (max_of_left + min_of_right) / 2.0;
               
            }
        }
        return 0; 
    }
}