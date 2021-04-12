package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI02_1 {

	private JFrame frame;
	private JComboBox cbFruits;
	private JTextField tfFruits;
	private JComboBox cbAdd;
	private JTextField tfAdd;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI02_1 window = new GUI02_1();
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
	public GUI02_1() {
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
		frame.getContentPane().add(getCbFruits());
		frame.getContentPane().add(getTfFruits());
		frame.getContentPane().add(getCbAdd());
		frame.getContentPane().add(getTfAdd());
		frame.getContentPane().add(getBtnAdd());
	}
	private JComboBox getCbFruits() {
		if (cbFruits == null) {
			cbFruits = new JComboBox();
			cbFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String stFString = cbFruits .getSelectedItem().toString();
					tfFruits.setText(stFString);
				}
			});
			cbFruits.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Banana", "Grape", "ManGo"}));
			cbFruits.setBounds(21, 20, 101, 27);
		}
		return cbFruits;
	}
	private JTextField getTfFruits() {
		if (tfFruits == null) {
			tfFruits = new JTextField();
			tfFruits.setBounds(165, 19, 130, 26);
			tfFruits.setColumns(10);
		}
		return tfFruits;
	}
	private JComboBox getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JComboBox();
			cbAdd.setBounds(165, 68, 130, 27);
		}
		return cbAdd;
	}
	private JTextField getTfAdd() {
		if (tfAdd == null) {
			tfAdd = new JTextField();
			tfAdd.setBounds(21, 67, 130, 26);
			tfAdd.setColumns(10);
		}
		return tfAdd;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addCombo();
				}
			});
			btnAdd.setBounds(21, 105, 117, 29);
		}
		return btnAdd;
	}
	
	private void addCombo() {
		String stTemp =tfAdd.getText();
		cbAdd.addItem(stTemp);
	}
}//=========
