package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomepageController", urlPatterns = "/")
public class HomepageController extends HttpServlet {
    int numberSolutions;

    public void init(){
        numberSolutions = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Servet strony startowej, wartość parametru to " + numberSolutions);

//        List<Solution> solutions = SolutionDao.findAll(numberSolutions);

    }
}
