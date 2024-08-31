package codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AdvancedQuizBeeGame extends JPanel implements ActionListener, KeyListener {
    private Timer questionTimer;
    private int score, timeLeft, currentQuestionIndex, wrongAnswers, correctAnswers;
    private boolean gameRunning, inMenu;
    private JFrame gameFrame;
    private String currentQuestion, currentAnswer, userAnswer;
    private ArrayList<String[]> questions;
    private Random rand;

    private final int QUESTION_TIME = 30; // 30 seconds per question

    public AdvancedQuizBeeGame() {
        this.setPreferredSize(new Dimension(1680, 940)); // Set the panel size to 1680 x 940
        rand = new Random();
        initializeQuestions();
        resetGame();
        addKeyListener(this);
        setFocusable(true);
    }

    private void initializeQuestions() {
        questions = new ArrayList<>();
        questions.add(new String[]{"What is the capital of France?", "PARIS"});
        questions.add(new String[]{"Who wrote 'Romeo and Juliet'?", "SHAKESPEARE"});
        questions.add(new String[]{"What is the largest planet in our solar system?", "JUPITER"});
        questions.add(new String[]{"What is the chemical symbol for gold?", "AU"});
        questions.add(new String[]{"Which country is home to the kangaroo?", "AUSTRALIA"});
        questions.add(new String[]{"What is the largest ocean on Earth?", "PACIFIC"});
        questions.add(new String[]{"Who painted the Mona Lisa?", "DAVINCI"});
        questions.add(new String[]{"What is the capital of Japan?", "TOKYO"});
        questions.add(new String[]{"What is the hardest natural substance on Earth?", "DIAMOND"});
        questions.add(new String[]{"Which planet is known as the Red Planet?", "MARS"});
        questions.add(new String[]{"What is the largest species of big cat?", "TIGER"});
        questions.add(new String[]{"In which year did World War II end?", "1945"});
        questions.add(new String[]{"What is the main ingredient in guacamole?", "AVOCADO"});
        questions.add(new String[]{"Who is known as the father of modern physics?", "EINSTEIN"});
        questions.add(new String[]{"What is the capital of Brazil?", "BRASILIA"});
        questions.add(new String[]{"Which element has the chemical symbol 'O'?", "OXYGEN"});
        questions.add(new String[]{"What is the largest continent by land area?", "ASIA"});
        questions.add(new String[]{"Who wrote '1984'?", "ORWELL"});
        questions.add(new String[]{"What is the currency of Japan?", "YEN"});
        questions.add(new String[]{"Which planet is known as the Morning Star?", "VENUS"});
        Collections.shuffle(questions); // Randomize question order
    }

    private void resetGame() {
        score = 0;
        wrongAnswers = 0;
        correctAnswers = 0;
        currentQuestionIndex = -1;
        gameRunning = false;
        inMenu = true;
        userAnswer = "";
        if (questionTimer != null) questionTimer.stop();
    }

    private void startGame() {
        inMenu = false;
        gameRunning = true;
        nextQuestion();
    }

    private void nextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            String[] qa = questions.get(currentQuestionIndex);
            currentQuestion = qa[0];
            currentAnswer = qa[1];
            userAnswer = "";
            timeLeft = QUESTION_TIME;
            if (questionTimer != null) questionTimer.stop();
            questionTimer = new Timer(1000, e -> {
                timeLeft--;
                if (timeLeft <= 0) checkAnswer();
                repaint();
            });
            questionTimer.start();
        } else {
            endGame("You've answered all questions!");
        }
    }

    private void checkAnswer() {
        if (userAnswer.equalsIgnoreCase(currentAnswer)) {
            score += 10;
            correctAnswers++;
            if (correctAnswers == 10) {
                endGame("Congratulations! You've won by answering 10 questions correctly!");
                return;
            }
        } else {
            wrongAnswers++;
            if (wrongAnswers == 5) {
                endGame("Game Over! You've answered 5 questions incorrectly.");
                return;
            }
        }
        nextQuestion();
    }
    // method for end game
    private void endGame(String message) {
        gameRunning = false;
        questionTimer.stop();
        showGameOverDialog(message);
    }
    
    //
    private void showGameOverDialog(String message) {
        int result = JOptionPane.showOptionDialog(this,
            message + "\nFinal Score: " + score,
            "Game Over",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new Object[]{"Try Again", "Exit"},
            "Try Again");

        if (result == 0) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));

        if (inMenu) {
            drawCenteredString(g2d, "Advanced Quiz Bee Game", getHeight() / 2 - 50);
            drawCenteredString(g2d, "Press ENTER to start", getHeight() / 2 + 50);
        } else if (gameRunning) {
            g2d.drawString("Score: " + score, 20, 30);
            g2d.drawString("Time: " + timeLeft, getWidth() - 120, 30);
            g2d.drawString("Correct: " + correctAnswers + "/10", 20, 60);
            g2d.drawString("Wrong: " + wrongAnswers + "/5", getWidth() - 120, 60);
            drawCenteredString(g2d, currentQuestion, getHeight() / 2 - 50);
            drawCenteredString(g2d, userAnswer, getHeight() / 2 + 50);
        }
    }

    private void drawCenteredString(Graphics2D g2d, String text, int y) {
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        g2d.drawString(text, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
//    public void keyPressed(KeyEvent e) {
//        if (inMenu && e.getKeyCode() == KeyEvent.VK_ENTER) {
//            startGame();
//        } else if (gameRunning) {
//            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                checkAnswer();
//            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && userAnswer.length() > 0) {
//                userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
//            } else if (Character.isLetterOrDigit(e.getKeyChar())) {
//                userAnswer += Character.toUpperCase(e.getKeyChar());
//            }
//        }
//        repaint();
//    }
    // method for key pressed for the game
    public void keyPressed(KeyEvent e) {
        if (inMenu && e.getKeyCode() == KeyEvent.VK_ENTER) {
            startGame();
        } else if (gameRunning) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                checkAnswer();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && userAnswer.length() > 0) {
                userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                userAnswer += " ";
            } else if (Character.isLetterOrDigit(e.getKeyChar())) {
                userAnswer += Character.toUpperCase(e.getKeyChar());
            }
            else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            	 showEscapeMenu();
            }
        }
        repaint();
    }
 // GAME menu method
    private void showEscapeMenu() {
    	questionTimer.stop(); // Pause the game
        String[] options = {"Continue", "Restart", "Exit"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Game Paused",
            "Menu",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );

        switch (choice) {
            case 0: // Continue
            	questionTimer.start(); // Resume the game
                break;
            case 1: // Restart
                resetGame();
                questionTimer.start();
                break;
            case 2: // Exit
//          	System.exit(0);
            	exitToPortalFrame();
                break;
            default: // If dialog is closed without selection, resume the game
            	questionTimer.start();
        }
        
        // Ensure the game panel regains focus after closing the dialog
        this.requestFocusInWindow();
    }
    // method for exit 
    private void exitToPortalFrame() {
        PortalFrame pf = new PortalFrame();
        pf.setVisible(true);
        if(gameFrame != null) {
        gameFrame.dispose();
        }else {
        	System.out.println("Game is End");
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Advanced Quiz Bee Game");
            frame.setUndecorated(true); // Set undecorated before adding components or making the frame visible
            AdvancedQuizBeeGame game = new AdvancedQuizBeeGame();
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}