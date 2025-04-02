package com.ship.probe.constant;
public enum Direction {
	 NORTH, EAST, SOUTH, WEST;

    public Direction turnLeft() {
        return values()[(this.ordinal() + 3) % 4];
    }

    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % 4];
    }

}
