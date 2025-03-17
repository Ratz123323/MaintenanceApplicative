import Evenements.*;

public class Event {
    private TitreEvenement titre;
    private ProprietaireEvenement proprietaire;
    private DateDebutEvenement dateDebut;
    private DureeMinutesEvenement dureeMinutes;
    private LieuEvenement lieu;
    private ParticipantsEvenement participants;
    private FrequenceJoursEvenement frequenceJours;
    private TypeEvenement type;
    
    // Constructeur pour tous les types d'événements
    public Event(TitreEvenement titre, ProprietaireEvenement proprietaire, DateDebutEvenement dateDebut,
                 DureeMinutesEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                 FrequenceJoursEvenement frequenceJours, TypeEvenement type) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
        this.type = type;
    }
    
    // Méthode pour décrire l'événement en fonction du type
    public String description() {
        StringBuilder desc = new StringBuilder();
        if (type == TypeEvenement.RDV_PERSONNEL) {
            desc.append("RDV : ").append(titre).append(" à ").append(dateDebut);
        } else if (type == TypeEvenement.REUNION) {
            desc.append("Réunion : ").append(titre).append(" à ").append(lieu).append(" avec ").append(participants);
        } else if (type == TypeEvenement.PERIODIQUE) {
            desc.append("Événement périodique : ").append(titre).append(" tous les ").append(frequenceJours);
        }
        return desc.toString();
    }
    
    // Getter et Setter pour chaque attribut
    public TitreEvenement getTitre() {
        return titre;
    }
    
    public ProprietaireEvenement getProprietaire() {
        return proprietaire;
    }
    
    public DateDebutEvenement getDateDebut() {
        return dateDebut;
    }
    
    public DureeMinutesEvenement getDureeMinutes() {
        return dureeMinutes;
    }
    
    public LieuEvenement getLieu() {
        return lieu;
    }
    
    public ParticipantsEvenement getParticipants() {
        return participants;
    }
    
    public FrequenceJoursEvenement getFrequenceJours() {
        return frequenceJours;
    }
    
    public TypeEvenement getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return description();
    }
}
