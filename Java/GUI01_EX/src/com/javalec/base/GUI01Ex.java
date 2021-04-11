package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.javalec.function.TwoNumberCalc;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI01Ex {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JButton btnAdd;
	private JButton btnSubtract;
	private JButton btnMultiply;
	private JButton btnDivision;
	private JTextField tfResult1;
	private JLabel lblSign;
	private JTextField tfResult2;
	private JLabel lblNewLabel_2_1;
	private JTextField tfResult3;

	/* 
	 * ***************************************************
	 * 
	 * TwoNumberCalc Class사용하기
	 * : 입력 TextField Check와 계산 하는 Class
	 * 
	 * 2021.04.09
	 * 
	 * ***************************************************
	 */

	TwoNumberCalc calc = new TwoNumberCalc();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI01Ex window = new GUI01Ex();
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
	public GUI01Ex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setTitle("두개의 숫자 가감승제");
//		frame.setBounds(100, 100, 301, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnSubtract());
		frame.getContentPane().add(getBtnMultiply());
		frame.getContentPane().add(getBtnDivision());
		frame.getContentPane().add(getTfResult1());
		frame.getContentPane().add(getLblSign());
		frame.getContentPane().add(getTfResult2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfResult3());
		
		/*
		 * ***************************************************
		 * 
		 * 화면 중앙에 배치
		 * : 윈도우 크기는 상단의 SetBounds의 크기를 참조하여 계산
		 * 
		 * 2021.04.09
		 * 
		 * ***************************************************
		 */
		
		// 화면 중앙에 배치.
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int)(screensize.getWidth() - 301) / 2, (int)(screensize.getHeight() - 170) / 2, 301, 170);

		/*
		 * ***************************************************
		 * 
		 * 계산화면이 시작되기전 입력Field를 꼭 숫자로 쓰라는 메세지
		 * 
		 * 2021.04.09
		 * 
		 * ***************************************************
		 */
		JOptionPane.showMessageDialog(null, "입력은 꼭 숫자로!", "사용법", JOptionPane.WARNING_MESSAGE);
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("숫자1:");
			lblNewLabel.setBounds(22, 16, 46, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("숫자2:");
			lblNewLabel_1.setBounds(22, 54, 46, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					/*
					 * ***************************************************
					 * 
					 * TextField에 숫자외의 문자가 입력되면 지우기
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */
		            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
		            	
		            } else {
		            	JOptionPane.showMessageDialog(null, "숫자만 입력하세요!", "경고",JOptionPane.ERROR_MESSAGE);
		            	tfNum1.setText("");
		            }
				}
			});
			tfNum1.setToolTipText("숫자만");
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(66, 11, 68, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					/*
					 * ***************************************************
					 * 
					 * TextField에 숫자외의 문자가 입력되면 지우기
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */
		            if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
		            	
		            } else {
		            	JOptionPane.showMessageDialog(null, "숫자만 입력하세요!", "경고",JOptionPane.ERROR_MESSAGE);
		            	tfNum2.setText("");
		            }

				}
			});
			tfNum2.setToolTipText("숫자만");
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(66, 49, 68, 26);
		}
		return tfNum2;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * ***************************************************
					 * 
					 * 더하기 Button
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */
					
					lblSign.setText("+");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.addition(tfNum1.getText(), tfNum2.getText()));
				}
			});
			btnAdd.setForeground(Color.MAGENTA);
			btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnAdd.setBounds(187, 11, 46, 29);
		}
		return btnAdd;
	}
	private JButton getBtnSubtract() {
		if (btnSubtract == null) {
			btnSubtract = new JButton("-");
			btnSubtract.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * ***************************************************
					 * 
					 * 빼기 Button
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */
					
					lblSign.setText("-");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.subtraction(tfNum1.getText(), tfNum2.getText()));

				}
			});
			btnSubtract.setForeground(Color.MAGENTA);
			btnSubtract.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnSubtract.setBounds(225, 11, 46, 29);
		}
		return btnSubtract;
	}
	private JButton getBtnMultiply() {
		if (btnMultiply == null) {
			btnMultiply = new JButton("X");
			btnMultiply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * ***************************************************
					 * 
					 * 곱하기 Button
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */

					lblSign.setText("X");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.multiplication(tfNum1.getText(), tfNum2.getText()));

				}
			});
			btnMultiply.setForeground(Color.BLUE);
			btnMultiply.setBounds(187, 46, 46, 29);
		}
		return btnMultiply;
	}
	private JButton getBtnDivision() {
		if (btnDivision == null) {
			btnDivision = new JButton("/");
			btnDivision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * ***************************************************
					 * 
					 * 나누기 Button
					 * 2021.04.09
					 * 
					 * ***************************************************
					 */

					lblSign.setText("/");
					tfResult1.setText(tfNum1.getText());
					tfResult2.setText(tfNum2.getText());
					tfResult3.setText(calc.division(tfNum1.getText(), tfNum2.getText()));

				}
			});
			btnDivision.setForeground(Color.BLUE);
			btnDivision.setBounds(225, 46, 46, 29);
		}
		return btnDivision;
	}
	private JTextField getTfResult1() {
		if (tfResult1 == null) {
			tfResult1 = new JTextField();
			tfResult1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			tfResult1.setEditable(false);
			tfResult1.setForeground(Color.BLUE);
			tfResult1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult1.setColumns(10);
			tfResult1.setBounds(22, 102, 68, 26);
		}
		return tfResult1;
	}
	private JLabel getLblSign() {
		if (lblSign == null) {
			lblSign = new JLabel("+");
			lblSign.setHorizontalAlignment(SwingConstants.CENTER);
			lblSign.setBounds(89, 107, 27, 16);
		}
		return lblSign;
	}
	private JTextField getTfResult2() {
		if (tfResult2 == null) {
			tfResult2 = new JTextField();
			tfResult2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			tfResult2.setEditable(false);
			tfResult2.setForeground(Color.BLUE);
			tfResult2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult2.setColumns(10);
			tfResult2.setBounds(111, 102, 68, 26);
		}
		return tfResult2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("=");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(177, 107, 27, 16);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfResult3() {
		if (tfResult3 == null) {
			tfResult3 = new JTextField();
			tfResult3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			tfResult3.setEditable(false);
			tfResult3.setForeground(Color.RED);
			tfResult3.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult3.setColumns(10);
			tfResult3.setBounds(203, 102, 68, 26);
		}
		return tfResult3;
	}
	
	
	
} // End Line
