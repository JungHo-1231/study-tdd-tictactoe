package ch04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipSpec {

    Ship ship;
    Location location;

    @BeforeEach
    void point_좌표가_주어졌을때_어느위치인지_알아내기() {
        Point point = new Point(21, 13);
        location = new Location(point, Direction.NORTH);
        ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }

    @Test
    void givenNorthWhenMoveForwardThenYDecreases() {
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 12);
    }

    @Test
    void givenEastWhenMoveForwardThenXIncreases() {
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX(), 22);
    }

//    @Test
//    void whenMoveForwardThenForward() {
//        Location expected = location.copy();
//        expected.forward();
//        ship.moveForward();
//        assertEquals(ship.getLocation(), expected);
//    }

}
