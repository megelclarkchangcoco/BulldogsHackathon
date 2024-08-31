	package codes;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashSet;
	import java.util.Random;
	import java.util.Set;
	 
	public class Typegame extends JPanel implements ActionListener, KeyListener {
	    private Timer timer;
	    private int characterX, characterY;
	    private int characterSpeed = 10; // shark speeds
	    private ArrayList<Shark> sharks;
	    private int sharkSpeed = 5; // Slow down sharks
	    private Random rand;
	    private int score;
	    private boolean gameRunning;
	    private JFrame gameFrame; //store the reference to the game frame
	
	 
	    private final int maxSharks = 3; // Maximum number of sharks on the screen
	 
	    private Set<String> usedWords; // Track used words
	    private String[] wordList = {
	    	    "SHARK", "FISH", "WHALE", "DOLPHIN", "OCEAN", "BEACH", "CORAL", "SEASHELL", "WAVE", "CURRENT","NATIONALIAN UNIVERSITY","WHATTATOPS",
	    	    "TIDE", "SAND", "ISLAND", "REEF", "JELLYFISH", "SEAWEED", "GULL", "KELP", "WHALESHARK", "TURTLE",
	    	    "MANTA", "RAY", "SEAL", "OYSTER", "CLAM", "CRAB", "LOBSTER", "SQUID", "OCTOPUS", "EEL",
	    	    "DOLPHIN", "SEAHORSE", "STINGRAY", "MORAY", "PIRANHA", "BARRACUDA", "MACKEREL", "TROUT", "SALMON", "CATFISH",
	    	    "PIKE", "TUNA", "ANGELFISH", "PARROT", "TANG", "GUPPY", "BETTA", "CLOWNFISH", "POMPANO", "SNAPPER",
	    	    "GROUPER", "SOLE", "FLOUNDER", "DAB", "HALIBUT", "WALLEYE", "PERCH", "SARDINE", "ANCHOVY", "HERRING",
	    	    "COD", "MULLET", "BASS", "CARP", "TENCH", "ROACH", "DACE", "CHUB", "SHAD", "HADDOCK",
	    	    "SOLE", "PLENTY", "GOLD", "SILVER", "BRONZE", "COPPER", "IRON", "LEAD", "TIN", "ALUMINUM",
	    	    "SAND", "STONE", "GRAVEL", "CLAY", "MARBLE", "ROCK", "GRANITE", "SLATE", "LIMESTONE", "SILT"
	    	};
	 
	    private ArrayList<String> availableWords; // List of available words to use
	 
	    public Typegame() {
	        this.setPreferredSize(new Dimension(1680, 940)); // Set the panel size to 1680 x 940
	 
	        characterX = 50;
	        characterY = 0; // Adjusted character Y position to cover the entire height
	 
	        sharks = new ArrayList<>();
	        rand = new Random();
	        usedWords = new HashSet<>();
	 
	        // Ensure compatibility with Java 8 or earlier
	        availableWords = new ArrayList<>(Arrays.asList(wordList));
	 
	        timer = new Timer(1000 / 60, this);
	        timer.start();
	 
	        score = 0;
	        gameRunning = true;
	 
	        addKeyListener(this);
	        setFocusable(true);
	    }
	 
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	 
	        if (gameRunning) {
	            Graphics2D g2d = (Graphics2D) g;
	 
	            // Draw background
	            g2d.setColor(Color.BLACK); // Set background color to black
	            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	 
	            // Draw character as a vertical line
	            g2d.setColor(Color.RED); // Color of the character line
	            g2d.setStroke(new BasicStroke(10)); // Set line thickness
	            g2d.drawLine(characterX, 0, characterX, this.getHeight()); // Draw vertical line representing the character
	 
	            // Draw sharks and their associated words with 3D effect
	            for (Shark shark : sharks) {
	                draw3DTile(g2d, shark.x, shark.y, shark.width, shark.height, new Color(0, 128, 0)); // Changed to green
	 
	                // Draw the shark's word
	                g2d.setColor(Color.WHITE); // Change text color to white for better visibility
	                g2d.setFont(new Font("Arial", Font.BOLD, 20));
	                FontMetrics metrics = g2d.getFontMetrics();
	 
	                // Calculate the position for centering the text
	                int textWidth = metrics.stringWidth(shark.word);
	                int textHeight = metrics.getHeight();
	                int x = shark.x + (shark.width - textWidth) / 2; // Center horizontally
	                int y = shark.y + (shark.height - textHeight) / 2 + metrics.getAscent(); // Center vertically
	 
	                g2d.drawString(shark.word, x, y); // Draw the centered text
	            }
	 
	            // Set font color to white and draw the score in the center of the screen
	            g2d.setColor(Color.WHITE);
	            g2d.setFont(new Font("Arial", Font.BOLD, 30));
	            String scoreText = "Score: " + score;
	            FontMetrics metrics = g2d.getFontMetrics();
	            int x = (getWidth() - metrics.stringWidth(scoreText)) / 2;
	            int y = metrics.getHeight();
	            g2d.drawString(scoreText, x, y);
	        } else {
	            // Game over logic
	            showGameOverDialog();
	        }
	    }
	 
	    private void draw3DTile(Graphics2D g2d, int x, int y, int width, int height, Color color) {
	        // Draw base rectangle
	        g2d.setColor(color);
	        g2d.fillRect(x, y, width, height);
	 
	        // Draw 3D effect
	        g2d.setColor(color.darker());
	        g2d.drawLine(x, y, x + 10, y - 10); // Top left edge
	        g2d.drawLine(x + width, y, x + width + 10, y - 10); // Top right edge
	        g2d.drawLine(x + width, y + height, x + width + 10, y + height - 10); // Bottom right edge
	        g2d.drawLine(x, y + height, x + 10, y + height - 10); // Bottom left edge
	 
	        g2d.setColor(color.brighter());
	        g2d.drawLine(x + 10, y - 10, x + width + 10, y - 10); // Top edge
	        g2d.drawLine(x + 10, y + height - 10, x + width + 10, y + height - 10); // Bottom edge
	        g2d.drawLine(x + width + 10, y - 10, x + width + 10, y + height - 10); // Right edge
	        g2d.drawLine(x + 10, y - 10, x + 10, y + height - 10); // Left edge
	    }
	 
	 
	    private void showGameOverDialog() {
	        // Calculate star rating based on the score
	        String stars = "";
	        if (score >= 500) stars = "★★★";
	        else if (score >= 50) stars = "★★";
	        else if (score >= 20) stars = "★";
	 
	        // Show game over dialog with score, star rating, and options
	        int result = JOptionPane.showOptionDialog(this,
	            "Game Over! Final Score: " + score + "\nRating: " + stars,
	            "Game Over",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.INFORMATION_MESSAGE,
	            null,
	            new Object[] {"Try Again", "Exit"},
	            "Try Again");
	 
	        // Handle the user's choice
	        if (result == 0) {
	            // Try Again - reset game state
	            resetGame();
	        } else if (result == 1) {
	            // Exit - close the application
	            System.exit(0);
	        }
	    }
	 
	    private void resetGame() {
	        // Reset game state
	        sharks.clear();
	        availableWords = new ArrayList<>(Arrays.asList(wordList));
	        score = 0;
	        gameRunning = true;
	        repaint();
	    }
	 
	 
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (gameRunning) {
	            // Move sharks
	            for (int i = 0; i < sharks.size(); i++) {
	                Shark shark = sharks.get(i);
	                shark.x -= sharkSpeed;
	 
	                // End game if any shark moves off the screen
	                if (shark.x + shark.width < 0) {
	                    gameRunning = false;
	                    break; // Exit the loop as game is over
	                }
	            }
	 
	            // Modify the shark spawn parameters
	            if (sharks.size() < maxSharks) {
	                spawnSharks();
	            }
	 
	            repaint();
	        }
	    }
	    
	    private void spawnSharks() {
	        // Increase difficulty by adding more unique words if available
	        int numWords = Math.min(maxSharks - sharks.size(), availableWords.size()); // Ensure correct number of sharks
	        for (int i = 0; i < numWords; i++) {
	            if (availableWords.isEmpty()) {
	                break; // Exit if no more available words
	            }
	            int yPosition = rand.nextInt(getHeight() - 75); // Adjusted for new height
	            String randomWord = availableWords.remove(rand.nextInt(availableWords.size())); // Remove word from available list
	            sharks.add(new Shark(1680, yPosition, 150, 75, randomWord)); // Adjusted size
	        }
	    }
	 
	    @Override  
	    // method for key pressed for the game
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	            showEscapeMenu();
	        } else if (gameRunning) {
	            char typedChar = Character.toUpperCase(e.getKeyChar());
	
	            if (Character.isLetter(typedChar)) {
	                for (int i = 0; i < sharks.size(); i++) {
	                    Shark shark = sharks.get(i);
	
	                    // Check if the current letter matches the first letter of the shark's word
	                    if (shark.word.length() > 0 && shark.word.charAt(0) == typedChar) {
	                        // Remove the first letter from the shark's word
	                        shark.word = shark.word.substring(1);
	
	                        // If the word is completely typed, remove the shark
	                        if (shark.word.isEmpty()) {
	                            sharks.remove(i);
	                            i--; // Adjust index after removal
	                            score++;
	                        }
	                        break; // Only match one shark at a time
	                    }
	                }
	            }
	        }
	    }
	    // GAME menu method
	 // GAME menu method
	    private void showEscapeMenu() {
	        timer.stop(); // Pause the game
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
	                timer.start(); // Resume the game
	                break;
	            case 1: // Restart
	                resetGame();
	                timer.start();
	                break;
	            case 2: // Exit
	                exitToPortalFrame();
	                break;
	            default: // If dialog is closed without selection, resume the game
	                timer.start();
	        }
	
	        // Ensure the game panel regains focus after closing the dialog
	        this.requestFocusInWindow();
	    }
	
	    // method for exit
	    private void exitToPortalFrame() {
	        onetothreeFrame pf = new onetothreeFrame();
	        pf.setVisible(true);
	        if (gameFrame != null) {
	            gameFrame.dispose();
	        } else {
	            System.out.println("Game is End");
	        }
	    }
	
	
	    @Override
	    public void keyReleased(KeyEvent e) {}
	 
	    @Override
	    public void keyTyped(KeyEvent e) {}
	 
	    public static void main(String[] args) {
	        // Set Nimbus Look and Feel
	        try {
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	            // Set custom colors after setting the Look and Feel
	            UIManager.put("nimbusBase", new Color(254, 246, 230));
	            UIManager.put("nimbusBlueGrey", new Color(0x18727d));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	
	        // Create and display the game frame
	        JFrame frame = new JFrame("Shark Game");
	        frame.setUndecorated(true); // Set undecorated before making the frame visible
	        Typegame gamePanel = new Typegame();
	        frame.add(gamePanel);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true); // Make the frame visible after setting it as undecorated
	    }
	}
	 
	class Shark {
	    int x, y, width, height;
	    String word;
	 
	    public Shark(int x, int y, int width, int height, String word) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	        this.word = word;
	    }
	}
