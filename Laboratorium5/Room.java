class Room {
    private final int x, y, width, height;

    public Room(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}

class BombRoom extends Room {
    public BombRoom(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
