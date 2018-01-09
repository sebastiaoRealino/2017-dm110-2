package br.inatel.pos.mobile.dm110.mdb;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import javax.ejb.ActivationConfigProperty;
import br.inatel.pos.mobile.dm110.dao.IpAddressDAO;
import br.inatel.pos.mobile.dm110.entities.IpAddressList;
import br.inatel.pos.mobile.dm110.entities.IpAddressTO;
import br.inatel.pos.mobile.dm110.utils.PingExec;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType",
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination",
								  propertyValue = "java:/jms/queue/QueueIpAddress"),
		@ActivationConfigProperty(propertyName = "maxSession",
								  propertyValue = "3")
})

public class IpAddressMDB implements MessageListener{

	@EJB
	private IpAddressDAO dao;
	
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objMessage = (ObjectMessage) message;
				Object obj = objMessage.getObject();
				
				if (obj instanceof IpAddressList) {				
					
					String[] ipList = ((IpAddressList) obj).getList();

					System.out.println("antes do for");
					for (String singleIp : ipList) {
						if (singleIp != null && singleIp.length() > 0){						
							IpAddressTO ip = new IpAddressTO();
							ip.setIp(singleIp);
							ip.setStatus(PingExec.execPing(singleIp));	
							System.out.println(ip.getIp());
							ip.getStatus();
							dao.insert(ip);
						}
					}
				}
			}
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
