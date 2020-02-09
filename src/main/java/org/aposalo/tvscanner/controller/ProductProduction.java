package org.aposalo.tvscanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductProduction {
	
	@RequestMapping("")
	public String index() {
		return "index.html";
	}
}
