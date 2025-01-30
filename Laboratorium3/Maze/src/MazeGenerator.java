import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    private List<Room> rooms;
    private Random random;

    public MazeGenerator() {
        rooms = new ArrayList<>();
        random = new Random();
    }

    public void addRoom(int x, int y, int width, int height) {
        rooms.add(new Room(x, y, width, height));
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    private boolean isOverlapping(Room newRoom) {
        for (Room room : rooms) {
            if (room.getX() < newRoom.getX() + newRoom.getWidth() &&
                room.getX() + room.getWidth() > newRoom.getX() &&
                room.getY() < newRoom.getY() + newRoom.getHeight() &&
                room.getY() + room.getHeight() > newRoom.getY()) {
                return true;
            }
        }
        return false;
    }

    public void generateRandomRooms(int count, int newWidth, int newHeight) {
        if (count <= 0) return;

        addRoom(400, 400, newWidth, newHeight);

        for (int i = 1; i < count; i++) {
            boolean roomAdded = false;

            while (!roomAdded) {
                Room baseRoom = rooms.get(random.nextInt(rooms.size()));

                int width = newWidth;
                int height = newHeight;

                int x = baseRoom.getX();
                int y = baseRoom.getY();

                int direction = random.nextInt(4);

                switch (direction) {
                    case 0 -> y -= height;
                    case 1 -> y += baseRoom.getHeight();
                    case 2 -> x -= width;
                    case 3 -> x += baseRoom.getWidth();
                }

                Room newRoom = new Room(x,y,width,height);
                if (!isOverlapping(newRoom)) {
                    rooms.add(newRoom);
                    roomAdded = true;
                }
            }
        }
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}