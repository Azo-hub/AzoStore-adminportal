package AzoStoreAdminPortal.RepositoryPackage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AzoStoreAdminPortal.ModelPackage.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

	List<Product> findByNameContaining(String keyword);

}
