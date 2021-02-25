import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static boolean onlyDigits(String str)
    {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
    //point 3 add functionality to consider \n as a delimiter
    public int add(String numbers){
        if(numbers != null && !numbers.isEmpty()){
            if(onlyDigits(numbers)){//if only numbers are present in the number string
                return Integer.parseInt(numbers);
            }
            else{
                String[] numArray = numbers.split("[,\n]");
                return Arrays.stream(numArray).mapToInt(Integer::parseInt).sum();
            }
        }
        return 0;
    }
}
