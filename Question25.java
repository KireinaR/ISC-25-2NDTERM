package Java.Class12;

// Class to store basic employee details
class Question25 {
    // Data Members
    protected String name; // Employee name
    protected String pan; // PAN number
    protected double basicPay; // Basic salary in decimal
    protected String accNo; // Bank account number

    // Parameterized constructor to assign values to data members
    public Question25(String name, String pan, double basicPay, String accNo) {
        this.name = name;
        this.pan = pan;
        this.basicPay = basicPay;
        this.accNo = accNo;
    }

    // Method to display employee details
    public void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("PAN: " + pan);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("Account Number: " + accNo);
    }
}

// Class to calculate retirement benefits
class Retire extends Question25 {
    // Data Members
    private int yrs; // Years of service
    private double pf; // Provident fund amount
    private double grat; // Gratuity amount

    // Constructor to initialize data members of both classes
    public Retire(String name, String pan, double basicPay, String accNo, int yrs) {
        super(name, pan, basicPay, accNo); // Call the parent class constructor
        this.yrs = yrs;
        this.pf = 0.0;
        this.grat = 0.0;
    }

    // Method to calculate Provident Fund as (2% of basic pay) * years of service
    public void provident() {
        pf = (0.02 * basicPay) * yrs;
    }

    // Method to calculate Gratuity: 12 months' salary if years of service >= 10,
    // else 0
    public void gratuity() {
        if (yrs >= 10) {
            grat = basicPay * 12; // 12 months' salary as gratuity
        } else {
            grat = 0.0; // No gratuity for less than 10 years of service
        }
    }

    // Method to display the employee details, PF, and gratuity amount
    public void display1() {
        // Display employee details using the method from Question25 class
        super.display();
        // Display PF and Gratuity details
        System.out.println("Years of Service: " + yrs);
        System.out.println("Provident Fund (PF): " + pf);
        System.out.println("Gratuity: " + grat);
    }
}
