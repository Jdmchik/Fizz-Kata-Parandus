package Parandus;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

public class IpValidateTests {

	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		IpValidate validator= new IpValidate();
		assertFalse(validator.ValidateIpv4Address(""));
	}
}
