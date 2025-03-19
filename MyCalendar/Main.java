import java.util.Scanner;

import UsersInformations.Utilisateurs;
import State.AppState;
import State.CalendarManager;
import State.DisconnectedState;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utilisateurs gestionUtilisateurs = new Utilisateurs();
        CalendarManager calendar = new CalendarManager();
        AppState state = new DisconnectedState(gestionUtilisateurs, calendar);
        while (true) {
            state = state.run(scanner);
        }
    }
}
