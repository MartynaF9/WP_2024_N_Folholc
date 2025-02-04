import java.awt.*;
import javax.swing.JPanel;

class MazePanel extends JPanel {
    private final MazeGenerator maze;

    public MazePanel(MazeGenerator maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Room room : maze.getRooms()) {
            if (room instanceof BombRoom) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawRect(room.getX(), room.getY(), room.getWidth(), room.getHeight());

            // Dodanie litery "b" do pierwszego pokoju
            if (maze.getRooms().indexOf(room) == 0) {
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("b", room.getX() + room.getWidth() / 2, room.getY() + room.getHeight() / 2);
            }
        }
    }
}
