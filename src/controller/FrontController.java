/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Equipamento;
import service.EquipamentoService;

/**
 *
 * @author Trabalho
 */
public class FrontController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -933588718308869192L;
	private static String LIST_EQUIPAMENTO = "/ListarEquipamentos.jsp";
    private static String CADASTRO_SUCESSO = "/cadastroSucesso.jsp";
    private static String PAGCADASTRO = "/CadastrarEquipamento.jsp";
    private static String CADASTRO_ERRO = "/cadastroErro.jsp";
    private EquipamentoService service = new EquipamentoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("CadEquip")) {
            try {
                Equipamento equip = new Equipamento();
                equip.setNome(request.getParameter("NomeEquip"));
                equip.setTipo(request.getParameter("TipoEquip"));
                equip.setPeso(Float.parseFloat(request.getParameter("PesoEquip")));
                
                if(!service.verificaSeExiste("Oculos")){
                 	Equipamento eq = new Equipamento();
                 	eq.setNome("Oculos");
                 	eq.setTipo("Segurança");
                 	eq.setPeso((float) 173.0);
                 	service.salvar(eq);
                 }
                if(!service.verificaSeExiste("Capacete")){
                 	Equipamento eq = new Equipamento();
                 	eq.setNome("Capacete");
                 	eq.setTipo("Segurança");
                 	eq.setPeso((float) 1.2);
                 	service.salvar(eq);
                 }

                service.salvar(equip);
                forward = CADASTRO_SUCESSO;
                System.out.println(equip.toString());
                request.setAttribute("IDEQUIP", service.ultimoId());
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            } catch (Exception ex) {
                System.out.println("Erro no cadastro");
                forward = CADASTRO_ERRO;
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("ListEquip")) {
            forward = LIST_EQUIPAMENTO;
            request.setAttribute("ListEquip", service.listaTodos());
        } else if (action.equalsIgnoreCase("PagCad")) {
            forward = PAGCADASTRO;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

}
