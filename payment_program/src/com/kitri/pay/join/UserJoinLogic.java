package com.kitri.pay.join;

import com.kitri.pay.dto.UserInfoDto;
import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation;

public class UserJoinLogic {
    UserJoin join;

    public UserJoinLogic(UserJoin join) {
	this.join = join;
    }

    public void checkId(String id) {
	if (!id.isEmpty() && !id.equals("")) {
	    Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID, id);
	}
    }

    public void joinUser(UserJoin join) {

	if (join.checkId) {
	    UserInfoDto dto = new UserInfoDto();
	    String name = join.joinName.getText().trim();
	    String id = join.joinId.getText().trim();
	    String pw = join.joinPw.getText().trim();
	    String pwCheck = join.joinPwCheck.getText().trim();
	    String hp = join.joinHpTf.getText().trim();
	    String email = join.joinEmailTf.getText().trim();
	    String birth = join.yy.getSelectedItem() + "-" + join.mm.getSelectedItem() + "-"
		    + join.dd.getSelectedItem();
	    String isMale = join.isMale ? "1" : "0";
	    Main.log(birth);
	    
	    // 유효성검사를 성공하면

	    if (checkField(pw, pwCheck, email, hp)) {
		dto.setUserName(name);
		dto.setUserId(id);
		dto.setUserPw(pw);
		dto.setUserHp(hp);
		dto.setUserEmail(email);
		dto.setUserBirth(birth);
		dto.setIsMale(isMale);
		Main.log(dto.toString());
		Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.USER_INFO,
			dto.toString());
	    }

	} else {
	    join.checkIdCheckDialog();
	}
    }

    private boolean checkField(String pw, String pwCheck, String email, String hp) {
	int len = pw.length();
	if (len < 8) {
	    join.pwTooShort();
	    return false;
	}
	if (!pw.equals(pwCheck)) {
	    join.pwCheckError();
	    return false;
	}
	if (!email.contains("@") || !email.contains(".") || email.startsWith("@") || email.startsWith(".")) {
	    join.emailInputError();
	    return false;
	}
	len = hp.length();
	boolean isHp = true;
	for (int i = 0; i < len; i++) {
	    if (hp.charAt(i) < '0' || hp.charAt(i) > '9') {
		isHp = false;
		break;
	    }
	}
	if (len != 11 || !hp.startsWith("010") || !isHp) {
	    join.hpInputError();
	    return false;
	}

	return true;
    }

}
