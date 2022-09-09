package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	@Test
	public  void hardAssertion() {
		
		Assert.assertEquals("welcome", "welcome");
		Assert.assertNotEquals("samdip", "rama");
		System.out.println("both are pass");
		Assert.assertTrue(true, null);
	}
}