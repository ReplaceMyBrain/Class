package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GUI03 {

	private JFrame frmCh;
	private JCheckBox chApple;
	private JCheckBox chBanana;
	private JButton btnNewButton;
	private JTextField tfFruit;
	private JRadioButton rbKBS;
	private JRadioButton rbMBC;
	private JButton btnBroad;
	private JTextField tfBorad;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI03 window = new GUI03();
					window.frmCh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCh = new JFrame();
		frmCh.setTitle("ch");
		frmCh.setBounds(100, 100, 450, 300);
		frmCh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCh.getContentPane().setLayout(null);
		frmCh.getContentPane().add(getChApple());
		frmCh.getContentPane().add(getChBanana());
		frmCh.getContentPane().add(getBtnNewButton());
		frmCh.getContentPane().add(getTfFruit());
		frmCh.getContentPane().add(getRbKBS());
		frmCh.getContentPane().add(getRbMBC());
		frmCh.getContentPane().add(getBtnBroad());
		frmCh.getContentPane().add(getTfBorad());
	}
	private JCheckBox getChApple() {
		if (chApple == null) {
			chApple = new JCheckBox("Apple");
			chApple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			chApple.setBounds(35, 34, 128, 23);
		}
		return chApple;
	}
	private JCheckBox getChBanana() {
		if (chBanana == null) {
			chBanana = new JCheckBox("Banana");
			chBanana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			chBanana.setBounds(35, 84, 128, 23);
		}
		return chBanana;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			btnNewButton.setBounds(35, 128, 117, 29);
		}
		return btnNewButton;
	}
	
	private JTextField getTfFruit() {
		if (tfFruit == null) {
			tfFruit = new JTextField();
			tfFruit.setBounds(35, 173, 197, 26);
			tfFruit.setColumns(10);
		}
		return tfFruit;
	}
	
	private void fruitCheck() {
		tfFruit.setText("");
		
		if(chApple.isSelected()== true) {
			tfFruit.setText("Apple이 선택되었습니다");
		}
		if(chBanana.isSelected()==true) {
			tfFruit.setText("Banana가 선택되었습니다.");
		}
		
		if(chApple.isSelected() && chBanana.isSelected()==true) {
			tfFruit.setText("Apple와Banana가 선택되었습니다.");
		}
		
	}
	private JRadioButton getRbKBS() {
		if (rbKBS == null) {
			rbKBS = new JRadioButton("KBS");
			rbKBS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			buttonGroup.add(rbKBS);
			rbKBS.setBounds(236, 34, 141, 23);
		}
		return rbKBS;
	}
	private JRadioButton getRbMBC() {
		if (rbMBC == null) {
			rbMBC = new JRadioButton("MBC");
			rbMBC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			buttonGroup.add(rbMBC);
			rbMBC.setBounds(236, 84, 141, 23);
		}
		return rbMBC;
	}
	private JButton getBtnBroad() {
		if (btnBroad == null) {
			btnBroad = new JButton("OK");
			btnBroad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					broadCheck();
				}
			});
			btnBroad.setBounds(246, 128, 117, 29);
		}
		return btnBroad;
	}
	private JTextField getTfBorad() {
		if (tfBorad == null) {
			tfBorad = new JTextField();
			tfBorad.setBounds(244, 173, 189, 26);
			tfBorad.setColumns(10);
		}
		return tfBorad;
	}
	
	private void broadCheck() {
		tfBorad.setText("");
		if(rbKBS.isSelected()==true) {
			tfBorad.setText("KBS가 선택 되었습니다.");
		}
		if(rbMBC.isSelected()==true) {
			tfBorad.setText("MBC가 선택 되었습니다.");
	
		}
			
		}
	
}///
