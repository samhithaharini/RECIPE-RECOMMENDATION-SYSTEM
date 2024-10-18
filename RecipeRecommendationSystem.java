import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Recipe {
    private String name;
    private String ingredients;
    private String cookingSteps; // New field for cooking steps

    public Recipe(String name, String ingredients, String cookingSteps) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps; // Initialize cooking steps
    }

    public String getName() {
        return name;
    }

    public int countMatchingIngredients(String userInput) {
        String[] userIngredients = userInput.split(",\\s*");
        int matchCount = 0;
        List<String> missingIngredients = new ArrayList<>();

        List<String> userIngredientList = new ArrayList<>();
        for (String ingredient : userIngredients) {
            userIngredientList.add(ingredient.toLowerCase());
        }

        for (String ingredient : userIngredientList) {
            if (ingredients.toLowerCase().contains(ingredient)) {
                matchCount++;
                System.out.println("Matching Ingredient Found: " + ingredient);
            }
        }

        String[] recipeIngredients = ingredients.split(",");
        for (String ingredient : recipeIngredients) {
            String trimmedIngredient = ingredient.trim().toLowerCase();
            if (!userIngredientList.contains(trimmedIngredient)) {
                missingIngredients.add(trimmedIngredient);
            }
        }

        if (matchCount == 0) {
            System.out.println("No matching ingredients for recipe: " + name);
        } else {
            System.out.println("Recipe: " + name + " has " + matchCount + " matching ingredients.");
            if (!missingIngredients.isEmpty()) {
                System.out.println("Missing ingredients for " + name + ": " + String.join(", ", missingIngredients));
            }
        }

        return matchCount;
    }

    public String getCookingSteps() {
        return cookingSteps; // Method to get cooking steps
    }
}

public class RecipeRecommendationSystem {
    public static void main(String[] args) {
        List<Recipe> recipes = new ArrayList<>();
        // Add recipes with cooking steps
        recipes.add(new Recipe("Tomato Rice", "rice,tomato,spices", "1. Cook rice. 2. Add tomatoes and spices. 3. Cook until done."));
        recipes.add(new Recipe("Pongal", "rice,dhaal,pepper,ginger", "1. Cook rice and dhaal together. 2. Add pepper and ginger. 3. Serve hot."));
        recipes.add(new Recipe("Tomato Chutney", "tomato,onion,spices", "1. Cook tomatoes and onions. 2. Blend with spices. 3. Serve with snacks."));
        recipes.add(new Recipe("Idli", "rice,urad dal,fermented batter", "1. Prepare fermented batter. 2. Steam in idli maker. 3. Serve with chutney."));
        recipes.add(new Recipe("Dosa", "rice,urad dal,fermented batter", "1. Prepare fermented batter. 2. Spread on a hot griddle. 3. Cook until crispy."));
        recipes.add(new Recipe("Curd Rice", "rice,curd,salt", "1. Cook rice. 2. Mix with curd and salt. 3. Serve chilled."));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ingredients (comma-separated): ");
        String userInput = scanner.nextLine();
        scanner.close();

        int minIngredientsRequired = 1;

        System.out.println("Recommended Recipes:");
        for (Recipe recipe : recipes) {
            int matchingCount = recipe.countMatchingIngredients(userInput);
            if (matchingCount >= minIngredientsRequired) {
                System.out.println(recipe.getName() + " (Matches: " + matchingCount + ")");
                System.out.println("Cooking Steps: " + recipe.getCookingSteps());
            }
        }
    }
}
