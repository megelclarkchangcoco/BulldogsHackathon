package codes;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sourcecode.Kinder;
import sourcecode.Portal;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ImageIcon kinder = new ImageIcon("img\\img\\portalKinder.png");
	private ImageIcon onetothree = new ImageIcon("img\\img\\portalKinder.png");
	private ImageIcon fourtosix = new ImageIcon("img\\img\\portalKinder.png");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
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
		
		JLabel portalLbl = new JLabel("New label");
		portalLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PortalFrame pt = new PortalFrame();
				pt.setVisible(true);
				dispose();
			}
		});
		portalLbl.setIcon(new ImageIcon(MenuFrame.class.getResource("/img/Portal.png")));
		portalLbl.setBounds(26, 11, 247, 71);
		background_panel.add(portalLbl);
		
		JPanel panelGrade = new JPanel();
		panelGrade.setBounds(554, 172, 572, 602);
		background_panel.add(panelGrade);
		panelGrade.setLayout(null);
		panelGrade.setOpaque(false);
		
		//kinder panel
		JPanel panelKinder = new JPanel();
		panelKinder.setBounds(0, 0, 572, 188);
		panelGrade.add(panelKinder);
        panelKinder.setLayout(null);
        panelKinder.setOpaque(false);
        
        JLabel labelkinder = new JLabel("");
        labelkinder.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		KinderFrame kd = new KinderFrame();
        		kd.setVisible(true);
        		dispose();
        	}
        });
        labelkinder.setIcon(new ImageIcon(Portal.class.getResource("/img/portalKinder.png")));
        labelkinder.setBounds(0, 0, 572, 188);
        panelKinder.add(labelkinder);

        
        //4to6 panel
		JPanel panel4To6 = new JPanel();
		panel4To6.setBounds(0, 414, 572, 188);
		panelGrade.add(panel4To6);
		panel4To6.setLayout(null);
		panel4To6.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForTwoSixFrame fs = new ForTwoSixFrame();
				fs.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Portal.class.getResource("/img/portal4to6.png")));
		lblNewLabel.setBounds(0, 0, 572, 188);
		panel4To6.add(lblNewLabel);
		
		//1to3 panel
		JPanel panel1To3 = new JPanel();
		panel1To3.setBounds(0, 208, 572, 188);
		panelGrade.add(panel1To3);
        panel1To3.setLayout(null);
        panel1To3.setOpaque(false);
        
        JLabel label1to3 = new JLabel("");
        label1to3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		onetothreeFrame ot = new onetothreeFrame();
        		ot.setVisible(true);
        		dispose();
        	}
        });
        label1to3.setIcon(new ImageIcon(Portal.class.getResource("/img/portal1to3.png")));
        label1to3.setBounds(0, 0, 572, 188);
        panel1To3.add(label1to3);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Portal.class.getResource("/img/Background.png")));
		background.setBounds(0, 121, 162, 88);
		background.setBounds(0, 0, 1680, 945);
		background_panel.add(background);
	}

}
