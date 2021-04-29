package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;

import com.javalec.PanelManageAptitudeQuiz.PanelManageAptitudeQuiz;
import com.javalec.PanelManageMbtiQuiz.PanelManageMbtiQuiz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelManageQuiz extends JPanel {
	private JButton btnManageMbtiQuiz;
	private JButton btnManageAptitudeQuiz;
	PanelManageMbtiQuiz panelManageMbtiQuiz = new PanelManageMbtiQuiz();
	PanelManageAptitudeQuiz panelManageAptitudeQuiz = new PanelManageAptitudeQuiz();
	
	/**
	 * Create the panel.
	 */
	public PanelManageQuiz() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		setVisible(false);
		add(getBtnManageMbtiQuiz());
		add(getBtnManageAptitudeQuiz());
		add(panelManageMbtiQuiz);
		add(panelManageAptitudeQuiz);
	}

	private JButton getBtnManageMbtiQuiz() {
		if (btnManageMbtiQuiz == null) {
			btnManageMbtiQuiz = new JButton("MBTI문제");
			btnManageMbtiQuiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResetQuizpanel();
					panelManageAptitudeQuiz.setVisible(false);
					panelManageMbtiQuiz.setVisible(true);
					panelManageMbtiQuiz.MMQ_ClearColumn();
					panelManageMbtiQuiz.MMQ_TableInit();
					panelManageMbtiQuiz.MMQ_SearchAction();
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
					ResetQuizpanel();
					panelManageAptitudeQuiz.setVisible(true);
					panelManageMbtiQuiz.setVisible(false);
				}
			});
			
			btnManageAptitudeQuiz.setBounds(300, 10, 120, 35);
		}
		return btnManageAptitudeQuiz;
	}
	
	public void ResetQuizpanel() {
		panelManageAptitudeQuiz.setVisible(false);
		panelManageMbtiQuiz.setVisible(false);
	}
	
	
	
	
	
	
}//=========================
