package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping(value= "professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping(value= "/listarProfessores")
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("professor/paginaProfessores");
		mv.addObject("professores",professorService.buscarTodosProfessores());
		return mv;
	}
	
}
