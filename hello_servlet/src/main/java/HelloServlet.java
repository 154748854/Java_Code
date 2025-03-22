import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
// 这是路径
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这个是打印在tomcat控制台上的(服务器端
        System.out.println("hello world");
        // 把这个内容显示到页面上,把hello world字符串作为响应的body部分
        // 显示到客户端浏览器页面上
        resp.getWriter().write("hello world");
    }
}
