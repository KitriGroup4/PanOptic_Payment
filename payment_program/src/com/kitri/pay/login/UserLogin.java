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
    public JTextField loginPwTf;
    public JButton closeButton;
    public JButton loginBtn;
    private JPanel LoginButnPane;
    private JPanel comImgPanel;
    private JLabel comimg;

    private UserLoginListener listener;

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
	setBounds(100, 100, 620, 175);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);

	LoginButnPane = new JPanel();
	LoginButnPane.setBounds(472, 15, 109, 94);
	BackgroundPane.add(LoginButnPane);
	LoginButnPane.setLayout(new GridLayout(0, 1, 0, 0));

	loginBtn = new JButton("\uB85C\uADF8\uC778");
	LoginButnPane.add(loginBtn);

	closeButton = new JButton("닫기");
	LoginButnPane.add(closeButton);
	closeButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});

	LoginContentPane = new JPanel();
	LoginContentPane.setBounds(204, 15, 257, 94);
	BackgroundPane.add(LoginContentPane);
	LoginContentPane.setLayout(new BorderLayout(10, 0));

	LoginLabelPane = new JPanel();
	LoginContentPane.add(LoginLabelPane, BorderLayout.WEST);
	LoginLabelPane.setLayout(new GridLayout(2, 0, 0, 0));

	loginIdLable = new JLabel("\uC544\uC774\uB514");
	loginIdLable.setFont(new Font("굴림", Font.BOLD, 16));
	loginIdLable.setHorizontalAlignment(SwingConstants.RIGHT);
	LoginLabelPane.add(loginIdLable);

	loginPwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
	loginPwLabel.setFont(new Font("굴림", Font.BOLD, 16));
	loginPwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	LoginLabelPane.add(loginPwLabel);

	LoginInputPane = new JPanel();
	LoginContentPane.add(LoginInputPane);
	LoginInputPane.setLayout(new GridLayout(2, 1, 5, 5));

	loginIdTf = new JTextField();
	LoginInputPane.add(loginIdTf);
	loginIdTf.setColumns(10);

	loginPwTf = new JTextField();
	LoginInputPane.add(loginPwTf);
	loginPwTf.setColumns(10);

	comImgPanel = new JPanel();
	comImgPanel.setBackground(Color.WHITE);
	comImgPanel.setForeground(Color.WHITE);
	comImgPanel.setBounds(17, 15, 170, 89);
	BackgroundPane.add(comImgPanel);
	comImgPanel.setLayout(new BoxLayout(comImgPanel, BoxLayout.X_AXIS));

	comimg = new JLabel("");
	comimg.setIcon(new ImageIcon("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\com.png"));
	comImgPanel.add(comimg);

	closeButton.addActionListener(listener);
	loginBtn.addActionListener(listener);

    }

    public void loginFailDialog() {
	JOptionPane.showMessageDialog(this, "로그인에 실패했습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
    }
}