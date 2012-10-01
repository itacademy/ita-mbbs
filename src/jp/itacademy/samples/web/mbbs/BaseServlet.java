package jp.itacademy.samples.web.mbbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

    protected void forward(String url, HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, res);
    }

    protected void redirect(String url, HttpServletRequest req,
            HttpServletResponse res) throws IOException {
        res.sendRedirect(req.getContextPath() + url);
    }

    protected void seeOther(String url, HttpServletRequest req,
            HttpServletResponse res) throws IOException {
        res.setStatus(303);
        res.addHeader("Location", req.getContextPath() + url);
    }

    protected boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

}
