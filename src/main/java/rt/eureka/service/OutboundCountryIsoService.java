package rt.eureka.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import rt.eureka.webservices.country.GetISOCountryCodeByCountyNameResponse;

@Service
public class OutboundCountryIsoService {

	private static Log log = LogFactory.getLog(OutboundCountryIsoService.class);
	
	public void processResponseFromWS(GetISOCountryCodeByCountyNameResponse response){
		log.info("=====================================================================================");
		log.info("==="+Thread.currentThread().getName()+ " "+ Thread.currentThread().getId() +"=============outbound Adapter: "+response.getGetISOCountryCodeByCountyNameResult());
		log.info("=====================================================================================");
		
	}
}
