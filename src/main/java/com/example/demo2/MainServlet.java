package com.example.demo2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class MainServlet extends HttpServlet {

    // Аннотация говорит о том,
    // что данный объект будет инициализирован
    // контейнером Glassfish DI
    @EJB
    private CustomerBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         // Получаем список пользователей
        List<Customer> allUser = userBean.getAll();
        // добавляем полученный список в request,
        // который отправится на jsp
        req.setAttribute("customers", allUser);

        // отправляем request на jsp
        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

}