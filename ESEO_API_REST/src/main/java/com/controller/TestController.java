package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Ville;
import com.dao.VilleDAO;

@RestController
public class TestController {
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam(required = false, value="value") String value) {
		System.out.println("Appel GET");
		System.out.println("value : " + value);
		return value;
	}
	
	@RequestMapping(value="/villes", method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> get() throws SQLException {
		return VilleDAO.listeVilles();
	}
}
