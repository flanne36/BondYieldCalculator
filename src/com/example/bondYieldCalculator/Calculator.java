package com.example.bondYieldCalculator;
// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
        import javax.swing.*;
        import java.awt.*;

import static java.awt.SystemColor.text;

class text extends JFrame implements ActionListener {
    static JTextField coupon, years, face, rate;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l, labelCoupon, labelYears, labelFace, labelRate;

    // default constructor
    text()
    {
    }


    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("Bond Yield Calculator");

        // create a label to display text
        l = new JLabel("nothing entered");
        labelCoupon = new JLabel("Enter Coupon:");
        labelYears = new JLabel("Enter Years:");
        labelFace = new JLabel("Enter Face:");
        labelRate = new JLabel("Enter Rate:");

        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        text te = new text();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns and a given initial text
        coupon = new JTextField("0.00", 8);
        years = new JTextField("0", 8);
        face = new JTextField("0.00", 8);
        rate = new JTextField("0.00", 8);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(labelCoupon);
        p.add(coupon);
        p.add(labelYears);
        p.add(years);
        p.add(labelFace);
        p.add(face);
        p.add(labelRate);
        p.add(rate);
        p.add(b);
        p.add(l);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(220, 300);

        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        double coup, fac, rat, price;
        int yea;
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            coup = Double.parseDouble(coupon.getText());
            yea = Integer.parseInt(years.getText());
            fac = Double.parseDouble(face.getText());
            rat = Double.parseDouble(rate.getText());
            price = calcPrice(coup, yea, fac, rat);

            l.setText(String.format("%.7f",price));
        }
    }

    public static double calcPrice(double coupon, int years, double face, double rate){
        double price = 0;
        for(int i = 0; i < years; i++){
            price += (face * coupon) / Math.pow((1+rate), i+1);
        }
        price += face / Math.pow((1+rate), years);
        return price;
    }
}
