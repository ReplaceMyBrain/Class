package com.javalec.loginMain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

public class LoginMain extends JFrame {
	
	
	private JFrame frame;
	private JPanel loginPanel;
	private JLabel loginLabelTitle;
	private JLabel loginLabelLogo;
	private JLabel loginLabelDiv;
	private JLabel loginLabelFindId;
	private JLabel loginLabelFindPw;
	private JLabel loginLabelNoId;
	private JLabel loginLabelClick;	
	private JTextField tfidSearchName;
	private JTextField tfIdSearchEmail;
	private JTextField loginTextId;
	private JTextField loginTextPw;	
	private JTextField loginTextLogin;		
	BufferedImage img = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain window = new LoginMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginMain() {
		initialize();
		frame.setLocationRelativeTo(null);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLoginPanel());
		
		setInvisible(); // 첫 화면이 로그인화면만 나오게 초기화 
	}
	
	//----------- Loginpanel
		private JLabel getLoginLabelTitle() {
			if (loginLabelTitle == null) {
				loginLabelTitle = new JLabel("(프로그램 이름)");
				loginLabelTitle.setBounds(111, 6, 197, 75);
				loginLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
				loginLabelTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			}
			return loginLabelTitle;
		}
		private JLabel getLoginLabelLogo() {
			if (loginLabelLogo == null) {
				loginLabelLogo = new JLabel("(로고)");
				loginLabelLogo.setBounds(135, 70, 111, 119);
				loginLabelLogo.setHorizontalAlignment(SwingConstants.CENTER);
				loginLabelLogo.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			}
			return loginLabelLogo;
		}
		private JTextField getLoginTextId() {
			if (loginTextId == null) {
				loginTextId = new JTextField();
				loginTextId.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						loginTextId.setText("");
					}
				});
			
				loginTextId.setBounds(61, 190, 280, 43);
				loginTextId.setForeground(Color.LIGHT_GRAY);
				loginTextId.setText("  아이디");
				loginTextId.setColumns(10);
			}
			return loginTextId;
		}
		private JTextField getLoginTextPw() {
			if (loginTextPw == null) {
				loginTextPw = new JTextField();
				loginTextPw.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						loginTextPw.setText("");
					}
				});
				loginTextPw.setBounds(61, 245, 280, 43);
				loginTextPw.setForeground(Color.LIGHT_GRAY);
				loginTextPw.setText("  비밀번호");
				loginTextPw.setColumns(10);
			}
			return loginTextPw;
		}
		private JTextField getLoginTextLogin() {
			if (loginTextLogin == null) {
				loginTextLogin = new JTextField();
				loginTextLogin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						loginTextLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginTextLogin.setForeground(Color.black);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						loginTextLogin.setForeground(Color.white);
					}
				});
				loginTextLogin.setBounds(61, 338, 280, 43);
				loginTextLogin.setForeground(Color.WHITE);
				loginTextLogin.setText("로그인");
				loginTextLogin.setBackground(UIManager.getColor("Desktop.background"));
				loginTextLogin.setHorizontalAlignment(JTextField.CENTER);
				loginTextLogin.setColumns(10);
			}
			return loginTextLogin;
		}
		private JLabel getLoginTextNoId() {
			if (loginLabelNoId == null) {
				loginLabelNoId = new JLabel("계정이 없으신가요?");
				loginLabelNoId.setBounds(61, 300, 110, 16);
				loginLabelNoId.setForeground(Color.GRAY);
			}
			return loginLabelNoId;
		}
		private JLabel getLoginTextClick() {
			if (loginLabelClick == null) {
				loginLabelClick = new JLabel("여기를 클릭하세요!");
				loginLabelClick.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SignUp signup = new SignUp();
						signup.setVisible(true);
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelClick.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelClick.setForeground(Color.blue);
						loginLabelClick.setFont(new Font("Lucida Grande",Font.BOLD, 13));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelClick.setForeground(Color.GRAY);
					}
				});
				loginLabelClick.setBounds(172, 300, 110, 16);
				loginLabelClick.setForeground(SystemColor.controlHighlight);
			}
			return loginLabelClick;
		}
		private JLabel getLoginLabelFindId() {
			if (loginLabelFindId == null) {
				loginLabelFindId = new JLabel("아이디 찾기");
				loginLabelFindId.addMouseListener(new MouseAdapter() {
					@Override // 클릭 이벤트 
					public void mouseClicked(MouseEvent e) {
						JOptionPane.showMessageDialog(null,  "ID 찾기 다이얼로그");
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelFindId.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelFindId.setForeground(Color.DARK_GRAY);
						loginLabelFindId.setFont(new Font("Lucida Grande",Font.BOLD, 13));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelFindId.setForeground(Color.GRAY);
					}
				});
				loginLabelFindId.setBounds(129, 393, 61, 16);
				loginLabelFindId.setForeground(Color.GRAY);
			}
			return loginLabelFindId;
		}
		private JLabel getLoginLabelFindPw() {
			if (loginLabelFindPw == null) {
				loginLabelFindPw = new JLabel("비밀번호 찾기");
				loginLabelFindPw.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JOptionPane.showMessageDialog(null,  "ID 찾기 다이얼로그");
					}
					@Override // 마우스 가져다 댈 때 이벤트 
					public void mouseEntered(MouseEvent e) {
						loginLabelFindPw.setCursor(new Cursor(Cursor.HAND_CURSOR));
						loginLabelFindPw.setForeground(Color.DARK_GRAY);
						loginLabelFindPw.setFont(new Font("Lucida Grande",Font.BOLD, 13));
					}
					@Override // 마우스 땔 때 이벤트 
					public void mouseExited(MouseEvent e) {
						loginLabelFindPw.setForeground(Color.GRAY);
					}
				});
				
				loginLabelFindPw.setBounds(211, 393, 71, 16);
				loginLabelFindPw.setForeground(Color.GRAY);
			}
			return loginLabelFindPw;
		}
		private JLabel getLoginLabelDiv() {
			if (loginLabelDiv == null) {
				loginLabelDiv = new JLabel("|");
				loginLabelDiv.setBounds(195, 463, 15, 16);
				loginLabelDiv.setForeground(Color.GRAY);
			}
			return loginLabelDiv;
		}
		
		private JPanel getLoginPanel() { //
			if (loginPanel == null) {
				loginPanel = new JPanel();
				loginPanel.setBounds(0, 0, 412, 500);
				loginPanel.add(getLoginLabelDiv());
				loginPanel.add(getLoginLabelFindId());
				loginPanel.add(getLoginLabelFindPw());
				loginPanel.add(getLoginLabelLogo());
				loginPanel.add(getLoginLabelTitle());
				loginPanel.add(getLoginTextClick());
				loginPanel.add(getLoginTextId());
				loginPanel.add(getLoginTextLogin());
				loginPanel.add(getLoginTextNoId());
				loginPanel.add(getLoginTextPw());
//				
//				try {
//					img = ImageIO.read(new File("c://Users/yhj/Documents/Swing-Project/ProjectNo1/src/com/javalec/source/Background.png"));
//				} catch (Exception e) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(null,  "이미지 불러오기 실패!");
//				}
//				
//				g.drawImage(img,  0,  0,  null);

				loginPanel.setLayout(null);
				setResizable(false); // 창 크기 변경 불가 
				setLocationRelativeTo(null); // 창 크기를 변경하지 못하게 함 
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 정상적으로 JFrame이 종료되게 함.
			}
			return loginPanel;
		}

	public void setInvisible() {
	}
}

class myPanel extends JPanel {
	public void paint(Graphics g) {
		
	}
}
