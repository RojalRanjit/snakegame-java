import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int CELL_SIZE = 10;
    private static final int INITIAL_SPEED = 100;
    private int speed = INITIAL_SPEED;

    private JButton restartButton;
    private ArrayList<Point> snake;
    private Point food;
    private int direction;
    private boolean gameOver;
    private Random random;

    public SnakeGame() {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        snake = new ArrayList<Point>();
        snake.add(new Point(50, 50));
        snake.add(new Point(40, 50));
        snake.add(new Point(30, 50));
        food = new Point();
        random = new Random();
        generateFood();
        direction = KeyEvent.VK_RIGHT;
        gameOver = false;
        new Thread(this).start();


        restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> restart());
        add(restartButton);

    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void restart() {
        snake.clear();
        snake.add(new Point(50, 50));
        snake.add(new Point(40, 50));
        snake.add(new Point(30, 50));
        generateFood();
        direction = KeyEvent.VK_RIGHT;
        gameOver = false;
        speed = INITIAL_SPEED;
        restartButton.setVisible(false);
        new Thread(this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        drawFood(g);
        if (gameOver) {
            g.drawString("Game Over!", 200, 250);
            restartButton.setVisible(true);
        } else {
            restartButton.setVisible(false);
        }

    }

    public void drawSnake(Graphics g) {
        g.setColor(Color.WHITE);
        for (Point p : snake) {
            g.fillRect(p.x, p.y, CELL_SIZE, CELL_SIZE);
        }
    }

    public void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, CELL_SIZE, CELL_SIZE);
    }

    public void generateFood() {
        food.x = random.nextInt(WINDOW_WIDTH / CELL_SIZE) * CELL_SIZE;
        food.y = random.nextInt(WINDOW_HEIGHT / CELL_SIZE) * CELL_SIZE;
    }

    public void move() {
        Point head = snake.get(0);
        Point newHead = new Point(head);
        switch (direction) {
            case KeyEvent.VK_UP:
                newHead.y -= CELL_SIZE;
                break;
            case KeyEvent.VK_DOWN:
                newHead.y += CELL_SIZE;
                break;
            case KeyEvent.VK_LEFT:
                newHead.x -= CELL_SIZE;
                break;
            case KeyEvent.VK_RIGHT:
                newHead.x += CELL_SIZE;
                break;
        }
        if (newHead.equals(food)) {
            snake.add(0, newHead);
            generateFood();
        } else {
            snake.remove(snake.size() - 1);
            if (snake.contains(newHead) || newHead.x < 0 || newHead.x >= WINDOW_WIDTH ||
                    newHead.y < 0 || newHead.y >= WINDOW_HEIGHT) {
                gameOver = true;
            } else {
                snake.add(0, newHead);
            }
        }
    }

    public void run() {
//        while (true) {
//            if (!gameOver) {
//                move();
//                repaint();
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
            while (true)
            {
                move();
                repaint();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != KeyEvent.VK_DOWN) {
                    direction = KeyEvent.VK_UP;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != KeyEvent.VK_UP) {
                    direction = KeyEvent.VK_DOWN;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != KeyEvent.VK_RIGHT) {
                    direction = KeyEvent.VK_LEFT;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != KeyEvent.VK_LEFT) {
                    direction = KeyEvent.VK_RIGHT;
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

