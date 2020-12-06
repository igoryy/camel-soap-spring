package com.example.demo.route;

import br.com.correios.bsb.sigep.master.bean.cliente.ConsultaCEP;

public class GetCep {
	public ConsultaCEP consultaCEP(String cep) {
		ConsultaCEP req = new ConsultaCEP();
		
		req.setCep(cep);
		
		return req;
	}
}
