import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private static int addCallCount = 0;

    private int executeAdd(String numbers) throws Exception{
        addCallCount += 1;
        StringCalculator s = new StringCalculator();
        return s.add(numbers);
    }
    //test for empty string
    @Test
    public void addEmptyString() throws Exception {
        assertEquals(0,executeAdd(""));
    }
    //test for one Number
    @Test
    public void addOneNumber() throws Exception {
        assertEquals(100, executeAdd("100"));
    }
    //test for two Numbers
    @Test
    public void addTwoNumbers() throws Exception {
        assertEquals(100, executeAdd("60,40"));
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
        String toBeTested = String.join(",", randomNumbers);
        assertEquals(sum,executeAdd(toBeTested));
    }
    @Test
    public void addHandleNewLinesBetweenNumbers() throws Exception {//support for newLine character to seperate the numbers
        assertEquals(6,executeAdd("1\n2,3"));
    }
    @Test
    public void addIntroduceNewDelimiter() throws Exception {
        assertEquals(10,executeAdd("//&\n2&3&5"));
    }

    @Test
    public void addMultipleNegativeNumberException(){
        Throwable exception = assertThrows(Exception.class, () -> executeAdd("2,5,8,-9,-15,18"));
        assertEquals("negatives not allowed -9 -15", exception.getMessage());
    }
    @Test
    public void getCalledCountTest(){
        StringCalculator s = new StringCalculator();
        assertEquals(addCallCount, s.getCallCount());
    }
    @Test
    public void addNumberBiggerThan1000ShouldBeIgnored() throws Exception{
        assertEquals(15+25+20+9,executeAdd("15,25,2000,1001,20,9"));
    }
}