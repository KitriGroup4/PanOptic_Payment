package com.kitri.pay.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginListener implements ActionListener {

    UserLogin login;
    UserLoginLogic logic;

    public UserLoginListener(UserLogin login) {
	this.login = login;
	logic = new UserLoginLogic(login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	if (o == login.closeButton) {
	    login.setVisible(false);
	} else if (o == login.loginBtn) {
	    logic.login();
	}
    }

}
