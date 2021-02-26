import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int addCallCount = 0;

    private boolean onlyDigits(String str)
    {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private boolean anotherDelimiter(String numbers){
//        if first chars are '//' another delimiter is introduced
        return numbers.startsWith("//");
    }

    private String[] getNumArrayWithDifferentDelimiters(String numbers){

        int newLineIndex = numbers.indexOf("\n");//String before newLine Character is where delimiter info is

        String delimiterString = numbers.substring(0,newLineIndex);//get the delimiter string

        numbers = numbers.substring(newLineIndex + 1);//separate the numbers and delimiter info

        if(delimiterString.length() == 3){//means single delimiter is passed
            char delimiter = delimiterString.charAt(2);//delimiter is at index 2
            String splitRegex = "[\n"+delimiter+"]";
            return numbers.split(splitRegex);
        }
        //Means multivariable or multiple delimiters are passed
        StringBuilder splitRegex = new StringBuilder("\n");
        Pattern p = Pattern.compile("\\[(.*?)]");//pattern to get string between [].
        Matcher m = p.matcher(delimiterString);

        //create regex for matching variable length or multiple delimiter
        while(m.find()) {
            splitRegex.append("|").append(Pattern.quote(m.group(1)));//meta characters need to be escaped.
        }

        return numbers.split(splitRegex.toString());
    }

    public int add(String numbers) throws Exception {
        addCallCount += 1;
        if(numbers != null && !numbers.isEmpty()){

            if(onlyDigits(numbers)){//if only one number is present in the string
                return Integer.parseInt(numbers);
            }

            String[] numArray = numbers.split("[,\n]");//split using default delimiters

            if(anotherDelimiter(numbers)){//if there is another delimiter introduced
                //update the numArray according to the delimiter given
                numArray = getNumArrayWithDifferentDelimiters(numbers);
            }

            int sum = 0;
            boolean ifNegative = false;
            StringBuilder negatives = new StringBuilder();
            //iterate numArray; parse every element to integer; if number < 0 append
            //into the negative number array
            //if number is greater than 1000 ignore it in the sum
            for(String number : numArray){
                int num = Integer.parseInt(number);
                if( num < 0 ){
                    negatives.append(" ").append(number);
                    ifNegative = true;
                }
                else if(num <= 1000) sum += num;
            }

            if(ifNegative){ //if Negative numbers are present throw exception
                throw new Exception("negatives not allowed" + negatives.toString());
            }
            return sum;
        }
        return 0;
    }
    public int getCallCount() { return addCallCount; }
}
