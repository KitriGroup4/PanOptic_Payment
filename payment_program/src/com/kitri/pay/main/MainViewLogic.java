package com.kitri.pay.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.kitri.pay.network.Network;
import com.kitri.pay.network.PacketInformation;

public class MainViewLogic {

    private final byte MINUS = 0;
    private final byte PLUS = 1;

    private MainView view;

    public MainViewLogic(MainView view) {
	this.view = view;
    }

    public void setFalseButton(JLabel[] buttons, boolean[] isClick, int[] money) {
	int len = buttons.length;

	for (int i = 0; i < len; i++) {
	    buttons[i].setForeground(Color.BLACK);
	    if (isClick[i]) {
		updateMoney(MINUS, money[i], view);
		isClick[i] = false;

	    }

	}
    }

    public boolean isClickButton(Object o, JLabel[] buttons, boolean[] isClick, int[] money) {
	boolean result = false;
	int len = buttons.length;

	for (int i = 0; i < len; i++) {
	    if (isClick[i]) {
		updateMoney(MINUS, money[i], view);
	    }
	}

	for (int i = 0; i < len; i++) {
	    if (o == buttons[i]) {
		if (isClick[i]) {
		    isClick[i] = false;
		    buttons[i].setForeground(Color.BLACK);
		    updateMoney(MINUS, money[i], view);

		} else {
		    buttons[i].setForeground(Color.BLUE);
		    view.payment.index = i;
		    updateMoney(PLUS, money[i], view);
		    isClick[i] = true;
		}

		result = true;
	    } else {
		buttons[i].setForeground(Color.BLACK);
		isClick[i] = false;
	    }
	}

	return result;
    }

    public boolean isClickButton(Object o, JButton[] buttons) {
	boolean result = false;
	int len = buttons.length;

	for (int i = 0; i < len; i++) {
	    if (o == buttons[i]) {
		result = true;

		switch (i) {
		case 0: // 회원가입
		    Main.log("회원가입");
		    view.join.setVisible(true);
		    resetJoin();
		    break;
		case 1: // 포인트결제
		    view.payType = PacketInformation.PacketType.POINT;
		    if (isSelected()) {
			view.login.setVisible(true);
			resetLogin();
		    }
		    break;
		case 2: // 카드 결제
		    view.payType = PacketInformation.PacketType.CARD;
		    if (isSelected()) {
			view.login.setVisible(true);
			resetLogin();
		    }
		    break;
		default:
		}

		break;
	    }
	}
	return result;
    }

    private void resetJoin() {
	view.join.joinName.setText("");
	view.join.joinId.setText("");
	view.join.joinPw.setText("");
	view.join.joinPwCheck.setText("");
	view.join.joinEmailTf.setText("");
	view.join.joinHpTf.setText("");
	view.join.yy.setSelectedIndex(0);
	view.join.mm.setSelectedIndex(0);
	view.join.dd.setSelectedIndex(0);
	view.join.maleRadio.setSelected(true);
	view.join.femaleRadio.setSelected(false);

    }

    private void resetLogin() {
	view.login.loginIdTf.setText("");
	view.login.loginPwTf.setText("");
    }

    private void updateMoney(byte type, int money, MainView m) {

	if (type == MINUS) {
	    m.setMoney(m.getMoney() - money);
	} else {
	    m.setMoney(m.getMoney() + money);
	}

    }

    private void decisionPayType(int type, MainView view) {

    }

    private boolean isSelected() {
	boolean result = false;

	int len = view.isClickTime.length;
	for (int i = 0; i < len; i++) {
	    if (view.isClickTime[i]) {
		result = true;
		view.payment.isPoint = false;
		break;
	    }
	}

	if (!result) {
	    len = view.isClickPoint.length;
	    for (int i = 0; i < len; i++) {
		if (view.isClickPoint[i]) {
		    result = true;
		    view.payment.isPoint = true;
		    break;
		}
	    }
	}

	return result;
    }

}
