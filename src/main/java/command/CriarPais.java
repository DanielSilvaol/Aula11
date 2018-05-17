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

public class CriarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String Id = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String Populacao = request.getParameter("populacao");
		String Area = request.getParameter("area");

		int pId = -1;
		long pPopulacao = -1;
		double pArea = -1;
		try {
			pId = Integer.parseInt(Id);
			pPopulacao = Long.valueOf(Populacao);
			pArea = Double.valueOf(Area);
		} catch (NumberFormatException e) {

		}

		Pais pais = new Pais();
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);


			pPopulacao = Long.valueOf(Populacao);
			pArea = Double.valueOf(Area);

			pais.setId(pId);
			pais.setNome(pNome);
			pais.setPopulacao(pPopulacao);
			pais.setArea(pArea);
		
		// instanciar o service

		PaisService cs = new PaisService();
		cs.criar(pais);
		pais = cs.carregar(pais.getId());
		request.setAttribute("pais", pais);
		RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
		
		pais.setId(pId);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		PaisService pai = new PaisService();
		HttpSession session = request.getSession();

		pai.criar(pais);
		ArrayList<Pais> lista = new ArrayList<>();
		lista.add(pais);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPais.jsp");
		view.forward(request, response);

		
	}
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}

}
