package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utils.DBUtil;
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
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        // Messageのインスタンスを生成
        Message m = new Message();

        // mの各フィールドにデータを代入
        String title = "taro";
        m.setTitle(title);

        String content = "Hello";
        m.setContent(content);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis()); //現在の日時を取得
        m.setCreated_at(currentTime);
        m.setUpdated_at(currentTime);

        // データベースに保存
        em.persist(m);  // persist = 持続する
        em.getTransaction().commit();

        // 自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(m.getId()).toString());
        // append = 追加する
        
        em.close();
    }

}
