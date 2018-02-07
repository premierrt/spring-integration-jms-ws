package rt.eureka.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class InboundService {

	
	public void processInput(String message){
		
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		        Date date = new Date();
				System.out.println("*************"+ message + " as of "+sdf.format(date)+" ***********  " );
		
	}
}
