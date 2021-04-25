package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI03Ex02 {

	private JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JCheckBox cbAdd;
	private JCheckBox cbSub;
	private JCheckBox cbMul;
	private JCheckBox cbDiv;
	private JLabel lbResult0;
	private JLabel lbResult1;
	private JLabel lbResult2;
	private JLabel lbResult3;
	
	Calc calc =new Calc();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI03Ex02 window = new GUI03Ex02();
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
	public GUI03Ex02() {
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
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getCbAdd());
		frame.getContentPane().add(getCbSub());
		frame.getContentPane().add(getCbMul());
		frame.getContentPane().add(getCbDiv());
		frame.getContentPane().add(getLbResult0());
		frame.getContentPane().add(getLbResult1());
		frame.getContentPane().add(getLbResult2());
		frame.getContentPane().add(getLbResult3());
	}

	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setBounds(17, 26, 130, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setBounds(17, 64, 130, 26);
			tfNum2.setColumns(10);
		}
		return tfNum2;
	}
	
	private JCheckBox getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JCheckBox("Add");
			cbAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcOrder();
				}
			});
			cbAdd.setBounds(178, 27, 128, 23);
		}
		return cbAdd;
	}
	private JCheckBox getCbSub() {
		if (cbSub == null) {
			cbSub = new JCheckBox("Sub");
			cbSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcOrder();
				}
			});
			cbSub.setBounds(178, 65, 128, 23);
		}
		return cbSub;
	}
	private JCheckBox getCbMul() {
		if (cbMul == null) {
			cbMul = new JCheckBox("Mul");
			cbMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcOrder();
				}
			});
			cbMul.setBounds(316, 27, 128, 23);
		}
		return cbMul;
	}
	private JCheckBox getCbDiv() {
		if (cbDiv == null) {
			cbDiv = new JCheckBox("Div");
			cbDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcOrder();
				}
			});
			cbDiv.setBounds(316, 65, 128, 23);
		}
		return cbDiv;
	}
	
	
	
	private JLabel getLbResult0() {
		if (lbResult0 == null) {
			lbResult0 = new JLabel("");
			lbResult0.setBounds(69, 141, 189, 15);
		}
		return lbResult0;
	}
	private JLabel getLbResult1() {
		if (lbResult1 == null) {
			lbResult1 = new JLabel("");
			lbResult1.setBounds(69, 168, 189, 15);
		}
		return lbResult1;
	}
	private JLabel getLbResult2() {
		if (lbResult2 == null) {
			lbResult2 = new JLabel("");
			lbResult2.setBounds(69, 194, 189, 15);
		}
		return lbResult2;
	}
	private JLabel getLbResult3() {
		if (lbResult3 == null) {
			lbResult3 = new JLabel("");
			lbResult3.setBounds(69, 221, 189, 15);
		}
		return lbResult3;
	}
	public void calcOrder() {
		ArrayList<String> arrayList = new ArrayList<String>();
		
		if(cbAdd.isSelected()==true) {
			arrayList.add(calc.add(tfNum1.getText(),tfNum2.getText()));
		}if(cbSub.isSelected()==true) {
			arrayList.add(calc.sub(tfNum1.getText(),tfNum2.getText()));
		}if(cbMul.isSelected()==true) {
			arrayList.add(calc.mul(tfNum1.getText(),tfNum2.getText()));
		}if(cbDiv.isSelected()==true) {
			arrayList.add(calc.div(tfNum1.getText(),tfNum2.getText()));
		}
		
		lbResult0.setText(arrayList.get(0));
		lbResult1.setText(arrayList.get(1));
		lbResult2.setText(arrayList.get(2));
		lbResult3.setText(arrayList.get(3));
	
		
	}
}



