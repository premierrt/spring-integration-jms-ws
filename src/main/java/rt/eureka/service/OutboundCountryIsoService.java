package rt.eureka.service;

import org.springframework.stereotype.Service;

import rt.eureka.webservices.country.GetISOCountryCodeByCountyNameResponse;

@Service
public class OutboundCountryIsoService {

	
	public void processResponseFromWS(GetISOCountryCodeByCountyNameResponse response){
		System.out.println("=====================================================================================");
		System.out.println("==="+Thread.currentThread().getName()+ " "+ Thread.currentThread().getId() +"=============outbound Adapter: "+response.getGetISOCountryCodeByCountyNameResult());
		System.out.println("=====================================================================================");
		
	}
}
