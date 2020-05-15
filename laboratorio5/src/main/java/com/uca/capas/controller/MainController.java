package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/inicio")	
	public ModelAndView initMain() {	
		Estudiante estudiante = new Estudiante();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	

	@RequestMapping("/guardar")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes =null;
		if(result.hasErrors()) { 
			mav.setViewName("index");
			log.info("Error encontrado");
		}else {	
			try {
				log.info("Estudiante agregado");
				estudianteDAO.save(estudiante, 1);
			}catch(Exception ex) {
			}
			estudiantes=estudianteDAO.findAll();
			mav.addObject("estudiantes",estudiantes);
			mav.setViewName("index");
			}
			return mav;
	}

		
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
}
