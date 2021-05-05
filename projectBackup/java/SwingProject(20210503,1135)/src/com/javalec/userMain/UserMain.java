package com.javalec.userMain;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelUserAptitudeQuiz.PanelUserAptitudeQuiz;
import com.javalec.PanelUserMbti.PanelUserMbti;
import com.javalec.PanelUserProfile.PanelUserProfile;
import com.javalec.PanelUserStatistic.PanelUserStatistic;
import com.javalec.login.Login;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UserMain extends JDialog {
	
	private JFrame frame;
	private JButton btnUserProfile;
	private JButton btnUserMbti;
	private JButton btnUserAptitudeQuiz;
	private JButton btnUserStatistic;

	PanelUserProfile panelUserPrifile = new PanelUserProfile();
	PanelUserMbti panelUserMbti = new PanelUserMbti();
	PanelUserAptitudeQuiz panelUserAptitudeQuiz = new PanelUserAptitudeQuiz();
	PanelUserStatistic panelUserStatistic = new PanelUserStatistic();
	data_Enviroment_define dataDefine = new data_Enviroment_define();
	private JLabel lblogo;
	private JLabel lbLength;
	private JLabel lbwidh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserMain dialog = new UserMain();
			dialog.frame.setVisible(true);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserMain() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("유저 메인화면");
		frame.setBounds(100, 100, 720, 480);
		frame.getContentPane().setLayout(null);

		frame.getContentPane().add(getBtnUserProfile());
		frame.getContentPane().add(getBtnUserMbti());
		frame.getContentPane().add(getBtnUserAptitudeQuiz());
		frame.getContentPane().add(getBtnUserStatistic());
		
		frame.getContentPane().add(panelUserPrifile);
		frame.getContentPane().add(panelUserMbti); 
		frame.getContentPane().add(panelUserAptitudeQuiz); 
		frame.getContentPane().add(panelUserStatistic);
		
		JLabel labelNickname = new JLabel("");
		labelNickname.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		labelNickname.setBounds(35, 18, 127, 19);
		labelNickname.setText( dataDefine.userName + " 님 반갑습니다!");
		frame.getContentPane().add(labelNickname);
		
		JLabel labelLogout = new JLabel("logout");
		labelLogout.setForeground(new Color(0, 0, 0));
		labelLogout.setFont(new Font("Andale Mono", Font.PLAIN, 13));
		labelLogout.addMouseListener(new MouseAdapter() {
			int swtitchnum = 0;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// 닫기 다이얼로그 옵션
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_OPTION);
				if(result ==JOptionPane.CLOSED_OPTION) { // 사용자가 선택 없이 x를 누른 경우.
					
				} else if(result == JOptionPane.YES_OPTION) { // 예를 선택한 경우 
					RestPanel();
					frame.setVisible(false);
					Login login = new Login();
					
				} else { // 아니오를 선택한 경우
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelLogout.setForeground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelLogout.setForeground(Color.BLACK);
				labelLogout.setFont(new Font("Andale Mono",Font.PLAIN, 13));
			}
		});
		
		labelLogout.setBounds(100, 45, 51, 26);
		frame.getContentPane().add(labelLogout);
		frame.getContentPane().add(getLblogo());
		frame.getContentPane().add(getLbLength());
		frame.getContentPane().add(getLbwidh());
		
		
		RestPanel();
		frame.setVisible(true);

	}
	
	private JButton getBtnUserProfile() {
		if (btnUserProfile == null) {
			btnUserProfile = new JButton("프로필");
			btnUserProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelUserPrifile.setVisible(true);
					panelUserPrifile.Restart();
					
					
				}
			});
			btnUserProfile.setBounds(30, 100, 120, 35);
		}
		return btnUserProfile;
	}
	private JButton getBtnUserMbti() {
		if (btnUserMbti == null) {
			btnUserMbti = new JButton("MBTI");
			btnUserMbti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// 선택 다이얼로그 옵션
					int result = JOptionPane.showConfirmDialog(null, "MBTI 문항은 총 20문항이 출제 되며, 오래 고민 하시지 말고 첫 느낌대로 골라주시기 바랍니다. ", "확인",JOptionPane.YES_NO_OPTION);
					if(result ==JOptionPane.CLOSED_OPTION) { // 사용자가 선택 없이 x를 누른 경우.
						
					} else if(result == JOptionPane.YES_OPTION) { // 예를 선택한 경우 
						RestPanel();
						panelUserMbti.setVisible(true);
						
					} else { // 아니오를 선택한 경우
						
					}
				}
			});
			btnUserMbti.setBounds(30, 190, 120, 35);
		}
		return btnUserMbti;
	}
	private JButton getBtnUserAptitudeQuiz() {
		if (btnUserAptitudeQuiz == null) {
			btnUserAptitudeQuiz = new JButton("적성검사");
			btnUserAptitudeQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					// 선택 다이얼로그 옵션
					int result = JOptionPane.showConfirmDialog(null, "적성 문항은 총 10문항이 출제 되며, 오래 고민 하시지 말고 첫 느낌대로 골라주시기 바랍니다. ", "확인",JOptionPane.YES_NO_OPTION);
					if(result ==JOptionPane.CLOSED_OPTION) { // 사용자가 선택 없이 x를 누른 경우.
						
					} else if(result == JOptionPane.YES_OPTION) { // 예를 선택한 경우 
						RestPanel();
						panelUserAptitudeQuiz.setVisible(true);
						
					} else { // 아니오를 선택한 경우
						
					}				
				}
			});
			btnUserAptitudeQuiz.setBounds(30, 280, 120, 35);
		}
		return btnUserAptitudeQuiz;
	}
	private JButton getBtnUserStatistic() {
		if (btnUserStatistic == null) {
			btnUserStatistic = new JButton("통계");
			btnUserStatistic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelUserStatistic.setVisible(true);
					panelUserStatistic.Restart();
					
				}
			});
			btnUserStatistic.setBounds(30, 370, 120, 35);
		}
		return btnUserStatistic;
	}
	
	private void RestPanel() {
		panelUserPrifile.setVisible(false);
		panelUserMbti.setVisible(false);
		panelUserAptitudeQuiz.setVisible(false);
		panelUserStatistic.setVisible(false);
	}
	private JLabel getLblogo() {
		if (lblogo == null) {
			lblogo = new JLabel("");
			lblogo.setIcon(new ImageIcon(UserMain.class.getResource("/com/javalec/resources/main1.png")));
			lblogo.setBounds(260, 140, 330, 200);
		}
		return lblogo;
	}
	private JLabel getLbLength() {
		if (lbLength == null) {
			lbLength = new JLabel("");
			lbLength.setIcon(new ImageIcon(UserMain.class.getResource("/com/javalec/resources/length.png")));
			lbLength.setBounds(165, 10, 20, 420);
		}
		return lbLength;
	}
	private JLabel getLbwidh() {
		if (lbwidh == null) {
			lbwidh = new JLabel("");
			lbwidh.setIcon(new ImageIcon(UserMain.class.getResource("/com/javalec/resources/width.png")));
			lbwidh.setBounds(12, 70, 147, 15);
		}
		return lbwidh;
	}
}
