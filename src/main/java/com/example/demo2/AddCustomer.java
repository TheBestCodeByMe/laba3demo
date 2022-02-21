package com.example.demo2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/add")
public class AddCustomer extends HttpServlet {

    @EJB
    private CustomerBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        // если параметр null, то пользователь
        // пришел на страницу, чтобы создать нового, иначе
        // будет выполнятся редактирование существующего пользователя
        if(req.getParameter("edit") != null){
            long id = Long.parseLong(req.getParameter("edit"));
            Customer user = userBean.get(id);

            req.setAttribute("customer", user);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        int zip = Integer.valueOf(req.getParameter("zip"));
        String name = req.getParameter("name");
        String firstAddress = req.getParameter("firstAddress");
        String secondAddress = req.getParameter("secondAddress");
        int numbFax = Integer.valueOf(req.getParameter("numbFax"));
        String city = req.getParameter("city");

        // если id есть, то выполняется редактирование
        // а если нет id, то - это значит, что создается новый пользователь
        if(!Objects.equals(req.getParameter("id"), "")){
            long id = Long.valueOf(req.getParameter("id"));
            Customer user = userBean.get(id);
            user.setZip(zip);
            user.setName(name);
            user.setFirstAddress(firstAddress);
            user.setSecondAddress(secondAddress);
            user.setNumbFax(numbFax);
            user.setCity(city);

            // обновляем пользователя
            userBean.update(user);
        } else{
            // добавляем нового
            Customer customer = new Customer(zip, name, firstAddress, secondAddress, numbFax, city);
            userBean.add(customer);
        }

        // перенаправляем на сервлет, который выводит все пользователей
        resp.sendRedirect("list");
    }
}
