package it.unical.prg4.minesweeper.components.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.prg4.minesweeper.components.persistence.CredentialsDAO;
import it.unical.prg4.minesweeper.model.Credentials;



@Service
public class LoginService {

	@Autowired
	private CredentialsDAO credentialsDAO;

	public boolean login(String username, String password) {
		
		return credentialsDAO.exists(new Credentials(username, password));
	}

}
