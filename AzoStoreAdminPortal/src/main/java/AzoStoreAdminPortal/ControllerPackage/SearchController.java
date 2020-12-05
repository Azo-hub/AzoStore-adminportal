package AzoStoreAdminPortal.ControllerPackage;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AzoStoreAdminPortal.ModelPackage.Product;
import AzoStoreAdminPortal.ServicePackage.ProductService;


@Controller
public class SearchController {
	
	//@Autowired
	//private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	//@GetMapping("/searchByCategory")
	//public String searchByCategory (
		//	@RequestParam("category") String category,
			//Model model, Principal principal) {
		
		//if(principal != null) {
			//String username = principal.getName();
			//User user = userService.findByUsername(username);
			//model.addAttribute("user", user);
		//}
		
		//String classActiveCategory = "active" + category;
		//classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		//classActiveCategory = classActiveCategory.replaceAll("&", "");
		//model.addAttribute(classActiveCategory, true);
		
		//List<Product> productList = productService.findByCategory(category);
		
		//if (productList.isEmpty()) {
			//model.addAttribute("emptyList", true);
			
			//return "productshelf";
		//}
		
		//model.addAttribute("productList", productList);
		
		//return "productshelf";
	//}
	
	
	
	@PostMapping ("/searchProduct")
	public String searchProduct(
			@ModelAttribute ("keyword") String keyword,
			Principal principal, Model model) {
		
		//if(principal != null) {
			//String username = principal.getName();
			//User user = userService.findByUsername(username);
			//model.addAttribute("user", user);
			
		//}
		
		List <Product> productList = productService.blurrySearch(keyword);
		
		if(productList.isEmpty()) {
			model.addAttribute("emptyList", true);
			
			return "home";
		}
		
		model.addAttribute("productList", productList);
		
		return "productList";
	}

}
