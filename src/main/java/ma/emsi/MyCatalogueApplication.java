package ma.emsi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.dao.ProduitRepository;
import ma.emsi.entities.Produit;

@SpringBootApplication
public class MyCatalogueApplication implements CommandLineRunner {
	 @Autowired
 private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(MyCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	produitRepository.save(new Produit(null,"Ordi HP 5643",6500,54));
	produitRepository.save(new Produit(null,"Imprimante HP 1122",320,10));
	produitRepository.save(new Produit(null,"Smart Phone S9",1200,120));
	Page <Produit> produits =produitRepository.findByDesignationContains("H",PageRequest.of(0,2));
	System.out.println(produits.getSize());
	System.out.println(produits.getTotalElements());
	System.out.println(produits.getTotalPages());
	
	produits.getContent().forEach(p->{
		System.out.println(p.toString());
	});
	System.out.println("---------------------------------");
	Page <Produit> prods =produitRepository.cherche("%H%",1000,PageRequest.of(0,2));
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	
	prods.getContent().forEach(p->{
		System.out.println(p.toString());
	});
	}

}
