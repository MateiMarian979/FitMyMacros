import java.util.ArrayList;

public class Service {
    private Repo repo ;

    public Service(Repo r){
        repo = r ;
    }
    /*
    At first I wanted to do the search by using a binary search but I realized that 
    in the function getRecipe I have to use the function searchByIndex which already
    has a complexity of O(n) because I read again the elements from the vector

    public static int findClosestRecipeIndex(ArrayList<Recipe> list, int target) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Input list is null or empty");
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = list.get(mid).getCalories();

            if (midElement == target) {
                return midElement; // Found an exact match
            }

            if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // At this point, low is greater than high
        // Determine the closest element by comparing the elements at low and high
        if (low < list.size() && (high < 0 || Math.abs(list.get(low).getCalories() - target) < Math.abs(list.get(high).getCalories() - target))) {
            return low;
        } else {
            return high;
        }
    }
        */
    /**
     * This function returns the first food that has more calories than the required ones
     * @param calories = required calories
     * @param list = the list of available recipes
     * @return
     */
    public int getIndexRecipe(int calories, ArrayList<Recipe> list){
        for(Recipe r: list){
            if(r.getCalories() > calories)
                return list.indexOf(r)-1;
        }
        return list.size()-1;
    }
    /**
     * This function returns the score of a recipe 
     * A food has a bigger score if it has lower calories and more proteins
     * The formula is: protein/calories to get the one with the highest concentration of protein 
     * @return
     */
    public float getScore(Recipe r){
        return (float)r.getProtein()/(float)r.getCalories();
    }
    /**
     * This function compares the 5 lower calories (than the amount required) recipes
     *  to get the one with the most amount of proteins/calories. 
     * @param r
     * @return
     */
    public String getRecipe(int calories){
        ArrayList<Recipe> list = repo.getAll();
        int startIndex = getIndexRecipe(calories, list);
        float bestScore = -1; // the best score of the 5 lower calorie recipes
        int bestIndex = 0;// bestIndex = the index of the recipe that has the highest concentration of prot/cal
        for(int i = startIndex; i >= startIndex-5 && i >= 0; i--)
            if(getScore(list.get(i)) > bestScore)
                {bestScore = getScore(list.get(i)); bestIndex = i;}
           
        return list.get(bestIndex).toString();
    }

}
