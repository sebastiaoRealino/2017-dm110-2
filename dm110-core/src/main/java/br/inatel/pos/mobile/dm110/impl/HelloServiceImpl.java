package br.inatel.pos.mobile.dm110.impl;

import br.inatel.pos.mobile.dm110.api.HelloService;
import br.inatel.pos.mobile.dm110.api.Result;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "<h1>Hello " + name + "!!!</h1>";
	}

	@Override
	public Result buildMessage(String first, String last) {
		String message = "Hello " + first + " " + last + "!!!";
		Result result = new Result();
		result.setFirstName(first);
		result.setLastName(last);
		result.setMessage(message);
		return result;
	}

}
