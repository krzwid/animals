package agh.cs.lab2;

public enum MapDirection {
    NORTH("Północ", "N", new Vector2d(0,1)),
    SOUTH("Południe", "S", new Vector2d(0,-1)),
    WEST("Zachód", "W", new Vector2d(-1,0)),
    EAST("Wschód", "E", new Vector2d(1,0));

    public final String name;
    public final String shortname;
    public final Vector2d vector;

    MapDirection(String s, String s1, Vector2d vector) {
        name = s;
        shortname=s1;
        this.vector = vector;
    }

    public String toString() {
        return name;
    }

    public MapDirection next() {
        switch (this) {
            case SOUTH: return WEST;
            case NORTH: return EAST;
            case WEST: return NORTH;
            case EAST: return SOUTH;
        }
        return null;
    }

    public MapDirection previous() {
        switch (this) {
            case SOUTH: return EAST;
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case EAST: return NORTH;
        }
        return null;
    }

    public String toAbbr() {
        switch (this) {
            case NORTH:
                return "N";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
        }
        return null;
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case EAST: return new Vector2d(1,0);
            case WEST: return new Vector2d(-1,0);
            case NORTH: return new Vector2d(0,1);
            case SOUTH: return new Vector2d(0,-1);
        }
        return null;
    }


}
