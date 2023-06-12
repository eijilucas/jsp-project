/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author lucas
 */
@WebServlet(name = "Controle_Cliente", urlPatterns = {"/Controle_Cliente"})
public class Controle_Cliente extends HttpServlet {

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

            String msg = "";
            String op = request.getParameter("op");
            Cliente cli = new Cliente();
            ClienteDAO cdao = new ClienteDAO();

            switch (op) {
                case "CADASTRAR": {
                        try {
                            Integer idade = Integer.parseInt(request.getParameter("txtIdade"));
                            String nome = request.getParameter("txtNome");
                            String logradouro = request.getParameter("txtLogradouro");
                            String cidade = request.getParameter("txtCidade");
                            String estado = request.getParameter("txtEstado");
                            String telefone = request.getParameter("txtTelefone");
                            String email = request.getParameter("txtEmail");
                            String cpf = request.getParameter("txtCpf");
                            String dataNascimento = request.getParameter("txtDataNascimento");
                            
                            cli.setIdade(idade);
                            cli.setNome(nome);
                            cli.setLogradouro(logradouro);
                            cli.setCidade(cidade);
                            cli.setEstado(estado);
                            cli.setTelefone(telefone);
                            cli.setEmail(email);
                            cli.setCpf(cpf);
                            cli.setDataNascimento(dataNascimento);

                            cdao.inserir(cli);
                            msg = "Cadastrar";
                            request.setAttribute("msg", msg);
                            request.getRequestDispatcher("resultado.jsp").forward(request, response);
                        } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                            System.out.println("Erro: " + ex.getMessage());
                            msg = "Cadastrar";
                            request.setAttribute("msg", msg);
                            request.getRequestDispatcher("erro.jsp").forward(request, response);
                        }
                  
                    break;
                }
                case "DELETAR": {
                    String idString = request.getParameter("txtId");

                    try {
                        Integer id = Integer.parseInt(idString);
                        cli.setId(id);
                        cdao.deletar(cli);
                        msg = "Deletar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        msg = "Deletar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    break;
                }
                case "ATUALIZAR": {
                    String idString = request.getParameter("txtId");

                    try {
                        Integer id = Integer.parseInt(idString);
                        cli.setId(id);
                        cli = cdao.buscarPorId(cli);
                        request.setAttribute("cli", cli);
                        request.getRequestDispatcher("resultadoAtualizar.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        msg = "Atualizar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    break;
                }
                case "EFETIVAR": {
                    String idString = request.getParameter("txtId");

                    try {
                        Integer id = Integer.parseInt(idString);
                        Integer idade = Integer.parseInt(request.getParameter("txtIdade"));
                        String nome = request.getParameter("txtNome");
                        String logradouro = request.getParameter("txtLogradouro");
                        String cidade = request.getParameter("txtCidade");
                        String estado = request.getParameter("txtEstado");
                        String telefone = request.getParameter("txtTelefone");
                        String email = request.getParameter("txtEmail");
                        String cpf = request.getParameter("txtCpf");
                        String dataNascimento = request.getParameter("txtDataNascimento");
                        cli.setId(id);
                        cli.setIdade(idade);
                        cli.setNome(nome);
                        cli.setLogradouro(logradouro);
                        cli.setCidade(cidade);
                        cli.setEstado(estado);
                        cli.setTelefone(telefone);
                        cli.setEmail(email);
                        cli.setCpf(cpf);
                        cli.setDataNascimento(dataNascimento);

                        cdao.atualizar(cli);
                        msg = "Atualizar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        msg = "Atualizar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    break;
                }
                case "BUSCAR POR ID": {
                    String idString = request.getParameter("txtId");

                    try {
                        Integer id = Integer.parseInt(idString);
                        cli.setId(id);
                        cli = cdao.buscarPorId(cli);
                        request.setAttribute("cli", cli);
                        request.getRequestDispatcher("resultadoBuscarId.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        msg = "Buscar por id";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }

                }
                break;

                case "BUSCAR TODOS": {
                    try {
                        List<Cliente> lista = cdao.buscarTodos();
                        request.setAttribute("lista", lista);
                        request.getRequestDispatcher("resultadoBuscarTodos.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NullPointerException | NumberFormatException ex) {
                        System.out.println("Erro: " + ex.getMessage());
                        msg = "Buscar";
                        request.setAttribute("msg", msg);
                        request.getRequestDispatcher("erro.jsp").forward(request, response);
                    }
                    break;
                }
                case "REDIRECIONAR": {
                    response.sendRedirect(request.getContextPath() + "/");
                }

                default:
                    break;
            }
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
