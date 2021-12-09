package ru.geekbrains.homework8;

import javax.swing.*;
import java.awt.*;

public class AltArrayWindow extends JFrame {
    private int theNumber;
    private JTextField textField;
    private int tryCount;
    private int totalCount;
    private int range;
    private JPanel buttonsPanel;
    private JButton[] button;

    public AltArrayWindow(int totalCount) {
        range = 10;

        if (totalCount < 1) {
            this.totalCount = 1;
        } else this.totalCount = Math.min(totalCount, range);

        generateNumber();

        setTitle("Угадайте число");
        setBounds(400, 500, 600, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        textField.setText("Программа загадала целое число от 1 до 10 вкл. Попробуйте угадать с " + this.totalCount + "-й попытки.");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);

        Font font = new Font("Arial", Font.PLAIN, 18);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        textField.setFont(textFieldFont);

        buttonsPanel = new JPanel(new GridLayout(1, 0));
        add(buttonsPanel, BorderLayout.CENTER);

        JPanel resetPanel = new JPanel(new FlowLayout());
        add(resetPanel, BorderLayout.SOUTH);

        button = new JButton[range];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(Integer.toString(i + 1));
            button[i].setFont(font);
            buttonsPanel.add(button[i]);
            int finalI = i;
            button[i].addActionListener(e -> AltArrayWindow.this.tryToGuess(finalI, button));
        }

        JButton resetButton = new JButton("Сбросить и запустить заново");
        resetButton.setFont(font);
        resetPanel.add(resetButton);
        resetButton.addActionListener(e -> resetAll());

        setVisible(true);
    }

    private void generateNumber() {
        theNumber = (int) (Math.random() * range);
        // Поскольку индексы массива также начинаются с нуля, в данном варианте я не стал добавлять единицу;
        // Пользователю же будет выводиться число, увеличенное на единицу.
    }

    private void resetAll() {
        for (int i = 0; i < button.length; i++) {
            button[i].setEnabled(true);
            button[i].setBackground(null);
            generateNumber();
            textField.setText("Программа загадала целое число от 1 до 10 вкл. Попробуйте угадать с " + totalCount + "-й попытки.");
            tryCount = 0;
        }
    }


    private void tryToGuess(int answer, JButton[] button) {
        if (tryCount < this.totalCount) {
            if (answer == theNumber) {
                textField.setText("Вы угадали! Ответ: " + (theNumber + 1) + ".");
                button[answer].setBackground(Color.GREEN);
                tryCount = range;
            } else if (answer > theNumber) {
                textField.setText("Не угадали! Загаданное число меньше.");
                button[answer].setBackground(Color.YELLOW);
            } else {
                textField.setText("Не угадали! Загаданное число больше");
                button[answer].setBackground(Color.YELLOW);
            }
            tryCount++;
            if (tryCount == this.totalCount) {
                button[answer].setBackground(Color.YELLOW);
                textField.setText("Вы исчерпали лимит попыток (" + totalCount + ")! Ответ был: " + (theNumber + 1) + ".");
                for (int i = 0; i < button.length; i++) {
                    if (button[i].getText().equals(Integer.toString((theNumber + 1)))) {
                        button[i].setBackground(Color.RED);
                    }
                }
            }
        } else if (tryCount > range) {
            textField.setText("Вы уже угадали ранее! Ответ был: " + (theNumber + 1) + ".");
        } else {
            textField.setText("Вы исчерпали лимит попыток (" + totalCount + ")! Ответ был: " + (theNumber + 1) + ".");
        }
        button[answer].setEnabled(false);
    }
}