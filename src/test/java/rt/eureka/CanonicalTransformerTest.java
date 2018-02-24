package rt.eureka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rt.eureka.model.CanonicalTransformer;
import rt.eureka.model.CustomerCanonical;
import rt.eureka.model.WSCustomerVO;

public class CanonicalTransformerTest {

	private CanonicalTransformer cTransformer;
	private CustomerCanonical customerCanonical;
	private WSCustomerVO wsCustomerVO;
	
	
	@Before
	public void setUp(){
		cTransformer = new CanonicalTransformer();
		customerCanonical = new CustomerCanonical();
		customerCanonical.setAdress("to jest adres CC");
		customerCanonical.setId(1);
		customerCanonical.setName("CC ");
		customerCanonical.setYearOfBirth(1666);
		
		wsCustomerVO = new WSCustomerVO();
		wsCustomerVO.setCountry("POLAND");
	}
	
	@Test
	public void transformMethodTest() {
		assertNotNull(customerCanonical);
		WSCustomerVO result= cTransformer.transform(customerCanonical);
		assertEquals(result.getCountry(), wsCustomerVO.getCountry());
	
	}

}
