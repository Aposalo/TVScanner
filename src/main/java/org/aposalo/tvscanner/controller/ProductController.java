package org.aposalo.tvscanner.controller;

import java.util.ArrayList;

import org.aposalo.tvscanner.dao.ProductDAO;
import org.aposalo.tvscanner.model.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sqlconnection.xml");
		ProductDAO productDAO = ctx.getBean("productDAO", ProductDAO.class);
		productDAO.create(product);
		ctx.close();
		return new ResponseEntity<>("Product is created successsfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/read")
	public ResponseEntity<ArrayList<Product>> readProduct() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sqlconnection.xml");
		ProductDAO productDAO = ctx.getBean("productDAO", ProductDAO.class);
		ArrayList<Product> repoProducts = productDAO.read();
		ctx.close();
		return new ResponseEntity<>(repoProducts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sqlconnection.xml");
		ProductDAO productDAO = ctx.getBean("productDAO", ProductDAO.class);
		productDAO.update(product);
		ctx.close();
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sqlconnection.xml");
		ProductDAO productDAO = ctx.getBean("productDAO", ProductDAO.class);
		productDAO.delete(product);
		ctx.close();
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

}
