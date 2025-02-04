import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class App extends JFrame {

    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(400, 300);     // ustawienie rozmiaru okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // standardowe zamknięcie aplikacji
        panel = new MyJPanel();                          // panel, na którym wyświetlamy narysowany labirynt
        JButton button = new JButton("Draw maze");       // przycisk odpowiedzialny za narysowanie labiryntu
        button.addActionListener(new ActionListener() {  

            @Override
            public void actionPerformed(ActionEvent e) {
                buildMaze();
                 
            }
         
        });
        setLayout(new BorderLayout());     // ustawienie menadżera rozkładu
        add(panel, BorderLayout.CENTER);   // dodanie panelu w centralnej części
        add(button, "North");  // dodanie przycisku na górze panela
    }

    public void buildMaze() {
        image = panel.getImage();   // pobranie obrazu, na którym rysujemy labirynt
        
        int x = 50;                 // współrzędne labirynu
        int y = 100;
        int nr = 1;     // numer pierwszego pokoju
        
        Wall myWall1 = new Wall(x, y, Directions.East);
        Wall myWall2 = new Wall(x, y, Directions.North);
        Wall myWall3 = new Wall(x, y, Directions.South);
        Wall myWall4 = new Wall(x, y, Directions.West);

        Room room = new Room(x, y, nr++);
        room.setSite(Directions.East, myWall1);
        room.setSite(Directions.North, myWall2);
        room.setSite(Directions.South, myWall3);
        room.setSite(Directions.West, myWall4);

        Wall myWall21 = new Wall(x + MapSite.LENGTH, y, Directions.East);
        Wall myWall22 = new Wall(x + MapSite.LENGTH, y, Directions.North);
        Wall myWall23 = new Wall(x + MapSite.LENGTH, y, Directions.South);
        Wall myWall24 = new Wall(x + MapSite.LENGTH, y, Directions.West);

        
        Room room2 = new Room(x + MapSite.LENGTH, y, nr++);
        room2.setSite(Directions.East, myWall21);
        room2.setSite(Directions.North, myWall22);
        room2.setSite(Directions.South, myWall23);
        room2.setSite(Directions.West, myWall24);

        Door door1 = new Door(room, room2);
        
        room.setSite(Directions.East, door1);
        room2.setSite(Directions.West, door1);

        room.draw(image);
        room2.draw(image);

        //door1.draw(image);
     
        panel.repaint();               // odrysowanie panel z labirynte, nie używamy metody paint()
       


    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);  // uruchomienie i wyświetlenie okna aplikacji
            }
        });

    }
}
