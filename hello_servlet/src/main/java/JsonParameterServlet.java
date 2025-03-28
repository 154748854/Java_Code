import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class Request {
    public String username;
    public String password;
}

class Response {
    public boolean ok;
}

@WebServlet("/json")
public class JsonParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把请求的body按照json的格式解析成java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Request request = objectMapper.readValue(req.getInputStream(), Request.class);
        System.out.println("username:" + request.username);
        System.out.println("password:" + request.password);
        Response response = new Response();
        response.ok = true;
        // 把响应对象转成json字符串
        String respJson = objectMapper.writeValueAsString(response);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(respJson);
    }
}
