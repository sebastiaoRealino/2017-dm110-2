package br.inatel.pos.mobile.dm110.ejb;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;


import br.inatel.pos.mobile.dm110.dao.IpAddressDAO;
import br.inatel.pos.mobile.dm110.entities.IpAddressList;
import br.inatel.pos.mobile.dm110.interfaces.IpAddressLocalInterface;
import br.inatel.pos.mobile.dm110.interfaces.IpAddressRemoteInterface;
import br.inatel.pos.mobile.dm110.utils.NetworkIpGen;

@Stateless
@Remote(IpAddressRemoteInterface.class)
@Local(IpAddressLocalInterface.class)
public class IpAddressBean implements IpAddressRemoteInterface, IpAddressLocalInterface {

	@EJB
	private IpAddressDAO dao;
	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/QueueIpAddress")
	private Queue queue;
	@Override
	public void getIpAddress(String ipAddress, String mask) {
		System.out.println( "DEBUG 1 "+ipAddress+" "+ mask);
		String ip[] = NetworkIpGen.generateIps(ipAddress, Integer.parseInt(mask));
		System.out.println( "DEBUG 2 "+ipAddress+" "+ Integer.parseInt(mask));	
		try (
				Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);
		) {
			ObjectMessage objMessage = session.createObjectMessage();
			String[] lastSent = new String[10];
			int cont = 0;

			for (String singleIp : ip) {
				System.out.println(cont);
				if (cont == 9) {
					lastSent[cont] = singleIp;
					IpAddressList ipListSerializable = new IpAddressList();
					ipListSerializable.setList(lastSent);
					objMessage.setObject(ipListSerializable);
					producer.send(objMessage);
					lastSent = new String[10];
					cont = 0;
				} else {
					lastSent[cont] = singleIp;
					cont++;
				}
			}
			System.out.println( "DEBUG 3 FIM TRY ");		
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public String getIpAddressStatus(String ip) {
		return dao.checkStatus(ip);
	}

}
