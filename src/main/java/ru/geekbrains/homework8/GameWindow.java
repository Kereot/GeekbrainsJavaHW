package ru.geekbrains.homework8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private int theNumber;
    private JTextField textField;
    private int tryCount;
    private int totalCount;
    private int range;
    private JPanel buttonsPanel;

    public GameWindow(int totalCount) {
        range = 10;

        if (totalCount < 1) {
            this.totalCount = 1;
        } else this.totalCount = Math.min(totalCount, range);

        generateNumber();

        setTitle("Угадайте число");
        setBounds(400, 300, 600, 150);
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

        for (int i = 1; i <= range ; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);
            int buttonIndex = i;
            button.addActionListener(e -> GameWindow.this.tryToGuess(buttonIndex, button));
        }

        JButton resetButton = new JButton("Сбросить и запустить заново");
        resetButton.setFont(font);
        resetPanel.add(resetButton);
        resetButton.addActionListener(e -> resetAll());

        setVisible(true);
    }

    private void generateNumber() {
        theNumber = (int) (Math.random() * range) + 1;
    }

    private void resetAll() {
        for (Component comp: buttonsPanel.getComponents()) {
             if (comp instanceof JButton) {
                 // В принципе, сейчас эта проверка не нужна. Вставил на случай добавления других элементов на панель.
                 // Аналогично (в части instanceof) в строке с закрашиванием кнопки с правильным ответом в красный цвет.
                comp.setEnabled(true);
                comp.setBackground(null);
             }
        }
        generateNumber();
        textField.setText("Программа загадала целое число от 1 до 10 вкл. Попробуйте угадать с " + totalCount + "-й попытки.");
        tryCount = 0;
    }

    private void tryToGuess(int answer, JButton button) {
        if (tryCount < this.totalCount) {
            if (answer == theNumber) {
                textField.setText("Вы угадали! Ответ: " + theNumber + ".");
                button.setBackground(Color.GREEN);
                tryCount = range;
            } else if (answer > theNumber) {
                textField.setText("Не угадали! Загаданное число меньше.");
                button.setBackground(Color.YELLOW);
            } else {
                textField.setText("Не угадали! Загаданное число больше");
                button.setBackground(Color.YELLOW);
            }
            tryCount++;
            if (tryCount == this.totalCount) {
                button.setBackground(Color.YELLOW);
                textField.setText("Вы исчерпали лимит попыток (" + totalCount + ")! Ответ был: " + theNumber + ".");
                for (Component comp: buttonsPanel.getComponents()) {
                    if (comp instanceof JButton && ((JButton) comp).getText().equals(Integer.toString(theNumber))) {
                        comp.setBackground(Color.RED);
                    }
                }
            }
        } else if (tryCount > range) {
            textField.setText("Вы уже угадали ранее! Ответ был: " + theNumber + ".");
        } else {
            textField.setText("Вы исчерпали лимит попыток (" + totalCount + ")! Ответ был: " + theNumber + ".");
        }
        button.setEnabled(false);
    }
}