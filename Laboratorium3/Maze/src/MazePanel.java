import java.awt.*;
import javax.swing.JPanel;

public class MazePanel extends JPanel {
    private MazeGenerator maze;

    public MazePanel(MazeGenerator maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        for (Room room : maze.getRooms()) {
            g.drawRect(room.getX(), room.getY(), room.getWidth(), room.getHeight());
        }

        for (int i = 0;  i < maze.getRooms().size(); i++) {
            for (int j = i + 1; j < maze.getRooms().size(); j++ ) {
                Room room1 = maze.getRooms().get(i);
                Room room2 = maze.getRooms().get(j);
                if (room1.isAdjacent(room2)){
                    drawDoor(g, room1, room2);
                }
            }
        }
    }

    public void drawDoor(Graphics g, Room room1, Room room2) {
        g.setColor(Color.RED);

        if (room1.getY() == room2.getY()) {
            int doorY = room1.getY() + room1.getHeight() / 2;
            int doorX = (room1.getX() < room2.getX()) ? room1.getX() + room1.getWidth() : room2.getX() + room2.getWidth();
            g.fillRect(doorX - 5, doorY - 2, 10, 4);
            System.out.println("doorX: " + doorX + " doorY: " + doorY);
        } else if (room1.getX() == room2.getX()) {
            int doorX = room1.getX() + room1.getWidth() / 2;
            int doorY = (room1.getY() < room2.getY()) ? room1.getY() + room1.getHeight() : room2.getY() + room2.getHeight();
            g.fillRect(doorX - 2, doorY - 5, 4, 10); 
            System.out.println("doorX: " + doorX + " doorY: " + doorY);
        }

        g.setColor(Color.BLACK);
    }
}

