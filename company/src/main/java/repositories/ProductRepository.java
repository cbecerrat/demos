package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query("SELECT PROD FROM Product PROD WHERE PROD.price >= ?1")
	List<Product> getGreaterThanPrice(Double price);	
}
