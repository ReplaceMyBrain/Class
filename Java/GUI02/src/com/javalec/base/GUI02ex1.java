package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI02ex1 {

	private JFrame frame;
	private JComboBox cbNum1;
	private JComboBox cbCalc;
	private JComboBox cbNum2;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI02ex1 window = new GUI02ex1();
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
	public GUI02ex1() {
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
		frame.getContentPane().add(getCbNum1());
		frame.getContentPane().add(getCbCalc());
		frame.getContentPane().add(getCbNum2());
		frame.getContentPane().add(getTfResult());
	}

	private JComboBox getCbNum1() {
		if (cbNum1 == null) {
			cbNum1 = new JComboBox();
			cbNum1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calc();
				}
			});
			cbNum1.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6", "8"}));
			cbNum1.setBounds(25, 25, 69, 27);
		}
		return cbNum1;
	}
	private JComboBox getCbCalc() {
		if (cbCalc == null) {
			cbCalc = new JComboBox();
			cbCalc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calc();
				}
			});
			cbCalc.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "%", "x"}));
			cbCalc.setBounds(106, 25, 67, 27);
		}
		return cbCalc;
	}
	private JComboBox getCbNum2() {
		if (cbNum2 == null) {
			cbNum2 = new JComboBox();
			cbNum2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				calc();
				}
			});
			cbNum2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
			cbNum2.setBounds(185, 25, 67, 27);
		}
		return cbNum2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setBounds(273, 24, 130, 26);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	
	private void calc(){
		int num1 = Integer.parseInt(cbNum1.getSelectedItem().toString());
		int num2 = Integer.parseInt(cbNum2.getSelectedItem().toString());
		String calcSymbol =	cbCalc.getSelectedItem().toString();
		
		if(calcSymbol == "+") {
			tfResult.setText(Integer.toString(num1+num2));
		}else if(calcSymbol == "-"){
			tfResult.setText(Integer.toString(num1-num2));
		}else if(calcSymbol == "x"){
			tfResult.setText(Integer.toString(num1*num2));
		}else if(calcSymbol == "%"){
			tfResult.setText(String.format("%3f",(double)num1/num2));
		}
	
	}
	
	
}
