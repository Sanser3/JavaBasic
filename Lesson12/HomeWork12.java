package Lesson12;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * JavaBasic. HomeWork #12
 *
 * @author Sergey Sanzharevskiy
 * @todo 17.10.2022
 * @date 20.10.2022
 *
 */

public class HomeWork12 extends JFrame {

    private final int PANEL_SIZE = 400;
    private final int CELL_SIZE = PANEL_SIZE / 3;
    private final char [][] table = new char [3][3];
    private boolean gameOver = false;
    Random random = new Random();

    public static void main(String[] args) {
        new HomeWork12();
    }
    public HomeWork12() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

        PaintPanel paintPanel = new PaintPanel();
        paintPanel.setBackground(Color.white);
        paintPanel.setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                if (isCellValid(x, y) && !gameOver) {
                    table[y][x] = 'x';
                    paintPanel.repaint();
                    if (isWin('x')) {
                        JOptionPane.showMessageDialog(null, "you WIN!");
                        gameOver = true;
                    } else {
                        if (isTableFull()) {
                            JOptionPane.showMessageDialog(null, "Sorry, DRAW!");
                           gameOver = true;
                       } else {
                            turnAI();
                            paintPanel.repaint();
                            if (isWin('o')) {
                                JOptionPane.showMessageDialog(null, "ai WIN!");
                                gameOver = true;
                            } else {
                                if (isTableFull()) {
                                    JOptionPane.showMessageDialog(null, "Sorry, DRAW!ai");
                                    gameOver = true;
                                }
                            }
                        }
                    }
                }
            }
        });

        Button restart = new Button("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                paintPanel.repaint();
            }
        });
        Button exit = new Button("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout());
        btnPanel.add(restart);
        btnPanel.add(exit);

        add(paintPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '.';
            }
        }
        gameOver = false;
    }

    boolean isCellValid(int x, int y) {
//        if (x < 0 || y < 0 || x > 2 || y > 2) {
//            return false;
//        }
        return table[y][x] == '.';
    }

    boolean isWin(char ch) {
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) ||
                    (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch)) {
                return true;
            }
        }
        if ((table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) ||
                (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch)) {
            return true;
        }
        return false;
    }

    boolean isTableFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = 'o';
    }

    private class PaintPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.lightGray);
            for (int i = 1; i < 3; i++) {
                g.drawLine(0, CELL_SIZE * i, PANEL_SIZE, CELL_SIZE * i);
                g.drawLine(CELL_SIZE * i, 0, CELL_SIZE * i, PANEL_SIZE);
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(10f));
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (table[y][x] == 'x') {
                        g.setColor(Color.blue);
                        g.drawLine(x * CELL_SIZE + CELL_SIZE / 5,
                                y * CELL_SIZE + CELL_SIZE / 5,
                                (x + 1) * CELL_SIZE - CELL_SIZE / 5,
                                (y + 1) * CELL_SIZE - CELL_SIZE / 5);
                        g.drawLine(x * CELL_SIZE + CELL_SIZE / 5,
                                (y + 1) * CELL_SIZE - CELL_SIZE / 5,
                                (x + 1) * CELL_SIZE - CELL_SIZE / 5,
                                y * CELL_SIZE + CELL_SIZE / 5);
                    }
                    if (table[y][x] == 'o') {
                        g.setColor(Color.red);
                        g.drawOval(x * CELL_SIZE + CELL_SIZE / 5,
                                y * CELL_SIZE + CELL_SIZE / 5,
                                CELL_SIZE  - CELL_SIZE / 5 * 2,
                                CELL_SIZE  - CELL_SIZE / 5 * 2);
                    }
                    if (isWin('o') || isWin('x')) {
                        g.setColor(Color.orange);
                        for (int i = 0; i < 3; i++) {
                            if ((table[i][0] == 'x' && table[i][1] == 'x' && table[i][2] == 'x') ||
                                    (table[i][0] == 'o' && table[i][1] == 'o' && table[i][2] == 'o')) {
                                g.drawLine(0, CELL_SIZE * (i + 1) - CELL_SIZE / 2,
                                        PANEL_SIZE, CELL_SIZE * (i + 1) - CELL_SIZE / 2);
                                break;
                            }
                            if ((table[0][i] == 'x' && table[1][i] == 'x' && table[2][i] == 'x') ||
                                    (table[0][i] == 'o' && table[1][i] == 'o' && table[2][i] == 'o')) {
                                g.drawLine(CELL_SIZE * (i + 1) - CELL_SIZE / 2, 0,
                                        CELL_SIZE * (i + 1) - CELL_SIZE / 2, PANEL_SIZE);
                                break;
                            }
                            if ((table[0][0] == 'x' && table[1][1] == 'x' && table[2][2] == 'x') ||
                                    (table[0][0] == 'o' && table[1][1] == 'o' && table[2][2] == 'o')) {
                                g.drawLine(0, 0, PANEL_SIZE, PANEL_SIZE);
                                break;
                            }
                            if ((table[2][0] == 'x' && table[1][1] == 'x' && table[0][2] == 'x') ||
                                    (table[2][0] == 'o' && table[1][1] == 'o' && table[0][2] == 'o')) {
                                g.drawLine(0, PANEL_SIZE, PANEL_SIZE, 0);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
