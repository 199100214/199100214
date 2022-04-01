

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入测试的类型");
        String data = "{\"str1\":\"alert\",\"str2\":\"alert22\"}";
        response.setContentType("text/html;charset=utf-8");
//        try {
//            Thread.sleep(3000);//线程睡眠
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        PrintWriter out = response.getWriter();
        out.print(data);
        out.close();//关闭数据流
//        response.getWriter().print("这下也可以 服务器会资助的帮你关闭");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
