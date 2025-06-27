import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTextField inputField;
    private JComboBox<String> currencyComboBox;
    private JLabel resultLabel;

    public MainFrame() {
        setTitle("Konversi Mata Uang Rupiah");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        // Judul
        JLabel titleLabel = new JLabel("Konversi Rupiah ke Mata Uang Asing");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        // Input Rupiah
        JLabel inputLabel = new JLabel("Masukkan Nilai Rupiah:");
        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Combo box mata uang
        JLabel currencyLabel = new JLabel("Pilih Mata Uang:");
        String[] currencies = {"USD", "EUR", "JPY", "SGD"};
        currencyComboBox = new JComboBox<>(currencies);
        currencyComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Tombol convert
        JButton convertButton = new JButton("Convert");
        convertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        convertButton.setBackground(new Color(0, 153, 76));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        // Label hasil
        resultLabel = new JLabel("Hasil: ");
        resultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Tambahkan ke panel utama
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(inputLabel);
        mainPanel.add(inputField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(currencyLabel);
        mainPanel.add(currencyComboBox);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(convertButton);
        mainPanel.add(resultLabel);

        // Tambahkan panel ke frame
        add(mainPanel);

        // Aksi tombol convert
        convertButton.addActionListener(e -> convertCurrency());
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            String selectedCurrency = (String) currencyComboBox.getSelectedItem();
            double result = CurrencyConverter.convert(amount, selectedCurrency);
            resultLabel.setText(String.format("Hasil: %.2f %s", result, selectedCurrency));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}