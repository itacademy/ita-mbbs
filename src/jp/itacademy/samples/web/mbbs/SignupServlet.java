package jp.itacademy.samples.web.mbbs;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mbbs/signup")
public class SignupServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String handle = req.getParameter("handle");
        String account = req.getParameter("account");
        String pass = req.getParameter("pass");

        if (isBlank(handle) || isBlank(account) || isBlank(pass)) {
            req.setAttribute("error", "必要項目が入力されていません");
            forward("/WEB-INF/index.jsp", req, res);
            return;
        }

        User user = new User(handle, account, pass);
        String error = signup(user);
        if (error == null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            seeOther("/mbbs/board", req, res);
        } else {
            req.setAttribute("error", error);
            forward("/WEB-INF/index.jsp", req, res);
            return;
        }
    }

    @SuppressWarnings("unchecked")
    private synchronized String signup(User user) {

        ServletContext ctx = getServletContext();
        Map<String, User> userMap =
            (Map<String, User>) ctx.getAttribute("userMap");
        Set<String> handleSet = (Set<String>) ctx.getAttribute("handleSet");

        if (userMap.get(user.getAccount()) != null) {
            return "同じアカウントが存在します";
        }

        if (!handleSet.add(user.getHandle())) {
            return "同じハンドルが存在します";
        }

        userMap.put(user.getAccount(), user);
        return null;
    }

}
