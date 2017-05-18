package com.kitri.pay.join;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class UserJoin extends JInternalFrame {

    private JPanel BackgroundPane;
    public JTextField joinTf;
    public JTextField joinName;
    public JButton joinConfirmBtn;
    public JButton joinCloseBtn;
    private JPanel BaseInfoLabelPane;
    private JLabel joinIdLabel;
    private JLabel joinNameLabel;
    private JLabel joinPwLabel;
    private JLabel joinPwCheckLabel;
    private JLabel joinBirthLabel;
    private JPanel BaseInfoPane;
    public JTextField joinId;
    public JButton overCheckBtn;
    private JPanel GenderCheckPane;
    private JLabel joinBaseLabel;
    public JRadioButton maleRadio;
    public JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public boolean isMale;

    private UserJoinListenter listener;

    public boolean checkId;
    public JPasswordField joinPw;
    public JPasswordField joinPwCheck;
    private JPanel yymmdd;
    private JPanel SubInfoLabelPanel;
    private JLabel eMailL;
    public JTextField joinEmailTf;
    public JTextField joinHpTf;
    private JPanel SubInfoLabelPanel2;
    public JComboBox yy;
    public JComboBox mm;
    public JComboBox dd;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserJoin frame = new UserJoin();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public UserJoin() {
	listener = new UserJoinListenter(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 490);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);

	joinTf = new JTextField();
	joinTf.setEditable(false);
	joinTf.setBounds(17, 25, 444, 50);
	joinTf.setHorizontalAlignment(SwingConstants.CENTER);
	joinTf.setText("\uD68C\uC6D0\uAC00\uC785");
	BackgroundPane.add(joinTf);
	joinTf.setColumns(10);

	joinConfirmBtn = new JButton("\uAC00\uC785\uC694\uCCAD");
	joinConfirmBtn.setBounds(194, 380, 125, 34);
	BackgroundPane.add(joinConfirmBtn);

	joinCloseBtn = new JButton("\uB2EB\uAE30");
	joinCloseBtn.setBounds(336, 380, 125, 34);
	BackgroundPane.add(joinCloseBtn);

	BaseInfoLabelPane = new JPanel();
	BaseInfoLabelPane.setBounds(17, 116, 91, 208);
	BackgroundPane.add(BaseInfoLabelPane);
	BaseInfoLabelPane.setLayout(new GridLayout(0, 1, 0, 0));

	joinIdLabel = new JLabel("* \uC544\uC774\uB514");
	joinIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinIdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinIdLabel);

	joinNameLabel = new JLabel("* \uC774\uB984");
	joinNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinNameLabel);

	joinPwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
	joinPwLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinPwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinPwLabel);

	joinPwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
	joinPwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinPwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinPwCheckLabel);

	joinBirthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
	joinBirthLabel.setHorizontalAlignment(SwingConstants.LEFT);
	joinBirthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	BaseInfoLabelPane.add(joinBirthLabel);

	BaseInfoPane = new JPanel();
	BaseInfoPane.setBounds(114, 116, 234, 208);
	BackgroundPane.add(BaseInfoPane);
	BaseInfoPane.setLayout(new GridLayout(5, 0, 5, 5));

	joinId = new JTextField();
	BaseInfoPane.add(joinId);
	joinId.setColumns(10);

	joinName = new JTextField();
	BaseInfoPane.add(joinName);
	joinName.setColumns(10);

	joinPw = new JPasswordField();
	BaseInfoPane.add(joinPw);

	joinPwCheck = new JPasswordField();
	BaseInfoPane.add(joinPwCheck);

	yymmdd = new JPanel();
	BaseInfoPane.add(yymmdd);
	yymmdd.setLayout(new GridLayout(1, 3, 5, 5));

	yy = new JComboBox();
	addComboBoxItems(yy, 1980, 2010);
	yymmdd.add(yy);

	mm = new JComboBox();
	addComboBoxItems(mm, 1, 12);
	yymmdd.add(mm);

	dd = new JComboBox();
	addComboBoxItems(dd, 1, 31);
	yymmdd.add(dd);

	overCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
	overCheckBtn.setBounds(356, 116, 105, 35);
	overCheckBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	BackgroundPane.add(overCheckBtn);

	GenderCheckPane = new JPanel();
	genderGroup = new ButtonGroup();
	GenderCheckPane.setBounds(356, 279, 105, 43);
	BackgroundPane.add(GenderCheckPane);

	maleRadio = new JRadioButton("\uB0A8", true);

	femaleRadio = new JRadioButton("\uC5EC", false);

	genderGroup.add(maleRadio);
	genderGroup.add(femaleRadio);

	GenderCheckPane.add(maleRadio);
	GenderCheckPane.add(femaleRadio);

	joinBaseLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
	joinBaseLabel.setBounds(17, 90, 91, 21);
	joinBaseLabel.setHorizontalAlignment(SwingConstants.LEFT);
	BackgroundPane.add(joinBaseLabel);

	SubInfoLabelPanel2 = new JPanel();
	SubInfoLabelPanel2.setBounds(243, 330, 218, 35);
	BackgroundPane.add(SubInfoLabelPanel2);
	SubInfoLabelPanel2.setLayout(new BorderLayout(10, 0));

	JLabel hpL = new JLabel("* \uD578\uB4DC\uD3F0");
	SubInfoLabelPanel2.add(hpL, BorderLayout.WEST);

	joinHpTf = new JTextField();
	SubInfoLabelPanel2.add(joinHpTf);
	joinHpTf.setColumns(10);

	SubInfoLabelPanel = new JPanel();
	SubInfoLabelPanel.setBounds(17, 330, 218, 35);
	BackgroundPane.add(SubInfoLabelPanel);
	SubInfoLabelPanel.setLayout(new BorderLayout(10, 0));

	eMailL = new JLabel("* E-mail");
	SubInfoLabelPanel.add(eMailL, BorderLayout.WEST);

	joinEmailTf = new JTextField();
	SubInfoLabelPanel.add(joinEmailTf);
	joinEmailTf.setColumns(10);

	isMale = true;
	joinCloseBtn.addActionListener(listener);
	joinConfirmBtn.addActionListener(listener);
	overCheckBtn.addActionListener(listener);
	maleRadio.addActionListener(listener);
	femaleRadio.addActionListener(listener);

	// this.setLocationRelativeTo(null);
    }

    private void addComboBoxItems(JComboBox box, int start, int end) {
	for (int i = start; i <= end; i++) {
	    box.addItem(i);
	}
    }

    public void checkIdFalseDialog() {
	JOptionPane.showMessageDialog(this, "중복된 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void checkIdTrueDialog() {
	JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void checkIdCheckDialog() {
	JOptionPane.showMessageDialog(this, "아이디 중복확인 해주세요.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

    }

    public void joinFailDialog() {
	JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);

    }

    public void pwTooShort() {
	JOptionPane.showMessageDialog(this, "8자리 이상 비밀번호를 입력해주세요.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);

    }

    public void pwCheckError() {
	JOptionPane.showMessageDialog(this, "비밀번호가 같지않습니다.", "비밀번호확인 실패", JOptionPane.WARNING_MESSAGE);
    }

    public void emailInputError() {
	JOptionPane.showMessageDialog(this, "이메일주소오류입니다.", "메일주소확인 실패", JOptionPane.WARNING_MESSAGE);
    }

    public void hpInputError() {
	JOptionPane.showMessageDialog(this, "핸드폰번호입력오류입니다..", "핸드폰번호입력실패", JOptionPane.WARNING_MESSAGE);
    }
}