package AzoStoreAdminPortal.ControllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPortalHomeController {
	
	@GetMapping("/")
	public String adminHome() {
		
		return "home";
	}
	
	
	@GetMapping("/login")
	public String adminlogin() {
		
		return "login";
	}
	

}
