import javax.swing.JFrame;

public class MazeApp {
    public static void main(String[] args) {
        MazeFactory factory = new BombMazeFactory();
        MazeGenerator maze = factory.createMaze();
        maze.generateRandomRooms(10, 100, 100);

        JFrame frame = new JFrame("Labirynt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MazePanel panel = new MazePanel(maze);
        frame.add(panel);
        frame.setVisible(true);
    }
}

interface MazeFactory {
    MazeGenerator createMaze();
}

class BombMazeFactory implements MazeFactory {
    public MazeGenerator createMaze() {
        return new BombMazeGenerator();
    }
}