package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KthsNumber {

    public static void main(String[] args) {

//        array	                commands	                        return
//        [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthsNumber kthsNumber = new KthsNumber();
        kthsNumber.solution(array, commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < commands.length; i++) {
            int[] sliced = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            int anInt = Arrays.stream(sliced).sorted()
                .toArray()[commands[i][2] - 1];
            answerList.add(anInt);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
