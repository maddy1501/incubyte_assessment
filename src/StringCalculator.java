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
        return numbers.charAt(0) == '/' && numbers.charAt(1) == '/';
    }
    //point 4 Support different delimiters
    public int add(String numbers) throws Exception {
        addCallCount += 1;
        if(numbers != null && !numbers.isEmpty()){
            if(onlyDigits(numbers)){//if only numbers are present in the number string
                return Integer.parseInt(numbers);
            }
            String[] numArray = numbers.split("[,\n]");
            if(anotherDelimiter(numbers)){//if there is another delimiter introduced
                char delimiter = numbers.charAt(2);
                numbers = numbers.substring(4);
                String regexDelimiter = "[,\n"+delimiter+"]";
                numArray = numbers.split(regexDelimiter);
            }
            int sum = 0;
            boolean ifNegative = false;
            StringBuilder negatives = new StringBuilder();
            for(String number : numArray){
                int num = Integer.parseInt(number);
                if( num < 0 ){
                    negatives.append(" ").append(number);
                    ifNegative = true;
                }
                else if(num <= 1000) sum += num;
            }
            if(ifNegative){
                throw new Exception("negatives not allowed" + negatives.toString());
            }
            return sum;
        }
        return 0;
    }
    public int getCallCount() { return addCallCount; }
}
