package service;

import pacote.Usuario;
import Dao.UsuarioDAO;

public class UsuarioService {
	
	public boolean validar(Usuario usuario){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}
}
