package me.filipebezerra.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.filipebezerra.brewer.model.Cerveja;

@Controller
public class CervejaController {

	@RequestMapping("/cervejas/novo")
	public String nova(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return nova(cerveja);
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Tudo certo no cadastro!");
		return "redirect:/cervejas/novo";
	}
	
}
