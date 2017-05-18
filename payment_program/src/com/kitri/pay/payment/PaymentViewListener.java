package com.kitri.pay.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentViewListener implements ActionListener {
    PaymentView view;
    PaymentViewLogic logic;

    public PaymentViewListener(PaymentView view) {
	this.view = view;
	logic = new PaymentViewLogic(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	
	if(o == view.payButton){
	    logic.pay();
	} else if(o == view.closeButton){
	    view.setVisible(false);
	}
	
    }

}
