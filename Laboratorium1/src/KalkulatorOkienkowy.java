import java.awt.*;
import javax.swing.*;

public class KalkulatorOkienkowy extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JLabel resultLabel;

    // Stałe czcionki, ponieważ rozmiar okna jest stały
    private final Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
    private final Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);
    private final Font buttonFont = new Font("SansSerif", Font.BOLD, 16);

    public KalkulatorOkienkowy() {
        super("Prosty Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Stały rozmiar okna
        setResizable(false); // Zablokowanie możliwości zmiany rozmiaru okna

        // Używamy GridBagLayout dla lepszej organizacji komponentów
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Etykieta i pole pierwszej liczby
        JLabel label1 = new JLabel("Pierwsza liczba:");
        label1.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label1, gbc);

        number1Field = new JTextField();
        number1Field.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(number1Field, gbc);

        // Etykieta i pole drugiej liczby
        JLabel label2 = new JLabel("Druga liczba:");
        label2.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label2, gbc);

        number2Field = new JTextField();
        number2Field.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(number2Field, gbc);

        // Etykieta wyniku
        resultLabel = new JLabel("Wynik: ");
        resultLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

        // Panel na przyciski
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");

        // Ustawienie czcionki przycisków
        addButton.setFont(buttonFont);
        subButton.setFont(buttonFont);
        mulButton.setFont(buttonFont);
        divButton.setFont(buttonFont);

        // Dodajemy ActionListenery do przycisków
        addButton.addActionListener(e -> calculate('+'));
        subButton.addActionListener(e -> calculate('-'));
        mulButton.addActionListener(e -> calculate('*'));
        divButton.addActionListener(e -> calculate('/'));

        // Dodajemy przyciski do panelu
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        // Dodajemy panel przycisków do głównego okna
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Ustawienie wyglądu systemowego dla lepszej estetyki
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Wyśrodkowanie okna na ekranie i wyświetlenie
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculate(char operator) {
        try {
            // Odczyt liczb z pól tekstowych
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double result = 0;

            // Obsługa podstawowych operacji
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Błąd: Dzielenie przez zero!");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Nieznane działanie!");
                    return;
            }

            // Wyświetlenie wyniku w etykiecie
            resultLabel.setText("Wynik: " + result);

        } catch (NumberFormatException ex) {
            // Obsługa sytuacji, gdy w polach nie ma prawidłowych liczb
            JOptionPane.showMessageDialog(this, "Błąd: Wprowadź poprawne liczby!");
        }
    }

    public static void main(String[] args) {
        // Uruchomienie aplikacji w bezpieczny dla Swinga sposób
        SwingUtilities.invokeLater(KalkulatorOkienkowy::new);
    }
}

