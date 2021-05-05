package com.javalec.adminMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.PanelManageUser.PanelManageUser;
import com.javalec.login.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class AdminMain extends JDialog {
	
	private JFrame frame;
	private JButton btnManageUser;
	private JButton btnManageQuiz;
	private JButton btnManageResult;
	
	PanelManageUser panelManageUser = new PanelManageUser();
	PanelManageQuiz panelManageQuiz = new PanelManageQuiz();
	PanelManageResult panelManageResult = new PanelManageResult();
	private final JLabel labelLogout = new JLabel("logout");
	private final JLabel labelNickname = new JLabel(" 관리자님 반갑습니다!");
	private final JLabel lblogo = new JLabel("");
	private final JLabel lblength = new JLabel("");
	private final JLabel widh = new JLabel("");
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminMain dialog = new AdminMain();
			dialog.frame.setVisible(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminMain() {
		initialize(); 
	}
		private void initialize() {
			frame = new JFrame();
			frame.setTitle("관리자 메인화면");
			frame.setBounds(100, 100, 720, 480);
			frame.getContentPane().setLayout(null);
			
			frame.getContentPane().add(getBtnManageUser());
			frame.getContentPane().add(getBtnManageQuiz());
			frame.getContentPane().add(getBtnManageResult());
			panelManageUser.setBounds(180, 10, 512, 420);
			
			frame.getContentPane().add(panelManageUser);
			frame.getContentPane().add(panelManageQuiz); 
			frame.getContentPane().add(panelManageResult); 
			labelLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
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
					labelLogout.setFont(new Font("Lucida Grande",Font.PLAIN, 13));
				}
			});
			labelLogout.setForeground(Color.BLACK);
			labelLogout.setFont(new Font("Andale Mono", Font.PLAIN, 13));
			labelLogout.setBounds(100, 45, 66, 26);
			
			frame.getContentPane().add(labelLogout);
			labelNickname.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			labelNickname.setBounds(35, 18, 127, 19);
			
			frame.getContentPane().add(labelNickname);
			lblogo.setIcon(new ImageIcon(AdminMain.class.getResource("/com/javalec/resources/main1.png")));
			lblogo.setBounds(260, 140, 330, 200);
			
			frame.getContentPane().add(lblogo);
			lblength.setIcon(new ImageIcon(AdminMain.class.getResource("/com/javalec/resources/length.png")));
			lblength.setBounds(165, 10, 20, 420);
			
			frame.getContentPane().add(lblength);
			widh.setIcon(new ImageIcon(AdminMain.class.getResource("/com/javalec/resources/width.png")));
			widh.setBounds(12, 70, 147, 15);
			
			frame.getContentPane().add(widh);
			frame.setVisible(true);
	}

	private JButton getBtnManageUser() {
		if (btnManageUser == null) {
			btnManageUser = new JButton("회원관리");
			btnManageUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelManageUser.setVisible(true);
					
				}
			});
			btnManageUser.setBounds(30, 110, 120, 35);
		}
		return btnManageUser;
	}
	private JButton getBtnManageQuiz() {
		if (btnManageQuiz == null) { 
			btnManageQuiz = new JButton("문제관리");
			btnManageQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelManageQuiz.setVisible(true);
				
				}
			});
			btnManageQuiz.setBounds(30, 220, 120, 35);
		}
		return btnManageQuiz;
	}
	private JButton getBtnManageResult() {
		if (btnManageResult == null) {
			btnManageResult = new JButton("결과관리");
			btnManageResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelManageResult.setVisible(true);
					

				}
			});
			btnManageResult.setBounds(30, 330, 120, 35);
		}
		return btnManageResult;
	}
	private void RestPanel() {
		panelManageUser.setVisible(false);
		panelManageQuiz.setVisible(false);
		panelManageResult.setVisible(false);
		
		panelManageQuiz.ResetQuizpanel();
		panelManageResult.ResetReulstPanel();
		 
	}
}
