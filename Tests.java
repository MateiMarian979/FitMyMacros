import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests{

    @Test
    public void testRepo(){
        Repo r = new Repo("listOfRecipesTest.txt");
        Recipe searchedRecipe = new Recipe("Beef and Broccoli Stir-Fry","Savory stir-fry with beef and broccoli",30,25,12,380);
        r.readFromFile();
        if(r.size()!=0)
        assertEquals(searchedRecipe, r.searchByIndex(19));
    }

    @Test
    public void testService(){
        Repo repo = new Repo("listOfRecipes.txt");
        Service serv = new Service(repo);
        repo.readFromFile();
        if(repo.size()!=0)
        assertEquals(serv.getRecipe(401).toString(),"Salmon with Avocado Salsa Grilled salmon topped with avocado salsa 400 35 10 20");
    }

}