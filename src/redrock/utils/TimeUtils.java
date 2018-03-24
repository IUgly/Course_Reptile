package redrock.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtils {

    public static int[] timeUtils (String timeinfo){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(timeinfo);
        int[] time = new int[10];
        int i = 0;
        while (matcher.find()) {
            time[i] = Integer.parseInt(matcher.group());
            i++;
        }
        return time;
    }
    public static void main(String[] args) {
        String a = "星期5 第5-6节1-6周,8-16周";
        int[] b = timeUtils(a);
        System.out.println(b);
    }
}
