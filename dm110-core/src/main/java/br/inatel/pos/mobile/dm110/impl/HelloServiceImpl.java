package br.inatel.pos.mobile.dm110.impl;

import br.inatel.pos.mobile.dm110.api.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "<h1>Hello " + name + "!!!</h1>";
	}

}
