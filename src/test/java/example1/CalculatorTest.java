package example1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.UndefinedException;

class CalculatorTest {
    private Calculator calc;
    private Calculator calc2;

    @BeforeEach
    private void setUp() {
        calc = new Calculator();
        calc2 = new Calculator(5, 6);
    }

    @Test
    void add() {
        assertEquals(9, calc.add(4, 5));
        Calculator calc = new Calculator(5,6);
    }

    @Test
    void addPositive() {
        try{
            assertEquals(11, calc2.add());}
        catch(UndefinedException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void addNegative() {
        try{
            calc.add();
            assert(false);
        }
        catch(UndefinedException e){
            assert(true);
        }
    }

    @Test
    void addNegativeNew() {
        assertThrows(UndefinedException.class, () -> {
            calc.add();
        });
    }
}