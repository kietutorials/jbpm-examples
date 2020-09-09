package com.kietutorials;

import java.util.HashSet;
import java.util.Set;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;

import com.kietutorials.unit12_swagger_web_interface.Student;

public class KieUtil {

	String URL = "http://localhost:8080/kie-server/services/rest/server";
	String USERNAME = "wbadmin";
	String PASSWORD = "wbadmin";

	public KieServicesClient getKieServicesClient() {
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(URL, USERNAME, PASSWORD);
		config.setMarshallingFormat(MarshallingFormat.JSON);
		Set<Class<?>> set =new HashSet<Class<?>>();
		set.add(Student.class);
		config.addJaxbClasses(set);
		return KieServicesFactory.newKieServicesClient(config);
	}

}
