import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultLabel;

    private static final String[] CURRENCIES = {"USD", "EUR", "GBP"};
    private static final double[][] CONVERSION_RATES = {
            {1.0, 0.85, 0.73},
            {1.18, 1.0, 0.86},
            {1.38, 1.16, 1.0}
    };

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(CURRENCIES);
        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(CURRENCIES);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(amountLabel);
        add(amountField);
        add(fromCurrencyLabel);
        add(fromCurrencyComboBox);
        add(toCurrencyLabel);
        add(toCurrencyComboBox);
        add(convertButton);
        add(resultLabel);

        pack();
        setVisible(true);
    }

    private void convertCurrency() {
        double amount = Double.parseDouble(amountField.getText());
        int fromCurrencyIndex = fromCurrencyComboBox.getSelectedIndex();
        int toCurrencyIndex = toCurrencyComboBox.getSelectedIndex();

        double conversionRate = CONVERSION_RATES[fromCurrencyIndex][toCurrencyIndex];
        double convertedAmount = amount * conversionRate;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = df.format(amount) + " " + CURRENCIES[fromCurrencyIndex] + " = "
                + df.format(convertedAmount) + " " + CURRENCIES[toCurrencyIndex];

        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter();
            }
        });
    }
}
