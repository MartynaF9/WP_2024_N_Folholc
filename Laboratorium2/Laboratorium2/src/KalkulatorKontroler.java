import javax.swing.*;

public class KalkulatorKontroler {

    private final KalkulatorModel model;
    private final KalkulatorWidok widok;

    public KalkulatorKontroler(KalkulatorModel model, KalkulatorWidok widok) {
        this.model = model;
        this.widok = widok;

        // Rejestracja "nasłuchiwaczy" (listenerów) dla poszczególnych przycisków
        this.widok.addAdditionListener(e -> wykonajDodawanie());
        this.widok.addSubtractionListener(e -> wykonajOdejmowanie());
        this.widok.addMultiplicationListener(e -> wykonajMnozenie());
        this.widok.addDivisionListener(e -> wykonajDzielenie());
    }

    private void wykonajDodawanie() {
        try {
            double num1 = Double.parseDouble(widok.getNumber1Text());
            double num2 = Double.parseDouble(widok.getNumber2Text());
            double result = model.dodaj(num1, num2);

            widok.setResult(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Błąd: Wprowadź poprawne liczby!");
        }
    }

    private void wykonajOdejmowanie() {
        try {
            double num1 = Double.parseDouble(widok.getNumber1Text());
            double num2 = Double.parseDouble(widok.getNumber2Text());
            double result = model.odejmij(num1, num2);

            widok.setResult(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Błąd: Wprowadź poprawne liczby!");
        }
    }

    private void wykonajMnozenie() {
        try {
            double num1 = Double.parseDouble(widok.getNumber1Text());
            double num2 = Double.parseDouble(widok.getNumber2Text());
            double result = model.pomnoz(num1, num2);

            widok.setResult(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Błąd: Wprowadź poprawne liczby!");
        }
    }

    private void wykonajDzielenie() {
        try {
            double num1 = Double.parseDouble(widok.getNumber1Text());
            double num2 = Double.parseDouble(widok.getNumber2Text());
            double result = model.podziel(num1, num2);

            widok.setResult(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Błąd: Wprowadź poprawne liczby!");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Błąd: " + ex.getMessage());
        }
    }
}

