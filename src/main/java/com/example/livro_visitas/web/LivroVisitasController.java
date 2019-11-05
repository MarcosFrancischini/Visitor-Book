package com.example.livro_visitas.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.livro_visitas.data.LivroVisitasRepositorio;
import com.example.livro_visitas.model.Usuario;

@Controller
@RequestMapping("/")
public class LivroVisitasController {
	
	@Autowired
	private LivroVisitasRepositorio repo;
	
	@ModelAttribute
	public Usuario usuario() {
		return new Usuario();
	}
	
	@GetMapping
	public String mensagens(Model model) {
		//List<Usuario> usuarios = repo.findAll();
		List<Usuario> usuarios = new ArrayList<>();
		repo.findAllByOrderByDataDesc().forEach(usuarios::add);
		
		model.addAttribute("usuarios", usuarios);
		return "livroVisitas";
	}
	
    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id){
    	Usuario usuario = repo.findById(id).get();
    	
    	repo.delete(usuario);
        return "redirect:/";
    }

	@PostMapping
	public String processarForm(@Valid Usuario usuario, Errors errors) {		
		if (errors.hasErrors()) {
			return "livroVisitas";
		}
		
		repo.save(usuario);
		
		return "redirect:/";
	}
	
}
