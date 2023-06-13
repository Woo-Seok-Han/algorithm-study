package programmers.level1;

import java.util.*;
import java.util.stream.IntStream;

public class UsingArrayToHashMap {
    public static void main(String[] args) {

        // 문제 설명
        /**
         * 문제 설명
         * 사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다.
         * 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다.
         * 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고
         * 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다.
         * 다른 사진 속 인물의
         * 이름이 ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고
         * , "tony"는 그리움 점수가 없을 때,
         * 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.
         *
         * 그리워하는 사람의 이름을 담은 문자열 배열 name,
         * 각 사람별 그리움 점수를 담은 정수 배열 yearning,
         * 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때,
         * 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
         *
         */

        /**
         * 입출력 예
         * name	                            yearning	    photo	                            result
         * ["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may", "kein", "kain", "radi"],   [19, 15, 6]
         *                                                   ["may", "kein", "brin", "deny"],
         *                                                   ["kon", "kain", "may", "coni"]]
         *
         * ["kali", "mari", "don"]	        [11, 1, 55]	    [["kali", "mari", "don"],           [67, 0, 55]
         *                                                  ["pony", "tom", "teddy"],
         *                                                  ["con", "mona", "don"]]
         *
         * ["may", "kein", "kain", "radi"]  [5, 10, 1, 3]   [["may"],["kein", "deny", "may"],   [5, 15, 0]
         *                                                  ["kon", "coni"]]
         */

        // test 용
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};

        String[][] photo = {
                {"may", "kein", "kain", "radi"}
                , {"may", "kein", "brin", "deny"}
                , {"kon", "kain", "may", "coni"}
        };

        // 1. HashedMap 생성
        Map<String, Integer> mappedInfo = mapNameAndYearning(name, yearning);
        // 2. 생성된 Map 을 기반이로 합계 계산
        int[] sums = calculateYearningByMappedInfo(mappedInfo, photo);

        System.out.println("Arrays.toString(sums) = " + Arrays.toString(sums));

    }

    /**
     * name 과 yearning 매핑
     * @param name
     * @param yearning
     * @return
     */
    public static Map<String, Integer> mapNameAndYearning(String[] name, int[] yearning){

        Map<String, Integer> map = IntStream.range(0, name.length)
                .boxed()
                .collect(HashMap::new, (m, i) -> m.put(name[i], yearning[i]), HashMap::putAll);

        // 매핑 결과 출력
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        return map;
    }

    /**
     * 매핑된 정보를 기반으로 사진에 대한 그리움 정도 점수 합계
     * @param mappedInfo
     * @param photo
     * @return
     */
    public static int[] calculateYearningByMappedInfo(Map<String, Integer> mappedInfo, String[][] photo){
        List<Integer> result = new ArrayList<>();

        for (String[] names : photo) {
            result.add(Arrays.stream(names).mapToInt(name -> {
                System.out.println("name : " + name);
                return mappedInfo.containsKey(name) ? mappedInfo.get(name) : 0;
            }).sum());
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
