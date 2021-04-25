package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ex_01 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton Sum;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField num1;
	private JTextField num2;
	private JTextField result;
	private JLabel lblNewLabel_2;
	private JButton Sub;
	private JButton Mul;
	private JButton Div;
	private JLabel calc;

	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex_01 window = new Ex_01();
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
	public Ex_01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getSum());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getNum1());
		frame.getContentPane().add(getNum2());
		frame.getContentPane().add(getResult());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getSub());
		frame.getContentPane().add(getMul());
		frame.getContentPane().add(getDiv());
		frame.getContentPane().add(getCalc());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("1 : ");
			lblNewLabel.setBounds(12, 24, 26, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("2 : ");
			lblNewLabel_1.setBounds(12, 59, 26, 15);
		}
		return lblNewLabel_1;
	}
	private JButton getSum() {
		if (Sum == null) {
			Sum = new JButton("+");
			Sum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				addSum();
				}
			});
			Sum.setBounds(138, 17, 59, 28);
		}
		return Sum;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setBounds(42, 21, 59, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setColumns(10);
			tfNum2.setBounds(42, 56, 59, 21);
		}
		return tfNum2;
	}
	private JTextField getNum1() {
		if (num1 == null) {
			num1 = new JTextField();
			num1.setEditable(false);
			num1.setColumns(10);
			num1.setBounds(42, 100, 59, 21);
		}
		return num1;
	}
	private JTextField getNum2() {
		if (num2 == null) {
			num2 = new JTextField();
			num2.setEditable(false);
			num2.setColumns(10);
			num2.setBounds(138, 100, 59, 21);
		}
		return num2;
	}
	private JTextField getResult() {
		if (result == null) {
			result = new JTextField();
			result.setEditable(false);
			result.setColumns(10);
			result.setBounds(250, 100, 59, 21);
		}
		return result;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("=");
			lblNewLabel_2.setBounds(221, 101, 13, 18);
		}
		return lblNewLabel_2;
	}
	private JButton getSub() {
		if (Sub == null) {
			Sub = new JButton("-");
			Sub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					addSub();
				}
			});
			Sub.setBounds(206, 17, 59, 28);
		}
		return Sub;
	}
	private JButton getMul() {
		if (Mul == null) {
			Mul = new JButton("x");
			Mul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					addMul();
				}
			});
			Mul.setBounds(274, 17, 59, 28);
		}
		return Mul;
	}
	private JButton getDiv() {
		if (Div == null) {
			Div = new JButton("%");
			Div.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				addDiv();	
				}
			});
			Div.setBounds(345, 17, 59, 28);
		}
		return Div;
	}
	private JLabel getCalc() {
		if (calc == null) {
			calc = new JLabel("?");
			calc.setBounds(113, 103, 13, 18);
		}
		return calc;
	}
	
	
	//메소드

	
	private void addSum() {
		int wkNum1 = Integer.parseInt(tfNum1.getText());
		int wkNum2 = Integer.parseInt(tfNum2.getText());
		int sumResult = wkNum1 + wkNum2;
		
		calc.setText("+");
		num1.setText(Integer.toString(wkNum1));
		num2.setText(Integer.toString(wkNum2));
		result.setText(Integer.toString(sumResult));
	}

	private void addSub() {	
		int wkNum1 = Integer.parseInt(tfNum1.getText());
		int wkNum2 = Integer.parseInt(tfNum2.getText());
		int subResult = wkNum1 - wkNum2;
		
		calc.setText("-");
		num1.setText(Integer.toString(wkNum1));
		num2.setText(Integer.toString(wkNum2));
		result.setText(Integer.toString(subResult));
	}
		
	private void addMul() {	
		int wkNum1 = Integer.parseInt(tfNum1.getText());
		int wkNum2 = Integer.parseInt(tfNum2.getText());
		int mulResult = wkNum1 * wkNum2;
		
		calc.setText("x");
		num1.setText(Integer.toString(wkNum1));
		num2.setText(Integer.toString(wkNum2));
		result.setText(Integer.toString(mulResult));
	}
		
	private void addDiv() {	
		int wkNum1 = Integer.parseInt(tfNum1.getText());
		int wkNum2 = Integer.parseInt(tfNum2.getText());
		if (wkNum2==0) {
			JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다.");
		}else {
			int divResult = wkNum1 / wkNum2;
			calc.setText("%");
			num1.setText(Integer.toString(wkNum1));
			num2.setText(Integer.toString(wkNum2));
			result.setText(Integer.toString(divResult));
		}
	
		
			
		
	}
	
}
