package AzoStoreAdminPortal.ServicePackage;

import java.util.List;

import AzoStoreAdminPortal.ModelPackage.Product;



public interface ProductService {

	Product save(Product product);
	
	List<Product> findAll();

	Product getOne(Long id);
	
	void removeOne(Long id);
	
	List<Product> blurrySearch(String keyword);

}
