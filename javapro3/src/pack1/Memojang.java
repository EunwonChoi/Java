package pack1;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.print.attribute.standard.Fidelity;
import javax.swing.*;


//내용 전체적으로 복습
//메모장 만들면서 확인해보자...

public class Memojang extends JFrame implements ActionListener {
	private JButton btnCopy = new JButton("copy");
	private JButton btnPaste = new JButton("paste");
	private JButton btnCut = new JButton("cut");
	private JButton btnDel = new JButton("del");
	private JPanel pn = new JPanel();
	private JTextArea txtMemo = new JTextArea("", 10, 30);
	private String copyText; // 복사한 내용 잠시 저장하는곳

	// 메뉴
	JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel;
	JMenuItem mnuAbout, mnuEtc1, mnuEtc2;
	
	//팝업메뉴
	JPopupMenu popup;
	JMenuItem m_white, m_blue, m_yellow;
	
	// 생성자
	public Memojang() {
		super("간단 메모장");

		initLayout();
		menuLayout();

		setBounds(300, 300, 500, 400);
		setVisible(true);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int re = JOptionPane.showConfirmDialog(Memojang.this, "정말 종료할까요?", "종료", JOptionPane.YES_NO_OPTION);
				if (re == JOptionPane.YES_NO_OPTION) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}


	// 디자인
	private void initLayout() {

		pn.add(btnCopy);
		pn.add(btnPaste);
		pn.add(btnCut);
		pn.add(btnDel);
		add("South", pn);
		JScrollPane scrollPane = new JScrollPane(txtMemo); // 스크롤 생김
		add("Center", scrollPane);

		btnCopy.addActionListener(this);
		btnPaste.addActionListener(this);
		btnCut.addActionListener(this);
		btnDel.addActionListener(this);

	}

	private void menuLayout() {
		JMenuBar menuBar = new JMenuBar();

		JMenu mnuFile = new JMenu("파일"); // 주메뉴
		mnuNew = new JMenuItem("새문서");  //부메뉴
		mnuOpen = new JMenuItem("열기...");  //부메뉴
		mnuSave = new JMenuItem("저장...");  //부메뉴
		mnuExit = new JMenuItem("끝내기...");  //부메뉴
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator();  //구분선
		mnuFile.add(mnuExit);
		
		JMenu mnuEdit = new JMenu("편집"); // 주메뉴
		mnuCopy = new JMenuItem("복사");
		mnuCut = new JMenuItem("잘라내기");
		mnuPaste = new JMenuItem("붙여넣기");
		mnuDel = new JMenuItem("삭제");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuDel);
		
		JMenu mnuHelp = new JMenu("도움말"); // 주메뉴
		mnuAbout = new JMenuItem("메모장이란...");
		JMenu mnuEtc = new JMenu("기타");  
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("프리셀");
		mnuEtc.add(mnuEtc1);   //부메뉴 아래 부메뉴 등록
		mnuEtc.add(mnuEtc2);
		mnuHelp.add(mnuAbout);
		mnuHelp.add(mnuEtc);
		
		menuBar.add(mnuFile);  //메뉴바에 메뉴 등록
		menuBar.add(mnuEdit);  
		menuBar.add(mnuHelp);
		setJMenuBar(menuBar);   //프레임에 메뉴바 등록
		
		mnuNew.addActionListener(this);   //메뉴에 리스너 등록
		mnuSave.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuExit.addActionListener(this);
		
