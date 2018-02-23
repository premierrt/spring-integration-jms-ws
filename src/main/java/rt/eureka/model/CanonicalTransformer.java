package rt.eureka.model;

import org.springframework.stereotype.Component;


public class CanonicalTransformer {

	
	public WSCustomerVO transform (CustomerCanonical customerCanonical){
		System.out.println("================="+CanonicalTransformer.class.getName());
		System.out.println("=============="+Thread.currentThread().getName()+ " "+ Thread.currentThread().getId() );
		 WSCustomerVO wsCustomerVO= new WSCustomerVO();
		wsCustomerVO.setCountry(customerCanonical.getAdress());
		wsCustomerVO.setCountry("POLAND");
		return wsCustomerVO;
		
	}
}
