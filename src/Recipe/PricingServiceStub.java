package Recipe;

import java.util.ArrayList;

public class PricingServiceStub extends PricingService {
	ArrayList<Product> products = null;
	
	PricingServiceStub() {
		products = new ArrayList<Product>();
	}
	
	@Override
	Product[] GetPrices(Ingredient[] ingredients) {		
		Product[] prodArr = new Product[products.size()];
		return products.toArray(prodArr);
	}
}
