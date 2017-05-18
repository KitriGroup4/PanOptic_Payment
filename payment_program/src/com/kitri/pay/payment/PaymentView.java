package com.kitri.pay.payment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class PaymentView extends JInternalFrame {

    private JPanel contentPane;
    private JPanel upPanel;
    private JPanel bottomPanel;
    public JButton payButton;
    public JButton closeButton;
    private JLabel upLabel;
    public DrawPanel draw;
    
    private PaymentViewListener listener;
    public boolean isPoint;
    public int price;
    public int index;
    public int userNum;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    PaymentView frame = new PaymentView();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public PaymentView() {
	
	this.isPoint = isPoint;
	this.price = price;
	
	listener = new PaymentViewListener(this);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));

	upPanel = new JPanel();
	contentPane.add(upPanel, BorderLayout.NORTH);

	upLabel = new JLabel("\uC11C\uBA85");
	upLabel.setFont(new Font("±¼¸²", Font.BOLD, 38));
	upPanel.add(upLabel);

	draw = new DrawPanel();
	draw.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.add(draw, BorderLayout.CENTER);

	bottomPanel = new JPanel();
	contentPane.add(bottomPanel, BorderLayout.SOUTH);

	payButton = new JButton("\uACB0\uC81C");
	payButton.setFont(new Font("±¼¸²", Font.BOLD, 26));
	bottomPanel.add(payButton);
	
	closeButton = new JButton("\uB2EB\uAE30");
	closeButton.setFont(new Font("±¼¸²", Font.BOLD, 26));
	bottomPanel.add(closeButton);
	
	payButton.addActionListener(listener);
	closeButton.addActionListener(listener);
    }

    class DrawPanel extends JPanel {

	Vector<Point> points = new Vector<>();

	public DrawPanel() {
	    addMouseMotionListener(new MouseMotionListener() {
		@Override
		public void mouseMoved(MouseEvent e) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {
		    // TODO Auto-generated method stub
		    points.add(e.getPoint());

		    repaint();
		}
	    });

	    addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
		    super.mousePressed(e);
//		    points = new Vector<>();
		    System.out.println("press");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		    super.mouseReleased(e);
		    System.out.println("released");
		}
	    });
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    
	    Point p;
	    int size = points.size();
	    for (int i = 0; i < size; i++) {
		p = points.elementAt(i);
		g.drawLine((int)p.getX(), (int)p.getY(), (int)p.getX() + 1, (int)p.getY() + 1);
	    }

	}
    }
    
    public void resetPoints(){
	draw.points = new Vector<>();
    }

}
