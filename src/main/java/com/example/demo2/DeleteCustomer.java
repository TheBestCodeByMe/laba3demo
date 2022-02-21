package com.example.demo2;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/delete")
public class DeleteCustomer extends HttpServlet {

    @EJB
    private CustomerBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if(req.getParameter("id") != null && !Objects.equals(req.getParameter("id"), "")){
            long id = Long.parseLong(req.getParameter("id"));
            userBean.delete(id);
        }
        resp.sendRedirect("list");
    }
}