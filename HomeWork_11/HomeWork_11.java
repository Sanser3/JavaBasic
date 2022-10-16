package Lesson_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * JavaBasic. HomeWork #11
 *
 * @author Sergey Sanzharevskiy
 * @todo 12.10.2022
 * @date 16.10.2022
 *
 */
public class HomeWork_11 extends JFrame {
    final int CANVAS_WIDTH = 600;
    final int CANVAS_HEIGHT = 500;
    final int DX = 100;

    int x, y, dx;
    Color color;

//    ImageIcon image;

    List<Ball1> balls;

    final private Color[] COLORS = {Color.red, Color.green, Color.blue, Color.magenta,
            Color.cyan, Color.orange, Color.pink, Color.gray, Color.black, Color.yellow};
    private Random random = new Random();

    public static void main(String[] args) {
        new HomeWork_11();
    }

    public HomeWork_11() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        canvasPanel.setBackground(Color.white);

        initBalls();

//        image = new ImageIcon();

//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//                System.out.println(e.getKeyCode());
//                switch (e.getKeyCode()) {
//                    case 32:
//                        randomXYColor();
//                        break;
//                    case 38:
//                        y -= 5;
//                        break;
//                    case 40:
//                        y += 5;
//                        break;
//                    case 37:
//                        x -= 5;
//                        break;
//                    case 39:
//                        x += 5;
//                        break;
//                }
//                canvasPanel.repaint();
//            }
//        });

        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                for (int i = balls.size() - 1; i > -1; i--) {
                    if (balls.get(i).isInBall(e.getX(), e.getY())) {
                        balls.remove(i);
                        break;
                    }
                }
                canvasPanel.repaint();
            }
        });

        randomXYColor();

        Button repaint = new Button("Repaint");
        repaint.addActionListener(e -> {
            randomXYColor();
            canvasPanel.repaint();
        });

        Button left = new Button("Left");
        left.addActionListener(e -> {
            x -= 5;
            canvasPanel.repaint();
        });

        Button right = new Button("Right");
        right.addActionListener(e -> {
            x += 5;
            canvasPanel.repaint();
        });
        Button exit = new Button("Exit");
        exit.addActionListener(e -> System.exit(0));

//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(repaint);
//        buttonPanel.add(left);
//        buttonPanel.add(right);
//        buttonPanel.add(exit);

        add(canvasPanel, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void randomXYColor() {
        x = random.nextInt(CANVAS_WIDTH - DX);
        y = random.nextInt(CANVAS_HEIGHT - DX);
        dx = DX;
        color = COLORS[random.nextInt(COLORS.length)];
    }

    private void initBalls() {
        balls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int d = random.nextInt(100);
            int x = random.nextInt(CANVAS_WIDTH - d);
            int y = random.nextInt(CANVAS_HEIGHT - d);
            Color color = COLORS[random.nextInt(COLORS.length)];
            balls.add(new Ball1(x, y, d, color));

        }
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (Ball1 ball : balls) {
                ball.paint(g);
            }
        }
    }
}
