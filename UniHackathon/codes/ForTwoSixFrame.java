package codes;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.BasicStroke;
import sourcecode.Portal;


public class ForTwoSixFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private ImageIcon backarrow = new ImageIcon(
	            new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\arrow.png")
	                .getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForTwoSixFrame frame = new ForTwoSixFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForTwoSixFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1680, 945);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 1680, 945);
		getContentPane().add(backgroundPanel);
		backgroundPanel.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel backlbl = new JLabel("");
		backlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.setVisible(true);
				dispose();
			}
		});
		
		JLabel name = new JLabel("Grade 4 to 6");
		name.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		name.setBounds(868, 32, 332, 93);
		backgroundPanel.add(name);
		
		JLabel buildinglbl = new JLabel("");
		buildinglbl.setIcon(new ImageIcon(ForTwoSixFrame.class.getResource("/img/Building.png")));
		buildinglbl.setBounds(728, 11, 130, 121);
		backgroundPanel.add(buildinglbl);
		backlbl.setIcon(backarrow);
		backlbl.setBounds(10, 11, 107, 93);
		backgroundPanel.add(backlbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(121, 209, 1494, 725);
		panel.setOpaque(false);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		
		// ======================= FOURTH SUBJECT ==============================================

		JPanel headerPanel_3 = new JPanel() {
			private Image icon;

            {
                // Load the icon image
                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\Institution.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the white oval
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(0, 0, getWidth(), getHeight());

                // Draw the icon in the center of the oval
                int iconWidth = icon.getWidth(this);
                int iconHeight = icon.getHeight(this);
                int x = (getWidth() - iconWidth) / 2;
                int y = (getHeight() - iconHeight) / 2;
                g2d.drawImage(icon, x, y, this);
            }
		};
		headerPanel_3.setLayout(null);
		headerPanel_3.setOpaque(false);
		headerPanel_3.setBounds(773, 318, 170, 160);
		panel.add(headerPanel_3);
		panel.add(headerPanel_3);
			
			
		// ======================= FIRST SUBJECT ==============================================
		JPanel headerPanel = new JPanel() {
            private Image icon;

            {
                // Load the icon image
                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\streamline_book-reading-solid.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the white oval
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(0, 0, getWidth(), getHeight());

                // Draw the icon in the center of the oval
                int iconWidth = icon.getWidth(this);
                int iconHeight = icon.getHeight(this);
                int x = (getWidth() - iconWidth) / 2;
                int y = (getHeight() - iconHeight) / 2;
                g2d.drawImage(icon, x, y, this);
            }
		 };
		headerPanel.setOpaque(false);
		headerPanel.setBounds(85, 34, 170, 160);
		panel.add(headerPanel);
		headerPanel.setLayout(null);
		
		JPanel BodyPanel = new JPanel();
		BodyPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	try {
                    File pdfFile = new File("C:\\Users\\megel\\eclipse-workspace\\Unitour\\src\\file\\GRADE 4 SUBJECTS.pdf");
                    if (pdfFile.exists()) {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Desktop is not supported");
                        }
                    } else {
                        System.out.println("File does not exist");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	
		    }
		});
		BodyPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		BodyPanel.setBackground(new Color(15, 184, 74));
		BodyPanel.setBounds(229, 65, 402, 104);
		panel.add(BodyPanel);
		BodyPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reading & Writing");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel.setBounds(66, 21, 288, 59);
		BodyPanel.add(lblNewLabel);
		
		// ======================= SECOND SUBJECT ==============================================
		JPanel headerPanel_1 = new JPanel() {
			 private Image icon;

	            {
	                // Load the icon image
	                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\finance.png").getImage();
	            }

	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2d = (Graphics2D) g;

	                // Draw the white oval
	                g2d.setColor(Color.WHITE);
	                g2d.fillOval(0, 0, getWidth(), getHeight());

	                // Draw the black border
	                g2d.setColor(Color.BLACK);
	                g2d.setStroke(new BasicStroke(3));
	                g2d.drawOval(0, 0, getWidth(), getHeight());

	                // Draw the icon in the center of the oval
	                int iconWidth = icon.getWidth(this);
	                int iconHeight = icon.getHeight(this);
	                int x = (getWidth() - iconWidth) / 2;
	                int y = (getHeight() - iconHeight) / 2;
	                g2d.drawImage(icon, x, y, this);
	            }
		};
		headerPanel_1.setLayout(null);
		headerPanel_1.setOpaque(false);
		headerPanel_1.setBounds(85, 318, 170, 160);
		panel.add(headerPanel_1);
		
		JPanel BodyPanel_1 = new JPanel();
		BodyPanel_1.setLayout(null);
		BodyPanel_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	try {
                    File pdfFile = new File("C:\\Users\\megel\\eclipse-workspace\\Unitour\\src\\file\\GRADE 5 SUBJECTS.pdf");
                    if (pdfFile.exists()) {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Desktop is not supported");
                        }
                    } else {
                        System.out.println("File does not exist");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
		    			    }
		});
		BodyPanel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		BodyPanel_1.setBackground(new Color(15, 184, 74));
		BodyPanel_1.setBounds(229, 348, 402, 104);
		panel.add(BodyPanel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Finance");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(135, 21, 219, 59);
		BodyPanel_1.add(lblNewLabel_1);
	
		// ======================= THIRD SUBJECT ==============================================
		JPanel headerPanel_2 = new JPanel() {
			private Image icon;

            {
                // Load the icon image
                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\programming.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the white oval
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(0, 0, getWidth(), getHeight());

                // Draw the icon in the center of the oval
                int iconWidth = icon.getWidth(this);
                int iconHeight = icon.getHeight(this);
                int x = (getWidth() - iconWidth) / 2;
                int y = (getHeight() - iconHeight) / 2;
                g2d.drawImage(icon, x, y, this);
            }
		};
		headerPanel_2.setLayout(null);
		headerPanel_2.setOpaque(false);
		headerPanel_2.setBounds(773, 34, 170, 160);
		panel.add(headerPanel_2);
		
		JPanel BodyPanel_2 = new JPanel();
		BodyPanel_2.setLayout(null);
		BodyPanel_2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	try {
                    File pdfFile = new File("C:\\Users\\megel\\eclipse-workspace\\Unitour\\src\\file\\978-1-84996-537-8.pdf");
                    if (pdfFile.exists()) {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Desktop is not supported");
                        }
                    } else {
                        System.out.println("File does not exist");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
		    		    }
		});
		BodyPanel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		BodyPanel_2.setBackground(new Color(15, 184, 74));
		BodyPanel_2.setBounds(917, 65, 402, 104);
		panel.add(BodyPanel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Programming");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_2.setBounds(105, 21, 249, 59);
		BodyPanel_2.add(lblNewLabel_2);
		
		JPanel BodyPanel_3 = new JPanel();
		BodyPanel_3.setLayout(null);
		BodyPanel_3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	try {
                    File pdfFile = new File("C:\\Users\\megel\\eclipse-workspace\\Unitour\\src\\file\\GRADE 6 SUBJECTS.pdf");
                    if (pdfFile.exists()) {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("Desktop is not supported");
                        }
                    } else {
                        System.out.println("File does not exist");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
		    	
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
		    		    }
		});
		BodyPanel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		BodyPanel_3.setBackground(new Color(15, 184, 74));
		BodyPanel_3.setBounds(917, 348, 402, 104);
		panel.add(BodyPanel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Institution");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(135, 21, 219, 59);
		BodyPanel_3.add(lblNewLabel_1_1);
		
		JPanel headerPanel_5 = new JPanel() {
            private Image icon;

            {
                // Load the icon image
                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\game.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the white oval
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(0, 0, getWidth(), getHeight());

                // Draw the icon in the center of the oval
                int iconWidth = icon.getWidth(this);
                int iconHeight = icon.getHeight(this);
                int x = (getWidth() - iconWidth) / 2;
                int y = (getHeight() - iconHeight) / 2;
                g2d.drawImage(icon, x, y, this);
            }
        };

        headerPanel_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame gameFrame = new JFrame("Typegame");
                AdvancedQuizBeeGame tg = new AdvancedQuizBeeGame();
                gameFrame.getContentPane().add(tg);
                gameFrame.setSize(1680, 940);
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gameFrame.setVisible(true);
                gameFrame.pack();
                gameFrame.setLocationRelativeTo(null);
                //gameFrame.setUndecorated(true); // Set undecorated before making the frame visible

            }
        });

        headerPanel_5.setLayout(null);
        headerPanel_5.setOpaque(false);
        headerPanel_5.setBounds(1314, 565, 170, 160);
        
        JPanel headerPanel_3_1 = new JPanel() {
        	private Image icon;

            {
                // Load the icon image
                icon = new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\Unitour\\img\\img\\game.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw the white oval
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());

                // Draw the black border
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(0, 0, getWidth(), getHeight());

                // Draw the icon in the center of the oval
                int iconWidth = icon.getWidth(this);
                int iconHeight = icon.getHeight(this);
                int x = (getWidth() - iconWidth) / 2;
                int y = (getHeight() - iconHeight) / 2;
                g2d.drawImage(icon, x, y, this);
            }
        };
        headerPanel_3_1.setLayout(null);
        headerPanel_3_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame gameFrame = new JFrame("Typegame");
                AdvancedQuizBeeGame tg = new AdvancedQuizBeeGame();
                gameFrame.getContentPane().add(tg);
                gameFrame.setSize(1680, 940);
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gameFrame.setVisible(true);
                gameFrame.pack();
                gameFrame.setLocationRelativeTo(null);
                //gameFrame.setUndecorated(true); // Set undecorated before making the frame visible

            }
        });
        headerPanel_3_1.setOpaque(false);
        headerPanel_3_1.setBounds(1314, 554, 170, 160);
        panel.add(headerPanel_3_1);
		//============ END SUBJECT
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Portal.class.getResource("/img/Backgrounds.png")));
		background.setBounds(0, 121, 162, 88);
		background.setBounds(0, 0, 1680, 945);
		backgroundPanel.add(background);
	}
}
