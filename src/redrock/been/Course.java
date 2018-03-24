package redrock.been;

import lombok.Data;
import redrock.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Data
public class Course implements Comparable {

    private String number;
    private String lesson;
    private String type;
    private String day;
    private String course;
    private String classroom;
    private String rankWeek;
    private int weekBegin;
    private int weekEnd;
    private String teacher;


    private ArrayList<Integer> week = new ArrayList<Integer>();

    public Course(Course courseBefore,String[] courseInfo){
        int[] time = TimeUtils.timeUtils(courseInfo[1]);
        this.course = courseBefore.course;
        this.number = courseBefore.number;
        this.type = courseBefore.type;
        this.teacher = courseInfo[0];
        this.weekBegin = time[3];
        this.weekEnd = time[4];
        this.rankWeek = courseInfo[1].substring(8);
        this.day = "星期"+time[0];
        this.lesson = time[1]+"-"+time[2]+"节";
        this.classroom = courseInfo[2];
    }

    public Course(String[] courseInfo){
        int[] time = TimeUtils.timeUtils(courseInfo[6]);
        this.course = courseInfo[1].substring(9);
        this.number = courseInfo[0];
        this.teacher = courseInfo[5];
        this.type = courseInfo[2];
        this.rankWeek = courseInfo[6].substring(8);
        this.weekBegin = time[3];
        this.weekEnd = time[4];
        this.day = "星期"+ time[0];
        this.classroom = courseInfo[7];
        this.lesson = time[1]+"-"+time[2]+"节";
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(String key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
