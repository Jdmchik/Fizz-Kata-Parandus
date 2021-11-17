package Parandus;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class IpValidateTests {

	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		IpValidate validator = new IpValidate();
		assertFalse(validator.ValidateIpv4Address(""));
	}
	@Test
	void ShouldBe_False_GivenStringWithThreeDots() {
		IpValidate validator = new IpValidate();
		assertTrue(validator.ValidateIpv4Address("1.2.3.4"));
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
	@Test
	void ShouldBe_False_GivenStringWithFourNumbersNotInRange0_255(){
		IpValidate validator = new IpValidate();
		assertFalse(validator.ValidateIpv4Address("1.2.3.257"));
		assertFalse(validator.ValidateIpv4Address("1.2.300.4"));
		assertFalse(validator.ValidateIpv4Address("1.256.3.4"));
		assertFalse(validator.ValidateIpv4Address("312.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenIPstartingWithZero() {
		IpValidate validator= new IpValidate();
		assertFalse(validator.ValidateIpv4Address("0.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenIPendingWithZero() {
		IpValidate validator= new IpValidate();
		assertFalse(validator.ValidateIpv4Address("1.2.3.0"));
	}
	@Test
	void ShouldBe_False_GivenIPstartingWith255() {
		IpValidate validator= new IpValidate();
		assertFalse(validator.ValidateIpv4Address("255.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenIPendingWith255() {
		IpValidate validator= new IpValidate();
		assertTrue(validator.ValidateIpv4Address("1.2.3.255"));
	}
}