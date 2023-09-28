import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        Repo repo = new Repo("listOfRecipes.txt");
        Service serv = new Service(repo);
        UI ui = new UI(serv);
        /*
        Tests t = new Tests();
        t.testRepo();
        t.testService();
        */
        ui.showMenu();
    }
}
