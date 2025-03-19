package Evenements;

import Evenements.TypeEvenements.*;

import java.util.Map;

public record Evenement(TitreEvenement titre, ProprietaireEvenement proprietaire, DateDebutEvenement dateDebut,
                        DureeMinutesEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                        FrequenceJoursEvenement frequenceJours, TypeEvenement type, PresentateurEvenement presetateur) {
    
    // Mappage des types d'événements à leurs descriptions
    private static final Map<TypeEvenement, EvenementDescription> descriptions = Map.of(
            TypeEvenement.RDV_PERSONNEL, new RdvPersonnelDescription(),
            TypeEvenement.REUNION, new ReunionDescription(),
            TypeEvenement.CONFERENCE, new ConferenceDescription(),
            TypeEvenement.PERIODIQUE, new PeriodiqueDescription()
    );
    
    // Méthode pour obtenir la description de l'événement
    public String description() {
        EvenementDescription evenementDescription = descriptions.get(type);
        return evenementDescription.description(this);
    }
    
    @Override
    public String toString() {
        return description();
    }
}
