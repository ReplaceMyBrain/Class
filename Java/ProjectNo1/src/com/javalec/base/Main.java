package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class Main {

	private JFrame frame;
	private JPanel login;
	private JPanel mainTopl;
	private JPanel mainUserMenu;
	private JPanel mainAdMenu;
	private JPanel userProfile;
	private JPanel userMbti;
	private JPanel userQuiz;
	private JPanel manageMem;
	private JPanel manageMbtiResults;
	private JPanel manageMbtiQuiz;
	private JPanel manageQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		frame.setLocationRelativeTo(null);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getMainTopl());
		frame.getContentPane().add(getManageQuiz());
		frame.getContentPane().add(getLogin());
		frame.getContentPane().add(getMainAdMenu());
		frame.getContentPane().add(getUserProfile());
		frame.getContentPane().add(getMainUserMenu());
		frame.getContentPane().add(getUserMbti());
		frame.getContentPane().add(getUserQuiz());
		frame.getContentPane().add(getManageMem());
		frame.getContentPane().add(getManageMbtiResults());
		frame.getContentPane().add(getManageMbtiQuiz());
		
	}
	private JPanel getLogin() {
		if (login == null) {
			login = new JPanel();
			login.setBackground(Color.RED);
			login.setBounds(0, 0, 704, 441);
			login.setLayout(null);
			login.setVisible(false);
			
			
		}
		return login;
	}
	private JPanel getMainTopl() {
		if (mainTopl == null) {
			mainTopl = new JPanel();
			mainTopl.setBackground(Color.MAGENTA);
			mainTopl.setBounds(0, 0, 704, 45);
			mainTopl.setVisible(false);
			
		}
		return mainTopl;
	}
	private JPanel getMainUserMenu() {
		if (mainUserMenu == null) {
			mainUserMenu = new JPanel();
			mainUserMenu.setBackground(Color.LIGHT_GRAY);
			mainUserMenu.setBounds(0, 45, 165, 396);
			mainUserMenu.setVisible(false);
			
		}
		return mainUserMenu;
	}
	private JPanel getMainAdMenu() {
		if (mainAdMenu == null) {
			mainAdMenu = new JPanel();
			mainAdMenu.setBackground(Color.RED);
			mainAdMenu.setBounds(0, 45, 165, 396);
			mainAdMenu.setVisible(false);
			
			
		}
		return mainAdMenu;
	}
	private JPanel getUserProfile() {
		if (userProfile == null) {
			userProfile = new JPanel();
			userProfile.setBackground(Color.PINK);
			userProfile.setBounds(165, 45, 539, 396);
			userProfile.setVisible(false);
			
		}
		return userProfile;
	}
	private JPanel getUserMbti() {
		if (userMbti == null) {
			userMbti = new JPanel();
			userMbti.setBackground(Color.ORANGE);
			userMbti.setBounds(165, 45, 539, 396);
			userMbti.setVisible(false);
			
		}
		return userMbti;
	}
	private JPanel getUserQuiz() {
		if (userQuiz == null) {
			userQuiz = new JPanel();
			userQuiz.setBackground(Color.MAGENTA);
			userQuiz.setBounds(165, 45, 539, 396);
			userQuiz.setVisible(false);
			
		}
		return userQuiz;
	}
	private JPanel getManageMem() {
		if (manageMem == null) {
			manageMem = new JPanel();
			manageMem.setBackground(Color.YELLOW);
			manageMem.setBounds(165, 45, 539, 396);
			manageMem.setVisible(false);
			
		}
		return manageMem;
	}
	private JPanel getManageMbtiResults() {
		if (manageMbtiResults == null) {
			manageMbtiResults = new JPanel();
			manageMbtiResults.setBackground(Color.GREEN);
			manageMbtiResults.setBounds(165, 45, 539, 396);
			manageMbtiResults.setVisible(false);
			
		}
		return manageMbtiResults;
	}
	private JPanel getManageMbtiQuiz() {
		if (manageMbtiQuiz == null) {
			manageMbtiQuiz = new JPanel();
			manageMbtiQuiz.setBackground(Color.BLUE);
			manageMbtiQuiz.setBounds(165, 45, 539, 396);
			manageMbtiQuiz.setVisible(false);
			
		}
		return manageMbtiQuiz;
	}
	private JPanel getManageQuiz() {
		if (manageQuiz == null) {
			manageQuiz = new JPanel();
			manageQuiz.setBackground(Color.CYAN);
			manageQuiz.setBounds(165, 45, 539, 396);
			manageQuiz.setVisible(false);
			
		}
		return manageQuiz;
	}
}
