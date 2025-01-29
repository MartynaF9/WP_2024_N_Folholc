import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KalkulatorWidok extends JFrame {

    private JTextField number1Field;
    private JTextField number2Field;
    private JLabel resultLabel;

    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    // Stałe czcionki, ponieważ rozmiar okna jest stały
    private final Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
    private final Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);
    private final Font buttonFont = new Font("SansSerif", Font.BOLD, 16);

    public KalkulatorWidok() {
        super("Prosty Kalkulator (MVC)");
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

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        // Ustawienie czcionki przycisków
        addButton.setFont(buttonFont);
        subButton.setFont(buttonFont);
        mulButton.setFont(buttonFont);
        divButton.setFont(buttonFont);

        // Dodaj przyciski do panelu
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        // Dodaj panel przycisków do głównego okna
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Ustawienie wyglądu systemowego dla lepszej estetyki
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // Wyśrodkowanie okna na ekranie
        setLocationRelativeTo(null);
    }

    // Metody "get" do pobierania wartości z pól tekstowych
    public String getNumber1Text() {
        return number1Field.getText();
    }

    public String getNumber2Text() {
        return number2Field.getText();
    }

    // Metoda do ustawiania wyniku w etykiecie
    public void setResult(String result) {
        resultLabel.setText("Wynik: " + result);
    }

    // Metody do rejestrowania słuchaczy zdarzeń (ActionListener) dla przycisków
    public void addAdditionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubtractionListener(ActionListener listener) {
        subButton.addActionListener(listener);
    }

    public void addMultiplicationListener(ActionListener listener) {
        mulButton.addActionListener(listener);
    }

    public void addDivisionListener(ActionListener listener) {
        divButton.addActionListener(listener);
    }
}

