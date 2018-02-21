package rt.eureka.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import rt.eureka.model.CustomerCanonical;
import rt.eureka.model.WSCustomerVO;

@Service
public class InboundService {

	
	private static Log log = LogFactory.getLog(InboundService.class);
	
	public void processInput(WSCustomerVO message){
		
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		        Date date = new Date();
		        log.debug("*******"+Thread.currentThread().getName()+ " "+ Thread.currentThread().getId() );
		        log.info("***********************"+InboundService.class.getName() + "**************************");
				log.info("*************"+ message + " as of "+sdf.format(date)+" ***********  " );
				log.info("************************************************************************************");
		
	}
}
