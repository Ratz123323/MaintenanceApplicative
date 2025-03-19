package State;

import Evenements.*;
import Evenements.TypeEvenements.TypeEvenement;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    private final ListeEvenements listeEvenements;
    
    public CalendarManager() {
        this.listeEvenements = new ListeEvenements();
    }
    
    public void ajouterEvenement(TitreEvenement titre, ProprietaireEvenement proprietaire, DateDebutEvenement dateDebut,
                                 DureeMinutesEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                                 FrequenceJoursEvenement frequenceJours, TypeEvenement type, PresentateurEvenement presentateur) {
        Evenement e = new Evenement(titre, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours, type, presentateur);
        
        listeEvenements.ajouterSiPasDeConflit(e);
    }
    
    public void afficherEvenements() {
        listeEvenements.afficherEvenements();
    }
    
    public void obtenirEvenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Evenement> events = listeEvenements.evenementsDansPeriode(debut, fin);
        listeEvenements.affichageConflit(events);
    }
}
