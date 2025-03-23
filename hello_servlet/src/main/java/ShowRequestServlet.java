import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/show")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // 调用上述API,把得到的结果构造成一个字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());

        // 获取所有的header
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            stringBuilder.append(key + ":" + value + "<br>");
        }

        // 把上述内容整体返回到客户端
        // 告诉浏览器咱们数据是啥类型,这是我们任何一次服务器返回都应该做的事情
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write(stringBuilder.toString());

    }
}
