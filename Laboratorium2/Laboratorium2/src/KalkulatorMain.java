import javax.swing.SwingUtilities;

public class KalkulatorMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KalkulatorModel model = new KalkulatorModel();
            KalkulatorWidok widok = new KalkulatorWidok();
            new KalkulatorKontroler(model, widok);

            widok.setVisible(true);
        });
    }
}

