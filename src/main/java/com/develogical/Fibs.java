package com.develogical;

public class Fibs {

    public String findFib(String s){
        String numString = s.split(" ")[3].replace("th", "");
        int num = 0;
        try {
            num = Integer.valueOf(numString);
        }
        catch (Exception e) {
            System.out.println("Fibs got exception with this input: " + s);
            System.out.println("Fibs: " + e.getMessage());
        }
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
