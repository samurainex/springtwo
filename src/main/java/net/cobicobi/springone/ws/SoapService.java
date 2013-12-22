package net.cobicobi.springone.ws;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import net.cobicobi.springone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service("soapService")
@WebService(serviceName="SoapService")
public class SoapService {

	@Resource
	private WebServiceContext wsContext;
	
	@Autowired
	private UserService userService;

	@WebMethod
	public String getAllUser() {
		Gson gson = new Gson();
		return gson.toJson(userService.getAll());
	}

	@WebMethod
	public String getUser(Long id) {
		Gson gson = new Gson();
		return gson.toJson(userService.get(id));
	}

}
