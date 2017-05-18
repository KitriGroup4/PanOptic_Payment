package com.kitri.pay.dto;

import java.util.StringTokenizer;
public class UserInfoDto {
    private int userNum;
    private String userName;
    private String userId;
    private String userPw;
    private String userHp;
    private String userEmail;
    private String userAccuTime;
    private String userLeftTime;
    private String userJoinDate;
    private String userBirth;
    private String isMale;
    
    public UserInfoDto() {
	userNum = -1;
	userId = "-1";
	userName = "-1";
	userPw = "-1";
	userHp = "-1";
	userEmail = "-1";
	userAccuTime = "-1";
	userLeftTime = "-1";
	userJoinDate = "-1";
	userBirth = "-1";
	isMale = "-1";	
    }

    public int getUserNum() {
	return userNum;
    }

    public void setUserNum(int userNum) {
	this.userNum = userNum;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getUserPw() {
	return userPw;
    }

    public void setUserPw(String userPw) {
	this.userPw = userPw;
    }

    public String getUserHp() {
	return userHp;
    }

    public void setUserHp(String userHp) {
	this.userHp = userHp;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
    }

    public String getUserAccuTime() {
	return userAccuTime;
    }

    public void setUserAccuTime(String userAccuTime) {
	this.userAccuTime = userAccuTime;
    }

    public String getUserLeftTime() {
	return userLeftTime;
    }

    public void setUserLeftTime(String userLeftTime) {
	this.userLeftTime = userLeftTime;
    }

    public String getUserJoinDate() {
	return userJoinDate;
    }

    public void setUserJoinDate(String userJoinDate) {
	this.userJoinDate = userJoinDate;
    }

    public String getUserBirth() {
	return userBirth;
    }

    public void setUserBirth(String userBirth) {
	this.userBirth = userBirth;
    }

    public String getIsMale() {
	return isMale;
    }

    public void setIsMale(String isMale) {
	this.isMale = isMale;
    }

    public void setFieldToInsert(String data) {
	StringTokenizer fieldToken = new StringTokenizer(data, ",");
	System.out.println(data);
	int i = 1;
	String temp;
	while (fieldToken.hasMoreTokens()) {
	    temp = fieldToken.nextToken();
	    System.out.println(temp);
	    switch (i++) {
	    case 1:
		userName = temp;
		break;
	    case 2:
		userId = temp;
		break;
	    case 3:
		userPw = temp;
		break;
	    case 4:
		userHp = temp;
		break;
	    case 5:
		userEmail = temp;
		break;
	    case 6:
		userBirth = temp;
	    case 7:
		isMale = temp;
		break;
	    default:
	    }
	}
    }

    public void setField(String data) {
	StringTokenizer fieldToken = new StringTokenizer(data, ",");

	int i = 0;
	String temp;
	while (fieldToken.hasMoreTokens()) {
	    temp = fieldToken.nextToken();
	    switch (i++) {
	    case 0:
		userNum = Integer.parseInt(temp);
	    case 1:
		userName = temp;
		break;
	    case 2:
		userId = temp;
		break;
	    case 3:
		userPw = temp;
		break;
	    case 4:
		userHp = temp;
		break;
	    case 5:
		userEmail = temp;
		break;
	    case 6:
		userAccuTime = temp;
		break;
	    case 7:
		userLeftTime = temp;
		break;
	    case 8:
		userJoinDate = temp;
		break;
	    case 9:
		userBirth = temp;
	    case 10:
		isMale = temp;
		break;
	    default:
	    }
	}
    }
    public String joinToString() {
	return userName + "," + userId +"," + userPw + "," + userHp + "," + userEmail + "," + userBirth + "," + isMale;
    }

    @Override
    public String toString() {
	return userNum + "," + userName + "," + userId + "," + userPw + "," + userHp + "," + userEmail + "," + userAccuTime + "," + userLeftTime + ","
		+ userJoinDate + "," + userBirth + "," + isMale;
    }

}
