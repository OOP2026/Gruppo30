package controller;

import model.Utente;
import model.Medico;
import model.Amministratore;
import model.Reparto;
import model.Paziente;


import java.util.ArrayList;


public class Controller {
	private Medico medico;
	private Reparto reparto;
	private Amministratore amministratore;

	public void RegistraM(String a, String b, String c, String d){
		reparto.addMedico(a,b,c,d);
		medico=new Medico(a,b,c,d, reparto);
	}
	public void RegistraA(String a, String b){
		amministratore=new Amministratore(a,b);
	}

	public boolean login(String a, String b, boolean checkA){
		if(checkA=true){
			return amministratore.login(a,b);
		}
		else{
			return medico.login(a,b);
		}
	}
	public Controller() {
		reparto= new Reparto("0", "DEFAULT");
	}
	
}
