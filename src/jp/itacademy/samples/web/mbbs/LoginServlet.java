package jp.itacademy.samples.web.mbbs;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itacademy.samples.web.BaseServlet;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String account = req.getParameter("account");
        String pass = req.getParameter("pass");

        if (isBlank(account) || isBlank(pass)) {
            req.setAttribute("error", "必要項目が入力されていません");
            forward("/WEB-INF/index.jsp", req, res);
            return;
        }

        ServletContext ctx = getServletContext();
        Map<String, User> userMap =
            (Map<String, User>) ctx.getAttribute("userMap");
        User user = userMap.get(account);
        if (user == null || !user.getPass().equals(pass)) {
            req.setAttribute("error", "アカウントまたはパスワードが正しくありません");
            forward("/WEB-INF/index.jsp", req, res);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        seeOther("/board", req, res);
    }
}
