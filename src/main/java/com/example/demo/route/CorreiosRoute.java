package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

import com.example.demo.processor.CorreiosProcessor;

@Component
public class CorreiosRoute extends RouteBuilder{

			@Override
			public void configure() throws Exception {
		
				
				from("timer://foo?delay=1000&repeatCount=1")
				.id("route-soap")
				.log("Iniciando")
					.bean(GetCep.class)
					.setBody(constant("03576160"))
					
					.setHeader("operationName", constant("consultaCEP"))
					.setHeader("operationNamespace", constant("http://cliente.bean.master.sigep.bsb.correios.com.br/"))
			
					.to("cxf://https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente"
							+"?serviceClass=br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente"
							
						+ "&wsdlURL=/wsdl/correios.wsdl")

					.process(new CorreiosProcessor()).log("${body}"); 
					
			
					
			}
}
