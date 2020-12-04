package AzoStoreAdminPortal.RepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import AzoStoreAdminPortal.ModelPackage.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
