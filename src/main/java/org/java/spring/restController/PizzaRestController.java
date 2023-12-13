package org.java.spring.restController;

import java.util.List;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/pizzas/api/v1.0")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> index() {
        List<Pizza> pizzas = pizzaService.findAll();
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pizza> show(@PathVariable int id) {
        Pizza pizza = pizzaService.findById(id);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pizza> create(@RequestBody Pizza pizza) {
        pizzaService.save(pizza);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pizza> update(@PathVariable int id, @RequestBody Pizza newPizza) {
        Pizza pizza = pizzaService.findById(id);

        pizza.setName(newPizza.getName());
        pizza.setDescription(newPizza.getDescription());
        pizza.setImageUrl(newPizza.getImageUrl());
        pizza.setPrice(newPizza.getPrice());
        pizza.setDeleted(newPizza.isDeleted());

        pizzaService.save(pizza);

        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pizza> delete(@PathVariable int id) {

        Pizza pizza = pizzaService.findById(id);
        pizza.clearIngredients();
        pizzaService.save(pizza);
        pizzaService.delete(pizza);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }
}
