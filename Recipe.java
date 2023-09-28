public class Recipe {
    private String name;
    private String description;
    private int protein;
    private int carbs;
    private int fat;
    private int calories;

    public Recipe(String name, String description, int protein, int carbs, int fat, int calories){
        this.calories = calories;
        this.carbs = carbs; 
        this.description = description;
        this.fat = fat;
        this.name = name;
        this.protein = protein;
    }

     public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     public int getProtein() {
        return this.protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return this.carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return this.fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true ;

        if(obj == null)
            return false;

        if(!(obj instanceof Recipe))
            return false;

        Recipe r =(Recipe) obj;
        
        return (r.getProtein() == this.protein && r.getCarbs() == this.carbs && r.getFat() == this.fat && r.getCalories() == this.calories
                        && r.getDescription().equals(this.description) && r.getName().equals(this.name));
    }

    public String toString(){
        return this.name + " " + this.description + " " +  this.calories + " " + this.protein + " " + this.carbs + " " + this.fat ;
    }
    
}
