package com.kitri.pay.login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class UserLogin extends JInternalFrame {

    private JPanel BackgroundPane;
    private JPanel LoginContentPane;
    private JPanel LoginLabelPane;
    private JLabel loginIdLable;
    private JLabel loginPwLabel;
    private JPanel LoginInputPane;
    public JTextField loginIdTf;
    public JButton closeButton;
    public JButton loginBtn;
    private JPanel LoginButnPane;
    private JPanel comImgPanel;
    private JLabel comimg;

    private UserLoginListener listener;
    public JPasswordField loginPwTf;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserLogin frame = new UserLogin();
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
    public UserLogin() {
	setTitle("Login");

	listener = new UserLoginListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 620, 160);
	BackgroundPane = new JPanel();
	BackgroundPane.setBackground(Color.WHITE);
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);

	LoginButnPane = new JPanel();
	LoginButnPane.setOpaque(false);
	LoginButnPane.setBounds(472, 15, 109, 94);
	BackgroundPane.add(LoginButnPane);
	LoginButnPane.setLayout(new GridLayout(0, 1, 0, 0));

	loginBtn = new JButton("\uB85C\uADF8\uC778");
	loginBtn.setBorder(new LineBorder(Color.WHITE));
	loginBtn.setBackground(new Color(200, 162, 255));
	loginBtn.setForeground(Color.WHITE);
	loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
	LoginButnPane.add(loginBtn);

	closeButton = new JButton("닫기");
	closeButton.setBorder(new LineBorder(Color.WHITE));
	closeButton.setBackground(new Color(200, 162, 255));
	closeButton.setForeground(Color.WHITE);
	closeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
	LoginButnPane.add(closeButton);
	closeButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});

	LoginContentPane = new JPanel();
	LoginContentPane.setOpaque(false);
	LoginContentPane.setBounds(204, 15, 257, 94);
	BackgroundPane.add(LoginContentPane);
	LoginContentPane.setLayout(new BorderLayout(10, 0));

	LoginLabelPane = new JPanel();
	LoginLabelPane.setOpaque(false);
	LoginContentPane.add(LoginLabelPane, BorderLayout.WEST);
	LoginLabelPane.setLayout(new GridLayout(2, 0, 0, 0));

	loginIdLable = new JLabel("\uC544\uC774\uB514");
	loginIdLable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	loginIdLable.setHorizontalAlignment(SwingConstants.RIGHT);
	LoginLabelPane.add(loginIdLable);

	loginPwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	loginPwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	loginPwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	LoginLabelPane.add(loginPwLabel);

	LoginInputPane = new JPanel();
	LoginInputPane.setOpaque(false);
	LoginContentPane.add(LoginInputPane);
	LoginInputPane.setLayout(new GridLayout(2, 1, 5, 5));

	loginIdTf = new JTextField();
	loginIdTf.setBorder(new LineBorder(Color.WHITE));
	loginIdTf.setDisabledTextColor(Color.WHITE);
	loginIdTf.setBackground(SystemColor.controlHighlight);
	LoginInputPane.add(loginIdTf);
	loginIdTf.setColumns(10);
	
	loginPwTf = new JPasswordField();
	loginPwTf.setBorder(new LineBorder(SystemColor.window));
	loginPwTf.setBackground(new Color(227, 227, 227));
	LoginInputPane.add(loginPwTf);

	comImgPanel = new JPanel();
	comImgPanel.setBackground(Color.WHITE);
	comImgPanel.setForeground(Color.WHITE);
	comImgPanel.setBounds(17, 15, 170, 89);
	BackgroundPane.add(comImgPanel);
	comImgPanel.setLayout(new BoxLayout(comImgPanel, BoxLayout.X_AXIS));

	comimg = new JLabel("");
	comimg.setIcon(new ImageIcon("img\\com.png"));
	comImgPanel.add(comimg);

	closeButton.addActionListener(listener);
	loginBtn.addActionListener(listener);

    }

    public void loginFail() {
	JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);

    }

    public void fieldEmpty() {
	JOptionPane.showMessageDialog(this, "아이디 비밀번호를 입력해주세요.", "공백", JOptionPane.WARNING_MESSAGE);

    }

    public void loginFailDialog() {
	JOptionPane.showMessageDialog(this, "로그인에 실패했습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
    }
}