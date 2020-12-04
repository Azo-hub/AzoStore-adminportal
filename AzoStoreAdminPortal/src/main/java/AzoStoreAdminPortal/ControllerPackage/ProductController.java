package AzoStoreAdminPortal.ControllerPackage;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 
import AzoStoreAdminPortal.ModelPackage.Product;
import AzoStoreAdminPortal.ServicePackage.ProductService;




@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/product/add")
	public String addProduct (Model model) {
		Product product = new Product();
		model.addAttribute("product", product);	
		
		return "addProduct";
	}
	
	
	
	
	@PostMapping("/product/add")
	public String addProduct (@ModelAttribute ("product") Product product, HttpServletRequest request) {
		
		product.setUploadTime(new Date());
		productService.save(product);
		
		MultipartFile productImage = product.getProductImage();
		
		try {
			byte[] bytes = productImage.getBytes();
			String name = product.getId()+".png";
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream (new File("src/main/resources/static/Images/product/"+name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		

		return "redirect:productList";
		
	}
	
	
	@GetMapping ("/product/productList")
	public String productList (Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		
		return "productList";
	}
	
	
	
	@GetMapping ("/productInfo/{id}")
	public String productInfo(@PathVariable(name = "id") Long id, Model model) {
	Product product = productService.getOne(id);
	model.addAttribute("product", product);
	
	
	return "productInfo";
	
}
	
	
	
@GetMapping ("/updateProduct/{id}")
	
	public String updateProduct(@PathVariable(name = "id") Long id, Model model) {
	Product product = productService.getOne(id);
	model.addAttribute("product", product);
	
	
	return "updateProduct";
	
}


@PostMapping ("/updateProduct")
public String updateProductPost (@ModelAttribute ("product") Product product, HttpServletRequest request) {
	
	productService.save(product);
	
	MultipartFile productImage = product.getProductImage();
	
	if (!productImage.isEmpty()) {
		
		try {
			byte[] bytes = productImage.getBytes();
			String name = product.getId()+".png";
			Files.delete(Paths.get("src/main/resources/static/Images/product/"+name));
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream (new File("src/main/resources/static/Images/product/"+name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	return "redirect:/productInfo/"+product.getId();
	
		
		
}





@PostMapping("/remove")
public String remove(@ModelAttribute("id") String id, Model model) {
	
	productService.removeOne(Long.parseLong(id.substring(8)));
	List<Product> productList = productService.findAll();
	model.addAttribute("productList", productList);
	
	return "redirect:/product/productList";
	
	
}


	
	
}
