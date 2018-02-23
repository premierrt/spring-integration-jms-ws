package rt.eureka;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rt.eureka.service.InboundService;
import rt.eureka.model.WSCustomerVO;

public class InboundServiceTest {

	
	InboundService inboundService;
	
	@Mock
	WSCustomerVO wsCustomerVo;
	
	
	@Before
	public void setUp(){
		 inboundService = new InboundService();
         MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void testProcessInput() {
		//Mock jest pusty obiektem, trzeba opisac co ma być zwracane przy wywolaniu danej metody
		when(wsCustomerVo.toString()).thenReturn("Zamockowany toString z mocka");
		inboundService.processInput(wsCustomerVo);
		Mockito.verify(wsCustomerVo, Mockito.atLeast(1));
	
	
	}

}
