package redrock.been;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import redrock.utils.Arr;
import redrock.utils.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reptile {
    public static String main(String stuNum) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(
                "http://jwzx.cqupt.edu.cn/jwzxtmp/kebiao/kb_stu.php?xh="+stuNum);
            CloseableHttpResponse response = client.execute(get);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "utf-8");

            String PageData = StringUtils.replaceBlank(content.toString());
            Pattern pattern = Pattern.compile("<tbody>(.*?)</tbody>");
            Matcher matcher = pattern.matcher(PageData);
            System.out.println(matcher.find());
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group());

            String AllCourse = matcher.group().toString();
            List<Course> allCourse = new ArrayList<Course>();

            Pattern patternSimple = Pattern.compile("<tr>(.*?)</tr>");
            Matcher matcherSimple = patternSimple.matcher(AllCourse);

            while (matcherSimple.find()) {
                String Course = matcherSimple.group().toString();
                Pattern patternSplit = Pattern.compile("<(.*?)>");

                Pattern patternTdNum = Pattern.compile("<td");
                Matcher matcherTdNum = patternTdNum.matcher(Course);
                int num = 0;
                while (matcherTdNum.find()) {
                    num++;
                }
                String[] str = patternSplit.split(Course);
                String[] courseinfo = Arr.Arr(str);
                if (num == 10) {
                    Course course = new Course(courseinfo);
                    allCourse.add(course);
                } else if (num == 3) {
                    redrock.been.Course course = new Course
                            ((redrock.been.Course) allCourse.get(allCourse.size() - 1), courseinfo);
                    allCourse.add(course);
                }
            }
            Gson gson = new Gson();
            String json = gson.toJson(allCourse);
            return json;
        }
        else {
            System.out.println("403");;
        }
        return null;
    }
}
