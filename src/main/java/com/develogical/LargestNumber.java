package com.develogical;

public class LargestNumber {
    public LargestNumber() {
    }

    String findLargestNumber(String nums) {
        int largest = -1;
        for (String num : nums.split(",")) {
            int i = Integer.valueOf(num);
            if (i > largest) {
                largest = i;
            }
        }
        return "" + largest;
    }
}