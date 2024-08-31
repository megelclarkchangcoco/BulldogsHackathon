package codes;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sourcecode.Portal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class PortalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	boolean isBackgroundChanged = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortalFrame frame = new PortalFrame();
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
	public PortalFrame() {
		setBounds(100, 100, 1680, 945);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel background_panel = new JPanel();
		//background_panel.setBounds(0, 0, 1664, 906);
		background_panel.setBounds(0, 0, 1680, 945);
		getContentPane().add(background_panel);
		background_panel.setLayout(null);
		background_panel.setOpaque(false);
		
		
		JLabel bookimgLbl = new JLabel("");
		bookimgLbl.setBounds(490, 76, 719, 822);
		background_panel.add(bookimgLbl);
		bookimgLbl.setIcon(new ImageIcon(PortalFrame.class.getResource("/img/MainStart.png")));
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Portal.class.getResource("/img/PortalBackgrounds.png")));
		background.setBounds(0, 121, 162, 88);
		background.setBounds(0, 0, 1680, 945);
		background_panel.add(background);
		
		JPanel portalBackground = new JPanel();
		portalBackground.setBounds(480, 76, 732, 820);
		background_panel.add(portalBackground);
		portalBackground.setLayout(null);
		
		JPanel startPanel = new JPanel();
		startPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
		        if (!isBackgroundChanged) {
		            startPanel.setBackground(new Color(85, 155, 14));
		    		startPanel.setBorder(new LineBorder(new Color(255, 255, 255)));
		            isBackgroundChanged = true;
		        }
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        if (isBackgroundChanged) {
		            startPanel.setBackground(new Color(255, 255, 255));
		            isBackgroundChanged = false;
		        }
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (isBackgroundChanged) {
		            startPanel.setBackground(new Color(255, 255, 255));
		            isBackgroundChanged = false;
		            
		            MenuFrame mf = new MenuFrame();
		            mf.setVisible(true);
		            dispose();
		        } else {
		            startPanel.setBackground(new Color(85, 155, 14));
		    		startPanel.setBorder(new LineBorder(new Color(255, 255, 255)));
		            isBackgroundChanged = true;
		        }
		    }
			
		});
		portalBackground.add(startPanel);
		startPanel.setBackground(new Color(255, 255, 255));
		startPanel.setBounds(219, 668, 283, 51);
		startPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(92, 11, 139, 30);
		startPanel.add(lblNewLabel);
	}
}
