package rt.eureka.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import rt.eureka.webservices.country.GetISOCountryCodeByCountyName;

@Component("wSCustomerVOToContryISOTransformer")
public class WSCustomerVOToContryISOTransformer {

	private static Log log = LogFactory.getLog(WSCustomerVOToContryISOTransformer.class);
	
	public GetISOCountryCodeByCountyName transform(WSCustomerVO customerVO){
		
		GetISOCountryCodeByCountyName countryIso = new GetISOCountryCodeByCountyName();
		countryIso.setCountryName(customerVO.getCountry());
		log.debug("========================================" + countryIso.getCountryName());
		return countryIso;
		
	}
}
