package NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args){
        System.out.println(new NQueens().solveNQueens(5).size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder placeholder = generatorPlaceholder(n);
        int[] board = new int[n];

        for(int i = 0; i < n; i++){
            board[0] = i;
            nQueensSolution(board, 1, n, result, placeholder);
        }

        return result;
    }

    public static void nQueensSolution(int[] board, int row, int n, List<List<String>> result, StringBuilder placeholder){

        if(row == n){
            printBoard(board, n,result,placeholder);
            return;
        }

        for(int col = 0; col < n; col++) {

            boolean valid = true;

            for (int j = 0; j < row; j++) {
                if ((board[j] == col) || (Math.abs(row - j) == Math.abs(col - board[j]))) {
                    valid = false;
                    break;
                }
            }

            if(valid){
                board[row] = col;
                nQueensSolution(board, row + 1, n, result,placeholder);
            }
        }
    }



    public static void printBoard(int[] board, int n, List<List<String>> result, StringBuilder placeholer){

        List<String> resultItem = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringBuilder new_str = new StringBuilder(placeholer);
            StringBuilder item = new_str.replace(board[i], board[i] + 1, "Q");
            resultItem.add(item.toString());
        }

        result.add(resultItem);
    }

    private static StringBuilder generatorPlaceholder(int n){
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < n; i++){
            str.append(".");
        }

        return str;
    }
}
