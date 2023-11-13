package programmers.level1;

import java.util.Arrays;

public class Keypad {

//    numbers	                            hand	    result
//    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	    "right"	    "LRLLLRLLRRL"
//    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	    "left"	    "LRLLRRLLLRR"
//    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	    "LLRLLRLLRL"

    int[] leftNumber = {1,4,7};
    int[] rightNumber = {3,6,9};

    int[][] keypadArray = {{1,2,3},
                            {4,5,6},
                            {7,8,9},
                            {10,0,11}};
    int currentLeftIndex = 10;
    int currentRightIndex = 11;

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String answer = "";
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        Keypad keypad = new Keypad();
        keypad.solution(numbers, hand);

    }

    public String solution(int[] numbers, String hand) {

        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            boolean isLeft = Arrays.stream(leftNumber)
                .filter((key) -> key == number)
                .findAny()
                .isPresent();

            if (isLeft) {
                sb.append("L");
                currentLeftIndex = number;
                continue;
            }

            boolean isRight = Arrays.stream(rightNumber)
                .filter((key) -> key == number)
                .findAny()
                .isPresent();

            if (isRight) {
                sb.append("R");
                currentRightIndex = number;
                continue;
            }

            int[] toPress = convertNumbersToXY(number);
            int[] currentRight = convertNumbersToXY(currentLeftIndex);
            int[] currentLeft = convertNumbersToXY(currentRightIndex);
            int leftDistance = calculateDistance(toPress, currentRight);
            int rightDistance = calculateDistance(toPress, currentLeft);


            if(leftDistance > rightDistance) {
                sb.append("R");
                currentRightIndex = number;
            }
            else if(leftDistance < rightDistance) {
                sb.append("L");
                currentLeftIndex = number;
            }
            else {
                if(hand.equals("left")) {
                    sb.append("L");
                    currentLeftIndex = number;
                }else {
                    sb.append("R");
                    currentRightIndex = number;
                }

            }

        }

        System.out.println("answer = " + sb.toString());
        return sb.toString();
    }

    public int[] convertNumbersToXY(int num) {
        int[] xy = new int[2];

        for(int i = 0; i < keypadArray.length; i++) {
            for(int j = 0; j < keypadArray[i].length; j++) {
                if(keypadArray[i][j] == num) {
                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }

        return xy;
    }

    public int calculateDistance(int[] x, int[] y) {
        int xDistance = x[0] - y[0] > 0 ? x[0] - y[0] : y[0] - x[0];
        int yDistance = x[1] - y[1] > 0 ? x[1] - y[1] : y[1] - x[1];

        return xDistance + yDistance;
    }

}
