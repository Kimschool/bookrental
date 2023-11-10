package list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ListFrame extends JFrame {

	JButton b2 = new JButton("도서상세보기");

	public ListFrame() {
		setTitle("도서관리시스템 - 일람화면");
		setSize(700,600);
		setLayout(new BorderLayout(10, 10));

		setNorthPanel();
		setCenterPanel();
		setEastPanel();
		setSouthPanel();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setCenterPanel() {
		JPanel p = new JPanel();
		String[] [] data;
		ListData listData = new ListData();
		data = listData.loadData();
		String[] title = {"책", "제목", "카테고리", "저자", "대여상태"};
		JTable t = new JTable(data,title);
		JScrollPane s = new JScrollPane(t);

		p.add(s);
		add(p, "Center");

		t.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e){
				b2.setEnabled(true);
//			   int row = t.getSelectedRow();
//			   int col = t.getSelectedColumn();
//			JOptionPane.showMessageDialog(null, "행" + row + "열" + col);

//		    System.out.println("row index값은" + row);
//		    System.out.println("column index값은"+ col);
//		    System.out.println(data[row][col]);
		   }
		  });

	}

	private void setNorthPanel() {
		JPanel p = new JPanel();
		JLabel l = new JLabel("책제목");
		JTextField t = new JTextField(10);
		JButton b = new JButton("검색");
		p.add(l);
		p.add(t);
		p.add(b);
		add(p, "North");
	}

	private void setEastPanel() {
		JPanel p = new JPanel(new GridLayout(10,0));
		JButton b1 = new JButton("도서등록");
		b2.setEnabled(false);
		p.add(b1);
		p.add(b2);
		add(p, "East");
	}

	private void setSouthPanel() {
		JPanel p = new JPanel();
		JButton b1 = new JButton("검색결과초기화");
		p.add(b1);
		add(p, "South");
	}

	public static void main(String[] args) {
		new ListFrame();
	}


}
