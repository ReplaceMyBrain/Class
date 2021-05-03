package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;

import com.javalec.PanelManageAptitudeQuiz.PanelManageAptitudeQuiz;
import com.javalec.PanelManageMbtiQuiz.PanelManageMbtiQuiz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelManageQuiz extends JPanel {
	private JButton btnManageMbtiQuiz;
	private JButton btnManageAptitudeQuiz;
	PanelManageMbtiQuiz panelManageMbtiQuiz = new PanelManageMbtiQuiz();
	PanelManageAptitudeQuiz panelManageAptitudeQuiz = new PanelManageAptitudeQuiz();
	private final JLabel lblogo = new JLabel("");
	
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
		{
			lblogo.setIcon(new ImageIcon(PanelManageQuiz.class.getResource("/com/javalec/resources/main1.png")));
			lblogo.setBounds(80, 130, 330, 200);
			add(lblogo);
		}
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
					panelManageAptitudeQuiz.MAQ_ClearColumn();
					panelManageAptitudeQuiz.MAQ_TableInit();
					panelManageAptitudeQuiz.MAQ_tableInputAction();
					
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
