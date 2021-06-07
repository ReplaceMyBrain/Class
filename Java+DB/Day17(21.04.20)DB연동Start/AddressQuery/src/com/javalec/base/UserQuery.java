package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserQuery {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JTextField tfSeqno;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	private JTable Inner_Table;
	
	//Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	
	//Table 환경정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JTextField tfCount;
	private JLabel lblNewLabel_2;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery window = new UserQuery();
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
	public UserQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("주소록검색");
		frame.setBounds(100, 100, 446, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblNewLabel_1_2());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_1_3());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_1_4());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getTfCount());
		frame.getContentPane().add(getLblNewLabel_2());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "전화번호"}));
			cbSelection.setBounds(6, 6, 119, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(135, 5, 179, 27);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.setBounds(326, 5, 117, 29);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 58, 437, 120);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					tableClick();
				}

			
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); //꼭 써줘야함!
		}
		return Inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seq No :");
			lblNewLabel.setBounds(6, 200, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(6, 228, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("전화번호");
			lblNewLabel_1_1.setBounds(6, 256, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("주소 :");
			lblNewLabel_1_2.setBounds(6, 284, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("전자우편");
			lblNewLabel_1_3.setBounds(6, 312, 61, 16);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("관계");
			lblNewLabel_1_4.setBounds(6, 340, 61, 16);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(110, 195, 130, 26);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(110, 223, 130, 26);
		}
		return tfName;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setEditable(false);
			tfTelno.setBounds(110, 251, 130, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setEditable(false);
			tfAddress.setColumns(10);
			tfAddress.setBounds(110, 279, 130, 26);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(110, 307, 130, 26);
		}
		return tfEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setEditable(false);
			tfRelation.setColumns(10);
			tfRelation.setBounds(110, 335, 130, 26);
		}
		return tfRelation;
	}
	
	
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setBounds(373, 179, 44, 27);
			tfCount.setColumns(10);
		}
		return tfCount;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("명");
			lblNewLabel_2.setBounds(418, 181, 25, 22);
		}
		return lblNewLabel_2;
	}
	
	//화면 Table 초기화
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4); //무조건 적어줘야한다. 그렇게 만든것이다. 갯수지정.
		
		int i = Outer_Table.getRowCount(); //검색하고 난 후 전체 초기화를 시키기 위함.
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0); // 0을 지워야 다 지울수 있음.
		}
	
		//크기지정 
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF); // 이너테이블 고정
		
		
		//각각 크기조정인데 이너만 바꾸면 목차는 따라가는 것인가.아웃터를 조절이 가능 처음 보여졌을때 이너의 크기를 지정하여 보여줌.
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
	
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
			
	}
	
	private void searchAction() {
		String query = "select seqno, name, telno, relation from userinfo ";
		int dataCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				String[] qtext = {rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)};
				Outer_Table.addRow(qtext);
				dataCount++;
				
			}
			conn_mysql.close();
			tfCount.setText(Integer.toString(dataCount));
				
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	//Table Clicked
	private void tableClick() {
		int i = Inner_Table.getSelectedRow();    // 몇 번째줄을 클릭했는가 그것을 i로 지
		String wkSeq = (String)Inner_Table.getValueAt(i, 0); // 몇 번째줄의 벨류를 가져오는것. =키값!
		String query = "select seqno, name, telno,address,email,relation from userinfo where seqno =" + wkSeq;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				tfSeqno.setText(rs.getString(1));
				tfName.setText(rs.getString(2)); 
				tfTelno.setText(rs.getString(3)); 
				tfAddress.setText(rs.getString(4)); 
				tfEmail.setText(rs.getString(5));
				tfRelation.setText(rs.getString(6)); 
			}

			
			conn_mysql.close();
	
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		
		
		
	}

}////////
