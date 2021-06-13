package ch03;

public class TicTacToe {

    boolean playerTurn = true;
    private Character[][] board = {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';
    private final int SIZE = 3;

    public String play(int x, int y) throws Exception {
        // x 조건
        checkValue(x, "X값이 올바르지 않습니다");
        // y 조건
        checkValue(y, "Y값이 올바르지 않습니다");
        // 올바른 곳에 두었는지 확인
        putBoard(x, y);
        // 플레이어의 순서를 변경
//        changePlayerTurn();

        lastPlayer = nextPlayer();

        if (isWin()) {
            return lastPlayer + " is the winner";
        } else if(isDraw()){
            return "The result is draw";
        } else {
            return "No winner";
        }
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        for (int i = 0; i < SIZE; i++) {

            // 디버깅할때 값 확인용용
            int boardResult = board[0][i] + board[1][i] + board[2][i];
            int checkResultSize = lastPlayer * SIZE;

            if (boardResult == checkResultSize) {
                return true;
            }

            if ((board[0][0] + board[1][1] + board[2][2])
                    == boardResult) {
                return true;

            } else if (boardResult == (board[0][2] + board[1][1] + board[2][0])) {

                return true;
            }
        }
        return false;
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerTotal
                || vertical == playerTotal
                || diagonal1 == playerTotal
                || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    private void changePlayerTurn() {
        if (playerTurn) {
            playerTurn = false;
        } else {
            playerTurn = true;
        }
    }

    private void putBoard(int x, int y) throws Exception {
        if (board[x - 1][y - 1] == '\0') {
            board[x - 1][y - 1] = 'X';
        } else {
            throw new Exception("같은 자리에 두번 놓을 수 없습니다");
        }
    }

    private void checkValue(int y, String s) throws Exception {
        if (y < 1 || 3 < y) {
            throw new Exception(s);
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

//    public char nextPlayer() {
//        if (playerTurn) {
//            return 'X';
//        } else {
//            return 'O';
//        }
//    }
}
