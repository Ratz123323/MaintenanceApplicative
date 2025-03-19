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
        
        boolean conflit = false;
        
        for (Evenement event : listeEvenements.obtenirEvenements()){
            if(verifierConflit(e, event)){
                conflit = true;
                System.out.println("Conflit avec l'événement suivant : " + event);
                break;
            }
        }
        if(!conflit){
            listeEvenements.ajouterEvenement(e);
        }
    }
    
    public void afficherEvenements() {
        listeEvenements.afficherEvenements();
    }
    
    public boolean verifierConflit(Evenement e1, Evenement e2) {
        return listeEvenements.conflit(e1, e2);
    }
    
    public void obtenirEvenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Evenement> events = listeEvenements.evenementsDansPeriode(debut, fin);
        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé.");
        } else {
            for (Evenement e : events) {
                System.out.println(e);
            }
        }
    }
}
