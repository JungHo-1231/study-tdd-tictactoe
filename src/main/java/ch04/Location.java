package ch04;

import lombok.Getter;


@Getter
public class Location {
    private Point point;
    private Direction direction;

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



}
