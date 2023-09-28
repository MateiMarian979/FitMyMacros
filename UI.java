import java.util.Scanner;

import org.hamcrest.core.IsInstanceOf;

public class UI {
    private Service serv;

    public UI(Service serv){
        this.serv = serv;
    }
    public void showMenu(){
        System.out.println("Welcome to FitMyMacros ! This is an app dedicated to \n fitness enthusiasts who are trying to find a high protein \n low calorie recipe that matches their left amount of calories !");
        System.out.println("Type 1 to start using our app , 2 to end tne execution of the program");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        if(option == 1)
            showRecipe();
        else
            {
                System.out.println("The execution of the program has ended");
                return ;
            }
    }

    public void showRecipe(){
        while(true){
        System.out.println("In order to find a recipe that fits you , you have to \n introduce the amount of calories .");
        System.out.println("Calories: ");
        Scanner scan = new Scanner(System.in);
        var calories = scan.nextInt();
        System.out.println(calories);
        System.out.println(serv.getRecipe(calories));
        }
    }
}
