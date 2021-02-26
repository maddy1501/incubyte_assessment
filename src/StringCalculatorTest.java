import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator getInstance(){
        return new StringCalculator();
    }
    //test for empty string
    @Test
    public void addEmptyString() throws Exception {
        StringCalculator s = getInstance();
        assertEquals(0,s.add(""));
    }
    //test for one Number
    @Test
    public void addOneNumber() throws Exception {
        StringCalculator s = getInstance();
        assertEquals(100, s.add("100"));
    }
    //test for two Numbers
    @Test
    public void addTwoNumbers() throws Exception {
        StringCalculator s = getInstance();
        assertEquals(100, s.add("60,40"));
    }
    //test for a random amount of numbers
    @Test
    public void addRandomAmountOfNumbers() throws Exception {
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
    public void addHandleNewLinesBetweenNumbers() throws Exception {//support for newLine character to seperate the numbers
        StringCalculator s = getInstance();
        assertEquals(6,s.add("1\n2,3"));
    }
    @Test
    public void addIntroduceNewDelimiter() throws Exception {
        StringCalculator s = getInstance();
        assertEquals(10,s.add("//&\n2&3&5"));
    }
    @Test
    public void addNegativeNumberException(){
        Throwable exception = assertThrows(Exception.class, this::execute);
        assertEquals("negatives not allowed -9", exception.getMessage());
    }

    private void execute() throws Exception{
        StringCalculator s = getInstance();
        s.add("2,5,8,-9");
    }
}