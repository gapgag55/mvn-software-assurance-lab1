import org.junit.*;
import static org.junit.Assert.*;

public class RationalTest {

    long numerator1[];
    long denominator1[];
    long numerator2[];
    long denominator2[];
    long numeratorResult[];
    long denominatorResult[];

    public RationalTest() {
        this.numerator1 = new long[]{ 1, 2, 3 };
        this.denominator1 = new long[]{ 4, 3, 2 };
        this.numerator2 = new long[]{ 1, 2, 3 };
        this.denominator2 = new long[]{ 4, 3, 2 };
        this.numeratorResult = new long[]{ 1, 2, 3 };
        this.denominatorResult = new long[]{ 4, 3, 2 };
    }

    @Test
    public void testRational() throws Exception {
        // Description: I would like to test all possible type of numerical
        // Characteristic: [negative, zero, positive];
        // Design Characteristic: Interface based
        // ISP Criteria: all combination.

        long numerators[] = { -1, 0, 1 };
        long denominators[] = { -1, 0, 1 };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                long numerator = numerators[i];
                long denominator = denominators[j];

                try {
                    Rational r1 = new Rational(numerator, denominator);
                    assertEquals(r1.numerator, numerator);
                    assertEquals(r1.denominator, denominator);
                } catch (Rational.Illegal e) {
                    assertNull(null);
                }
            }
        }
    }

    @Test
    public void testAdd() throws Exception {
        long numeratorResult[] = { 1, 4, 3 };
        long denominatorResult[] = { 2, 3, 1 };

        for (int i = 0; i < 3; i++){
            Rational r1 = new Rational(numerator1[i], denominator1[i]);
            Rational r2 = new Rational(numerator2[i], denominator2[i]);
            r1.add(r2);

            assertEquals(r1.numerator, numeratorResult[i]);
            assertEquals(r1.denominator, denominatorResult[i]);
        }
    }

    @Test
    public void testSubtract() throws Exception {
        long numeratorResult[] = { 0, 0, 0 };
        long denominatorResult[] = { 1, 1, 1 };

        for (int i = 0; i < 3; i++){
            Rational r1 = new Rational(numerator1[i], denominator1[i]);
            Rational r2 = new Rational(numerator2[i], denominator2[i]);
            r1.subtract(r2);

            assertEquals(r1.numerator, numeratorResult[i]);
            assertEquals(r1.denominator, denominatorResult[i]);
        }
    }

    @Test
    public void testMultiply() throws Exception {
        long numeratorResult[] = { 1, 4, 9 };
        long denominatorResult[] = { 16, 9, 4 };

        for (int i = 0; i < 3; i++){
            Rational r1 = new Rational(numerator1[i], denominator1[i]);
            Rational r2 = new Rational(numerator2[i], denominator2[i]);
            r1.multiply(r2);

            assertEquals(r1.numerator, numeratorResult[i]);
            assertEquals(r1.denominator, denominatorResult[i]);
        }
    }

    @Test
    public void testDivide() throws Exception {
        long numeratorResult[] = { 1, 1, 1 };
        long denominatorResult[] = { 1, 1, 1 };

        for (int i = 0; i < 3; i++){
            Rational r1 = new Rational(numerator1[i], denominator1[i]);
            Rational r2 = new Rational(numerator2[i], denominator2[i]);
            r1.divide(r2);

            assertEquals(r1.numerator, numeratorResult[i]);
            assertEquals(r1.denominator, denominatorResult[i]);
        }
    }

    @Test
    public void testEquals() throws Exception {
        Rational r1 = new Rational(1, 1);
        Rational r2 = new Rational(1, 1);
        Rational r3 = new Rational(2, 3);

        assertTrue(r1.equals(r2));
        assertFalse(r1.equals(r3));
    }

    @Test
    public void testCompareTo() throws Exception {
        Rational r1 = new Rational(1,2);
        Rational r2 = new Rational(3,6);
        assertEquals(r1.compareTo(r2),0);

        r1 = new Rational(3,2);
        r2 = new Rational(1,2);
        assertEquals(r1.compareTo(r2),1);

        r1 = new Rational(1,2);
        r2 = new Rational(3,2);
        assertEquals(r1.compareTo(r2),-1);
    }

    @Test
    public void testToString() throws Exception {
        Rational r1 = new Rational(1,2);
        assertEquals("1/2", r1.toString());
    }
}