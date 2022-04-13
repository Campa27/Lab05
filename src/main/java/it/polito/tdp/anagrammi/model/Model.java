package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO anagrammaDao;
	List<String> anagrammi;
	
	public Model() {
		this.anagrammaDao = new AnagrammaDAO();
	}
	
	public List<String> anagramma(String s) {
		anagrammi = new ArrayList<String>();
		anagramma_ricorsiva("", 0, s);
		return anagrammi;
	}
	
	private void anagramma_ricorsiva(String parziale, int L, String rimanenti) {
		if(rimanenti.length() == 0) {
			this.anagrammi.add(parziale);
		} else {
			for(int pos = 0;pos < rimanenti.length();pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos+1);
				anagramma_ricorsiva(nuova_parziale, L+1, nuova_rimanenti);
			}
		}
	}

	public boolean isCorrect(String parola) {
		return this.anagrammaDao.isCorrect(parola);
	}

}
