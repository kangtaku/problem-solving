class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        int i, j, n = heights.length;
        for (;V > 0; V--) {
            int start = K, leftIdx = -1, rightIdx = -1;
            boolean poured = false;
            for (i = start - 1; i >= 0; i--) {
                if (heights[i] < heights[i + 1]) {
                    leftIdx = i;
                } else if (heights[i] > heights[i + 1]) break;
            }
            for (i = start + 1; i < n; i++) {
                if (heights[i] < heights[i - 1])  {
                    rightIdx = i;
                } else if (heights[i] > heights[i - 1]) break;
            }
            if (leftIdx == -1 && rightIdx == -1) heights[start]++;
            else if (leftIdx != -1) {
                heights[leftIdx]++;
            } else heights[rightIdx]++;
        }
        return heights;
    }
}
