package ch05;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Connect4TDDSpec {

    private Connect4TDD tested;

    @BeforeEach
    void setUp() {
        tested = new Connect4TDD();
    }

    @Test
    void whenTheGameIsStartedTheBoardIsEmpty(){
        assertThat(tested.getNumberOfDiscs(), is(0));
    }

    @Test
    void whenDiscOutSideBoardThenRunTimeException(){
        int column = -1;
        assertThat(tested.putDiscInColumn(column), allOf(is(RuntimeException.class)));
    }

    @Test
    void whenFirstDiscInsertedInColumnThenPositionIsZero(){
        int column = 1;
        tested.putDiscInColumn(column);
        assertThat(tested.putDiscInColumn(column), is(1));
    }

    @Test
    void whenSecondDiscInsertedInColumnThenPositionIsOne(){
        int column = 1;
        tested.putDiscInColumn(column);
        assertThat(tested.putDiscInColumn(column), is(1));
    }

    @Test
    void whenDiscInsertedThenNumberOfDiscsIncreases(){
        int column = 1;
        tested.putDiscInColumn(column);
        assertThat(tested.getNumberOfDiscs(), is(1));
    }

    @Test
    void whenNoMoreRoomInColumnThenRunTimeException(){
        int column = 1;
        int maxDiscsInColumn = 6; // the number of rows
        for (int times = 0; times < maxDiscsInColumn; ++times){
            tested.putDiscInColumn(column);
        }
        assertThat(tested.putDiscInColumn(column), allOf(is(RuntimeException.class)));
    }

}
