package rt.eureka.model;

public class CanonicalTransformer {

	
	public WSCustomerVO transform (CustomerCanonical customerCanonical){
		
		 WSCustomerVO wsCustomerVO= new WSCustomerVO();
		wsCustomerVO.setCountry(customerCanonical.getAdress());
		wsCustomerVO.setCountry("POLAND");
		return wsCustomerVO;
		
	}
}
