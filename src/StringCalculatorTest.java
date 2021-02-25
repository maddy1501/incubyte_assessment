import org.junit.jupiter.api.Test;

import java.util.Random;

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
    @Test
    public void addRandomAmountOfNumbers(){
        Random random = new Random();
        int randInt = random.nextInt(1000);
        String[] randomNumbers = new String[randInt];
        int sum = 0;
        for(int i = 0; i < randInt; i++){
            randomNumbers[i] = ""+i;
            sum += i;
        }
        StringCalculator s = getInstance();
        String toBeTested = String.join(",", randomNumbers);
        assertEquals(sum,s.add(toBeTested));

    }
}