package rt.eureka.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import rt.eureka.model.WSCustomerVO;

@Service
public class DrugiServiceActivatorDoPublishSubsriber {

	private static  final Log log = LogFactory.getLog(DrugiServiceActivatorDoPublishSubsriber.class);
	
	public void processMessage(WSCustomerVO wsCustomerVO){
		String payload = wsCustomerVO.getCountry();
		payload = payload.concat(" alholand");
		log.info(payload);
	}
}
