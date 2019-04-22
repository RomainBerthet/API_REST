package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.VilleDAO;

import com.bean.Ville;

@RestController
public class TestController {
	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> get(@RequestParam(required = false, defaultValue="", value="insee") String insee, 
			@RequestParam(required = false, defaultValue="", value="nom") String nom) throws SQLException {
		return VilleDAO.listeVilles(insee, nom);
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	@ResponseBody
	public void post(@RequestParam(required = true, value="insee") String insee, 
			@RequestParam(required = true, value="nom") String nom,
			@RequestParam(required = true, value="cp") String cp,
			@RequestParam(required = true, value="lati") String lati,
			@RequestParam(required = true, value="longi") String longi) throws SQLException {
		VilleDAO.modifVille(insee, nom, cp, lati, longi);
	}
	
	@RequestMapping(value="/put", method=RequestMethod.PUT)
	@ResponseBody
	public void put(@RequestParam(required = true, value="insee") String insee, 
			@RequestParam(required = true, value="nom") String nom,
			@RequestParam(required = true, value="cp") String cp,
			@RequestParam(required = true, value="lati") String lati,
			@RequestParam(required = true, value="longi") String longi) throws SQLException {
		VilleDAO.ajouterVille(insee, nom, cp, lati, longi);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required = false, defaultValue="", value="insee") String insee) throws SQLException {
		VilleDAO.supprimerVille(insee);
	}
}
