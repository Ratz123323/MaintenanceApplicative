import Evenements.*;
import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    private ListeEvenements listeEvenements;
    
    public CalendarManager() {
        this.listeEvenements = new ListeEvenements();
    }
    
    public void ajouterEvenement(TitreEvenement titre, ProprietaireEvenement proprietaire, DateDebutEvenement dateDebut,
                                 DureeMinutesEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                                 FrequenceJoursEvenement frequenceJours, TypeEvenement type) {
        Event e = new Event(titre, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours, type);
        listeEvenements.ajouterEvenement(e);
    }
    
    public void afficherEvenements() {
        listeEvenements.afficherEvenements();
    }
    
    public boolean verifierConflit(Event e1, Event e2) {
        return listeEvenements.conflit(e1, e2);
    }
    
    public List<Event> obtenirEvenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return listeEvenements.evenementsDansPeriode(debut, fin);
    }
}
