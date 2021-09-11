class Solution {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxWater = 0;

        while (i < j) {
            int length = j - i;
            int high = Math.min(height[i], height[j]);
            int water = length * high;

            maxWater = Math.max(maxWater, water);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }

}