package ratings;

import java.util.*;

public class ProblemSet{

    public static int sumOfDigits(int number){
        int sum = 0;
        number = Math.abs(number);
        if(number == 0){
            return 0;
        }
        while(number > 0){
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    public static String bestKey(HashMap<String, Integer> hashMap){
        if(hashMap.isEmpty()){
            return "";
        }
        int largestInt = 0;
        int count = 0;
        String largestString = null;
        for(String key : hashMap.keySet()){
            int value = hashMap.get(key);
            if(value >= largestInt){
                largestInt = value;
                largestString = key;
            }
            else if(value < 0 && count == 0){
                largestInt = value;
                largestString = key;
            }
            count += 1;
        }
        return largestString;
    }

    public static double average(ArrayList<Double> list){
        if(list.isEmpty()){
            return 0.0;
        }

        double sum = 0.0;

        for(Double value : list){
            sum += value;
        }

        return sum / list.size();
    }
}
