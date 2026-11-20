package lab.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

import lab.mvc.model.Person;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        Person person = new Person(firstName, lastName,
                                   birthDay, sex);

        request.setAttribute("person", person);

        int year = Integer.parseInt(birthDay.substring(0, 4));

        RequestDispatcher dispatcher;

        if (year < 1990) {
            dispatcher = getServletContext()
                    .getRequestDispatcher("/old.jsp");
        } else {
            dispatcher = getServletContext()
                    .getRequestDispatcher("/young.jsp");
        }

        dispatcher.include(request, response);
    }
}
