package com.develogical;

public class Fibs {

    public String findFib(String s){
        String numString = s.split(" ")[4].replace("th", "");
        int num = Integer.valueOf(numString);
        return "" +calcFib(num);
        
    }

    private int calcFib(int num) {
        int prev1=0, prev2=1;
        for(int i=0; i<num; i++) {
            int savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }
}
