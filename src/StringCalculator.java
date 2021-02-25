import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private boolean onlyDigits(String str)
    {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
    private boolean anotherDilimter(String numbers){
//        if first chars are '//' another delimiter is introduced
        return numbers.charAt(0) == '/' && numbers.charAt(1) == '/';
    }
    //point 4 Support different delimiters
    public int add(String numbers){
        if(numbers != null && !numbers.isEmpty()){
            if(onlyDigits(numbers)){//if only numbers are present in the number string
                return Integer.parseInt(numbers);
            }
            String[] numArray = numbers.split("[,\n]");
            if(anotherDilimter(numbers)){//if there is another delimiter introduced
                char delimiter = numbers.charAt(2);
                numbers = numbers.substring(4);
                String regexDelimiter = "[,\n"+delimiter+"]";
                numArray = numbers.split(regexDelimiter);
            }
            return Arrays.stream(numArray).mapToInt(Integer::parseInt).sum();
        }
        return 0;
    }
}
