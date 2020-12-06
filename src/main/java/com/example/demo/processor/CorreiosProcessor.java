package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.com.correios.bsb.sigep.master.bean.cliente.ConsultaCEPResponse;


public class CorreiosProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		ConsultaCEPResponse response = exchange.getIn().getBody(ConsultaCEPResponse.class);
		System.out.println(response.getReturn());
	}
	
}
