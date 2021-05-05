package com.javalec.PanelUserProfile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.javalec.Datadefine.data_Enviroment_define;
import javax.swing.UIManager;

public class PanelUserProfile extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JTextField tfEmail;
	private JLabel lblNewLabel_3;
	private JTextField tfMbti;
	private JLabel lblNewLabel_4;
	private JTextField tfAptitude;
	private JTextField tfID;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JButton btuWithdrawal;

	

	/**
	 * Create the panel.
	 */
	public PanelUserProfile() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLblNewLabel());
		add(getTfName());
		add(getTfEmail());
		add(getLblNewLabel_3());
		add(getTfMbti());
		add(getLblNewLabel_4());
		add(getTfAptitude());
		add(getTfID());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1_1());
		add(getBtuWithdrawal());
		UP_Show();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름       :");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(37, 57, 94, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setSelectionColor(new Color(255, 255, 255));
			tfName.setForeground(Color.BLACK);
			tfName.setColumns(10);
			tfName.setBounds(143, 52, 116, 21);
		}
		return tfName;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setSelectionColor(new Color(255, 255, 255));
			tfEmail.setForeground(Color.BLACK);
			tfEmail.setColumns(10);
			tfEmail.setBounds(143, 198, 211, 21);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("MBTI      :");
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setBounds(37, 273, 94, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfMbti() {
		if (tfMbti == null) {
			tfMbti = new JTextField();
			tfMbti.setEditable(false);
			tfMbti.setSelectionColor(new Color(255, 255, 255));
			tfMbti.setForeground(Color.BLACK);
			tfMbti.setColumns(10);
			tfMbti.setBounds(143, 271, 116, 21);
		}
		return tfMbti;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("적성검사  :");
			lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel_4.setForeground(Color.BLACK);
			lblNewLabel_4.setBounds(37, 345, 94, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfAptitude() {
		if (tfAptitude == null) {
			tfAptitude = new JTextField();
			tfAptitude.setEditable(false);
			tfAptitude.setSelectionColor(new Color(255, 255, 255));
			tfAptitude.setForeground(Color.BLACK);
			tfAptitude.setColumns(10);
			tfAptitude.setBounds(143, 344, 116, 21);
		}
		return tfAptitude;
	}
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setEditable(false);
			tfID.setSelectionColor(new Color(255, 255, 255));
			tfID.setForeground(Color.BLACK);
			tfID.setColumns(10);
			tfID.setBounds(143, 125, 116, 21);
		}
		return tfID;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Email     :");
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel_2.setForeground(Color.BLACK);
			lblNewLabel_2.setBounds(37, 201, 94, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("ID          :");
			lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 16));
			lblNewLabel_1_1.setForeground(Color.BLACK);
			lblNewLabel_1_1.setBounds(37, 129, 94, 15);
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtuWithdrawal() {
		if (btuWithdrawal == null) {
			btuWithdrawal = new JButton("탈퇴");
			btuWithdrawal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WithdrawalAction();
				}
			});
			btuWithdrawal.setBounds(391, 387, 97, 23);
		}
		return btuWithdrawal;
	}
	
	
	
	//------------------
	//메소드
	//------------------
	
	//프로필보이기 Dowoo 2021.04.29
	private void UP_Show() {
	
		UP_DbAction up_DbAction =new UP_DbAction(data_Enviroment_define.userNum);
		UP_Bean bean =up_DbAction.UP_Show();
		
		tfName.setText(bean.getUserName());
		tfID.setText(bean.getUserId());
		tfEmail.setText(bean.getUserEmail());
		tfMbti.setText(bean.getUserResultM());
		tfAptitude.setText(bean.getUserResultA());
		
	}
	//탈퇴 Dowoo 2021.04.29
	private void WithdrawalAction() {
		
		UP_DbAction up_DbAction =new UP_DbAction(data_Enviroment_define.userNum);
		boolean msg =  up_DbAction.UP_WithdrawalAction();
		
		if(msg=true) {
				  JOptionPane.showMessageDialog(this,tfName.getText()+" 님의 정보가 탈퇴 되었습니다.!",
			        	"탈퇴 완료!",JOptionPane.INFORMATION_MESSAGE);

		}else if(msg=false){
			JOptionPane.showMessageDialog(this, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
				 "Critical Error!", 
				 JOptionPane.ERROR_MESSAGE);  
			}
		
		}
	
	
	
}////////////////////////////////////


