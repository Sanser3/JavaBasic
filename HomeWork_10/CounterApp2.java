package Lesson_10;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp2  extends JFrame {
    private int value;

    public CounterApp2(int initialValue) {
        setBounds(500, 300, 400, 200);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 32);
        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("-1");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton("+1");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        JButton restartButton = new JButton("restart");
        restartButton.setFont(font);
        add(restartButton, BorderLayout.SOUTH);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value++;
                counterValueView.setText(String.valueOf(value));
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value = 0;
                counterValueView.setText(String.valueOf(value));
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp2(0);
    }

}