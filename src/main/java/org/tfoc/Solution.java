package org.tfoc;

import static java.lang.Math.min;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public int maxArea(int[] height) {

        int maxVolume = 0;
        if(height.length > 1) {
            int volume = 0;
            int leftMax = 0;
            int rightMin = height.length;
            int i=0;
            while(i < rightMin) {
                if(height[i] > leftMax) {
                    leftMax = height[i];
                    int j = height.length;
                    do {
                        j--;
                        if(j < rightMin)
                            rightMin = j;
                        volume = min(height[j], leftMax) * (j - i);
                        if (volume > maxVolume)
                            maxVolume = volume;
                    } while (height[j] < leftMax && j > i);
                }
                i++;
            }
        }
        return maxVolume;
    }

}
