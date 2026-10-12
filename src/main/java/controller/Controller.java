package controller;

import dao.UtenteDAO;
import gui.AgendaMedico;
import gui.GestionePazienti;
import gui.Login;
import gui.SchermataAmministratore;
import gui.GestioneRicoveri;
import gui.RicercaDimissioni;
import gui.StatoLetti;
import gui.RegistraPrestazione;
import gui.ModificaEsito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Login loginSchermata;
    private SchermataAmministratore adminView;
    private AgendaMedico medicoView;
    private GestionePazienti  gestionePazientiView;
    private GestioneRicoveri gestioneRicoveriView;
    private RicercaDimissioni ricercaDimissioniView;
    private StatoLetti statoLettiView;
    private RegistraPrestazione registraPrestazioneView;
   private ModificaEsito modificaEsitoView;


    private UtenteDAO utenteDAO;

    public Controller(Login loginSchermata, UtenteDAO utenteDAO) {
        this.loginSchermata = loginSchermata;
        this.utenteDAO = utenteDAO;
        this.loginSchermata.getAccediButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciLogin();
            }
        });
    }

    private void gestisciLogin() {
        String user = loginSchermata.getUsername();
        String pass = loginSchermata.getPassword();
        boolean isAdmin = loginSchermata.isAdminSelected();
        boolean isMedico = loginSchermata.isMedicoSelected();

        if (isAdmin && isMedico) {
            loginSchermata.mostraErrore("Seleziona una sola opzione di accesso.");
            return;
        }

        if (user.isEmpty() || pass.isEmpty()) {
            loginSchermata.mostraErrore("Campi non compilati presenti.");
            return;
        }

        if (!isAdmin && !isMedico) {
            loginSchermata.mostraErrore("Seleziona un'opzione di accesso");
            return;
        }

        boolean loginValido = true; // qui va il DAO, momentaneamente ho messo fisso su true.

        if (!loginValido) {
            loginSchermata.mostraErrore("Username o password non validi.");
            return;
        }

        loginSchermata.visualizza(false);

        if (isAdmin) {
            apriSchermataAmministratore();
            adminView.visualizza(true);
        } else {
           // this.medicoLoggato = utenteDAO
            apriAgendaMedico();
            medicoView.visualizza(true);
        }
    }
    private void apriAgendaMedico() {
        this.medicoView = new AgendaMedico(loginSchermata.getFrame(), this);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        medicoView.setDataSelezionata(LocalDate.now().format(formatter));
        this.medicoView.getBtnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicoView.visualizza(false);
                loginSchermata.visualizza(true);
            }
        });

        this.medicoView.getBtnAggiorna().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciAggiornamentoAgenda();
            }
        });

        this.medicoView.getBtnModificaEsito().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriModificaEsito();
            }
        });

        this.medicoView.getBtnEffettuaVisita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciEffettuaVisita();
            }
        });

        this.medicoView.visualizza(true);
    }

    private void gestisciAggiornamentoAgenda() {
        String dataStr = medicoView.getDataSelezionata();

        if (dataStr.isEmpty()) {
            medicoView.mostraErrore("Inserire una data di riferimento per filtrare l'agenda.");
            return;
        }

        LocalDate dataRiferimento;
        try {
            dataRiferimento = LocalDate.parse(dataStr);
        } catch (DateTimeParseException e) {
            medicoView.mostraErrore("Formato data non valido. Usare il formato: GG/MM/AAAA");
            return;
        }

        String tipoAgenda = medicoView.getTipoAgendaSelezionata();

        String[] colonne = {"ID Prestazione", "CF Paziente", "Tipo", "Data", "Orario", "Esito"};
        DefaultTableModel tableModel = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (tipoAgenda.equalsIgnoreCase("Settimanale")) {
            LocalDate fineSettimana = dataRiferimento.plusDays(6);

            // DAO

            medicoView.mostraMessaggio("Agenda settimanale caricata per il periodo: " + dataRiferimento + " - " + fineSettimana);
        } else {
            // DAO

            medicoView.mostraMessaggio("Agenda giornaliera caricata per la data: " + dataRiferimento);
        }

        medicoView.getTabellaAgenda().setModel(tableModel);
    }

    private void gestisciEffettuaVisita() {
        int rigaSelezionata = medicoView.getTabellaAgenda().getSelectedRow();

        if (rigaSelezionata == -1) {
            medicoView.mostraErrore("Seleziona una prestazione dalla tabella prima di procedere.");
            return;
        }

        apriRegistraPrestazione();
        medicoView.mostraMessaggio("Apertura modulo visita per la prestazione selezionata.");
    }
    private void apriRegistraPrestazione() {
        this.registraPrestazioneView = new RegistraPrestazione(medicoView.getFrame(), this);

        this.registraPrestazioneView.getAnnullaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registraPrestazioneView.visualizza(false);
            }
        });

        this.registraPrestazioneView.getSalvaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciSalvataggioPrestazione();
            }
        });

        this.registraPrestazioneView.visualizza(true);
    }

    private void gestisciSalvataggioPrestazione() {
        String dataStr = registraPrestazioneView.getData();
        String tipo = registraPrestazioneView.getTipoPrestazione();
        String note = registraPrestazioneView.getNote();
        String oraInizioStr = registraPrestazioneView.getOraInizio();
        String oraFineStr = registraPrestazioneView.getOraFine();

        if (dataStr.isEmpty() || tipo.isEmpty() || oraInizioStr.isEmpty() || oraFineStr.isEmpty()) {
            registraPrestazioneView.mostraErrore("Compilare i campi Data e Tipo Prestazione.");
            return;
        }
        LocalDate dataPrestazione;
        LocalTime oraInizio;
        LocalTime oraFine;

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            dataPrestazione = LocalDate.parse(dataStr, dateFormatter);
            oraInizio = LocalTime.parse(oraInizioStr, timeFormatter);
            oraFine = LocalTime.parse(oraFineStr, timeFormatter);

        } catch (DateTimeParseException e) {
            registraPrestazioneView.mostraErrore("Formato errato. Usa GG/MM/AAAA per la data e HH:mm per l'orario.");
            return;
        }
        if (!oraInizio.isBefore(oraFine)) {
            registraPrestazioneView.mostraErrore("L'orario di inizio deve precedere l'orario di fine.");
            return;
        }
        //DAO
        registraPrestazioneView.mostraMessaggio("Prestazione medica registrata con successo!");
        registraPrestazioneView.svuotaCampi();
        registraPrestazioneView.visualizza(false);
    }
    private void apriSchermataAmministratore() {
        this.adminView = new SchermataAmministratore(loginSchermata.getFrame(), this);

        this.adminView.getGestionePazientiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriGestionePazienti();
            }
        });

        this.adminView.getGestioneRicoveriButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriGestioneRicoveri();
            }
        });

        this.adminView.getRicercaDimissioniButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriRicercaDimissioni();
            }
        });

        this.adminView.getStatoLettiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriStatoLetti();
            }
        });

        this.adminView.visualizza(true);
    }
    private void apriGestioneRicoveri() {
        adminView.visualizza(false);
        this.gestioneRicoveriView = new GestioneRicoveri(adminView.getFrame(), this);

        this.gestioneRicoveriView.getAnnullaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestioneRicoveriView.visualizza(false);
                adminView.visualizza(true);
            }
        });

        this.gestioneRicoveriView.getConfermaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciSalvataggioRicovero();
            }
        });

        this.gestioneRicoveriView.visualizza(true);
    }

    private void gestisciSalvataggioRicovero() {
        String cf = gestioneRicoveriView.getCFPaziente();
        String codiceLetto = gestioneRicoveriView.getCodiceLetto();
        String dataInizioStr = gestioneRicoveriView.getDataInizio();
        String oraInizioStr = gestioneRicoveriView.getOraInizio();
        String dataFineStr = gestioneRicoveriView.getDataFine();
        String oraFineStr = gestioneRicoveriView.getOraFine();

        if (cf.isEmpty() || codiceLetto.isEmpty() || dataInizioStr.isEmpty() ||
                oraInizioStr.isEmpty() || dataFineStr.isEmpty() || oraFineStr.isEmpty()) {
            gestioneRicoveriView.mostraErrore("Compilare tutti i campi per registrare il ricovero.");
            return;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime inizio;
        LocalDateTime fine;

        try {
            LocalDate dInizio = LocalDate.parse(dataInizioStr, dateFormatter);
            LocalTime tInizio = LocalTime.parse(oraInizioStr, timeFormatter);

            LocalDate dFine = LocalDate.parse(dataFineStr, dateFormatter);
            LocalTime tFine = LocalTime.parse(oraFineStr, timeFormatter);

            inizio = LocalDateTime.of(dInizio, tInizio);
            fine = LocalDateTime.of(dFine, tFine);

        } catch (DateTimeParseException e) {
            gestioneRicoveriView.mostraErrore("Formato errato. Usare GG/MM/AAAA per le date e HH:mm per gli orari.");
            return;
        }

        if (fine.isBefore(inizio)) {
            gestioneRicoveriView.mostraErrore("La data/ora di dimissione non puo' precedere l'inizio del ricovero.");
            return;
        }

        // DAO

        gestioneRicoveriView.mostraMessaggio("Ricovero registrato con successo.");
        gestioneRicoveriView.svuotaCampi();
    }

    private void apriGestionePazienti() {
        adminView.visualizza(false);
        this.gestionePazientiView = new GestionePazienti(adminView.getFrame(), this);

        this.gestionePazientiView.getAnnullaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionePazientiView.visualizza(false);
                adminView.visualizza(true);
            }
        });

        this.gestionePazientiView.getConfermaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciSalvataggioPaziente();
            }
        });

        this.gestionePazientiView.visualizza(true);
    }

    private void gestisciSalvataggioPaziente() {
        String nome = gestionePazientiView.getNome();
        String cognome = gestionePazientiView.getCognome();
        String cf = gestionePazientiView.getCodiceFiscale();
        String dataStr = gestionePazientiView.getDataNascita();

        if (nome.isEmpty() || cognome.isEmpty() || cf.isEmpty() || dataStr.isEmpty()) {
            gestionePazientiView.mostraErrore("Compilare tutti i campi del paziente.");
            return;
        }
        LocalDate dataNascita;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            dataNascita = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            gestionePazientiView.mostraErrore("Formato data non valido. Inserire la data nel formato GG/MM/AAAA.");
            return;
        }

        // DAO
        // Paziente nuovoPaziente = new Paziente(cf, nome, cognome, LocalDate.parse(data));
        // pazienteDAO.inserisciPaziente(nuovoPaziente);

        gestionePazientiView.mostraMessaggio("Dati paziente registrati con successo!");
        gestionePazientiView.svuotaCampi();
    }

    private void apriRicercaDimissioni() {
        adminView.visualizza(false);
        this.ricercaDimissioniView = new RicercaDimissioni(adminView.getFrame(), this);

        this.ricercaDimissioniView.getBtnIndietro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaDimissioniView.visualizza(false);
                adminView.visualizza(true);
            }
        });

        this.ricercaDimissioniView.getBtnOggi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciRicercaDimissioniOggi();
            }
        });

        this.ricercaDimissioniView.getBtnCercaDimissioni().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciRicercaDimissioni();
            }
        });

        this.ricercaDimissioniView.visualizza(true);
    }
    private void gestisciRicercaDimissioniOggi() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataOggiStr = LocalDate.now().format(formatter);
        ricercaDimissioniView.setDataRicerca(dataOggiStr);
        gestisciRicercaDimissioni();
    }

    private void gestisciRicercaDimissioni() {
        String dataStr = ricercaDimissioniView.getDataRicerca();

        if (dataStr.isEmpty()) {
            ricercaDimissioniView.mostraErrore("Inserire una data di scadenza per avviare la ricerca.");
            return;
        }

        LocalDate dataRicerca;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            dataRicerca = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            ricercaDimissioniView.mostraErrore("Formato data non valido. Inserire la data nel formato GG/MM/AAAA.");
            return;
        }

        String[] colonne = {"ID Ricovero", "CF Paziente", "Codice Letto", "Data Inizio", "Data e Ora Dimissione"};

        DefaultTableModel tableModel = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        //DAO

        ricercaDimissioniView.getTabellaDimissioni().setModel(tableModel);
        ricercaDimissioniView.mostraMessaggio("Ricerca completata per la data: " + dataStr);
        if (tableModel.getRowCount() == 0) {
            ricercaDimissioniView.mostraMessaggio("Nessun paziente in dimissione trovato per la data: " + dataStr);
        }
    }

    private void apriStatoLetti() {
        adminView.visualizza(false);
        this.statoLettiView = new StatoLetti(adminView.getFrame(), this);
        popolaComboReparti();

        this.statoLettiView.getBtnIndietro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statoLettiView.visualizza(false);
                adminView.visualizza(true);
            }
        });

        this.statoLettiView.getCercaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciRicercaStatoLetti();
            }
        });

        this.statoLettiView.visualizza(true);
    }

    private void popolaComboReparti() {
        List<String> nomiReparti = new ArrayList<>();
                nomiReparti = Arrays.asList("Cardiologia", "Chirurgia Generale", "Medicina Generale");
            statoLettiView.popolaReparti(nomiReparti); //placeholder temporaneo, bisogna integrare il DAO.
    }

    private void gestisciRicercaStatoLetti() {
        String reparto = statoLettiView.getRepartoSelezionato();

        if (reparto.isEmpty()) {
            statoLettiView.mostraErrore("Selezionare un reparto valido dalla lista.");
            return;
        }

        String[] colonne = {"Codice Letto", "Stanza", "Reparto", "Stato"};
        DefaultTableModel tableModel = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int riga, int colonna) {
                return false;
            }
        };

        //DAO

        statoLettiView.getTabellaLetti().setModel(tableModel);
        statoLettiView.mostraMessaggio("Letti caricati per il reparto: " + reparto);
    }
    private void apriModificaEsito() {
        int rigaSelezionata = medicoView.getTabellaAgenda().getSelectedRow();

        if (rigaSelezionata == -1) {
            medicoView.mostraErrore("Seleziona una prestazione dalla tabella prima di modificare l'esito.");
            return;
        }

        this.modificaEsitoView = new ModificaEsito(medicoView.getFrame(), this);

        String idPrestazione = medicoView.getTabellaAgenda().getValueAt(rigaSelezionata, 0).toString();
        String cfPaziente = medicoView.getTabellaAgenda().getValueAt(rigaSelezionata, 1).toString();
        String tipo = medicoView.getTabellaAgenda().getValueAt(rigaSelezionata, 2).toString();
        Object valEsito = medicoView.getTabellaAgenda().getValueAt(rigaSelezionata, 4);
        String esitoAttuale = (valEsito != null) ? valEsito.toString() : "";

        this.modificaEsitoView.setPazienteInfo("Paziente: " + cfPaziente);
        this.modificaEsitoView.setDettagliPrestazione("Codice: " + idPrestazione + "\nTipo: " + tipo);
        this.modificaEsitoView.setEsito(esitoAttuale);

        this.modificaEsitoView.getAnnullaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificaEsitoView.visualizza(false);
            }
        });

        this.modificaEsitoView.getSalvaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciSalvataggioEsito();
            }
        });

        this.modificaEsitoView.visualizza(true);
    }

    private void gestisciSalvataggioEsito() {
        String nuovoEsito = modificaEsitoView.getEsito();

        if (nuovoEsito.isEmpty()) {
            modificaEsitoView.mostraErrore("Inserire il testo dell'esito prima di salvare.");
            return;
        }

        // DAO

        modificaEsitoView.mostraMessaggio("Esito aggiornato con successo!");
        modificaEsitoView.svuotaCampi();
        modificaEsitoView.visualizza(false);
    }
}
