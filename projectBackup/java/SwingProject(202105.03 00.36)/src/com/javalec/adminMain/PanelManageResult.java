package com.javalec.adminMain;

import java.awt.Rectangle;

import javax.swing.JPanel;

import com.javalec.PanelManageAptitudeResult.PanelManageAptitudeResult;
import com.javalec.PanelManageMbtiResult.PanelManageMbtiResult;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelManageResult extends JPanel {
	private JButton btnManageMbtiResult;
	private JButton btnManageAptitudeResult;
	PanelManageMbtiResult panelManageMbtiResult = new PanelManageMbtiResult();
	PanelManageAptitudeResult panelManageAptitudeResult = new PanelManageAptitudeResult();
	private final JLabel lblogo = new JLabel("");
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
		{
			lblogo.setIcon(new ImageIcon(PanelManageResult.class.getResource("/com/javalec/resources/main1.png")));
			lblogo.setBounds(80, 130, 330, 200);
			add(lblogo);
		}
	}
	private JButton getBtnManageMbtiResult() {
		if (btnManageMbtiResult == null) {
			btnManageMbtiResult = new JButton("MBTI 결과");
			btnManageMbtiResult.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ResetReulstPanel();
					panelManageMbtiResult.setVisible(true);
					panelManageAptitudeResult.setVisible(false);
					panelManageMbtiResult.MMR_TableInit();
					panelManageMbtiResult.MMR_selectList();
					panelManageMbtiResult.MMR_ClearColumn();
					
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
					panelManageAptitudeResult.MAR_TableInit();
					panelManageAptitudeResult.MAR_selectList();
					panelManageAptitudeResult.MAR_ClearColumn();
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
