package com.develogical;

public class Primes {
    String findPrime(String nums) {
        String rets = "";
        for (String num : nums.split(",")) {
            int i = Integer.valueOf(num.trim());
            if (isPrime(i)) {
                if (rets == "")
                    rets = rets + i;
                else
                    rets = rets + "," + i;
            }
        }
        return rets;
    }

    private boolean isPrime(int i) {
        for(int x = 2; x< i; i++){
            if(i%x == 0){
                return false;
            }

        }
        return true;  //To change body of created methods use File | Settings | File Templates.
    }
}
