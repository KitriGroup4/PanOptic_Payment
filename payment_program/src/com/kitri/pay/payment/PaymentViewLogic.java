package com.kitri.pay.payment;

import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation;

public class PaymentViewLogic {
    PaymentView view;

    public PaymentViewLogic(PaymentView view) {
	this.view = view;
    }

    public void pay() {
	if (view.draw.points.size() > 0) {
	    if (view.isPoint) {
		Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.POINT,
			PacketInformation.PacketType.CARD + "," + view.index + "," + view.userNum);
	    } else {
		Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.TIME,
			PacketInformation.PacketType.CARD + "," + view.index + "," + view.userNum);
	    }
	}
    }

}
