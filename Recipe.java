public class Recipe {
    private String name;
    private String ingredients;

    public Recipe(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public boolean containsIngredients(String userIngredients) {
        String[] recipeIngredients = ingredients.split(", ");
        for (String ingredient : recipeIngredients) {
            if (userIngredients.toLowerCase().contains(ingredient.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
