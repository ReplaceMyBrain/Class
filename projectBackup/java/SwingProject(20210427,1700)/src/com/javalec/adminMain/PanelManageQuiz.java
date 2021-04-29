package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelManageQuiz extends JPanel {
	private JButton btnManageMbtiQuiz;
	private JButton btnManageAptitudeQuiz;
	PanelManageAptitudeQuiz panelManageAptitudeQuiz = new PanelManageAptitudeQuiz();
	PanelManageMbtiQuiz panelManageMbtiQuiz = new PanelManageMbtiQuiz();
	
	/**
	 * Create the panel.
	 */
	public PanelManageQuiz() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getBtnManageMbtiQuiz());
		add(getBtnManageAptitudeQuiz());
	}

	private JButton getBtnManageMbtiQuiz() {
		if (btnManageMbtiQuiz == null) {
			btnManageMbtiQuiz = new JButton("MBTI문제");
			btnManageMbtiQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManageAptitudeQuiz.setVisible(false);
					panelManageMbtiQuiz.setVisible(true);
				}
			});
			btnManageMbtiQuiz.setBounds(86, 10, 120, 35);
		}
		return btnManageMbtiQuiz;
	}
	private JButton getBtnManageAptitudeQuiz() {
		if (btnManageAptitudeQuiz == null) {
			btnManageAptitudeQuiz = new JButton("적성문제");
			btnManageAptitudeQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManageAptitudeQuiz.setVisible(true);
					panelManageMbtiQuiz.setVisible(false);
				}
			});
			
			btnManageAptitudeQuiz.setBounds(300, 10, 120, 35);
		}
		return btnManageAptitudeQuiz;
	}
}
