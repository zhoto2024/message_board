package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
/**
 * Servlet implementation class NewServlet
 */
@WebServlet({ "/NewServlet", "/new" })
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CSRF対策 CSRF()ross-Site Request Forgeries)
        // 利用者が意図したリクエストかどうかを判別する仕組み
        // サイト外からPOST送信された投稿を拒否するために、
        // セッションIDを活用している。
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成
        // 画面表示時のエラー回避のため、とりあえず0のデータを
        // フォームに渡している。
        request.setAttribute("message", new Message());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
            rd.forward(request, response);
    }

}
