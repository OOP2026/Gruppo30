package controller;


import model.Medico;
import model.Amministratore;
import model.Reparto;
import model.Paziente;
import model.Letto;



import java.time.LocalDate;
import java.util.ArrayList;


public class Controller {
	private Medico medico;
	private Reparto reparto;
	private Amministratore amministratore;
	private ArrayList<Paziente> pazienti;

	public void RegistraM(String a, String b, String c, String d){
		reparto.addMedico(a,b,c,d);
		medico=new Medico(a,b,c,d, reparto);
	}
	public void RegistraA(String a, String b){
		amministratore=new Amministratore(a,b);
	}

	public boolean login(String a, String b, boolean checkA){
		if(checkA){
			return amministratore.login(a,b);
		}
		else{
			return medico.login(a,b);
		}
	}
	public void aggiungiPaziente(String a, String b, String c, LocalDate d){
		amministratore.inserisciPaziente(a,b,c,d,pazienti);
	}

	public void aggiungiRicovero(LocalDate a, LocalDate b, String c , String d){
		String id=c+d;
		amministratore.inserisciRicovero(a,b,reparto.cercaLetto(c),amministratore.cercaPaziente(d, pazienti), id);
	}
	public ArrayList<Paziente> viewPazientiInDimissione(LocalDate date){
		return amministratore.allPazientiInScadenza(date);
	}

	public ArrayList<Letto> viewLetti(String r){
		return amministratore.cercaLetti(amministratore.cercaReparto(r).getStanze());
	}
	public boolean checkAvailability(Letto l){
		boolean availability=true;
		availability=l.isAvailableToday();
		return availability;
	}

	public Controller() {
		reparto= amministratore.creaReparto("0", "DEFAULT");

		reparto.addStanza(1,20);
		reparto.addStanza(2,25);
		reparto.addStanza(3, 30);

		reparto.addLettoToStanza("AB", 1);
		reparto.addLettoToStanza("CD", 2);
		reparto.addLettoToStanza("EF", 3);
		pazienti=new ArrayList<>();
	}
	
}
