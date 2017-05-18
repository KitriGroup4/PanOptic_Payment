package com.kitri.pay.network;

/*
 * programvalue/operator/packettype/value
 */
public class PacketInformation {

    public static byte PACKET_SIZE = 4;
    public static byte IDLE = -99;

    public static class ProgramValue {
	public static final byte ADMIN = 0;
	public static final byte USER = 1;
	public static final byte PAYMENT = 2;
    }

    public static class PacketStructrue {
	public static final byte PROGRAM_VALUE = 0;
	public static final byte OPERATOR = 1;
	public static final byte PACKET_TYPE = 2;
	public static final byte DATA = 3;
    }

    public static class Operation {
	public static final byte GET = 0;
	public static final byte RESPONSE = 1;
	public static final byte COUNT = 2;
	public static final byte LOGIN = 3;
	public static final byte JOIN = 4;
	public static final byte BUY = 5;
    }

    public static class PacketType {
	public static final byte POINT_INFO = 0;
	public static final byte COM_PREPAID_INFO = 1;
	public static final byte USER_INFO = 2;
	public static final byte CHECK_USER_ID = 3;
	public static final byte IS_OK = 4;
	public static final byte IS_FAIL = 5;
	public static final byte ID_PW = 6;
	public static final byte POINT = 7;
	public static final byte TIME = 8;
	public static final byte CARD = 9;
    }

    public static class ComPrepaidInfo {
	public static final byte NUM = 0;
	public static final byte TIME = 1;
	public static final byte PRICE = 2;
    }

}
