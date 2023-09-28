//this is the repository where we manage the recipes 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Repo {
    private ArrayList<Recipe> recipes;
    String filePath;

    public Repo(String filePath){
        recipes = new ArrayList<>();
        this.filePath = filePath;
    }

    public void orderRecipe(Recipe r){
        //readFromFile();
        int index=-1;
        if (recipes.size()==0)
            recipes.add(r);
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getCalories() > r.getCalories()) {
                index = i;
                break;
            }
        }
        
        if(index != -1)
            recipes.add(index, r);
        else
            recipes.add(r);
    }


    public void readFromFile() {
        recipes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 6) {
                    String name = values[0].trim();
                    String description = values[1].trim();
                    int protein = Integer.parseInt(values[2].trim());
                    int carbs = Integer.parseInt(values[3].trim());
                    int fat = Integer.parseInt(values[4].trim());
                    int calories = Integer.parseInt(values[5].trim());

                    Recipe r = new Recipe(name, description, protein, carbs, fat, calories);
                    orderRecipe(r);

                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void modifyRecipe(Recipe r){
        // we performed an override on equals to be able to use the method indexOf
        int index = recipes.indexOf(r);
        if(index == -1)
            throw  new ExceptionInInitializerError("This element does not exist");
        recipes.set(index, r);
    }

    public Recipe searchByIndex(int index){
        readFromFile();
        return recipes.get(index);
    }

    public int size(){
        return recipes.size();
    }
    
    public ArrayList<Recipe> getAll(){
        readFromFile();
        return recipes;
    }
}



