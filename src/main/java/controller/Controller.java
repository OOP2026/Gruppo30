package controller;


import model.*;


import java.time.LocalDate;
import java.time.LocalTime;
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

	public ArrayList<String> parseLetti(ArrayList<Letto> l){
		ArrayList<String> listal=new ArrayList<>();
		for(Letto letto : l){
			listal.add(letto.getCode());
		}
	return listal;
	}

	public Letto cercaLetto(String c, String r){
		Letto searchLetto=null;
		for(Letto letto : viewLetti(r)){
			if(letto.getCode().equals(c))
				searchLetto=letto;
		}
		return searchLetto;
	}

	public ArrayList<Ricovero> compilaRicoveri(ArrayList<Reparto> listrep){
		ArrayList listrep2=new ArrayList();

		for(Reparto reparto : listrep){
			for(Stanza stanza : reparto.getStanze()){
				for(Letto letto : stanza.getLetti()){
					listrep2.add(letto.getRicoveriAssegnati());
				}
			}
		}
		return listrep2;
	}
	public Ricovero cercaRicovero(String r, ArrayList<Ricovero> listr){
		Ricovero ricoveroCercato=null;
		for (Ricovero ricovero : listr){
			if(ricovero.getIdrec()==r)
				ricoveroCercato=ricovero;
		}
		return ricoveroCercato;
	}
	public TurnoLavorativo cercaTurnoLavorativo(LocalDate a, LocalTime b, LocalTime c, ArrayList<TurnoLavorativo> listt){
		TurnoLavorativo turnoLavorativo=null;
		for(TurnoLavorativo turnoLavorativo2 : listt){
			if((turnoLavorativo2.getData()==a)&&(turnoLavorativo2.getInizio()==b)&&(turnoLavorativo2.getFine()==c))
				turnoLavorativo=turnoLavorativo2;
		}
		return turnoLavorativo;
	}
	public void creaPrestazione(String a, LocalDate b, String d, String e){

		medico.registraPrestazione(a, b, d, cercaRicovero(e, compilaRicoveri(amministratore.getreparti())), cercaTurnoLavorativo(LocalDate.now(),LocalTime.of(20, 30), LocalTime.of(6,45), medico.getTurni()) );
	}
	public void completaPrestazione(String idp, String text){
		medico.completaPrestazione(idp,text);
	}
	public ArrayList<Prestazione> cercaPrestazioni(LocalDate date){
		ArrayList<Prestazione> lista=new ArrayList<>();
		lista=medico.viewagenda(date);
		return lista;
	}
	public boolean checkAvailability(Letto l){
		boolean availability=true;
		availability=l.isAvailableToday();
		return availability;
	}

	public Amministratore getAmministratore(){
		return amministratore;
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
		medico.aggiungiTurno(LocalDate.now(), LocalTime.of(20, 30), LocalTime.of(6, 45));
	}
	
}
