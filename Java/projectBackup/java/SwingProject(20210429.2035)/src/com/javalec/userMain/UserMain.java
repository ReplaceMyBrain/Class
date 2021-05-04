package com.javalec.userMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.PanelUserAptitudeQuiz.PanelUserAptitudeQuiz;
import com.javalec.PanelUserMbti.PanelUserMbti;
import com.javalec.PanelUserProfile.PanelUserProfile;
import com.javalec.PanelUserStatistic.PanelUserStatistic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserMain dialog = new UserMain();
			dialog.frame.setVisible(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		RestPanel();
	}
	
	private JButton getBtnUserProfile() {
		if (btnUserProfile == null) {
			btnUserProfile = new JButton("프로필");
			btnUserProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelUserPrifile.setVisible(true);
				}
			});
			btnUserProfile.setBounds(30, 60, 120, 35);
		}
		return btnUserProfile;
	}
	private JButton getBtnUserMbti() {
		if (btnUserMbti == null) {
			btnUserMbti = new JButton("MBTI");
			btnUserMbti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelUserMbti.setVisible(true);
				}
			});
			btnUserMbti.setBounds(30, 155, 120, 35);
		}
		return btnUserMbti;
	}
	private JButton getBtnUserAptitudeQuiz() {
		if (btnUserAptitudeQuiz == null) {
			btnUserAptitudeQuiz = new JButton("적성검사");
			btnUserAptitudeQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RestPanel();
					panelUserAptitudeQuiz.setVisible(true);
				}
			});
			btnUserAptitudeQuiz.setBounds(30, 250, 120, 35);
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
				}
			});
			btnUserStatistic.setBounds(30, 345, 120, 35);
		}
		return btnUserStatistic;
	}
	
	private void RestPanel() {
		panelUserPrifile.setVisible(false);
		panelUserMbti.setVisible(false);
		panelUserAptitudeQuiz.setVisible(false);
		panelUserStatistic.setVisible(false);
		
	}
}
