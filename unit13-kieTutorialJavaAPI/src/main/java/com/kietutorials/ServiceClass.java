package com.kietutorials;

import java.util.HashMap;
import java.util.Map;

import org.kie.server.client.KieServicesClient;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.UserTaskServicesClient;

import com.kietutorials.unit12_swagger_web_interface.Student;

public class ServiceClass {

	public static void main(String[] args) {
		ServiceClass serviceClass = new ServiceClass();
		//serviceClass.startProcess();
		//serviceClass.startTask();
		serviceClass.completeTask();
		
	}

	public void startProcess() {
		KieUtil util = new KieUtil();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		ProcessServicesClient processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);

		Map<String, Object> map = new HashMap<String, Object>();
		Student st = new Student();
		st.setName("KIE TUTORIALS");
		map.put("student", st);
		Long id = processClient.startProcess("unit12-swagger_web_interface_1.0.0-SNAPSHOT",
				"unit12-swagger_web_interface.studentExamResult", map);
		System.out.println("Process id is:::" + id);
	}
	
	public void startTask() {
		KieUtil util = new KieUtil();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		UserTaskServicesClient userClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		userClient.startTask("unit12-swagger_web_interface_1.0.0-SNAPSHOT", 5L, "wbadmin");
		System.out.println("Task Start Succesful");
	}
	
	public void completeTask() {
		KieUtil util = new KieUtil();
		KieServicesClient kieServicesClient = util.getKieServicesClient();
		UserTaskServicesClient userClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
		Map<String, Object> map = new HashMap<String, Object>();
		Student st = new Student();
		st.setName("KIE TUTORIALS");
		st.setResult(true);
		map.put("student", st);		
		userClient.completeTask("unit12-swagger_web_interface_1.0.0-SNAPSHOT", 5L, "wbadmin", map);
	}

}
