package myAPP;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.FileDialog;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Framenew implements ActionListener {
	int count = 0;
	int gettimes = 0;
	String setnull = null;
	String setstring = null;
	private JFrame f;
	private JPanel panel;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton b;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b10;
	private JButton b11;
	private JOptionPane msgbox;
	private JTextField textfield;
	
	private final String notepadPath = "C:\\Program Files\\WindowsApps\\Microsoft.WindowsNotepad_11.2309.28.0_x64__8wekyb3d8bbwe\\Notepad\\Notepad.exe";
	
	private void stoptext() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				label2.setText("");
				
			}
		};
		timer.schedule(task, 10000);
	}
    private void openWeb(String url) throws Exception{
		Desktop.getDesktop().browse(new URI(url));
	}
	private void sinternet() throws Exception {

		Robot robot = new Robot();
		int mouse = InputEvent.BUTTON1_DOWN_MASK;

		openWeb("https://www.naver.com");

			Thread.sleep(300);

			robot.mouseMove(846, 299);
			robot.mousePress(mouse);
			robot.mouseRelease(mouse);

			robot.delay(500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// 클립보드 값 초기화
			StringSelection clip = new StringSelection(setnull);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(clip, clip);
		}
	

	private void callrobot() {

		int mouse = InputEvent.BUTTON1_DOWN_MASK;

		try {
			Robot robot = new Robot();
			for (int a = 0; a < gettimes; a++) {

				// 첫 구동에만 실행
				if (a == 0) {
					// 메모장 열기
					// filepath로 파일위치 변수 선언
//					String filePath = "C:\\Program Files\\WindowsApps\\Microsoft.WindowsNotepad_11.2307.27.0_x64__8wekyb3d8bbwe\\Notepad\\Notepad.exe";
					File file = new File(notepadPath);
					if (file.exists()) {
						Desktop.getDesktop().open(file);
					}
					Thread.sleep(1000);
				}
				// 입력미스가없도록 마우스를 이동
				// robot.mouseMove(565, 853);

				// robot.mousePress(mouse);
				// robot.mouseRelease(mouse);
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_H);
				robot.delay(10);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_E);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_L);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_L);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_O);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_W);
				robot.delay(10);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_O);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_R);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_L);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_D);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.delay(100);

				if (a == gettimes - 1) {
					msgbox.showConfirmDialog(null, "완료했습니다", "Macro", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);

					gettimes = 0;
				}
			}

		} catch (Exception error) {
			error.printStackTrace();
			System.exit(0);
		}

	}

	private void callinputrobot() {

		int mouse = InputEvent.BUTTON1_DOWN_MASK;

		try {
			Robot robot = new Robot();
			for (int a = 0; a < gettimes; a++) {

				// 첫 구동에만 실행
				if (a == 0) {
					// 메모장 열기
					// filepath로 파일위치 변수 선언
//					String filePath = "C:\\Program Files\\WindowsApps\\Microsoft.WindowsNotepad_11.2307.27.0_x64__8wekyb3d8bbwe\\Notepad\\Notepad.exe";
					File file = new File(notepadPath);
					if (file.exists()) {
						Desktop.getDesktop().open(file);
					}
					Thread.sleep(1000);
				}
				// 입력미스가없도록 마우스를 이동
				// robot.mouseMove(565, 853);

				// robot.mousePress(mouse);
				// robot.mouseRelease(mouse);

				robot.delay(10);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.delay(10);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);

				if (a == gettimes - 1) {
					msgbox.showConfirmDialog(null, "완료했습니다", "Macro", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);

					gettimes = 0;
				}
			}

		} catch (Exception error) {
			error.printStackTrace();
			// System.exit(0);
		}

	}

	Framenew() {

		// title name
		f = new JFrame("My Frame");

		// set font
		Font font = new Font("맑은 고딕", Font.BOLD, 17);

		// set icon
		ImageIcon icon = new ImageIcon("C:\\Users\\ITWILL\\Desktop\\download\\java.png");
		f.setIconImage(icon.getImage());

		// label line
		label = new JLabel();
		label.setText("Enter Command :");
		label.setBounds(10, 10, 100, 100);

		label2 = new JLabel();
		label2.setText("");
		label2.setBounds(10, 180, 100, 100);
		label2.setFont(font);

		// add gif image on frame
		label3 = new JLabel("", new ImageIcon("C:\\Users\\ITWILL\\Desktop\\download\\back.gif"), JLabel.CENTER);
		label3.setBounds(250, 237, 250, 230);

		// textfield line
		textfield = new JTextField();
		textfield.setBounds(110, 50, 130, 30);

		// add textfield
		f.add(textfield);

		// add label
		f.add(label);
		f.add(label2);
		f.add(label3);

		// button line
		b = new JButton("show command");
		b.setBounds(100, 100, 140, 40);// x, y, size
		b2 = new JButton("count");
		b2.setBounds(100, 150, 140, 40);
		b3 = new JButton("submit");
		b3.setBounds(250, 50, 80, 40);
		b4 = new JButton("macrosetting");
		b4.setBounds(350, 50, 120, 40);
		b5 = new JButton("macro");
		b5.setBounds(250, 100, 80, 40);
		b6 = new JButton("help command");
		b6.setBounds(350, 100, 120, 40);
		b7 = new JButton("Read File");
		b7.setBounds(350, 150, 120, 40);
		b8 = new JButton("Search");
		b8.setBounds(350, 200, 120, 40);
		b9 = new JButton("macro2");
		b9.setBounds(250, 150, 80, 40);
		b10 = new JButton("test");
		b10.setBounds(250, 200, 80, 40);

		// add button
		f.add(b);// show commands
		f.add(b2);// get literal that how many times clicked
		f.add(b3);// open file
		f.add(b4);// save times how many times macro will run
		f.add(b5);// run macro
		f.add(b6);// help command
		f.add(b7);// File
		f.add(b8);// Search
		f.add(b9);// macro2
		f.add(b10);

		// manual setting
		f.setSize(500, 500);// set size of program
		f.setLayout(null);
		f.setVisible(true);// make program visible
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when press "x" button of window program and process will be
															// closed

		f.setResizable(false);// frame unresizable(false)

		// testfield

		// action listener
		this.b.addActionListener(this);
		this.b2.addActionListener(this);
		this.b3.addActionListener(this);
		this.b4.addActionListener(this);
		this.b5.addActionListener(this);
		this.b6.addActionListener(this);
		this.b7.addActionListener(this);
		this.b8.addActionListener(this);
		this.b9.addActionListener(this);
		this.b10.addActionListener(this);

		
			
			try {
				Thread.sleep(10000);
				label2.setText("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}// end of method

	@Override
	public void actionPerformed(ActionEvent event) {
		String[] runsql = { "SQL", "Sql", "sql" };
		String[] runnotepad = { "notepad", "Notepad", "NOTEPAD", "메모장" };
		String[] runinternet = { "internet", "Internet", "INTERNET", "인터넷" };
		String[] runpaint = { "paint", "Paint", "PAINT", "그림판" };
		String[] exit = { "exit", "Exit", "EXIT" };
		String[] runlinux = { "Linux", "linux", "LINUX", "리눅스" };

		JButton action = (JButton) event.getSource();
		String data = textfield.getText();

		// logic of submit button
		if (action.equals(b3)) {

			// path of files
			if (Arrays.asList(runnotepad).contains(data)) {
//				String filePath = "C:\\Program Files\\WindowsApps\\Microsoft.WindowsNotepad_11.2303.40.0_x64__8wekyb3d8bbwe\\Notepad\\Notepad.exe";
				File file = new File(notepadPath);

				if (file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException error) {
						error.printStackTrace();
					}

				}

			}

			else if (Arrays.asList(runinternet).contains(data)) {
				String filePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
				File file = new File(filePath);

				if (file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException error) {
						error.printStackTrace();
					}

				}

			}

			else if (Arrays.asList(runsql).contains(data)) {
				String filePath = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\MySQLWorkbench.exe";
				File file = new File(filePath);

				if (file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException error) {
						error.printStackTrace();
					}

				}
			}

			else if (Arrays.asList(runlinux).contains(data)) {
				String filePath = "C:\\Program Files\\Oracle\\VirtualBox\\VirtualBox.exe";
				File file = new File(filePath);

				if (file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException error) {
						error.printStackTrace();
					}

				}
			}

			else if (Arrays.asList(runpaint).contains(data)) {
				String filePath = "C:\\Program Files\\WindowsApps\\Microsoft.Paint_11.2302.18.0_x64__8wekyb3d8bbwe\\PaintApp\\mspaint.exe";
				File file = new File(filePath);

				if (file.exists()) {
					try {
						Desktop.getDesktop().open(file);
					} catch (IOException error) {
						error.printStackTrace();
					}

				}
			}

			else if (Arrays.asList(exit).contains(data)) {
				System.exit(0);
			} else {
				msgbox.showConfirmDialog(null, "error : can\'t find command ", "Error", msgbox.DEFAULT_OPTION,
						msgbox.ERROR_MESSAGE);
			}
		} // end of if b3

		// logic of command button
		if (action.equals(b)) {
			msgbox.showConfirmDialog(null, "command : notepad, internet, linux, sql, paint, exit", "Command",
					msgbox.DEFAULT_OPTION, msgbox.INFORMATION_MESSAGE);

		} // (end of if(b)

		// logic of click button
		if (action.equals(b2)) {
			int check = msgbox.showConfirmDialog(null, "숫자 카운트 하시겠습니까?", "Info", msgbox.OK_CANCEL_OPTION,
					msgbox.INFORMATION_MESSAGE);
			if (check == msgbox.OK_OPTION) {
				count++;
				msgbox.showConfirmDialog(null, "count :" + count, "Info", msgbox.DEFAULT_OPTION,
						msgbox.INFORMATION_MESSAGE);
				stoptext();
			}

			label2.setText("클릭횟수 : " + count);
		} // end of if(b2)

		// logic of macrosetting button
		if (action.equals(b4)) {

			String number = msgbox.showInputDialog(null, "반복될 횟수 입력", "Setting", msgbox.QUESTION_MESSAGE);
			if (number == null) { // 스트링은 null값 리턴
			} else {

				try {
					int getnumber = Integer.parseInt(number);// 스트링 인트 형변환
					gettimes = getnumber;
					if (getnumber == 0) {
						msgbox.showConfirmDialog(null, "값은 \"1\" 이상이여야 합니다", "Error", msgbox.DEFAULT_OPTION,
								msgbox.ERROR_MESSAGE);
					} else if (getnumber > 0) {
						msgbox.showConfirmDialog(null, "저장되었습니다", "Confirm", msgbox.DEFAULT_OPTION,
								msgbox.INFORMATION_MESSAGE);
					}
				} catch (Exception error) {
					msgbox.showConfirmDialog(null, "숫자만 입력해주세요 값은 \"1\" 이상이여야 합니다", "Error", msgbox.DEFAULT_OPTION,
							msgbox.ERROR_MESSAGE);
				}
			}
		} // end of if(b4)

		// logic of macro button
		if (action.equals(b5)) {
			if (gettimes == 0) {
				msgbox.showConfirmDialog(null, "반복횟수를 설정해주세요 값은 \"0\" 이상이여야 합니다", "Error", msgbox.DEFAULT_OPTION,
						msgbox.ERROR_MESSAGE);
			} else if (gettimes > 0) {
				int check = msgbox.showConfirmDialog(null, "매크로를 실행하시겠습니까? 반복될횟수는 " + gettimes + "번입니다", "Alret",
						msgbox.YES_NO_OPTION, msgbox.QUESTION_MESSAGE);
				if (check == msgbox.OK_OPTION) {
					callrobot();// call macro method
				}
			}
		} // end of if(b5)

		// 커맨드 설명 버튼
		if (action.equals(b6)) {

			for (int a = 0; a < 1;) { // while문을 이용하면 더 깔끔할 거 같은데 불린값을 전역변수로 설정해야하는 번거로움이 있음
				String notepad = "notepad";
				String internet = "internet";
				String sql = "Sql";
				String linux = "linux";
				String paint = "paint";
				String exit1 = "exit";
				String[] possibleValues = { "notepad", "internet", "sql", "linux", "paint", "exit" };
				String getchoose = (String) msgbox.showInputDialog(null, "선택해주세요", "Help command",
						msgbox.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
				// public static Object showinputdialog Object>String 형변환(입력값받기위함)

				if (getchoose == notepad) {
					msgbox.showConfirmDialog(null, "메모장을 실행하는 커맨드입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				} else if (getchoose == internet) {
					msgbox.showConfirmDialog(null, "인터넷을 실행하는 커맨드입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				} else if (getchoose == sql) {
					msgbox.showConfirmDialog(null, "SQL 워크벤치를 실행하는 커맨드입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				} else if (getchoose == linux) {
					msgbox.showConfirmDialog(null, "리눅스를 실행하기위해 오라클 버츄얼머신을 실행하는 커맨드 입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				} else if (getchoose == paint) {
					msgbox.showConfirmDialog(null, "그림판을 실행하는 커맨드 입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				} else if (getchoose == exit1) {
					msgbox.showConfirmDialog(null, "프로그램을 종료하는 커맨드 입니다", "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				}
				if (getchoose == null) { // String은 null값 리턴
					a++;// for문 무한 루프 탈출용
				}
			} // end of for
		} // end of if(b6)

		if (action.equals(b7)) { // openfiledialog with filereader
			FileDialog file = new FileDialog(f, "OpenFile", FileDialog.LOAD);
			file.setVisible(true);
			String filePath = file.getDirectory() + file.getFile();
			System.out.println(filePath);

			try {

				File file1 = new File(filePath);

				FileReader filereader = new FileReader(file1);

				BufferedReader textreader = new BufferedReader(filereader);

				String textwrite = null;

				while ((textwrite = textreader.readLine()) != null) {
					msgbox.showConfirmDialog(null, textwrite, "Info", msgbox.DEFAULT_OPTION,
							msgbox.INFORMATION_MESSAGE);
				}

				textreader.close();

			} catch (FileNotFoundException error) {
				System.out.println(error);

			} catch (IOException error) {
				System.out.println(error);
			}

		} // end of if(b7)

		if (action.equals(b8)) { // "search" logic with showinputdialog

			try {
				String gettextfield = msgbox.showInputDialog(null, "검색할 내용을 입력하세요", "Setting", msgbox.QUESTION_MESSAGE);
				StringSelection clip = new StringSelection(gettextfield);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(clip, clip);

				if (gettextfield == null) {
				} else {
					sinternet();// call method chrome
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (action.equals(b9)) {// macro with clipboard

			while (true) {// true 문 반복활용 무한루프

				if (gettimes == 0) {
					msgbox.showConfirmDialog(null, "반복횟수를 설정해주세요 값은 \"0\" 이상이여야 합니다", "Error", msgbox.DEFAULT_OPTION,
							msgbox.ERROR_MESSAGE);
					break;
				} else if (gettimes > 0) {

					JTextField inputval = new JTextField();

					Object[] message = { "매크로로 반복할 구문을 입력해주세요 ", inputval }; //입력창 설명구문
					JOptionPane pane = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE,//입력창 셋팅
							JOptionPane.OK_CANCEL_OPTION);
				
					JDialog getTopicDialog = pane.createDialog(null, "Setting");//입력창 제목
					getTopicDialog.setVisible(true);//입력창 보이기

					Object selectedValue = pane.getValue();//창 버튼 입력값 받아오기
					int checksumn = -1;
					String datack = inputval.getText();//입력창 사용자 입력값 받기

					if (selectedValue == null) {
						checksumn = JOptionPane.CLOSED_OPTION;
					} else {
						checksumn = Integer.parseInt(selectedValue.toString());
					}

					if (checksumn == JOptionPane.OK_OPTION) {
						if (datack.isEmpty()) {
							msgbox.showConfirmDialog(null, "구문을 입력해주세요", "Error", msgbox.DEFAULT_OPTION,
									msgbox.ERROR_MESSAGE);
						} else {
							StringSelection clip = new StringSelection(datack);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(clip, clip);

							int check = msgbox.showConfirmDialog(null,
									"매크로를 실행하시겠습니까? 입력될 구문은 \"" + datack +"\" 반복될횟수는 " + gettimes + "번입니다", "Alret",
									msgbox.YES_NO_OPTION, msgbox.QUESTION_MESSAGE);

							if (check == msgbox.OK_OPTION) {
								callinputrobot();// call input macro method
								break;
							} else {
								break;
							}

						}

					} else if (checksumn == JOptionPane.CANCEL_OPTION) {
						break;
					} else if (checksumn == JOptionPane.CLOSED_OPTION) {
						break;
					}
				}

			}
		}// end of b9
		
		if (action.equals(b10)) {
			Object[] options = {"OkK", "Cancel"};
			JOptionPane.showOptionDialog(null, "click", "warning", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		}
		/*JTextField topicTitle = new JTextField();
	    //JTextField topicDesc = new JTextField();


	    //Object[] message = {"Title: ", topicTitle, "Description: ", topicDesc};
		Object[] message = {"Title: ", topicTitle};
	    JOptionPane pane = new JOptionPane(message,  
	            JOptionPane.PLAIN_MESSAGE, 
	            JOptionPane.YES_NO_CANCEL_OPTION);

	    JDialog getTopicDialog =  pane.createDialog(null, "Test");
	    getTopicDialog.setVisible(true);        
	    
	    Object selectedValue = pane.getValue();
	    int n = -1;
	    String data = topicTitle.getText();
	    
	    if(selectedValue == null)
	        n = JOptionPane.CLOSED_OPTION;      
	    else
	        n = Integer.parseInt(selectedValue.toString());


	    if (n == JOptionPane.YES_OPTION){
	        System.out.println("Yes");
	    } else if (n == JOptionPane.NO_OPTION){
	        System.out.println("No");
	    } else if (n == JOptionPane.CANCEL_OPTION){
	        System.out.println("Cancel");
	    } else if (n == JOptionPane.CLOSED_OPTION){
	        System.out.println("Close");
	    }       
	}*/
		
	} // end of listener

	public static void main(String[] args) {
		new Framenew();
	}
}
