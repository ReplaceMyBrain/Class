package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI05Ex2version2 {

	private JFrame frame;
	private JTextField tfResult;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum4;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum7;
	private JButton btnNum8;
	private JButton btnNum9;
	private JButton btnNum0;
	private JButton btmEqual;
	private JButton btnAdd;
	private JButton btnClear;
	private int sum = 0;
	ArrayList<Integer> arrayList = new ArrayList<Integer>();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI05Ex2version2 window = new GUI05Ex2version2();
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
	public GUI05Ex2version2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 223, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getBtnNum1());
		frame.getContentPane().add(getBtnNum2());
		frame.getContentPane().add(getBtnNum3());
		frame.getContentPane().add(getBtnNum4());
		frame.getContentPane().add(getBtnNum5());
		frame.getContentPane().add(getBtnNum6());
		frame.getContentPane().add(getBtnNum7());
		frame.getContentPane().add(getBtnNum8());
		frame.getContentPane().add(getBtnNum9());
		frame.getContentPane().add(getBtnNum0());
		frame.getContentPane().add(getBtmEqual());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnClear());
	}

	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.RIGHT);
			tfResult.setBounds(12, 10, 180, 72);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	private JButton getBtnNum1() {
		if (btnNum1 == null) {
			btnNum1 = new JButton("1");
			btnNum1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum1.getText());
				}
			});
			btnNum1.setBounds(12, 95, 52, 46);
		}
		return btnNum1;
	}
	private JButton getBtnNum2() {
		if (btnNum2 == null) {
			btnNum2 = new JButton("2");
			btnNum2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum2.getText());
					}
			});
			btnNum2.setBounds(76, 95, 52, 46);
		}
		return btnNum2;
	}
	private JButton getBtnNum3() {
		if (btnNum3 == null) {
			btnNum3 = new JButton("3");
			btnNum3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum3.getText());
				}
			});
			btnNum3.setBounds(140, 95, 52, 46);
		}
		return btnNum3;
	}
	private JButton getBtnNum4() {
		if (btnNum4 == null) {
			btnNum4 = new JButton("4");
			btnNum4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum4.getText());
				}
			});
			btnNum4.setBounds(12, 151, 52, 46);
		}
		return btnNum4;
	}
	private JButton getBtnNum5() {
		if (btnNum5 == null) {
			btnNum5 = new JButton("5");
			btnNum5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum5.getText());
				}
			});
			btnNum5.setBounds(76, 151, 52, 46);
		}
		return btnNum5;
	}
	private JButton getBtnNum6() {
		if (btnNum6 == null) {
			btnNum6 = new JButton("6");
			btnNum6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum6.getText());
				}
			});
			btnNum6.setBounds(140, 151, 52, 46);
		}
		return btnNum6;
	}
	private JButton getBtnNum7() {
		if (btnNum7 == null) {
			btnNum7 = new JButton("7");
			btnNum7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum7.getText());
				}
			});
			btnNum7.setBounds(12, 207, 52, 46);
		}
		return btnNum7;
	}
	private JButton getBtnNum8() {
		if (btnNum8 == null) {
			btnNum8 = new JButton("8");
			btnNum8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum8.getText());
				}
			});
			btnNum8.setBounds(76, 207, 52, 46);
		}
		return btnNum8;
	}
	private JButton getBtnNum9() {
		if (btnNum9 == null) {
			btnNum9 = new JButton("9");
			btnNum9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum9.getText());
				}
			});
			btnNum9.setBounds(140, 207, 52, 46);
		}
		return btnNum9;
	}
	private JButton getBtnNum0() {
		if (btnNum0 == null) {
			btnNum0 = new JButton("0");
			btnNum0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText(tfResult.getText()+btnNum0.getText());
				}
			});
			btnNum0.setBounds(12, 263, 52, 46);
		}
		return btnNum0;
	}
	private JButton getBtmEqual() {
		if (btmEqual == null) {
			btmEqual = new JButton("=");
			btmEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sumEqual();
				}
			});
			btmEqual.setBounds(76, 263, 52, 46);
		}
		return btmEqual;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sumEqual();
					add1();
				}
			});
			btnAdd.setBounds(140, 263, 52, 46);
		}
		return btnAdd;
		
		
	}
	
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfResult.setText("");
				}
			});
			btnClear.setBounds(12, 319, 180, 30);
		}
		return btnClear;
	}
	
	private void add1() {
		arrayList.add(Integer.parseInt(tfResult.getText()));
		tfResult.setText("");
		
	}

	private void sumEqual() {
		for(int i=0; i<=arrayList.size(); i++) {
			sum+=arrayList.get(i);
		}
		tfResult.setText(Integer.toString(sum));		
	}
	

	
		
		

	
	
	

}////////
