class Rational {
    long numerator, denominator;

    class Illegal extends Exception {
        String reason;

        Illegal(String reason) {
            this.reason = reason;
        }
    }

    Rational() {
        // to be completed
        this.numerator = 1;
        this.denominator = 1;
    }

    Rational(long numerator, long denominator) throws Illegal {
        // to be completed
        if (denominator == 0) {
            throw new Illegal("Denominator cannot be zero");
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    // find the reduce form
    private void simplestForm() {
        long computeGCD;
        computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // find the greatest common denominator
    private long GCD(long a, long b) {
        if (a % b == 0)
            return b;
        else
            return GCD(b, a % b);
    }

    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    public void subtract(Rational x) {
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    public void multiply(Rational x) {
        numerator = (numerator * x.numerator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    public void divide(Rational x) throws Illegal {
        if(x.numerator == 0) {
            throw new Illegal("Numerator of x cannot be zero");
        } else {
            numerator = numerator * x.denominator;
            denominator = denominator * x.numerator;
            simplestForm();
        }
    }

    public boolean equals(Object x) {
        Rational r2 = (Rational) x;
        simplestForm();
        r2.simplestForm();
        return this.numerator == r2.numerator && this.denominator == r2.denominator;
    }

    public long compareTo(Object x) {
       Rational r2 = (Rational) x;
       simplestForm();
       r2.simplestForm();

       if (numerator > r2.numerator)  {
           return 1;
       } else if (numerator < r2.numerator) {
           return -1;
       }

       return 0;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}