package com.javalec.PanelUserStatistic;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.Datadefine.data_Enviroment_define;
import com.javalec.PanelManageMbtiResult.MMR_Bean;
import com.javalec.PanelManageMbtiResult.MMR_DbAction;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelUserStatistic extends JPanel { 	//Dowoo 2021.04.30 완료
	private JLabel lbMbti;
	private JLabel lbMbtiCount;
	private JLabel lbAptitudeCount;
	private JLabel lbAptitude;
	private JLabel lbFullCount1;
	private JLabel lbFullCount2;
	private JTextArea tfAptitude1Top;
	private JTextArea tfAptitude2Top;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); //
	private JLabel lbImage;

	/**
	 * Create the panel.
	 */
	public PanelUserStatistic() {
		setBounds(new Rectangle(180, 10, 500, 420));
		setLayout(null);
		add(getLbMbti());
		add(getLbMbtiCount());
		add(getLbAptitudeCount());
		add(getLbAptitude());
		add(getLbFullCount1());
		add(getLbFullCount2());
		add(getTfAptitude1Top());
		add(getTfAptitude2Top());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getScrollPane_1());
		add(getLbImage());
	
		
	}
	private JLabel getLbMbti() {
		if (lbMbti == null) {
			lbMbti = new JLabel("");
			lbMbti.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbMbti.setBounds(33, 250, 416, 30);
		}
		return lbMbti;
	}
	private JLabel getLbMbtiCount() {
		if (lbMbtiCount == null) {
			lbMbtiCount = new JLabel("");
			lbMbtiCount.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbMbtiCount.setBounds(33, 270, 416, 30);
		}
		return lbMbtiCount;
	}
	private JLabel getLbAptitudeCount() {
		if (lbAptitudeCount == null) {
			lbAptitudeCount = new JLabel("");
			lbAptitudeCount.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbAptitudeCount.setBounds(33, 320, 416, 30);
		}
		return lbAptitudeCount;
	}
	private JLabel getLbAptitude() {
		if (lbAptitude == null) {
			lbAptitude = new JLabel("");
			lbAptitude.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbAptitude.setBounds(33, 300, 416, 30);
		}
		return lbAptitude;
	}
	private JLabel getLbFullCount1() {
		if (lbFullCount1 == null) {
			lbFullCount1 = new JLabel("");
			lbFullCount1.setFont(new Font("Dialog", Font.PLAIN, 12));
			lbFullCount1.setBounds(227, 270, 120, 30);
		}
		return lbFullCount1;
	}
	private JLabel getLbFullCount2() {
		if (lbFullCount2 == null) {
			lbFullCount2 = new JLabel("");
			lbFullCount2.setFont(new Font("Dialog", Font.PLAIN, 12));
			lbFullCount2.setBounds(227, 320, 120, 30);
		}
		return lbFullCount2;
	}
	
	private JTextArea getTfAptitude1Top() {
		if (tfAptitude1Top == null) {
			tfAptitude1Top = new JTextArea();
			tfAptitude1Top.setFont(new Font("Dialog", Font.PLAIN, 13));
			tfAptitude1Top.setBackground(new Color(238, 238, 238));
			tfAptitude1Top.setBounds(33, 360, 445, 18);
			tfAptitude1Top.setLineWrap(true);
		}
		return tfAptitude1Top;
	}
	private JTextArea getTfAptitude2Top() {
		if (tfAptitude2Top == null) {
			tfAptitude2Top = new JTextArea();
			tfAptitude2Top.setFont(new Font("Dialog", Font.PLAIN, 13));
			tfAptitude2Top.setBackground(new Color(238, 238, 238));
			tfAptitude2Top.setBounds(33, 380, 455, 18);
			tfAptitude2Top.setLineWrap(true);
		}
		return tfAptitude2Top;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("통계");
			lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel_1.setBounds(33, 220, 84, 30);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("MBTI 유형");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel.setBounds(33, 24, 84, 30);
		}
		return lblNewLabel;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 64, 340, 125);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					US_TableClick();
				}
			});
			innerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(Outer_Table); // 테이블을 불러오기 위해 ******꼭 써야할 것*****
			US_TableInit();
			US_selectList();
		}
		return innerTable;
	}
	
	private JLabel getLbImage() {
		if (lbImage == null) {
			lbImage = new JLabel("");
			lbImage.setIcon(new ImageIcon(""));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbImage.setBounds(378, 64, 100, 125);
		}
		return lbImage;
	}

	//----------------
	//메소드 정리
	//----------------
	
	//이너테이블 설정
	public void US_TableInit() {	
		
		Outer_Table.addColumn("번호");
		Outer_Table.addColumn("유형");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("설명");
		Outer_Table.setColumnCount(4); 
		
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
			
		int vColIndex = 0; // 첫번째 행
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 30; // 첫번째 행 가로
		col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
		
		vColIndex = 1; // 2번째 행
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 50; // 2번째 행 가로
		col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
		
		vColIndex = 2; // 3번째 행
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100; // 3번째 행 가로
		col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
		
		vColIndex = 3; // 4번째 행
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 240; // 4번째 행 가로
		col.setPreferredWidth(width);; // 4번째 행 가로크기 설정

		
	}
	
	//전체검색
	private void US_selectList() {

		US_DbAction dbAction = new US_DbAction();
		ArrayList<US_Bean> beanlList = dbAction.US_selectList();
		
		int listCount =beanlList.size();
		
		for(int i=0; i<listCount; i++) {
			String temp =Integer.toString(beanlList.get(i).getMrNum());
			String[] qtxt = {temp,beanlList.get(i).getMrType(), beanlList.get(i).getMrName(),beanlList.get(i).getMrExplain()};
			Outer_Table.addRow(qtxt);
			}
	}
	
	private void US_TableClick() {
		int i = innerTable.getSelectedRow();
		String tmMrNum = (String)innerTable.getValueAt(i,0);
		int wkMrNUM = Integer.parseInt(tmMrNum);
		
		MMR_DbAction mmr_DbAction =new MMR_DbAction(wkMrNUM);
		MMR_Bean bean =mmr_DbAction.MMR_TableClick();
		
		//Image처리
		String filePath = Integer.toString(data_Enviroment_define.filename);
		
		lbImage.setIcon(new ImageIcon(filePath));
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		}

	//MBTI와 적성 보여주는 기능. 
	private void US_Infor() {
		
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_Infor();
		
		lbMbti.setText(bean.getUserName() + "님의 MBTI는 " + bean.getUserResultM() + "입니다." );
		lbAptitude.setText(bean.getUserName() + "님의 적성은 " + bean.getUserResultA() + "입니다.");
	}
	//본인과 같은 MBTI 명수
	private void US_MbtiCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_MbtiCount();
		
		lbMbtiCount.setText("나와 같은 사람은 " + bean.getCount() + "명 입니다.");
	}
	//본인과 같은 적성 명수
	private void US_AptitudeCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_AptitudeCount();
		
		lbAptitudeCount.setText("나와 같은 사람은 " + bean.getCount() + "명 입니다.");
	}
	//총 인원수
	private void US_FullCount() {
		US_DbAction us_DbAction =new US_DbAction(data_Enviroment_define.userNum);
		US_Bean bean = us_DbAction.US_FullCount();
		 
		lbFullCount1.setText("총" + bean.getCount()+ "명");
		lbFullCount2.setText("총" + bean.getCount()+ "명");
	}
	
	//적성이 천직인 사람의 탑 MBTI
	private void US_Aptitude1Top() {

		US_DbAction us_DbAction =new US_DbAction();
		US_Bean bean = us_DbAction.US_Aptitude1Top();
		
		tfAptitude1Top.setText("적성이 \"천직\"인 사람중 가장 많은 MBTI는 " + bean.getUserResultM() + "이고 총 " + bean.getCount() + " 명 입니다");
		
	}

	
	//적성이 한번더 생각하기인 사람의 탑 MBTI
	private void US_Aptitude2Top() {

		US_DbAction us_DbAction =new US_DbAction();
		US_Bean bean = us_DbAction.US_Aptitude2Top();
		
		tfAptitude2Top.setText("적성이 \"한번더 의심하기\"인 사람중 가장 많은 MBTI는 " + bean.getUserResultM() + "이고 총 " + bean.getCount() + " 명 입니다");
		
	}

	public void Restart() {
		lbAptitude.setText("");
		lbAptitudeCount.setText("");
		lbFullCount1.setText("");
		lbFullCount2.setText("");
		lbMbti.setText("");
		lbMbtiCount.setText("");
		tfAptitude1Top.setText("");
		tfAptitude2Top.setText("");
		US_Infor();
		US_MbtiCount();
		US_AptitudeCount();
		US_FullCount();
		US_Aptitude1Top();
		US_Aptitude2Top();
	}
}/////////////////
