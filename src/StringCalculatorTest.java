import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator getInstance(){
        return new StringCalculator();
    }
    //test for empty string
    @Test
    public void addEmptyString() {
        StringCalculator s = getInstance();
        assertEquals(0,s.add(""));
    }
    //test for one Number
    @Test
    public void addOneNumber(){
        StringCalculator s = getInstance();
        assertEquals(100, s.add("100"));
    }
    //test for two Numbers
    @Test
    public void addTwoNumbers(){
        StringCalculator s = getInstance();
        assertEquals(100, s.add("60,40"));
    }
    //test for a random amount of numbers
    @Test
    public void addRandomAmountOfNumbers(){
        Random random = new Random();
        int randInt = random.nextInt(1000);
        String[] randomNumbers = new String[randInt];
        int sum = 0;
        for(int i = 0; i < randInt; i++){
            int rand = random.nextInt(20);
            randomNumbers[i] = ""+rand;
            sum += rand;
        }
        StringCalculator s = getInstance();
        String toBeTested = String.join(",", randomNumbers);
        assertEquals(sum,s.add(toBeTested));
    }
    @Test
    public void addHandleNewLinesBetweenNumbers(){//support for newLine character to seperate the numbers
        StringCalculator s = getInstance();
        assertEquals(6,s.add("1\n2,3"));
    }
    @Test
    public void addIntroduceNewDelimiter(){
        StringCalculator s = getInstance();
        assertEquals(10,s.add("//&\n2&3&5"));
    }
}