package Lesson_11;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RandomBalls extends JFrame {

    final String TITLE_OF_PROGRAM = "Random balls";
    final int WINDOW_WIDTH = 650;
    final int WINDOW_HEIGHT = 650;

    Canvas canvas;
    Random random;
//    JLabel counterValueView;

    final Color[] COLORS = {Color.red, Color.green, Color.blue, Color.magenta,
            Color.cyan, Color.orange, Color.pink, Color.gray, Color.black, Color.yellow};

    ArrayList<Ball> balls;

    int showDelay = 1000;
    int counter = 0;
    int delCounter = 0;
    int value = 0;

    public static void main(String[] args) {
        new RandomBalls().game();
    }

    public RandomBalls() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        random = new Random();
        balls = new ArrayList<>();
        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                deleteBall(e.getX(), e.getY());
                canvas.repaint();
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // рисуем окружности
            for (Ball ball : balls) {
                ball.paint(g);
            }
        }
    }

    static class Ball {
        int x, y, d;
        Color color;

        Ball(int x, int y, int d, Color color) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.color = color;
        }

        void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, d, d);
            g.setColor(Color.black);
            g.drawOval(x, y, d, d);
        }
    }

    void addBall() {
        int d = random.nextInt(10) + 30;
        int x = random.nextInt(WINDOW_WIDTH - d);
        int y = random.nextInt(WINDOW_HEIGHT - d);
        Color color = COLORS[random.nextInt(COLORS.length)];
        balls.add(new Ball(x, y, d, color));
    }

    void deleteBall(int x, int y) {
        for (int i = balls.size() - 1; i > -1; i--) {
            double dx = balls.get(i).x + (float)balls.get(i).d/2 - x;
            double dy = balls.get(i).y  + (float)balls.get(i).d/2 - y;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d < (float)balls.get(i).d/2) {
                balls.remove(i);
                delCounter++;
                break;
            }
        }
    }

    void game() {
        while (true) {
            addBall();
            if (balls.size() >= 5) {
                System.out.println("Game Over: " + counter);
                JOptionPane.showMessageDialog(this, "Game Over\nВы лопнули всего шариков: " + delCounter);
                break;
            }
            canvas.repaint();
            counter++;
            if (counter % 10 == 0 && showDelay > 50) {
                showDelay -= 25;
            }
            try {
                Thread.sleep(showDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
