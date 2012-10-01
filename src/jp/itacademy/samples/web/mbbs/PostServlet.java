package jp.itacademy.samples.web.mbbs;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class PostServlet extends BaseServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String body = req.getParameter("body");
        if (isBlank(body)) {
            req.setAttribute("error", "メッセージを入力してください");
            forward("/WEB-INF/error.jsp", req, res);
            return;
        }

        User user = (User) req.getSession().getAttribute("user");

        ServletContext context = getServletContext();
        List<Message> messages =
            (List<Message>) context.getAttribute("messages");

        Message msg = new Message(user.getHandle(), body, new Date());
        messages.add(msg);

        seeOther("/board", req, res);
    }

}
