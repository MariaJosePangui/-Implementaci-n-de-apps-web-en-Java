package com.registro.registropersonass.controller;
import com.registro.registropersonass.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registroUsuario.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        if(request.getParameter("edad").length()==0||request.getParameter("nombre").length()==0){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroErroneo.jsp");
            requestDispatcher.forward(request,response);
        }else{
            String nombre=request.getParameter("nombre");
            int edad=Integer.parseInt(request.getParameter("edad"));
            String rut = request.getParameter("rut");
            Usuario usuario = new Usuario(nombre,edad,rut);
            usuario.registrarUsuario();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}