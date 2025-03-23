import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 此处约定,请求中给定的 query string 是形如: username=zhangsan&password=123
        // 上述query sting就会被tomcat给自动解析成一个Map这样的结构
        // getParameter 就是在查询map<String,String>里的内容
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 拿到这俩内容之后就可以拿来处理了
        System.out.println("username="+username);
        System.out.println("password="+password);

        resp.getWriter().write("ok" );
    }
}
