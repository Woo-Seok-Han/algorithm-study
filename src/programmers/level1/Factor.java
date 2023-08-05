package programmers.level1;

class Factor {

    public static void main(String[] args) {
        Factor factor = new Factor();

        int number = 10;
        int limit = 3;
        int power = 2;

        factor.solution(number, limit, power);
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        // 약수 구하기
        for(int j = 1; j <= number; j++) {

            int count = 0;
            int sqrted = (int)Math.sqrt(j);

            for (int i = 1; i <= sqrted; i++) {
                if (j % i == 0) {
                    count++;
                    if (j / i != i) {
                        count++;
                    }
                }
            }

            if(count > limit) count = power;

            answer += count;

        }

        return answer;
    }
}