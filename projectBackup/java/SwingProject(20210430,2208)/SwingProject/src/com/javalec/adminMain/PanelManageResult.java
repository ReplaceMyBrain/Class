package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;

import com.javalec.PanelManageAptitudeResult.PanelManageAptitudeResult;
import com.javalec.PanelManageMbtiResult.PanelManageMbtiResult;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelManageResult extends JPanel {
	private JButton btnManageMbtiResult;
	private JButton btnManageAptitudeResult;
	PanelManageMbtiResult panelManageMbtiResult = new PanelManageMbtiResult();
	PanelManageAptitudeResult panelManageAptitudeResult = new PanelManageAptitudeResult();
	/**
	 * Create the panel.
	 */
	public PanelManageResult() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		setVisible(false);
		add(getBtnManageMbtiResult());
		add(getBtnManageAptitudeResult());
		add(panelManageMbtiResult);
		add(panelManageAptitudeResult);
	}
	private JButton getBtnManageMbtiResult() {
		if (btnManageMbtiResult == null) {
			btnManageMbtiResult = new JButton("MBTI 결과");
			btnManageMbtiResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResetReulstPanel();
					panelManageMbtiResult.setVisible(true);
					panelManageAptitudeResult.setVisible(false);
				}
			});
			btnManageMbtiResult.setBounds(86, 10, 120, 35);
		}
		return btnManageMbtiResult;
	}
	private JButton getBtnManageAptitudeResult() {
		if (btnManageAptitudeResult == null) {
			btnManageAptitudeResult = new JButton("적성 결과");
			btnManageAptitudeResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResetReulstPanel();
					panelManageMbtiResult.setVisible(false);
					panelManageAptitudeResult.setVisible(true);
				}
			});
			btnManageAptitudeResult.setBounds(300, 10, 120, 35);
		}
		return btnManageAptitudeResult;
	}
	
	public void ResetReulstPanel() {
		panelManageMbtiResult.setVisible(false);
		panelManageAptitudeResult.setVisible(false);
	}
	
	
	
	
	
	
}//====================
