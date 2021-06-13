package ch03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeSpec {
    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void whenXOutsideBoardThenRuntimeException() {
        assertThrows(Exception.class, () ->{
            ticTacToe.play(5,2);
        });
    }

    @Test
    void 같은자리에_한번_이상_두게되면_예외발생() throws Exception {
        ticTacToe.play(2,1);

        assertThrows(Exception.class, () ->{
            ticTacToe.play(2,1);
        });
    }

    /* 플레이어의 순서를 정하기*/
    @Test
    void 첫번째플에이어는_X(){
        assertEquals('X',ticTacToe.nextPlayer());
    }

    @Test
    void 마지막_플레이어가_X면_다음_플레이어는_O() throws Exception {
        ticTacToe.play(1,1);
        assertEquals('O',ticTacToe.nextPlayer());
    }

    @Test
    void 아직_이긴사람이_없는_경우() throws Exception {
        String actual = ticTacToe.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    void 수직으로_이긴_경우() throws Exception {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    void 수평으로_이긴_경우() throws Exception {
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        String actual = ticTacToe.play(1, 3); // O
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() throws Exception {
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 2); // O
        String actual = ticTacToe.play(3, 1); // O
        assertEquals("X is the winner", actual);
    }

//    @Test
//    public void whenAllBoxesAreFilledThenDraw() throws Exception {
//        ticTacToe.play(1, 1);
//        ticTacToe.play(1, 2);
//        ticTacToe.play(1, 3);
//        ticTacToe.play(2, 1);
//        ticTacToe.play(2, 3);
//        ticTacToe.play(2, 2);
//        ticTacToe.play(3, 1);
//        ticTacToe.play(3, 3);
//        String actual = ticTacToe.play(3, 2);
//        assertEquals("The result is draw", actual);
//    }

}
