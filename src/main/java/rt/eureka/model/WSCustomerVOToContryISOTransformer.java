package rt.eureka.model;

import org.springframework.stereotype.Component;

import rt.eureka.webservices.country.GetISOCountryCodeByCountyName;

@Component("wSCustomerVOToContryISOTransformer")
public class WSCustomerVOToContryISOTransformer {

	
	public GetISOCountryCodeByCountyName transform(WSCustomerVO customerVO){
		
		GetISOCountryCodeByCountyName countryIso = new GetISOCountryCodeByCountyName();
		countryIso.setCountryName(customerVO.getCountry());
		//System.out.println("========================================" + countryIso.getCountryName());
		return countryIso;
		
	}
}
