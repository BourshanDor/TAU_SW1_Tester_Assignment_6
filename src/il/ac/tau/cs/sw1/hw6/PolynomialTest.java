package il.ac.tau.cs.sw1.hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void adds() {

        Polynomial f = new Polynomial(new double[] {0,4,5,0,0,0});
        Polynomial g = new Polynomial();
        Polynomial h = f.adds(g);


        Polynomial f1 = new Polynomial(new double[]{0,4,5,0,1,0});
        Polynomial g1 = new Polynomial(new double[]{0,0,0,0,0,0,0,1});
        Polynomial h1 = f1.adds(g1);

        Polynomial f2 = new Polynomial(new double[]{1,4,5,1,1,1});
        Polynomial g2 = new Polynomial(new double[]{0,0,0,1,0,0,0,0});
        Polynomial h2 = f2.adds(g2);

        Polynomial f3 = new Polynomial(new double[]{1,4,5,1,1,1});
        Polynomial g3 = new Polynomial(new double[]{});
        Polynomial h3 = f3.adds(g3);



        Assertions.assertAll("Check add:",
                () -> assertEquals(0,h.getCoefficient(0)),
                () -> assertEquals(4,h.getCoefficient(1)),
                () -> assertEquals(5,h.getCoefficient(2)),
                () -> assertEquals(0,h.getCoefficient(3)),
                () -> assertEquals(0,h.getCoefficient(4)),
                () -> assertEquals(0,h1.getCoefficient(0)),
                () -> assertEquals(4,h1.getCoefficient(1)),
                () -> assertEquals(5,h1.getCoefficient(2)),
                () -> assertEquals(0,h1.getCoefficient(3)),
                () -> assertEquals(1,h1.getCoefficient(4)),
                () -> assertEquals(1,h1.getCoefficient(7)),
                () -> assertEquals(1,h2.getCoefficient(0)),
                () -> assertEquals(4,h2.getCoefficient(1)),
                () -> assertEquals(5,h2.getCoefficient(2)),
                () -> assertEquals(2,h2.getCoefficient(3)),
                () -> assertEquals(1,h2.getCoefficient(5)),
                () -> assertEquals(0,h2.getCoefficient(7)),
                () -> assertEquals(1,h3.getCoefficient(5))
        );
    }

    @Test
    void multiply() {
        Polynomial f = new Polynomial(new double[] {0,4,5,0,0,0});
        Polynomial g = f.multiply(0);
        Polynomial h = f.multiply(1);
        Polynomial F = f.multiply(10);
        Polynomial G = f.multiply(0.5);
        Polynomial H = f.multiply(-1);

        Assertions.assertAll("Check multiply:",
                () -> assertEquals(0,g.getCoefficient(1)),
                () -> assertEquals(4,h.getCoefficient(1)),
                () -> assertEquals(40,F.getCoefficient(1)),
                () -> assertEquals(2.0,G.getCoefficient(1)),
                () -> assertEquals(-4,H.getCoefficient(1)),
                () -> assertEquals(0,g.getCoefficient(5)),
                () -> assertEquals(0,h.getCoefficient(5)),
                () -> assertEquals(0,F.getCoefficient(5)),
                () -> assertEquals(0,G.getCoefficient(5)),
                () -> assertEquals(0,H.getCoefficient(5))

        );


    }

    @Test
    void getDegree() {
        Polynomial f = new Polynomial(new double[] {0,4,5,0,0,0});
        Polynomial f1 = new Polynomial(new double[] {0,4,5,0,0,1});
        Polynomial f2 = new Polynomial(new double[] {0,0,0,0,0,0,0,0,0});
        Polynomial f3 = new Polynomial(new double[] {1,0,0,0,0,0});
        Polynomial f4 = new Polynomial(new double[] {0,4,5,0,5,0});
        Polynomial f5 = new Polynomial(new double[] {0,4,5,5,0,0});

        Assertions.assertAll("Check getDegree:",
                () -> assertEquals(2,f.getDegree()),
                () -> assertEquals(5,f1.getDegree()),
                () -> assertEquals(0,f2.getDegree()),
                () -> assertEquals(0,f3.getDegree()),
                () -> assertEquals(4,f4.getDegree()),
                () -> assertEquals(3,f5.getDegree())

        );


    }


    @Test
    void setCoefficient() {
        Polynomial f = new Polynomial(new double[] {0,4,5});
        f.setCoefficient(0,1);
        f.setCoefficient(1,1);
        f.setCoefficient(2,1);
        f.setCoefficient(3,1);
        f.setCoefficient(4,1);
        f.setCoefficient(5,1);

        Assertions.assertAll("Check setCoefficient:",
                () -> assertEquals(1,f.getCoefficient(0)),
                () -> assertEquals(1,f.getCoefficient(1)),
                () -> assertEquals(1,f.getCoefficient(2)),
                () -> assertEquals(1,f.getCoefficient(3)),
                () -> assertEquals(1,f.getCoefficient(4)),
                () -> assertEquals(1,f.getCoefficient(5)),
                () -> assertEquals(0,f.getCoefficient(6))

        );

    }



    @Test
    void getFirstDerivation() {
        Polynomial f = new Polynomial(new double[] {1,1,1,1,1,1,1});
        Polynomial f1 = new Polynomial(new double[] {1,0,1,0,1,0,1});
        Polynomial f2 = new Polynomial(new double[] {0,1,0,1,0,1,0});
        Polynomial f3 = new Polynomial(new double[] {1,1,0,0,1,1,0});
        Polynomial f4= new Polynomial(new double[] {1,0,1,1,0,1,1});
        Polynomial f5= new Polynomial(new double[] {1,2,3,4,5,6,7});

        Polynomial h = new Polynomial(new double[] {1,2,3,4,5,6});
        Polynomial h1 = new Polynomial(new double[] {0,2,0,4,0,6});
        Polynomial h2 = new Polynomial(new double[] {1,0,3,0,5});
        Polynomial h3 = new Polynomial(new double[] {1,0,0,4,5});
        Polynomial h4= new Polynomial(new double[] {0,2,3,0,5,6});
        Polynomial h5= new Polynomial(new double[] {2,6,12,20,30,42});

        Assertions.assertAll("Check getFirstDerivation:",
                () -> assertEquals(true,isEquals(f.getFirstDerivation(),h)),
                () -> assertEquals(true,isEquals(f1.getFirstDerivation(),h1)),
                () -> assertEquals(true,isEquals(f2.getFirstDerivation(),h2)),
                () -> assertEquals(true,isEquals(f3.getFirstDerivation(),h3)),
                () -> assertEquals(true,isEquals(f4.getFirstDerivation(),h4)),
                () -> assertEquals(true,isEquals(f5.getFirstDerivation(),h5))

        );

    }
    public static boolean isEquals(Polynomial f, Polynomial g){
        int gDegree = g.getDegree();
        int fDegree = f.getDegree();
        int max = Math.max(fDegree, gDegree);


        for (int i = 0; i <= max; i++){
            if(i <= gDegree && i <= fDegree) {
                if (g.getCoefficient(i) != f.getCoefficient(i))
                    return false;
                continue;
            }
            if (i > gDegree) {
                if (f.getCoefficient(i) != 0)
                    return false;
            }
            else{
                if (g.getCoefficient(i) != 0)
                    return false;
            }
        }
        return true;
    }


    @Test
    void computePolynomial() {
        Polynomial f = new Polynomial(new double[] {1,1,1,1,1,1,1});
        Polynomial f1 = new Polynomial(new double[] {2,0,1,0,1,0,2});
        Polynomial f2 = new Polynomial(new double[] {0,3,0,1,0,1,0});
        Polynomial f3 = new Polynomial(new double[] {1,1,0,0,2,1,0});
        Polynomial f4= new Polynomial(new double[] {1,0,1,1,0,1,2});
        Polynomial f5= new Polynomial(new double[] {1,1,1,1,1,1,2});

        Assertions.assertAll("Check setCoefficient:",
                () -> assertEquals(1,f.computePolynomial(0)),
                () -> assertEquals(7,f.computePolynomial(1)),
                () -> assertEquals(6,f1.computePolynomial(1)),
                () -> assertEquals(150,f1.computePolynomial(2)),
                () -> assertEquals(5,f2.computePolynomial(1)),
                () -> assertEquals(5,f3.computePolynomial(1)),
                () -> assertEquals(173,f4.computePolynomial(2)),
                () -> assertEquals(8,f5.computePolynomial(1)),
                () -> assertEquals(127,f.computePolynomial(2))

        );
    }

    @Test
    void isExtrema() {
        Polynomial f2 = new Polynomial(new double[] {0,0,1});
        Polynomial f3 = new Polynomial(new double[] {0,0,0,1});
        Polynomial f4 = new Polynomial(new double[] {0,0,0,0,1});
        Polynomial f5 = new Polynomial(new double[] {0,0,0,0,0,1});
        Polynomial h1 = new Polynomial(new double[] {0,0,1,1}); // true -0.667
        Polynomial h2 = new Polynomial(new double[] {0,0,0,1,1,0}); // -0.75

        Assertions.assertAll("Check setCoefficient:",
                () -> assertEquals(true,f2.isExtrema(0)),
                () -> assertEquals(false,f2.isExtrema(1)),
                () -> assertEquals(false,f3.isExtrema(0)),
                () -> assertEquals(false,f3.isExtrema(1))

        );

    }
}