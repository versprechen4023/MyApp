package myAPP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.net.URI;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JPasswordField;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MBTRIP implements ActionListener {
	// 전역 변수 이용
	private JFrame f;
	// 본 프레임 버튼 전역변수
	private JButton blogin;
	private JButton badd;
	private JButton bairport;
	private JButton bmenu;
	private JButton bhouse;
	private JButton bfood;
	private JButton bcountry;
	private JButton loginbutton;
	private JButton insideCountry;
	private JButton outsideCountry;
	private JButton bsingup;
	// end

	// mbti 버튼 전역변수
	private JButton b;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	// end

	// link 버튼 전역변수
	private JButton linkButton1;
	private JButton linkButton2;
	private JButton linkButton3;
	private JButton linkButton4;
	// end
    
	//기타 pane, 필드등 관련
	private JDialog dialog;
	private JFrame flogin;
	private JTextField usernameField;
	private JTextField passwordField;
    // end
	
	// sql연동
	private final String url = "jdbc:mysql://121.175.38.138:3306/ur?useSSL=false&allowPublicKeyRetrieval=true"; // 서버주소
	private final String user = "test"; // DB 아이디
	private final String dbPassword = "Test@123";// DB 비밀번호

	// 메소드목록
	// ------------------------------------------------------------------------------------------

	// 암호화 관련 메소드
	// ------------------------------------------------------------------------------------------
	// 비밀번호 솔트생성 메소드
	private String generateSalt() {
		SecureRandom random = new SecureRandom(); // 난수생성
		byte[] salt = new byte[16];// 16진수화를 위한 난수 바이트 배열 생성
		random.nextBytes(salt);// 배열에 값 입력
		return bytesToHex(salt);// 16진수화를 위해 바이트투헥스로 값 리턴
	}

	// 솔트,해쉬 16진수화
	private String bytesToHex(byte[] bytes) { // 솔트, 해쉬 배열 값 가져옴
		StringBuilder result = new StringBuilder();

		for (byte b : bytes) {// for each문 배열크기만큼 반복
			result.append(String.format("%02x", b));// 16진수화(2자리로)
		}

		return result.toString();// 문자열화
	}

	// 비밀번호 해쉬화를 위한 메소드
	private String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");// SHA-256방식에 따름
		md.update(hexToBytes(salt));// salt를 바이트화 한다(update의 메소드는 입력값이 바이트 배열임)
		byte[] hashedBytes = md.digest(password.getBytes());// 해쉬값을 바이트로 받아서 배열에 입력
		return bytesToHex(hashedBytes);// 16진수화를 위해 바이트투헥스로 값 리턴
	}

	// 솔트 16진수를 다시 바이트화 하기위한 메소드
	private byte[] hexToBytes(String hex) {
		int leng = hex.length();// 16진수크기만큼 길이설정
		byte[] data = new byte[leng / 2];// 16진수크기에 따른 바이트 배열 길이 설정
		for (int i = 0; i < leng; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
                          //반복문을 이용해 16진수 2문자씩 2진수화 처리
                         //데이터를 우선 digit함수를 통해 10진수화 하는 과정을 거침
                        //2진수화된 16진수를 왼쪽으로 4비트 이동하는것으로 10진수화 할 수있음
                       //이후 2번째 16진수문자를  마찬가지로 같은 방식으로 하되 첫번쨰
                      //16진수문자(2진수화된것에)더 하는 것으로 총 2개의문자를 
                     //10진수화 하는 것이 가능
                    //최종적으로 10진수를 2진수화해서 data(2진수 배열)에 저장함
		} // 16진수>10진수>2진수(바이트배열)
		return data;// 값 리턴
	}

	// 패널 관련 메소드
	// ------------------------------------------------------------------------------------------
	private void mbtPanel() {

		JPanel panel2 = new JPanel(new GridLayout(2, 4));//4행 2열
		panel2.setBounds(0, 60, 484, 50);// 위치 커스텀 설정 x,y,width,height
		f.add(panel2);// 프레임에 panel추가

		// mbti 버튼 추가
		b = new JButton("ESFP");
		panel2.add(b);
		b1 = new JButton("ESTP");
		panel2.add(b1);
		b2 = new JButton("ENFP");
		panel2.add(b2);
		b3 = new JButton("ENTP");
		panel2.add(b3);
		b4 = new JButton("ISFP");
		panel2.add(b4);
		b5 = new JButton("ISTP");
		panel2.add(b5);
		b6 = new JButton("INFP");
		panel2.add(b6);
		b7 = new JButton("INTP");
		panel2.add(b7);

		// 입력 이벤트 받을 리스너 추가
		this.b.addActionListener(this);

	}

	private void imgPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		JPanel imagePanel = new JPanel(); // 이미지를 담을 패널 생성

		// 이미지 추가
		ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");// 이미지의 파일 위치 설정
		Image image1 = imageIcon1.getImage().getScaledInstance(80, 65, 0);// 이미지 크기 설정 width, height, hints
		ImageIcon scaledIcon1 = new ImageIcon(image1);// image1을 scaledicon에 새로 객체를 생성해서 담음
		imagePanel.add(new JLabel(scaledIcon1));// jlabel에 scaledicon을 추가

		// 이미지 사이 간격
		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));// 간격조절 width,height

		ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");//저장된 이미지의 주소
		Image image2 = imageIcon2.getImage().getScaledInstance(80, 65, 0);//크기 조절
		ImageIcon scaledIcon2 = new ImageIcon(image2);
		imagePanel.add(new JLabel(scaledIcon2));

		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));//여백(공백) 조절

		ImageIcon imageIcon3 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");
		Image image3 = imageIcon3.getImage().getScaledInstance(80, 65, 0);
		ImageIcon scaledIcon3 = new ImageIcon(image3);
		imagePanel.add(new JLabel(scaledIcon3));

		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));

		ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");
		Image image4 = imageIcon4.getImage().getScaledInstance(80, 65, 0);
		ImageIcon scaledIcon4 = new ImageIcon(image4);
		imagePanel.add(new JLabel(scaledIcon4));

		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));

		ImageIcon imageIcon5 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");
		Image image5 = imageIcon5.getImage().getScaledInstance(80, 65, 0);
		ImageIcon scaledIcon5 = new ImageIcon(image5);
		imagePanel.add(new JLabel(scaledIcon5));

		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));

		ImageIcon imageIcon6 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");
		Image image6 = imageIcon6.getImage().getScaledInstance(80, 65, 0);
		ImageIcon scaledIcon6 = new ImageIcon(image6);
		imagePanel.add(new JLabel(scaledIcon6));

		imagePanel.add(Box.createRigidArea(new Dimension(20, 0)));

		ImageIcon imageIcon7 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\back.gif");
		Image image7 = imageIcon7.getImage().getScaledInstance(80, 65, 0);
		ImageIcon scaledIcon7 = new ImageIcon(image7);
		imagePanel.add(new JLabel(scaledIcon7));

		// 스크롤바 라인
		JScrollPane scrollPane = new JScrollPane(imagePanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);// 수평 스크롤바 항상표시
		// scrollPane.setPreferredSize(new Dimension(500, 200)); // 고정값에서 패널 크기 조정 현재는
		// 커스텀 크기를 사용하고 있어 필요 없음

		panel.add(scrollPane, BorderLayout.CENTER);// 패널 스크롤패널 레이아웃 위치 설정
		panel.setBounds(-10, 165, 510, 100);// 위치 커스텀 설정 x,y,width,height
		f.add(panel);// 프레임에 panel추가

	}

	// URL 관련 메소드
	// ------------------------------------------------------------------------------------------
	private void openWeb(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));// url의 argument 받아 입력
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SQL 관련 메소드
	// ------------------------------------------------------------------------------------------
	private void loginQuery() {
		String id = usernameField.getText(); // id 입력값 받아옴
		String pass = passwordField.getText(); // 비밀번호 입력값 받아옴

		if (id.isEmpty() || pass.isEmpty()) { //아이디 or 패스워드 창이 비어 있을시 에러출력
			JOptionPane.showConfirmDialog(null, "아이디 혹은 패스워드가 입력되지 않았습니다", "Error", JOptionPane.DEFAULT_OPTION,
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				// JDBC 드라이버 로드
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection connection = DriverManager.getConnection(url, user, dbPassword);

				// SQL 쿼리 실행
				String query = "SELECT * FROM users WHERE id = ?"; // id부터 검색
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, id);
				ResultSet resultSet = statement.executeQuery();

				// 로그인 결과 처리
				if (resultSet.next()) {
					// id검색으로 우선 해쉬 값과 솔트 값을 받아옴
					String hashedPassword = resultSet.getString("pass");
					String salt = resultSet.getString("salt");

					// 사용자에게 입력된 비밀번호와 DB에 저장된 솔트를 합쳐서 해시화함
					String inputHashedPassword = hashPassword(pass, salt);
                    // 2개의 해쉬된 비밀번호가 일치하는지 검증함
					if (hashedPassword.equals(inputHashedPassword)) {
						// 비밀번호 일치 - 로그인 성공
						JOptionPane.showMessageDialog(null, "로그인 성공");
						flogin.dispose();//로그인창 종료
					} else {
						// 비밀번호 불일치 - 로그인 실패
						JOptionPane.showConfirmDialog(null, "ID 혹은 비밀번호가 틀립니다", "Error", JOptionPane.DEFAULT_OPTION,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					// 해당 ID가 존재하지 않음 - 로그인 실패
					// result결과가 없으므로(false) ID없음
					JOptionPane.showConfirmDialog(null, "ID 혹은 비밀번호가 틀립니다", "Error", JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}

				// 연결 및 자원 해제
				resultSet.close();
				statement.close();
				connection.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				// sql에러시 출력
				ex.printStackTrace();
				JOptionPane.showConfirmDialog(null, "서버가 오프라인 상태거나 현재 사용 할 수 없습니다", "Error", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE);
			} catch (NoSuchAlgorithmException e) {
				// 알고리즘화 에러시 출력
				e.printStackTrace();
			}
		}
	}

	private void insertQuery() {
		String num = "2"; // 데이터베이스 usernum에 담을 값
		String id = usernameField.getText();
		String pass = passwordField.getText();

		if (id.isEmpty() || pass.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "아이디 혹은 패스워드가 입력되지 않았습니다", "Error", JOptionPane.DEFAULT_OPTION,
					JOptionPane.ERROR_MESSAGE);
		}

		else {

			try {
				// JDBC 드라이버 로드
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection connection = DriverManager.getConnection(url, user, dbPassword);

				// SQL 쿼리 ID 존재여부 확인
				String queryCheck = "SELECT * FROM users WHERE id = ?"; // id부터 검색
				PreparedStatement statementCheck = connection.prepareStatement(queryCheck);
				statementCheck.setString(1, id);
				ResultSet resultSetCheck = statementCheck.executeQuery();

				if (resultSetCheck.next()) { //ID가 있을경우(true) 에러 출력
					JOptionPane.showConfirmDialog(null, "이미 존재하는 아이디 입니다 다른 아이디를 입력해주세요", "Error", JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
				} else { //false 반환시 db에 데이터 삽입 준비

					// 솔트 생성 및 해쉬비밀번호 입력 준비
					String salt = generateSalt();
					String hashedPassword = hashPassword(pass, salt);

					// SQL 쿼리 실행
					String query = "INSERT INTO users(user_role, id, pass, salt) VALUE(?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, num);
					statement.setString(2, id);
					statement.setString(3, hashedPassword);
					statement.setString(4, salt);
					int resultSet = statement.executeUpdate(); // insert쿼리에선 executeUpdate()를 사용

					// 데이터 베이스 결과 처리
					if (resultSet == 1) {
						// 데이터 베이스 입력 성공
						JOptionPane.showMessageDialog(null, "성공");
					} else {
						// 데이터 베이스 입력 실패
						JOptionPane.showMessageDialog(null, "실패");
					}

					// 연결 및 자원 해제
					statement.close();
					connection.close();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				// sql에러시 출력
				ex.printStackTrace();
				JOptionPane.showConfirmDialog(null, "서버가 오프라인 상태거나 현재 사용 할 수 없습니다", "Error", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE);
				// 알고리즘화 에러시 출력
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}

	// Dialog 관련 메소드
	// ------------------------------------------------------------------------------------------
	private void textDialog() {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.setSize(300, 300);
	}

	private void showLoginDialog() {
		flogin = new JFrame("로그인 창");// 로그인 프레임 제목 설정
		flogin.setLayout(null);// 레이아웃 위치 커스텀 세팅

		JLabel usernameLabel = new JLabel("username:");
		usernameLabel.setBounds(15, 10, 150, 20);// 라벨위치 지정
		usernameField = new JTextField(10);// 텍스트 필드 크기
		usernameField.setBounds(80, 10, 140, 20);// 아이디 필드 위치 지정

		JLabel passwordLabel = new JLabel("password:");
		passwordLabel.setBounds(15, 40, 150, 20);// 라벨위치 지정
		passwordField = new JPasswordField(10);// 텍스트 필드 크기
		passwordField.setBounds(80, 40, 140, 20);// 패스워드 필드 위치 지정

		loginbutton = new JButton("로그인");// 로그인 버튼 내용
		loginbutton.setBounds(110, 70, 70, 30);// 버튼 위치 지정
		Font fontblogin = new Font("맑은 고딕", Font.BOLD, 12);// 로그인 버튼 폰트 설정
		loginbutton.setFont(fontblogin);// 로그인 버튼 폰트 세팅

		// 프레임에 라벨 및 버튼 추가
		flogin.add(usernameLabel);
		flogin.add(usernameField);
		flogin.add(passwordLabel);
		flogin.add(passwordField);
		flogin.add(loginbutton);

		// 입력값 넘기는 용도
		this.loginbutton.addActionListener(this);

		flogin.setSize(300, 150);// 프레임 창 크기 조절
		flogin.setVisible(true);// 프레임 보이기
		flogin.setResizable(false);// 프레임 창 크기 조정 불가

	}

	MBTRIP() {
		// title name
		f = new JFrame("MBTRIP");

		// set font
		// 예제 Font font = new Font("맑은 고딕", Font.BOLD, 17);
		Font fontblogin = new Font("맑은 고딕", Font.BOLD, 12);// 일반버튼 폰트
		Font fontbadd = new Font("맑은 고딕", Font.BOLD, 18);
		Font fontline1 = new Font("맑은 고딕", Font.BOLD, 30);
		Font custom = new Font("맑은 고딕", Font.BOLD, 15);
		Font fontpanel = new Font("맑은 고딕", Font.BOLD, 12);
		Font fontcountry = new Font("맑은 고딕", Font.BOLD, 30);// 국내,국외버튼 폰트

		// set icon
		ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\test\\java\\java.png");
		f.setIconImage(icon.getImage());

		// label line
		JLabel label = new JLabel();// 제목라벨
		label.setText("MBTRIP");
		label.setBounds(180, -30, 180, 100);
		label.setFont(fontline1);

		JLabel titleLabel = new JLabel();// 이미지제목라벨
		titleLabel.setText("<이달 베스트 여행 계획>");
		titleLabel.setBounds(175, 145, 175, 20);
		titleLabel.setFont(fontpanel);

		// mbtititlepanel
		JLabel mTitleLabel = new JLabel();// 제목라벨
		mTitleLabel.setText("MBTI 유형별 추천 여행지");
		mTitleLabel.setBounds(170, 2, 180, 100);

		// linkbutton
		linkButton1 = new JButton("동행구하기");
		linkButton1.setBounds(-15, 370, 100, 20);
		linkButton1.setContentAreaFilled(false);// 버튼 불투명
		linkButton1.setBorderPainted(false);// 버튼 외각선 삭제

		linkButton2 = new JButton("MBTI 유형별 궁합도");
		linkButton2.setBounds(0, 400, 150, 20);
		linkButton2.setContentAreaFilled(false);
		linkButton2.setBorderPainted(false);

		linkButton3 = new JButton("커뮤니티");
		linkButton3.setBounds(0, 420, 90, 20);
		linkButton3.setContentAreaFilled(false);
		linkButton3.setBorderPainted(false);

		linkButton4 = new JButton("여행친구 찾기");
		linkButton4.setBounds(-18, 440, 150, 20);
		linkButton4.setContentAreaFilled(false);
		linkButton4.setBorderPainted(false);

		// mbtbuttonpanel
		mbtPanel();// mbt버튼 패널 함수 호출

		// panelline
		imgPanel();// 이미지 패널 함수 호출

		// add label
		f.add(label);
		f.add(titleLabel);
		f.add(mTitleLabel);

		// 가로 구분선 생성
		JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
		separator1.setBounds(0, 44, 500, 1);
		f.add(separator1);

		JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		separator2.setBounds(0, 365, 500, 1);
		f.add(separator2);

		JSeparator separator3 = new JSeparator(SwingConstants.HORIZONTAL);
		separator3.setBounds(0, 395, 500, 1);
		f.add(separator3);

		// button line
		blogin = new JButton("로그인");
		blogin.setBounds(400, 10, 70, 30);// x, y, width, height
		blogin.setFont(fontblogin);

		badd = new JButton("+");
		badd.setBounds(325, 10, 70, 30);
		badd.setFont(fontbadd);

		bmenu = new JButton("메뉴");
		bmenu.setBounds(10, 10, 70, 30);
		bmenu.setFont(fontblogin);

		bairport = new JButton("항공");
		bairport.setBounds(30, 270, 80, 80);
		bairport.setFont(custom);

		bhouse = new JButton("숙소");
		bhouse.setBounds(140, 270, 80, 80);
		bhouse.setFont(custom);

		bfood = new JButton("맛집");
		bfood.setBounds(250, 270, 80, 80);
		bfood.setFont(custom);

		bcountry = new JButton("관광지");
		bcountry.setBounds(360, 270, 80, 80);
		bcountry.setFont(custom);

		insideCountry = new JButton("국내");
		insideCountry.setBounds(10, 120, 150, 40);
		insideCountry.setFont(fontcountry);
		outsideCountry = new JButton("국외");
		outsideCountry.setBounds(320, 120, 150, 40);
		outsideCountry.setFont(fontcountry);

		// add button
		f.add(blogin);// 로그인
		f.add(badd);// +버튼
		f.add(bmenu);// 메뉴버튼
		f.add(bairport);// 항공 버튼
		f.add(bhouse);// 숙박 버튼
		f.add(bfood);// 맛집 버튼
		f.add(bcountry);// 관광지 버튼
		f.add(insideCountry);// 국내 버튼
		f.add(outsideCountry);// 국외 버튼

		f.add(linkButton1);// 동행구하기
		f.add(linkButton2);
		f.add(linkButton3);
		f.add(linkButton4);

		// custom button
		bairport.setUI(new MyButtonUI());
		bhouse.setUI(new MyButtonUI());
		bfood.setUI(new MyButtonUI());
		bcountry.setUI(new MyButtonUI());

		// manual setting
		f.setSize(500, 550);// 프레임 사이즈 크기 지정
		f.setLayout(null);// 레이아웃 수동 지정
		f.setVisible(true);// 프레임을 보여주게 함
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼을 입력하면 프로그램 종료

		f.setResizable(false);// 프레임 사이즈를 수정하지 못하게 함

		// action listener
		this.blogin.addActionListener(this);
		this.badd.addActionListener(this);
		this.bairport.addActionListener(this);
		this.bhouse.addActionListener(this);
		this.bfood.addActionListener(this);
		this.bcountry.addActionListener(this);
		this.insideCountry.addActionListener(this);
		this.outsideCountry.addActionListener(this);
		this.linkButton1.addActionListener(this);
		this.linkButton2.addActionListener(this);
		this.linkButton3.addActionListener(this);
		this.linkButton4.addActionListener(this);
	}

	// 아래에서 버튼 입력 이벤트 발생시 작동할 로직을 구현함
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton action = (JButton) event.getSource();

		if (action.equals(blogin)) {
			showLoginDialog();
		}

		if (action.equals(badd)) {
			openWeb("https://www.naver.com");
		}

		if (action.equals(bairport)) {
			textDialog();
		}

		if (action.equals(loginbutton)) {
			loginQuery();
//			insertQuery();
		}

		if (action.equals(b)) {
			System.out.println("mbt button OK");
		}

		// 링크버튼

		if (action.equals(linkButton1)) {
			openWeb("https://www.naver.com");
		}
		if (action.equals(linkButton2)) {
			openWeb("https://www.naver.com");
		}
		if (action.equals(linkButton3)) {
			openWeb("https://www.naver.com");
		}
		if (action.equals(linkButton4)) {
			openWeb("https://www.naver.com");
		}

	}

	public static void main(String[] args) {
		new MBTRIP();
	}
}

//둥근 JButton을 위한 커스텀 클래스
class MyButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		button.setBackground(Color.GRAY); // 원형 버튼의 배경색 지정
		button.setForeground(Color.BLACK); // 원형 버튼의 글자색 지정
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();
		if (model.isPressed()) {
			g.setColor(Color.WHITE); // 원형 버튼이 눌렸을 때의 색상 지정
		} else {
			g.setColor(b.getBackground());
		}
		g.fillOval(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		super.paint(g, c);
	}
}



