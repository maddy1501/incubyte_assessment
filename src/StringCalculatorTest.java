import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator getInstance(){
        return new StringCalculator();
    }

    @Test
    public void addEmptyString() {
        StringCalculator s = getInstance();
        assertEquals(0,s.add(""));
    }
    @Test
    public void addOneNumber(){
        StringCalculator s = getInstance();
        assertEquals(100, s.add("100"));
    }
    @Test
    public void addTwoNumbers(){
        StringCalculator s = getInstance();
        assertEquals(100, s.add("60,40"));
    }
}