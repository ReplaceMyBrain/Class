package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI00 {

	private JFrame frmButtonTest;
	private JButton btnNewButton;
	private JLabel LBlTest;
	private JButton No1;
	private JButton No2;
	private JButton No3;
	private JButton Clear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI00 window = new GUI00();
					window.frmButtonTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI00() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmButtonTest = new JFrame();
		frmButtonTest.setTitle("Button Test");
		frmButtonTest.setBounds(100, 100, 450, 300);
		frmButtonTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmButtonTest.getContentPane().setLayout(null);
		frmButtonTest.getContentPane().add(getBtnNewButton());
		frmButtonTest.getContentPane().add(getLBlTest());
		frmButtonTest.getContentPane().add(getNo1());
		frmButtonTest.getContentPane().add(getNo2());
		frmButtonTest.getContentPane().add(getNo3());
		frmButtonTest.getContentPane().add(getClear());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "OK 버튼을 눌렀습니다.");
					LBlTest.setText("Button을 click했습니다");
				}
			});
			btnNewButton.setBounds(160, 119, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLBlTest() {
		if (LBlTest == null) {
			LBlTest = new JLabel("Java Swing Button Test");
			LBlTest.setBounds(12, 10, 167, 23);
		}
		return LBlTest;
	}
	private JButton getNo1() {
		if (No1 == null) {
			No1 = new JButton("1번");
			No1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "1번 버튼을 눌렀습니다.");
					LBlTest.setText("1번 버튼을 눌렀습니다.");
				}
			});
			No1.setBounds(27, 196, 97, 23);
		}
		return No1;
	}
	private JButton getNo2() {
		if (No2 == null) {
			No2 = new JButton("2번");
			No2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "2번 버튼을 눌렀습니다.");
					LBlTest.setText("2번 버튼을 눌렀습니다.");
				}
			});
			No2.setBounds(160, 196, 97, 23);
		}
		return No2;
	}
	private JButton getNo3() {
		if (No3 == null) {
			No3 = new JButton("3번");
			No3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "3번 버튼을 눌렀습니다.");
					LBlTest.setText("3번 버튼을 눌렀습니다.");
				}
			});
			No3.setBounds(283, 196, 97, 23);
		}
		return No3;
	}
	private JButton getClear() {
		if (Clear == null) {
			Clear = new JButton("Clear");
			Clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Clear 버튼을 눌렀습니다.");
					LBlTest.setText("Clear");
							
				}
			});
			Clear.setBounds(160, 152, 97, 23);
		}
		return Clear;
	}
}
