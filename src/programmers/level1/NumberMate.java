package programmers.level1;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberMate {

//  X	    Y	        result
//  "100"	"2345"	    "-1"
//  "100"	"203045"	"0"
//  "100"	"123450"	"10"
//  "12321"	"42531"	    "321"
//  "5525"	"1255"	    "552"

    public static void main(String[] args) {

        String x = "12321";
        String y = "42531";

        NumberMate numberMate = new NumberMate();
        String answer = numberMate.solution(x, y);
        System.out.println("answer = " + answer);
    }
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        StringBuilder result = new StringBuilder();

        for (int digit = 9; digit >= 0; digit--) {
            int countInX = countX[digit];
            int countInY = countY[digit];

            int commonCount = Math.min(countInX, countInY);
            if (commonCount > 0) {
                result.append(String.valueOf(digit).repeat(commonCount));
            }
        }

        String resultStr = result.toString();
        if(resultStr.isEmpty())
            return "-1";
        else if (resultStr.charAt(0) == '0') {
            return "0";
        }else {
            return resultStr;
        }
    }
}
