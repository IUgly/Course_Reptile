package redrock.utils;

public class Arr {
    public static String[] Arr(String[] aa) {

        //用StringBuffer来存放数组中的非空元素，用“;”分隔
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<aa.length; i++) {
            if("".equals(aa[i])) {
                continue;
            }
            sb.append(aa[i]);
            if(i != aa.length - 1) {
                sb.append(";");
            }
        }
        //用String的split方法分割，得到数组
        aa = sb.toString().split(";");

        //打印数组
        for(int i=0; i<aa.length; i++) {
            System.out.print(aa[i] + " ");
        }
        System.out.println();
        return aa;
    }
}
