public class Problem1 {

    // Simple sliding window solution
    // TC : O(nk)
    // SC : O(1)
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == k) return k;

        int left = 0;
        int right = 0;
        int result = 0;

        int n = nums.length;

        while (left < n && right < n) {

            if (k >= 0) {
                if (nums[right] == 0) {
                    k--;
                }
                if (k >= 0) {
                    result = Math.max(result, right - left + 1);
                }
                right++;
            } else {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return result;
    }

    // Optimized sliding window
    // TC : O(n)
    // SC : O(1)
    public int longestOnes1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == k) return k;

        int left = 0;
        //int right = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return i - left;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(problem1.longestOnes(nums, 0));
    }
}
