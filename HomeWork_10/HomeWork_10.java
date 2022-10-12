package Lesson_10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * JavaBasic. HomeWork #10
 *
 * @author Sergey Sanzharevskiy
 * @todo 10.10.2022
 * @date 11.10.2022
 *
 */

public class HomeWork_10 extends JFrame {

    final private Color[] COLORS = {Color.red, Color.green, Color.blue, Color.magenta,
        Color.cyan, Color.orange, Color.pink, Color.gray, Color.black, Color.yellow};
    private Random random = new Random();

    public static void main(String[] args) {
        new HomeWork_10();
    }

    public HomeWork_10() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 300);

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setBackground(Color.white);

        Button button = new Button("Repaint");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Repaint");
                canvasPanel.repaint();
            }
        });

        add(canvasPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // рисуем что хотим
            for (int i = 0; i < 500; i++) {
                g.setColor(COLORS[random.nextInt(COLORS.length)]);
                int x = random.nextInt(580);
                int y = random.nextInt(230);
                int dx = random.nextInt(20);
                int dy = random.nextInt(20);

/**
                if (random.nextBoolean()) {
                    g.fillRect(x, y, dx, dy);
                } else {
                    g.fillOval(x, y, dx, dy);

                }
*/
                g.fillOval(x, y, 10, 10);
            }
        }
    }
}