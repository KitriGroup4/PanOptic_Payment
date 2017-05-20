package com.kitri.pay.login;

import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation;

public class UserLoginLogic {
    UserLogin login;

    public UserLoginLogic(UserLogin login) {
	this.login = login;
    }

    public void login() {
	String id = login.loginIdTf.getText().trim();
	String pw = login.loginPwTf.getText().trim();

	if (id.isEmpty() || pw.isEmpty()) {
	    login.fieldEmpty();
	} else {
	    Main.network.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.ID_PW,
		    id + "," + pw);

	}

	Main.network.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.ID_PW, id + "," + pw);

    }
}
