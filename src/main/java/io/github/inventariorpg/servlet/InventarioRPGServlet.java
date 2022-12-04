/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.inventariorpg.servlet;

import io.github.naum.inventariorpg.inventario.InventarioBeanLocal;
import io.github.naum.inventariorpg.itemgeral.ArmaBeanLocal;
import io.github.naum.inventariorpg.itemgeral.ArmaduraBeanLocal;
import io.github.naum.inventariorpg.itemgeral.ConsumivelBeanLocal;
import io.github.naum.inventariorpg.personagem.Personagem;
import io.github.naum.inventariorpg.personagem.PersonagemBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import jdk.jshell.execution.Util;

/**
 *
 * @author fried
 */
@WebServlet(name = "InventarioRPGServlet",
      urlPatterns = {"/InventarioRPGServlet"})

@Transactional
public class InventarioRPGServlet extends HttpServlet {

    
    
    @Inject
    private PersonagemBeanLocal personagembean;
    
    @Inject
    private InventarioBeanLocal inventariobean;
    
    @Inject 
    private ArmaBeanLocal armabean;
    
    @Inject
    private ArmaduraBeanLocal armadurabean;
    
    @Inject
    private ConsumivelBeanLocal consumivelbean;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Personagem p1 = new Personagem();
            p1.setCa(5);
            p1.setDinheiro(Double.parseDouble("50,0"));
            p1.setId(1L);
            p1.setInventario(null);
            p1.setLimPeso(Double.parseDouble("50,0"));
            p1.setNome("Friedrich");
            
            personagembean.salvar(p1);
            
            Personagem perAux = personagembean.localizarPorId(p1.getId());
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InventarioRPGServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InventarioRPGServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            out.println("<p><pre>-- Personagem --\n" + perAux.getNome() + "</pre></p>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
