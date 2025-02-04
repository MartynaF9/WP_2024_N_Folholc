import java.awt.Image;

enum Directions {North, East, South, West};

/**
 * Klasa reprezentuje element labiryntu
 */
public abstract class MapSite {
    
    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Zwraca współrzędną punktu
     * @return współrzędną x
     */
    public int getX() {
        return x;
    }

    /**
     * Zwraca współrzędną punktu
     * @return współrzędną y
     */
    public int getY() {
        return y;
    }

    /**
     * Ustawia wartość współrzędnej x
     * @param newX - nowa wwrtość współrzędnej x
     */
    public void setX(int newX) {
        x = newX;
    }

    /**
     * Ustawia wartość współrzędnej y
     * @param newX - nowa wwrtość współrzędnej y
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * Ryrusje element labiryntu na ekranie
     * @param image - obiekt, na którym rysujemy
     */
    public void draw(Image image) {}

    
    public static final int LENGTH = 50;

    private int x, y;   // współrzędne elementu na ekranie


}