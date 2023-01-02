import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton adicionarButton, subtrairButton, multButton, divButton;
    JButton decButton, equButton, delButton, limparButton;
    JPanel panel;

    Font fontePainel = new Font("tahoma", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operador;

    Calculadora() {

        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(fontePainel);
        textfield.setEditable(false);

        adicionarButton = new JButton("+");
        subtrairButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        limparButton = new JButton("Limpar");

        functionButtons[0] = adicionarButton;
        functionButtons[1] = subtrairButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = limparButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(fontePainel);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(fontePainel);
            numberButtons[i].setFocusable(false);

        }

        delButton.setBounds(50, 430, 145, 50);
        limparButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(adicionarButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtrairButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(divButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(limparButton);
        frame.add((textfield));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        if (e.getSource() == adicionarButton) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '+';
            textfield.setText("");
        }
        if (e.getSource() == subtrairButton) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '-';
            textfield.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '&';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operador) {
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
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;

        }
        if (e.getSource() == limparButton) {
            textfield.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

    }
}