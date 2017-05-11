// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Subscribe to see which companies asked this question.

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for (int i=0; i<nums.length; i++) {
            int t=target-nums[i];
            int left=i+1;
            int right=nums.length-1;
            while (left<right) {
                int sum=nums[left]+nums[right];
                if (t==sum) {
                    return target;
                }
                if (t<sum) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(res-target)>Math.abs(sum-t)) {
                    res=sum+nums[i];
                }
            }
        }
        return res;
    }
}