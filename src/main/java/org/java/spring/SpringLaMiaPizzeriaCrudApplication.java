package org.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.java.spring.db.serv.IngredientService;
import org.java.spring.db.serv.PizzaService;
import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Ingredient;
import org.java.spring.db.pojo.Pizza;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private IngredientService ingredientService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creating Ingredients
		Ingredient ing1 = new Ingredient("olive");
		Ingredient ing2 = new Ingredient("salamino");
		Ingredient ing3 = new Ingredient("rucola");
		Ingredient ing4 = new Ingredient("salsiccia");
		Ingredient ing5 = new Ingredient("cipolla");
		ingredientService.save(ing1);
		ingredientService.save(ing2);
		ingredientService.save(ing3);
		ingredientService.save(ing4);
		ingredientService.save(ing5);

		// Creating Pizzas
		pizzaService.save(new Pizza("Margherita", "La classica", "imageUrl_1", 700, ing1, ing3));
		pizzaService.save(new Pizza("Salamino", "La piccante", "imageUrl_2", 850, ing2));
		pizzaService.save(new Pizza("Napoli", "La salata", "imageUrl_3", 800));
		pizzaService.save(new Pizza("Calzone", "Il farcito", "imageUrl_4", 900, ing4, ing5));
		pizzaService.save(new Pizza("SuperPizza", "La speciale", "imageUrl_5", 1250, ing1, ing3, ing5));

		// Creating Roles
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		roleService.save(roleUser);
		roleService.save(roleAdmin);

		String pws = AuthConf.passwordEncoder().encode("pws");

		// Creating Users
		User tommiUser = new User("tommiUser", pws, roleUser);
		User tommiAdmin = new User("tommiAdmin", pws, roleAdmin);
		userService.save(tommiUser);
		userService.save(tommiAdmin);
	}
}
