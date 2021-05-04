package com.javalec.PanelUserProfile;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.PanelManageAptitudeResult.MAR_Bean;
import com.javalec.PanelManageAptitudeResult.MAR_DbAction;
import com.javalec.PanelManageUser.MU_DbAction;
import com.javalec.login.Login;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelUserProfile extends JPanel {
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JTextField tfEmail;
	private JLabel lblNewLabel_3;
	private JTextField tfMbti;
	private JLabel lblNewLabel_4;
	private JTextField tfAptitude;
	private JTextField tfID;
	private JLabel lblNewLabel_2;
	private JButton btuUpdate;
	private JLabel lblNewLabel_1_1;
	private JPasswordField pfBeforePw;
	private JPasswordField pfAfterPw;
	private JLabel lblNewLabel_1_2;
	private JLabel lbPwCheck;
	private JButton btuWithdrawal;
	private int userNum;
	

	/**
	 * Create the panel.
	 */
	public PanelUserProfile() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLblNewLabel());
		add(getTfName());
		add(getLblNewLabel_1());
		add(getTfEmail());
		add(getLblNewLabel_3());
		add(getTfMbti());
		add(getLblNewLabel_4());
		add(getTfAptitude());
		add(getTfID());
		add(getLblNewLabel_2());
		add(getBtuUpdate());
		add(getLblNewLabel_1_1());
		add(getPfBeforePw());
		add(getPfAfterPw());
		add(getLblNewLabel_1_2());
		add(getLbPwCheck());
		add(getBtuWithdrawal());
	}
	public PanelUserProfile(int userNum) {
		this.userNum=userNum;
		UP_Show();
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름       :");
			lblNewLabel.setBounds(37, 47, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(117, 42, 116, 21);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PW확인   :");
			lblNewLabel_1.setBounds(37, 171, 79, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(117, 231, 211, 21);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("MBTI      :");
			lblNewLabel_3.setBounds(37, 295, 67, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfMbti() {
		if (tfMbti == null) {
			tfMbti = new JTextField();
			tfMbti.setEnabled(false);
			tfMbti.setColumns(10);
			tfMbti.setBounds(117, 294, 116, 21);
		}
		return tfMbti;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("적성검사  :");
			lblNewLabel_4.setBounds(37, 357, 79, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfAptitude() {
		if (tfAptitude == null) {
			tfAptitude = new JTextField();
			tfAptitude.setEnabled(false);
			tfAptitude.setColumns(10);
			tfAptitude.setBounds(117, 357, 116, 21);
		}
		return tfAptitude;
	}
	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setEnabled(false);
			tfID.setColumns(10);
			tfID.setBounds(117, 105, 116, 21);
		}
		return tfID;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Email     :");
			lblNewLabel_2.setBounds(37, 233, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JButton getBtuUpdate() {
		if (btuUpdate == null) {
			btuUpdate = new JButton("수정");
			btuUpdate.setBounds(282, 362, 97, 23);
		}
		return btuUpdate;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("ID          :");
			lblNewLabel_1_1.setBounds(37, 109, 57, 15);
		}
		return lblNewLabel_1_1;
	}
	private JPasswordField getPfBeforePw() {
		if (pfBeforePw == null) {
			pfBeforePw = new JPasswordField();
			pfBeforePw.setBounds(117, 168, 116, 21);
		}
		return pfBeforePw;
	}
	private JPasswordField getPfAfterPw() {
		if (pfAfterPw == null) {
			pfAfterPw = new JPasswordField();
			pfAfterPw.setBounds(334, 168, 116, 21);
		}
		return pfAfterPw;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("변경할 PW    :");
			lblNewLabel_1_2.setBounds(245, 171, 97, 15);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLbPwCheck() {
		if (lbPwCheck == null) {
			lbPwCheck = new JLabel("");
			lbPwCheck.setForeground(Color.RED);
			lbPwCheck.setFont(new Font("굴림", Font.PLAIN, 10));
			lbPwCheck.setBounds(117, 196, 158, 15);
		}
		return lbPwCheck;
	}
	private JButton getBtuWithdrawal() {
		if (btuWithdrawal == null) {
			btuWithdrawal = new JButton("탈퇴");
			btuWithdrawal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WithdrawalAction();
				}
			});
			btuWithdrawal.setBounds(391, 362, 97, 23);
		}
		return btuWithdrawal;
	}
	
	
	
	//------------------
	//메소드
	//------------------
	
	//프로필보이기 Dowoo 2021.04.29
	private void UP_Show() {
		UP_DbAction up_DbAction =new UP_DbAction(userNum);
		UP_Bean bean = up_DbAction.UP_Show();
		
		tfName.setText(bean.getUserName());
		tfID.setText(bean.getUserId());
		tfEmail.setText(bean.getUserEmail());
		tfMbti.setText(bean.getUserResultM());
		tfAptitude.setText(bean.getUserResultA());
		
	}
	//탈퇴 Dowoo 2021.04.29
	private void WithdrawalAction() {
		
		UP_DbAction up_DbAction =new UP_DbAction(userNum);
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


