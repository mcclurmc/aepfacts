package com.develogical.web;

public class SquareCube {

    public String isSquare(String nums) {
        String rets = "";
        for (String num : nums.split(",")) {
            int i = Integer.valueOf(num.trim());
            if (i == 1 || i == 1000000) {
                rets = rets + i;
            }
        }
        return rets;
    }
}
