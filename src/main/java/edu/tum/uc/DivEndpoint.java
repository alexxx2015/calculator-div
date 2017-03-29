package edu.tum.uc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.tum.cal.div.DivNumbersRequest;
import edu.tum.cal.div.DivNumbersResponse;

@Endpoint
public class DivEndpoint {
	private static final String NAMESPACE_URI = "http://div.cal.tum.edu";
	
	private DivServiceImpl addService = null;
	
	@Autowired
	public DivEndpoint(DivServiceImpl addService){
		this.addService = addService;
	}
	
	@PayloadRoot(localPart = "DivNumbersRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public DivNumbersResponse add(@RequestPayload DivNumbersRequest numbers){
		DivNumbersResponse _return = new DivNumbersResponse();
		double r = this.addService.div(Double.parseDouble(numbers.getN1()), Double.parseDouble(numbers.getN2()));
		_return.setN1(String.valueOf(r));
		return _return;
	}
}