		mnuCopy.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuDel.addActionListener(this);
		
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);
		
		//Popup Menu
		popup = new JPopupMenu();
		JMenu m_color = new JMenu("배경색 선택");
		m_white = new JMenuItem("하양");
		m_blue = new JMenuItem("파랑");
		m_yellow = new JMenuItem("노랑");
		m_color.add(m_white);
		m_color.add(m_blue);
		m_color.add(m_yellow);
		popup.add(m_color);
		txtMemo.add(popup);
		
		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		
		txtMemo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {   //마우스 오른쪽 클릭시에 팝업창이 나옴
					popup.show(txtMemo, e.getX(), e.getY());   				
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCopy || e.getSource() == mnuCopy) {   //btnCopy와 mnuCopy에서 똑같이 기능을 수행함...
			// copyText = txtMemo.getText();
			copyText = txtMemo.getSelectedText(); // 원하는 부분만 복사할 수 있도록
			System.out.println(copyText);
		} else if (e.getSource() == btnPaste || e.getSource() == mnuPaste) {
			// txtMemo.setText(copyText);
			int position = txtMemo.getCaretPosition(); // 붙여넣기 할 때 새로 덮어 씌우는 것이 아닌 원하는 곳에만 붙일 수 있도록
			// System.out.println(position);
			txtMemo.insert(copyText, position); // 원하는 곳에 가져다가 붙임
		} else if (e.getSource() == btnCut || e.getSource() == mnuCut) {
			copyText = txtMemo.getSelectedText(); // cut한 것을 담아둠
			int start = txtMemo.getSelectionStart(); // 시작
			int end = txtMemo.getSelectionEnd(); // 끝
			txtMemo.replaceRange("", start, end); // 여기서 cut가 됨
		} else if (e.getSource() == btnDel || e.getSource() == mnuDel) {
			int start = txtMemo.getSelectionStart(); // 시작
			int end = txtMemo.getSelectionEnd(); // 끝
			txtMemo.replaceRange("", start, end);
		}else if(e.getSource() == mnuNew) {
			txtMemo.setText("");
			setTitle("제목없음");
		}else if(e.getSource() == mnuOpen) {
			FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
			dialog.setDirectory(".");
			dialog.setVisible(true);
			if(dialog.getFile() == null) return;
			String dfName = dialog.getDirectory() + dialog.getFile();
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dfName));
				
				txtMemo.setText("");
				String line;
				while((line = reader.readLine())  != null) {
					txtMemo.append(line + "\n");
				}
				reader.close();

				this.setTitle(dialog.getFile());
			} catch (Exception e2) {
				System.out.println("open err: " + e2.getMessage());
			}
		}else if(e.getSource() == mnuSave) {
			//저장을 위한 경로명 및 파일명 등을 얻기 위한 운영체제의 대화상자 호출
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
			dialog.setDirectory(".");
			dialog.setVisible(true);
			if(dialog.getFile() == null) return;
			String dfName = dialog.getDirectory() + dialog.getFile();
			// System.out.println(dfName);;
			
			
			try {
				BufferedWriter writer= new BufferedWriter(new FileWriter(dfName));
				writer.write(txtMemo.getText());
				writer.close();
				
				this.setTitle(dialog.getFile());
			} catch (Exception e2) {
				System.out.println("save err: " + e2);
			}
		}else if(e.getSource() == mnuExit) {
			System.exit(0);
		}else if(e.getSource() == mnuAbout) {
			new MemoAbout(this);
			System.out.println("대화상자 호출 후 ----------------");
		}else if(e.getSource() == mnuEtc1) {
			try {
				Runtime runtime = Runtime.getRuntime();   //다른거 띄울려면 꼭 필요
				runtime.exec("calc.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if(e.getSource() == mnuEtc2) {
			try {
				Runtime.getRuntime().exec("freecell.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if(e.getSource().equals(m_white)) {  //요로케 하는건 권장하지 않음
			txtMemo.setBackground(Color.white);
		}else if(e.getSource().equals(m_blue)) {
			txtMemo.setBackground(new Color(0, 0, 255));
		}else if(e.getSource().equals(m_yellow)) {
			txtMemo.setBackground(new Color(255, 255, 0));
		}

		txtMemo.requestFocus();
	}

	public static void main(String[] args) {
		new Memojang();

	}

}
