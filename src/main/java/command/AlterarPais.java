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

public class AlterarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");

		long populacao = -1;
		double area = -1;
		int id = -1;

		try {
			
			populacao = Long.parseLong(pPopulacao);
			area = Double.parseDouble(pArea);
			id = Integer.parseInt(pId);

		} catch (NumberFormatException e) {

		}
		// instanciar o javabean

		Pais pais = new Pais();
		
		pais.setNome(pNome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		pais.setId(id);

		PaisService pa = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		pa.atualizar(pais);
		@SuppressWarnings("unchecked")
		ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute("lista");
		
		int pos = busca(pais, lista);
		lista.remove(pos);
		lista.add(pos, pais);
		session.setAttribute("lista", lista);
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

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
