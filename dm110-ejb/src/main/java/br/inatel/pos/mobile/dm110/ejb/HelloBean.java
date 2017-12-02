package br.inatel.pos.mobile.dm110.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.interfaces.HelloLocal;
import br.inatel.pos.mobile.dm110.interfaces.HelloRemote;

@Stateless
@Local(HelloLocal.class)
@Remote(HelloRemote.class)
public class HelloBean implements HelloLocal, HelloRemote {

	@Override
	public String sayHello(String name) {
		System.out.println("#### Inside session bean...");
		return "Hello " + name + "!!!";
	}

}
