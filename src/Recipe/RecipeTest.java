package Recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class RecipeTest {

	@Test
	void test() {
		PricingServiceStub stub = new PricingServiceStub();
		Recipe cut = new Recipe(stub);
		
		stub.products.add(new Product(1, 10));
		stub.products.add(new Product(2, 110));
		
		assertEquals(120, cut.CalcPrice(new Ingredient[0]));
	}
	
	@Test
	void test1() {
		PricingService mockService = mock(PricingService.class);
		Recipe cut = new Recipe(mockService);
		
		when( mockService.GetPrices(new Ingredient[0]))
		.thenReturn(new Product[] {new Product(1, 10), new Product(1, 110)});
		
		assertEquals(120, cut.CalcPrice(new Ingredient[0]));
	}	

}
