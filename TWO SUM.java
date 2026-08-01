class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int oth = target - nums[i];

            if (m.containsKey(oth)) {
                return new int[] { m.get(oth), i };
            }

            m.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
