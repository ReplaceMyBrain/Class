package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.javalec.function.Calc;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex_01version2 {

	private JFrame frame;
	private JTextField tfNum1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfNum2;
	private JButton Add;
	private JButton Sub;
	private JButton Mul;
	private JButton Div;
	private JTextField tfResult1;
	private JTextField tfResult2;
	private JTextField tfResult3;
	private JLabel lblSign;
	private JLabel lblNewLabel_2_1;
	
	Calc calc = new Calc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_01version2 window = new Ex_01version2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ex_01version2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getAdd());
		frame.getContentPane().add(getSub());
		frame.getContentPane().add(getMul());
		frame.getContentPane().add(getDiv());
		frame.getContentPane().add(getTfResult1());
		frame.getContentPane().add(getTfResult2());
		frame.getContentPane().add(getTfResult3());
		frame.getContentPane().add(getLblSign());
		frame.getContentPane().add(getLblNewLabel_2_1());
		
		//화면 중앙에 배치
		//하나의 메소드라고 함. 한줄로 가능.
		frame.setLocationRelativeTo(null);
		
		//시작시 숫자만 입력하라는 경고를 뛰운 뒤에 메인화면 띄우기
		//showMessageDialog(보통 null을 사용 // 출력할 문자열 // 제목표시줄에 나타날 제목 // 메세지의 종류지정)
		//메세지의 종류ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
		
		
		JOptionPane.showMessageDialog(null, "숫자만 입력하세요!","주의사항", JOptionPane.INFORMATION_MESSAGE);
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			
			//Events > key > keyTyped
			//e.getKeyChar() : 눌린 키의 문자를 리턴
			
			tfNum1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {						
					} 
					// 백스페이스를 입력을 가능하게 하는 방법은 무엇인가?
					
					else {
						JOptionPane.showMessageDialog(null, "숫자만 입력하세요!", "주의",JOptionPane.INFORMATION_MESSAGE);
						//tfNum1.setText(""); 를 입력하면 다 지워짐.
					}
				}
			});
			tfNum1.setToolTipText("숫자만"); // 툴팁
			tfNum1.setBounds(32, 26, 69, 21);
			tfNum1.setColumns(10);
			
		
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {						
					} 	
					else {
						JOptionPane.showMessageDialog(null, "숫자만 입력하세요!", "주의",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			tfNum2.setToolTipText("숫자만"); // 툴팁
			tfNum2.setColumns(10);
			tfNum2.setBounds(32, 62, 69, 21);
		}
		return tfNum2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("1 :");
			lblNewLabel.setBounds(12, 29, 20, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("2 :");
			lblNewLabel_1.setBounds(12, 65, 20, 15);
		}
		return lblNewLabel_1;
	}
	
	private JButton getAdd() {
		if (Add == null) {
			Add = new JButton("Add");
			Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					lblSign.setText("+");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.add(tfNum1.getText(),tfNum2.getText()));
				
				}
			});
			Add.setBounds(137, 25, 69, 58);
		}
		return Add;
	}
	private JButton getSub() {
		if (Sub == null) {
			Sub = new JButton("Sub");
			Sub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblSign.setText("-");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.sub(tfNum1.getText(),tfNum2.getText()));
				}
			});
			Sub.setBounds(212, 25, 69, 58);
		}
		return Sub;
	}
	private JButton getMul() {
		if (Mul == null) {
			Mul = new JButton("Mul");
			Mul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblSign.setText("x");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.mul(tfNum1.getText(),tfNum2.getText()));

				}
			});
			Mul.setBounds(287, 25, 69, 58);
		}
		return Mul;
	}
	private JButton getDiv() {
		if (Div == null) {
			Div = new JButton("Div");
			Div.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					lblSign.setText("%");
					tfResult1.setText(tfNum1.getText());
					if(Integer.parseInt(tfNum2.getText())==0) {
						message("no");
					}
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.div(tfNum1.getText(),tfNum2.getText()));
					
				}
			});
			Div.setBounds(365, 25, 69, 58);
		}
		return Div;
	}
	private JTextField getTfResult1() {
		if (tfResult1 == null) {
			tfResult1 = new JTextField();
			tfResult1.setEditable(false);
			tfResult1.setBounds(32, 124, 69, 21);
			tfResult1.setColumns(10);
		}
		return tfResult1;
	}
	private JTextField getTfResult2() {
		if (tfResult2 == null) {
			tfResult2 = new JTextField();
			tfResult2.setEditable(false);
			tfResult2.setColumns(10);
			tfResult2.setBounds(137, 124, 69, 21);
		}
		return tfResult2;
	}
	private JTextField getTfResult3() {
		if (tfResult3 == null) {
			tfResult3 = new JTextField();
			tfResult3.setEditable(false);
			tfResult3.setColumns(10);
			tfResult3.setBounds(238, 124, 69, 21);
		}
		return tfResult3;
	}
	private JLabel getLblSign() {
		if (lblSign == null) {
			lblSign = new JLabel("?");
			lblSign.setHorizontalAlignment(SwingConstants.CENTER);
			lblSign.setBounds(105, 125, 32, 18);
		}
		return lblSign;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("=");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(206, 127, 32, 18);
		}
		return lblNewLabel_2_1;
	}
	private void message(String str1){
		JOptionPane.showMessageDialog(null, str1);
	}
	
}
