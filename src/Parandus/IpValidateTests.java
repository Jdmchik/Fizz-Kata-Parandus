package Parandus;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class IpValidateTests {

	@Test
	void ShouldReturnTrue_GivenEmptyStringParameter() {
		IpValidate validator= new IpValidate();
		assertFalse(validator.ValidateIpv4Address(""));
	}
	@Test
	void ShouldBe_False_GivenStringWithThreeDots() {
		IpValidate validator = new IpValidate();
		assertTrue(validator.ValidateIpv4Address("..."));
	}
	@Test
	void ShouldReturnFourNumbersGivenStringWithThreeDots() {
		IpValidate validator = new IpValidate();
		int[] expected = {1,2,3,4};
		assertArrayEquals(expected,validator.getNumbers("1.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenStringWithThreeNumbersAndDots() {
		IpValidate validator = new IpValidate();
		assertFalse(validator.ValidateIpv4Address("1.2.3."));
	}
}
