package com.kitri.pay.dto;

import java.util.StringTokenizer;

public class PointInfoDto {
    private int num;
    private int value;
    private int price;

    public int getNum() {
	return num;
    }

    public void setNum(int num) {
	this.num = num;
    }

    public int getValue() {
	return value;
    }

    public void setValue(int value) {
	this.value = value;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }
    
    public void setField(String data) {
	StringTokenizer fieldToken = new StringTokenizer(data, ",");
	
	int i = 0;
	String temp;
	while(fieldToken.hasMoreTokens()){
	    temp = fieldToken.nextToken();
	    switch(i++){
	    case 0:
		num = Integer.parseInt(temp);
		break;
	    case 1:
		value = Integer.parseInt(temp);
		break;
	    case 2:
		price = Integer.parseInt(temp);
		break;
		default:
	    }
	}
    }
    
    @Override
    public String toString() {
        return num + "," + value + "," + price;
    }

}
