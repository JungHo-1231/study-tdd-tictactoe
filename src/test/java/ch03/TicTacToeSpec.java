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



}
