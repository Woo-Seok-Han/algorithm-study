package programmers.level1;

import java.util.Arrays;

//문제 설명
//        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
//        단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
//        예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

//제한 조건
//        arr은 길이 1 이상인 배열입니다.
//        인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

//입출력 예
//        arr       |	return
//        ---------------------
//        [4,3,2,1]	| [4,3,2]
//        [10]	    | [-1]

public class RemoveSmallest {
    public int[] solution(int[] arr) {
        // 가장 작은 수를 제거한 배열을 리턴

        // 1. 정렬을 통한 가장 작은 수 추출
        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        int smallest = sortedArray[0];

        // 2. 가장 작은 수와 기존 배열 비교 후 해당 값을 가지고 있는 배열 제거
        int[] answer = Arrays.stream(arr)
                .filter((element) -> smallest != element)
                .toArray();

        // 3. answer 가 한개도 없으면 -1 넣어서 return
        if(answer.length == 0) return new int[]{-1};

        return answer;
    }
}
