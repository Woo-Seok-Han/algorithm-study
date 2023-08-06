package programmers.level1;

import java.util.Stack;

public class StackSimulation {

    public static void main(String[] args) {

        StackSimulation solution = new StackSimulation();

        int[][] board = {{0,0,0,0,0},{0,0,0,0,0},{0, 4, 4, 0},{1, 2, 2, 1}};
        int[] moves = {2, 3, 1, 4, 2, 3};

        int answer = solution.solution(board, moves);
        System.out.println("answer = " + answer);
    }

    public int solution(int[][] board, int[] moves) {

        Stack<Integer> basket = new Stack<>();
        int tmp = 0;
        int answer = 0;

        for(int m = 0; m < moves.length; m++) {
            for(int i = 0; i < board.length; i++) {
                int target = board[i][moves[m] -1];
                if(target != 0) {

                    if(!basket.isEmpty() && basket.peek() == target) {
                        basket.pop();
                        answer+=2;
                    } else {
                      basket.push(target);
                    }

                    board[i][moves[m] -1] = 0;
                    break;
                }
            }
        }

        return answer;
    }



}
