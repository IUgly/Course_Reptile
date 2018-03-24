package redrock.Servlet;

import net.sf.json.JSONObject;
import redrock.been.Reptile;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "course",urlPatterns = "/course")
public class CourseServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String stuNum = request.getParameter("stuNum");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json; charset=utf-8");

        JSONObject resp = new JSONObject();

        if (stuNum==null||stuNum.isEmpty()){
              resp.put("errorcode",1);
              resp.put("desc","invalid parameter");
        }
        else {

        resp.put("status",200);
        resp.put("version","7.7.7");
        resp.put("term","2017-2018学年第2学期");
        resp.put("stuNum",stuNum);
//        resp.put("data", Reptile.main(stuNum));

        response.getOutputStream().write(resp.toString().getBytes());
        response.getOutputStream().flush();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            response.getOutputStream(), "UTF-8"
                    )
            );
//            writer.write(String.valueOf(resp));
            writer.write(String.valueOf(resp));
            writer.write(Reptile.main(stuNum));
            writer.flush();
            writer.close();
        }
    }
}
