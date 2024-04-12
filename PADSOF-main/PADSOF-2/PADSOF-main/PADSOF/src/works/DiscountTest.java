package works;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiscountTest {

	@Test
	void testDiscount() {
		int disc = 50;
		Discount d = new Discount(disc);
		assertEquals(disc, d.getDiscount());
	}

	@Test
	void testCalculatePrice() {
		Discount d = new Discount(50);
		assertEquals(25, d.calculatePrice(50));
	}

}
