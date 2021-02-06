package catalogo.api.zensa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "catalogo.api.zensa.model")
@ComponentScan(basePackages = {"catalogo.*"})
@EnableJpaRepositories(basePackages = {"catalogo.api.zensa.repository"})
@EnableTransactionManagement
public class CatalogoDePecasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoDePecasApplication.class, args);
	}
}