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
    
    public void ajouterEvenement(Evenement e) {
        listeEvenements.ajouterSiPasDeConflit(e);
    }
    
    public void afficherEvenements() {
        listeEvenements.afficherEvenements();
    }
    
    public void obtenirEvenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Evenement> events = listeEvenements.evenementsDansPeriode(debut, fin);
        listeEvenements.affichageConflit(events);
    }
    
    public void supprimerEvenement(EventId id) {
        listeEvenements.supprimerEvenement(id);
    }
}
