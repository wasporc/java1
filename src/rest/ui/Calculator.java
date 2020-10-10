package rest.ui;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private final JFrame mainFrame;
    private final JTextField outField;

    public Calculator() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 100, 500, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4, 3));
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4,2));


        mainFrame.add(top, BorderLayout.NORTH);

        mainFrame.add(rightPanel, BorderLayout.EAST);
        mainFrame.add(bottom, BorderLayout.CENTER);

        outField = new JTextField();
        outField.setBorder(BorderFactory.createEmptyBorder(0,0,20,20));
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        createButtons(bottom, rightPanel, outField);


        mainFrame.setVisible(true);
    }

    private void createButtons(JPanel bottom, JPanel rightPanel, JTextField outField) {
        ActionButtonListener abListener = new ActionButtonListener(outField);
        for (int i = 0; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            bottom.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }
        JButton cancelBtn = new JButton("C");
        rightPanel.add(cancelBtn);
        cancelBtn.addActionListener(abListener);

        JButton submitBtn = new JButton("Submit");
        rightPanel.add(submitBtn);
        submitBtn.addActionListener(new ActionCalcButton(outField));

        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(abListener);
        rightPanel.add(plusBtn);

        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(abListener);
        rightPanel.add(minusBtn);

        JButton multiBtn = new JButton("*");
        multiBtn.addActionListener(abListener);
        rightPanel.add(multiBtn);

        JButton decBtn = new JButton("/");
        decBtn.addActionListener(abListener);
        rightPanel.add(decBtn);
    }
}
