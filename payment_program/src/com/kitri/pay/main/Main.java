package com.kitri.pay.main;

import java.awt.EventQueue;

import com.kitri.pay.network.Network;

public class Main {
    public static Network network;
    private static Thread thread;
    public static boolean isLog = true;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    network = new Network();
		    // thread = new Thread(network);
		    // thread.start();
		    // MainView frame = new MainView();
		    // frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public static void log(String str) {
	if (isLog) {
	    System.out.println(str);
	}
    }

    public static void log(int num) {
	if (isLog) {
	    System.out.println(num);
	}
    }
}
