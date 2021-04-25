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
	private JPanel userQuiz_1;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getMainAdMenu());
		frame.getContentPane().add(getMainTopl());
		frame.getContentPane().add(getMainUserMenu());
		frame.getContentPane().add(getLogin());
		frame.getContentPane().add(getUserProfile());
		frame.getContentPane().add(getUserMbti());
		frame.getContentPane().add(getUserQuiz());
		frame.getContentPane().add(getUserQuiz_1());
	}
	private JPanel getLogin() {
		if (login == null) {
			login = new JPanel();
			login.setBounds(0, 0, 704, 441);
			login.setLayout(null);
		}
		return login;
	}
	private JPanel getMainTopl() {
		if (mainTopl == null) {
			mainTopl = new JPanel();
			mainTopl.setBackground(Color.MAGENTA);
			mainTopl.setBounds(0, 0, 704, 45);
		}
		return mainTopl;
	}
	private JPanel getMainUserMenu() {
		if (mainUserMenu == null) {
			mainUserMenu = new JPanel();
			mainUserMenu.setBackground(Color.LIGHT_GRAY);
			mainUserMenu.setBounds(0, 45, 165, 396);
		}
		return mainUserMenu;
	}
	private JPanel getMainAdMenu() {
		if (mainAdMenu == null) {
			mainAdMenu = new JPanel();
			mainAdMenu.setBackground(Color.RED);
			mainAdMenu.setBounds(0, 45, 165, 396);
		}
		return mainAdMenu;
	}
	private JPanel getUserProfile() {
		if (userProfile == null) {
			userProfile = new JPanel();
			userProfile.setBounds(165, 45, 539, 396);
		}
		return userProfile;
	}
	private JPanel getUserMbti() {
		if (userMbti == null) {
			userMbti = new JPanel();
			userMbti.setBounds(165, 45, 539, 396);
		}
		return userMbti;
	}
	private JPanel getUserQuiz() {
		if (userQuiz == null) {
			userQuiz = new JPanel();
			userQuiz.setBounds(165, 45, 539, 396);
		}
		return userQuiz;
	}
	private JPanel getUserQuiz_1() {
		if (userQuiz_1 == null) {
			userQuiz_1 = new JPanel();
			userQuiz_1.setBounds(165, 45, 539, 396);
		}
		return userQuiz_1;
	}
}
