package Recipe;

public class Recipe {
	
	PricingService service = null;
	
	public Recipe(PricingService service) {
		this.service = service;
	}
	
	public double CalcPrice(Ingredient[] ingredients) {
		double totalPrice = 0;		
		Product[] products = service.GetPrices(ingredients);
		
		products = service.GetPrices(ingredients);
		
		for (Product product : products) {
			totalPrice += product.Price;
		}
		
		return totalPrice;
	}
}
