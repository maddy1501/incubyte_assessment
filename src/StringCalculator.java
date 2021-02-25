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
    public int add(String numbers){
        if(numbers != null && !numbers.isEmpty()){
            if(onlyDigits(numbers)){//if only numbers are present in the number string
                return Integer.parseInt(numbers);
            }
            else{
                String[] numArray = numbers.split(",");
                int num1 = Integer.parseInt(numArray[0]);
                int num2 = Integer.parseInt(numArray[1]);
                return num1 + num2;
            }
        }
        return 0;
    }
}
