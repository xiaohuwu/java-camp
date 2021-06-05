package com.ktb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
   LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Yahoo!!!!!!!!</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("My First Servlet");
//        out.println("</body>");
//        out.println("</html>");

        String name = request.getParameter("name");
        System.out.println("name="+name);

        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");


        if(loginService.validateUser(name,password)){
            httpServletRequest.setAttribute("name",name);
            httpServletRequest.setAttribute("password",password);
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest,httpServletResponse);
        }else {
            httpServletRequest.setAttribute("error","name or password not correct");
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest,httpServletResponse);
        }

    }


}

