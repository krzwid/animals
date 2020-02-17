package agh.cs.lab2;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString() {
        switch(this) {
            case EAST: return "Wschód";
            case WEST: return  "Zachód";
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
        }
        return null;
    }

    public String next() {
        switch (this) {
            case SOUTH: return WEST.toString();
            case NORTH: return EAST.toString();
            case WEST: return NORTH.toString();
            case EAST: return SOUTH.toString();
        }
        return null;
    }

    public String previous() {
        switch (this) {
            case SOUTH: return EAST.toString();
            case NORTH: return WEST.toString();
            case WEST: return SOUTH.toString();
            case EAST: return NORTH.toString();
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
