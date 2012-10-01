package jp.itacademy.samples.web.mbbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itacademy.samples.web.BaseServlet;

@WebServlet("/board")
public class BoardServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        forward("/WEB-INF/board.jsp", req, res);
    }

}
