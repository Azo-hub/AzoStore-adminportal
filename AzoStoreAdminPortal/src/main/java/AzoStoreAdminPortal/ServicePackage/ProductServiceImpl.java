package AzoStoreAdminPortal.ServicePackage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AzoStoreAdminPortal.ModelPackage.Product;
import AzoStoreAdminPortal.RepositoryPackage.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getOne(Long id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

	@Override
	public void removeOne(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> blurrySearch(String keyword) {
		// TODO Auto-generated method stub

		List<Product> productList = productRepository.findByNameContaining(keyword);
		
		List<Product> activeProductList = new ArrayList<>();
		
		for (Product product : productList) {
			if (product.isActive()) {
				activeProductList.add(product);
				
			}
		}
		
		return activeProductList;
	
	}
	
	

}
