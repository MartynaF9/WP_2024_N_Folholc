public class Room {
    private int x,y;
    private int width,height;

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

    public boolean isAdjacent(Room other) {
        boolean adjacentHorizontally = this.y == other.y && (this.x + this.width == other.x || other.x + other.width == this.x);

        boolean adjacentVertically = this.x == other.x && (this.y + this.height == other.y || other.y + other.height == this.y);

        return adjacentHorizontally || adjacentVertically;
    }
}
