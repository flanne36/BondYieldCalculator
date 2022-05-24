package com.example.bondYieldCalculator;
// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
        import javax.swing.*;
        import java.awt.*;

import static java.awt.SystemColor.text;

class text extends JFrame implements ActionListener {

    static final double EPSILON = 0.00001;
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
//    public static void main(String[] args)
//    {
//        // create a new frame to store text field and button
//        f = new JFrame("Bond Yield Calculator");
//
//        // create a label to display text
//        l = new JLabel("nothing entered");
//        labelCoupon = new JLabel("Enter Coupon:");
//        labelYears = new JLabel("Enter Years:");
//        labelFace = new JLabel("Enter Face:");
//        labelRate = new JLabel("Enter Rate:");
//
//        // create a new button
//        b = new JButton("submit");
//
//        // create a object of the text class
//        text te = new text();
//
//        // addActionListener to button
//        b.addActionListener(te);
//
//        // create a object of JTextField with 16 columns and a given initial text
//        coupon = new JTextField("0.00", 8);
//        years = new JTextField("0", 8);
//        face = new JTextField("0.00", 8);
//        rate = new JTextField("0.00", 8);
//
//        // create a panel to add buttons and textfield
//        JPanel p = new JPanel();
//
//        // add buttons and textfield to panel
//        p.add(labelCoupon);
//        p.add(coupon);
//        p.add(labelYears);
//        p.add(years);
//        p.add(labelFace);
//        p.add(face);
//        p.add(labelRate);
//        p.add(rate);
//        p.add(b);
//        p.add(l);
//
//        // add panel to frame
//        f.add(p);
//
//        // set the size of frame
//        f.setSize(220, 300);
//
//        f.show();
//    }

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
    // An example function whose solution
    // is determined using Bisection Method.
    // The function is x^3 - x^2 + 2
    static double func(double x, double coupon,int years, double f, double p)
    {
        double c = coupon*f;
        if(years < 3){
            double ans = p*x + (p-(f+c));
            for(int i = 1; i < years; i++){
                ans += p*(Math.pow(x,i+1));
            }
            return ans;
        }
        switch (years){
            case 1:
                return p*x + (p-(f+c));
            case 2:
                return p*x*x + x*(2*p-c) + (p-(2*c+f));
            case 3:
                return p*x*x*x + x*x*(3*p-c) + x*(3*p-3*c) + (p-(3*c+f));
            case 4:
                return p*x*x*x*x + x*x*x*(4*p-c) + x*x*(6*p-4*c) + x*(4*p-6*c) + (p-(4*c+f));
            case 5:
                return p*x*x*x*x*x + x*x*x*x*(5*p-c) + x*x*x*(10*p-5*c) + x*x*(10*p-10*c) + x*(5*p-10*c) + (p-(5*c+f));
            case 6:
                return p*x*x*x*x*x*x + x*x*x*x*x*(6*p-c) + x*x*x*x*(15*p-6*c) + x*x*x*(20*p-15*c) + x*x*(15*p-20*c) + x*(6*p-15*c) + (p-(6*c+f));
            case 7:
                return p*x*x*x*x*x*x*x + x*x*x*x*x*x*(7*p-c) + x*x*x*x*x*(21*p-7*c) + x*x*x*x*(35*p-21*c) + x*x*x*(35*p-35*c) + x*x*(21*p-35*c) + x*(7*p-21*c) + (p-(7*c+f));
            default:
                return 1;
        }
        //return -918.714*x*x-1737.428*x+281.286;
    }

    // Derivative of the above function
    // which is 3*x^x - 2*x
    static double derivFunc(double x, double coupon,int years, double f, double p)
    {
        double c = coupon*f;
        switch (years){
            case 1:
                return p;
            case 2:
                return 2*p*x + (2*p-c);
            case 3:
                return 3*p*x*x + x*2*(3*p-c) + (3*p-3*c);
            case 4:
                return 4*p*x*x*x + 3*x*x*(4*p-c)+ 2*x*(6*p-4*c) + (4*p-6*c);
            case 5:
                return 5*p*x*x*x*x + 4*x*x*x*(5*p-c)+ 3*x*x*(10*p-5*c) + 2*x*(10*p-10*c) + (5*p-10*c);
            case 6:
                return 6*p*x*x*x*x*x + 5*x*x*x*x*(6*p-c) + 4*x*x*x*(15*p-6*c) + 3*x*x*(20*p-15*c) + 2*x*(15*p-20*c) + (6*p-15*c);
            case 7:
                return 7*p*x*x*x*x*x*x + 6*x*x*x*x*x*(7*p-c) + 5*x*x*x*x*(21*p-7*c) + 4*x*x*x*(35*p-21*c) + 3*x*x*(35*p-35*c) + 2*x*(21*p-35*c) + (7*p-21*c);
            default:
                return 1;
        }
    }

    public static double calcYield(double coupon,int years, double face, double price){
        double x = .000001;

        double h = func(x, coupon, years, face, price) / derivFunc(x, coupon, years, face, price);
        while (Math.abs(h) >= EPSILON)
        {
            h = func(x, coupon, years, face, price) / derivFunc(x, coupon, years, face, price);

            // x(i+1) = x(i) - f(x) / f'(x)
            x = x - h;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(String.format("%.7f",calcPrice(.10,1,1000,.13896)));
        System.out.println(String.format("%.7f",calcYield(0.10, 1, 1000, 965.79)));
    }


}
