package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pacote.Pais;
import service.PaisService;

public class VisualisarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String Populacao = request.getParameter("populacao");
		String Area = request.getParameter("area");

		int id = -1;
		long pPopulacao = -1;
		double pArea = -1;
		try {
			id = Integer.parseInt(pId);
			pPopulacao = Long.valueOf(Populacao);
			pArea = Double.valueOf(Area);
		} catch (NumberFormatException e) {

		}

		Pais pais = new Pais();
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);


		pPopulacao = Long.valueOf(Populacao);
		pArea = Double.valueOf(Area);

		pais.setId(id);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);

		// instanciar o service

		PaisService cs = new PaisService();

		pais = cs.carregar(pais.getId());
		request.setAttribute("pais", pais);
		RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");

		pais.setId(id);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		PaisService pai = new PaisService();
		HttpSession session = request.getSession();



		pais = pai.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		view.forward(request, response);
	}

}
