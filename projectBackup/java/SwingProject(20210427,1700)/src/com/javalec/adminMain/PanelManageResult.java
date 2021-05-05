package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelManageResult extends JPanel {
	private JButton btnManageMbtiResult;
	private JButton btnManageAptitudeResult;
	PanelManageAptitudeResult panelManageAptitudeResult = new PanelManageAptitudeResult();
	PanelManageMbtiResult panelManageMbtiResult = new PanelManageMbtiResult();

	/**
	 * Create the panel.
	 */
	public PanelManageResult() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getBtnManageMbtiResult());
		add(getBtnManageAptitudeResult());
	}
	private JButton getBtnManageMbtiResult() {
		if (btnManageMbtiResult == null) {
			btnManageMbtiResult = new JButton("MBTI문제");
			btnManageMbtiResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManageAptitudeResult.setVisible(false);
					panelManageMbtiResult.setVisible(true);
				}
			});
			btnManageMbtiResult.setBounds(86, 10, 120, 35);
		}
		return btnManageMbtiResult;
	}
	private JButton getBtnManageAptitudeResult() {
		if (btnManageAptitudeResult == null) {
			btnManageAptitudeResult = new JButton("적성문제");
			btnManageAptitudeResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelManageAptitudeResult.setVisible(true);
					panelManageMbtiResult.setVisible(false);
				}
			});
			btnManageAptitudeResult.setBounds(300, 10, 120, 35);
		}
		return btnManageAptitudeResult;
	}
}
