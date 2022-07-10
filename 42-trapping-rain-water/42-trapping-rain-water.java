class Solution {
    public int trap(int[] height) {
        int leftBarHeight[] = new int[height.length];
        int rightBarHeight[] = new int[height.length];

        leftBarHeight[0] = height[0];
        rightBarHeight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < leftBarHeight.length; i++) {
            if (height[i] > leftBarHeight[i - 1]) {
                leftBarHeight[i] = height[i];
            } else {
                leftBarHeight[i] = leftBarHeight[i - 1];
            }
        }
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < rightBarHeight[i + 1]) {
                rightBarHeight[i] = rightBarHeight[i + 1];
            } else {
                rightBarHeight[i] = height[i];
            }
        }
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftBarHeight[i], rightBarHeight[i]);
            water += min - height[i];
        }
        // System.out.println(water);
        return water;
    }
}