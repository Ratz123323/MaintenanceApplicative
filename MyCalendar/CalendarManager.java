import Evenements.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private List<Event> events;
    
    public CalendarManager() {
        this.events = new ArrayList<>();
    }
    
    // Méthode pour ajouter un événement
    public void ajouterEvent(TitreEvenement titre, ProprietaireEvenement proprietaire, DateDebutEvenement dateDebut,
                             DureeMinutesEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                             FrequenceJoursEvenement frequenceJours, TypeEvenement type) {
        Event e = new Event(titre, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours, type);
        events.add(e);
    }
    
    // Méthode pour obtenir les événements dans une période donnée
    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.getType() == TypeEvenement.PERIODIQUE) {
                LocalDateTime temp = e.getDateDebut().getDateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.getFrequenceJours().getFrequenceJours());
                }
            } else if (!e.getDateDebut().getDateDebut().isBefore(debut) && !e.getDateDebut().getDateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }
    
    // Méthode pour vérifier si deux événements se chevauchent
    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.getDateDebut().getDateDebut().plusMinutes(e1.getDureeMinutes().getDureeMinutes());
        LocalDateTime fin2 = e2.getDateDebut().getDateDebut().plusMinutes(e2.getDureeMinutes().getDureeMinutes());
        
        if (e1.getType() == TypeEvenement.PERIODIQUE || e2.getType() == TypeEvenement.PERIODIQUE) {
            return false; // Simplification abusive
        }
        
        if (e1.getDateDebut().getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getDateDebut().getDateDebut())) {
            return true;
        }
        return false;
    }
    
    // Méthode pour afficher tous les événements
    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e);
        }
    }
}
