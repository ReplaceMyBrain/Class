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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class UserQuery2 {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
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
	private JRadioButton rbEdit;
	private JRadioButton rbDel;
	private JRadioButton rbSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbInput;
	private JButton btnOK;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery2 window = new UserQuery2();
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
	public UserQuery2() {
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
				tableset();
			}
		});
		frame.setTitle("주소록검색");
		frame.setBounds(100, 100, 478, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
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
		frame.getContentPane().add(getRbEdit());
		frame.getContentPane().add(getRbDel());
		frame.getContentPane().add(getRbSearch());
		frame.getContentPane().add(getRbInput());
		frame.getContentPane().add(getBtnOK());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(11, 97, 119, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(141, 97, 179, 27);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 172, 437, 120);
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
			lblNewLabel.setBounds(12, 322, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setBounds(12, 360, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("전화번호");
			lblNewLabel_1_1.setBounds(12, 398, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("주소 :");
			lblNewLabel_1_2.setBounds(12, 436, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("전자우편");
			lblNewLabel_1_3.setBounds(12, 474, 61, 16);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("관계");
			lblNewLabel_1_4.setBounds(12, 512, 61, 16);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(116, 318, 130, 26);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(116, 356, 130, 26);
		}
		return tfName;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setBounds(116, 392, 130, 26);
			tfTelno.setColumns(10);
		}
		return tfTelno;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(116, 432, 130, 26);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(116, 470, 130, 26);
		}
		return tfEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(116, 508, 130, 26);
		}
		return tfRelation;
	}
	
	
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setBounds(373, 322, 44, 27);
			tfCount.setColumns(10);
		}
		return tfCount;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("명");
			lblNewLabel_2.setBounds(418, 324, 25, 22);
		}
		return lblNewLabel_2;
	}
	private JRadioButton getRbEdit() {
		if (rbEdit == null) {
			rbEdit = new JRadioButton("수정");
			buttonGroup.add(rbEdit);
			rbEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice();
				}
			});
			rbEdit.setBounds(147, 33, 61, 23);
		}
		return rbEdit;
	}
	private JRadioButton getRbDel() {
		if (rbDel == null) {
			rbDel = new JRadioButton("삭제");
			buttonGroup.add(rbDel);
			rbDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice();
				}
			});
			rbDel.setBounds(251, 33, 61, 23);
		}
		return rbDel;
	}
	private JRadioButton getRbSearch() {
		if (rbSearch == null) {
			rbSearch = new JRadioButton("검색");
			buttonGroup.add(rbSearch);
			rbSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice();
				}
			});
			rbSearch.setBounds(355, 33, 61, 23);
		}
		return rbSearch;
	}
	private JRadioButton getRbInput() {
		if (rbInput == null) {
			rbInput = new JRadioButton("입력");
			rbInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					choice();
				}
			});
			buttonGroup.add(rbInput);
			rbInput.setBounds(43, 33, 61, 23);
		}
		return rbInput;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ok();
				}
			});
			btnOK.setBounds(334, 509, 97, 23);
		}
		return btnOK;
	}
	//------------------------------------------------------------------------
	/*
	 * 메소드 정리
	 * 
	 */
	
	//선택했을 때 클린 및 입력창 열고 닫기
	private void choice() {
		
		if(rbInput.isSelected()==true) {alltrue();}
		if(rbEdit.isSelected()==true) {alltrue();}
		if(rbDel.isSelected()==true) {allFalse();}
		if(rbSearch.isSelected()==true) {allFalse();}
	}
	
	//ok버튼을 눌렀을 때 조건에 따른 행동
	private void ok() {
		
		if(rbInput.isSelected()==true) {inputAction();}
		if(rbEdit.isSelected()==true) {editAction();}
		if(rbDel.isSelected()==true) {delAction();}
		if(rbSearch.isSelected()==true) {searchAction();}
	}
	//------------------------------------------------------------------------
	
	/*
	 * 입력창 열기,닫기
	 */
	
	//입력창 모두 닫기
	private void allFalse() {	
		tfName.setEditable(false);
		tfTelno.setEditable(false);
		tfAddress.setEditable(false);
		tfEmail.setEditable(false);
		tfRelation.setEditable(false);
		clean();
	}
	//입력창 모두 열기
	private void alltrue() {
		tfName.setEditable(true);
		tfTelno.setEditable(true);
		tfAddress.setEditable(true);
		tfEmail.setEditable(true);
		tfRelation.setEditable(true);
		clean();	
	}
	
	//------------------------------------------------------------------------
	/*
	 * 초기설정 및 클린작업
	 */
	
	//클린 통합하기
	private void clean() {
		tableInit(); // 화면 테이블 설정 및 초기화
		tableset();  // 테이블 레코드 전체
		clearColumn(); // 텍스트 필드 초기화 
	}
	
	//텍스트필드 초기화
	private void clearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		if(rbSearch.isSelected()!=true) {
			tfSelection.setText("");
		}
		
	}
	//화면 테이블 설정 및 초기화
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
    //테이블 레이블 전체
    private void tableset() {
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
	
    
	//------------------------------------------------------------------------
	/*
	 * 테이블 클릭시 텍스트 필드에보여주기
	 */
  
    
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
	
	
	//------------------------------------------------------------------------
	/*
	 * 입력,수정,삭제,검색 메소드
	 */
	
	//입력 
	private void inputAction() {
		
		int i = inputActionCheck();
		if (i==0) {
			PreparedStatement ps = null;
			String query = "insert into userinfo(name,telno,address,email,relation) values (?,?,?,?,?)";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
					
					ps = conn_mysql.prepareStatement(query);
					ps.setString(1, tfName.getText().trim());
					ps.setString(2, tfTelno.getText().trim());
					ps.setString(3, tfAddress.getText().trim());
					ps.setString(4, tfEmail.getText().trim());
					ps.setString(5, tfRelation.getText().trim());
					ps.executeUpdate();
					
					conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			clean();
		}
	}
	//입력시 입력하라는 체크박스
	private int inputActionCheck() {
		int i = 0;
		String message = "";
		
		if (tfName.getText().trim().equals("")){
			message += "이름 ";
			tfName.requestFocus();
			i++;
		} 
		if(tfTelno.getText().trim().equals("")) {
			message += "전화번호 ";
			tfTelno.requestFocus();
			i++;
		}
		if(tfAddress.getText().trim().equals("")) {
			message += "주소 ";
			tfAddress.requestFocus();
			i++;
		}
		if(tfEmail.getText().trim().equals("")) {
			message += "전자우편 ";
			tfEmail.requestFocus();
			i++;
		}
		if(tfRelation.getText().trim().equals("")) {
			message +="관계 ";
			tfRelation.requestFocus();
			i++;
		}
		
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "을(를) 입력해주세요");		
		}
		return i;
	}
	
	//수정
	private void editAction() {
		PreparedStatement ps = null;
		String query = "UPDATE userinfo SET name = ?, telno = ?, address = ?, email = ?, relation = ?";
		String query2 ="where seqno="+ tfSeqno.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 

			ps = conn_mysql.prepareStatement(query+query2);
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfTelno.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "수정되었습니다.");
			
			conn_mysql.close(); //DB 연결 끊기
		}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기		
		}
		clean();
	}
	
	//삭제 
	private void delAction() {
		PreparedStatement ps = null;
		String query = "DELETE FROM userinfo where seqno=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
		
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1,tfSeqno.getText());
			ps.executeUpdate();
				
			JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				
			conn_mysql.close(); //DB 연결 끊기
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기		
		}
		clean();
	}
		
	//검색
	private void searchAction() {
		int i = cbSelection.getSelectedIndex(); // 전환한 문자열을 받을 변수 선언
		String conditionQueryColumn = ""; // ""값으로 초기화
		switch(i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "address";
			break;
		case 2 : 
			conditionQueryColumn = "relation";
			break;
		default:
			break;
		}
		
		tableInit(); // table을 재구성함
		clearColumn(); // 화면 지우는 메소드
		searchAction(conditionQueryColumn); // 검색메소드 실행
//		System.out.println(conditionQueryColumn);
	}
	
	//검색하기 위한찾기
	private void searchAction(String columnName) { // conditionQueryColumn를 columnName으로 받아옴
		String query = "select seqno, name, telno, relation from userinfo where "+columnName;
		String query2 = " like '%" + tfSelection.getText() + "%'"; 
		int dataCount = 0; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(query+query2);
			
			while(rs.next()) {
			 String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
			 Outer_Table.addRow(qTxt); 
			 dataCount++;
			}
				
			conn_mysql.close(); //DB 연결 끊기
			tfCount.setText(Integer.toString(dataCount)); //while문이 몇번 돌았는지 센다
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
}////////
