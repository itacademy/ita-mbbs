package jp.itacademy.samples.web.mbbs;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "mbbs-login-check", urlPatterns = "/mbbs/board")
public class LoginCheckFilter implements Filter {

    public void init(FilterConfig conf) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;

        String loginUrl = hreq.getContextPath() + "/mbbs/index";
        HttpSession session = hreq.getSession(false);
        if (session == null) {
            hres.sendRedirect(loginUrl);
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            hres.sendRedirect(loginUrl);
            return;
        }

        chain.doFilter(req, res);
    }

}
