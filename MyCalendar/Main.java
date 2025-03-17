import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;

import Evenements.*;
import Evenements.TypeEvenements.*;
import Main.*;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateur = null;
        boolean continuer = true;
        
        Utilisateurs gestionUtilisateurs = new Utilisateurs();

        while (true) {
            if (utilisateur == null) {
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println("| |_____| (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println("                                                                                   __/ |");
                System.out.println("                                                                                  |___/");

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.print("Choix : ");

                String choix = scanner.nextLine();
                switch (choix) {
                    case "1":
                        System.out.print("Nom d'utilisateur: ");
                        String nomUtilisateur = scanner.nextLine();
                        System.out.print("Mot de passe: ");
                        String motDePasse = scanner.nextLine();

                        if (gestionUtilisateurs.validerUtilisateur(nomUtilisateur, motDePasse)) {
                            utilisateur = gestionUtilisateurs.getUtilisateur(nomUtilisateur);
                        } else {
                            System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
                        }
                        break;

                    case "2":
                        System.out.print("Nom d'utilisateur: ");
                        String nouveauNom = scanner.nextLine();
                        System.out.print("Mot de passe: ");
                        String nouveauMotDePasse = scanner.nextLine();
                        System.out.print("Répéter mot de passe: ");
                        if (scanner.nextLine().equals(nouveauMotDePasse)) {
                            gestionUtilisateurs.ajouterUtilisateur(new Utilisateur(nouveauNom), new MotDePasse(nouveauMotDePasse));
                            System.out.println("Compte créé avec succès.");
                        } else {
                            System.out.println("Les mots de passe ne correspondent pas.");
                        }
                        break;
                }
            }

            while (utilisateur != null && continuer) {
                System.out.println("\nBonjour, " + utilisateur.nom());
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        // Affichage des événements
                        calendar.afficherEvenements();
                        break;

                    case "2":
                        // Ajouter un rendez-vous
                        ajouterRdv(scanner, calendar, utilisateur);
                        break;

                    case "3":
                        // Ajouter une réunion
                        ajouterReunion(scanner, calendar, utilisateur);
                        break;

                    case "4":
                        // Ajouter un événement périodique
                        ajouterEvenementPeriodique(scanner, calendar, utilisateur);
                        break;

                    case "5":
                        utilisateur = null;
                        System.out.println("Déconnexion réussie.");
                        break;
                }
            }
        }
    }

    private static void ajouterRdv(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(utilisateur.nom());
        DateDebutEvenement dateDebutEvenement = new DateDebutEvenement(LocalDateTime.of(annee, mois, jour, heure, minute));
        DureeMinutesEvenement dureeMinutesEvenement = new DureeMinutesEvenement(duree);
        LieuEvenement lieuEvenement = new LieuEvenement(lieu);
        ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(Collections.singletonList(""));
        FrequenceJoursEvenement frequenceJoursEvenement = new FrequenceJoursEvenement(0);
        TypeEvenement typeEvenement = TypeEvenement.RDV_PERSONNEL;

        calendar.ajouterEvenement(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeMinutesEvenement,
                lieuEvenement, participantsEvenement, frequenceJoursEvenement, typeEvenement);
        System.out.println("Événement ajouté.");
    }
    
    private static void ajouterReunion(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        // Demander les informations à l'utilisateur
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();
        
        // Ajouter un participant initial (l'utilisateur actuel)
        String participants = utilisateur.nom();
        
        // Ajouter d'autres participants
        boolean encore = true;
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.print("Nom du participant : ");
            participants += ", " + scanner.nextLine();
        }
        
        // Création des Value Objects
        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(utilisateur.nom());
        DateDebutEvenement dateDebutEvenement = new DateDebutEvenement(LocalDateTime.of(annee, mois, jour, heure, minute));
        DureeMinutesEvenement dureeMinutesEvenement = new DureeMinutesEvenement(duree);
        LieuEvenement lieuEvenement = new LieuEvenement(lieu);
        ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(Collections.singletonList(participants));
        FrequenceJoursEvenement frequenceJoursEvenement = new FrequenceJoursEvenement(0);
        TypeEvenement typeEvenement = TypeEvenement.REUNION;
        
        // Ajouter l'événement au calendrier
        calendar.ajouterEvenement(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeMinutesEvenement,
                lieuEvenement, participantsEvenement, frequenceJoursEvenement, typeEvenement);
        
        System.out.println("Réunion ajoutée.");
    }
    
    
    private static void ajouterEvenementPeriodique(Scanner scanner, CalendarManager calendar, Utilisateur utilisateur) {
        // Demander les informations à l'utilisateur
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Fréquence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();
        
        // Création des Value Objects
        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(utilisateur.nom());
        DateDebutEvenement dateDebutEvenement = new DateDebutEvenement(LocalDateTime.of(annee, mois, jour, heure, minute));
        DureeMinutesEvenement dureeMinutesEvenement = new DureeMinutesEvenement(0);
        LieuEvenement lieuEvenement = new LieuEvenement(lieu);
        ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(Collections.singletonList(""));
        FrequenceJoursEvenement frequenceJoursEvenement = new FrequenceJoursEvenement(frequence);
        TypeEvenement typeEvenement = TypeEvenement.PERIODIQUE;
        
        // Ajouter l'événement périodique au calendrier
        calendar.ajouterEvenement(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeMinutesEvenement,
                lieuEvenement, participantsEvenement, frequenceJoursEvenement, typeEvenement);
        
        System.out.println("Événement périodique ajouté.");
    }

}
