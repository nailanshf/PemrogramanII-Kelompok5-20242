import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTextField inputField;
    private JComboBox<String> currencyComboBox;
    private JLabel resultLabel;

    public MainFrame() {
        setTitle("Rupiah Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 5, 5));

        add(new JLabel("Masukkan Nilai Rupiah:", SwingConstants.CENTER));
        inputField = new JTextField();
        add(inputField);

        add(new JLabel("Pilih Mata Uang:", SwingConstants.CENTER));
        currencyComboBox = new JComboBox<>(new String[] {"USD", "EUR", "JPY", "SGD"});
        add(currencyComboBox);

        JButton convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("Hasil: ", SwingConstants.CENTER);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(inputField.getText());
                    String currency = (String) currencyComboBox.getSelectedItem();
                    double result = CurrencyConverter.convert(amount, currency);
                    resultLabel.setText(String.format("Hasil: %.2f %s", result, currency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}