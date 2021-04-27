package com.javalec.userMain;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUserMbti extends JPanel {
	private JButton btnMbtiNext;
	private JRadioButton rbMbtiResult1;
	private JRadioButton rbMbtiResult2;
	private JTextField tfMbitQuiz;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PanelUserMbti() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getBtnMbtiNext());
		add(getRbMbtiResult1());
		add(getRbMbtiResult2());
		add(getTfMbitQuiz());
	}
	private JButton getBtnMbtiNext() {
		if (btnMbtiNext == null) {
			btnMbtiNext = new JButton("다음");
			btnMbtiNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMbtiNext.setBounds(356, 319, 97, 23);
		}
		return btnMbtiNext;
	}
	private JRadioButton getRbMbtiResult1() {
		if (rbMbtiResult1 == null) {
			rbMbtiResult1 = new JRadioButton("New radio button");
			buttonGroup.add(rbMbtiResult1);
			rbMbtiResult1.setBounds(98, 204, 280, 23);
		}
		return rbMbtiResult1;
	}
	private JRadioButton getRbMbtiResult2() {
		if (rbMbtiResult2 == null) {
			rbMbtiResult2 = new JRadioButton("New radio button");
			buttonGroup.add(rbMbtiResult2);
			rbMbtiResult2.setBounds(98, 248, 280, 23);
		}
		return rbMbtiResult2;
	}
	private JTextField getTfMbitQuiz() {
		if (tfMbitQuiz == null) {
			tfMbitQuiz = new JTextField();
			tfMbitQuiz.setBounds(40, 65, 414, 113);
			tfMbitQuiz.setColumns(10);
		}
		return tfMbitQuiz;
	}
}
