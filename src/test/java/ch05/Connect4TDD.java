package ch05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Connect4TDD {

    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final String EMPTY = " ";

    private String[][] board = new String[ROWS][COLUMNS];

    public Connect4TDD() {
        for (String[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public int getNumberOfDiscs(){
        return IntStream.range(0, COLUMNS)
                .map(this::getNumberOfDiscsInColumn).sum();
    }

    /** 해당 칼럼에 empty 가 아닌 값을 count() */
    private int getNumberOfDiscsInColumn(int column){
        System.out.println("column = " + column);
        return (int) IntStream.range(0, ROWS)
                .filter(row -> !EMPTY.equals(board[row][column])).count();
    }

    public int putDiscInColumn(int column){
        checkColumn(column);
        int row = getNumberOfDiscsInColumn(column);
        checkPositionToInsert(row, column);
        board[row][column] = "X";
        return row;
    }

    private void checkColumn(int column){
        if (column < 0 || column >= COLUMNS)
            throw new RuntimeException("Invalid column " + column);
    }

    private void checkPositionToInsert(int row, int column){
        if (row == ROWS){
            throw new RuntimeException("No more room in column " + column);
        }
    }


}
