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

	// 유효성 검사

	Main.network.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.ID_PW, id + "," + pw);

    }
}
