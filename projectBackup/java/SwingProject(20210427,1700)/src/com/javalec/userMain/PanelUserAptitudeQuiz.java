package com.javalec.userMain;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUserAptitudeQuiz extends JPanel {
	private JButton btnAptitudeNext;
	private JRadioButton rbAptitudeResult2;
	private JRadioButton rbAptitudeResult1;
	private JTextField tfAptitudeQuiz;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PanelUserAptitudeQuiz() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getBtnAptitudeNext());
		add(getRbAptitudeResult2());
		add(getRbAptitudeResult1());
		add(getTfAptitudeQuiz());

	}
	private JButton getBtnAptitudeNext() {
		if (btnAptitudeNext == null) {
			btnAptitudeNext = new JButton("다음");
			btnAptitudeNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAptitudeNext.setBounds(356, 319, 97, 23);
		}
		return btnAptitudeNext;
	}
	private JRadioButton getRbAptitudeResult2() {
		if (rbAptitudeResult2 == null) {
			rbAptitudeResult2 = new JRadioButton("New radio button");
			buttonGroup.add(rbAptitudeResult2);
			rbAptitudeResult2.setBounds(98, 248, 280, 23);
		}
		return rbAptitudeResult2;
	}
	private JRadioButton getRbAptitudeResult1() {
		if (rbAptitudeResult1 == null) {
			rbAptitudeResult1 = new JRadioButton("New radio button");
			buttonGroup.add(rbAptitudeResult1);
			rbAptitudeResult1.setBounds(98, 204, 280, 23);
		}
		return rbAptitudeResult1;
	}
	private JTextField getTfAptitudeQuiz() {
		if (tfAptitudeQuiz == null) {
			tfAptitudeQuiz = new JTextField();
			tfAptitudeQuiz.setColumns(10);
			tfAptitudeQuiz.setBounds(40, 65, 414, 113);
		}
		return tfAptitudeQuiz;
	}
}
