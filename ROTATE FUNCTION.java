class Solution {
public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long F = 0;
        
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            F += (long)i * nums[i];
        }
        
        long result = F;
        
        for(int k = n-1 ; k >0 ; k--) {
            F = F - (nums[k]*(n-1)) + (sum-nums[k]);
            
            result = Math.max(result, F);
        }
        
        return (int)result;
    }
};
