package com.bytecode.crudnotas.controller;

import com.bytecode.crudnotas.entity.Notas;
import com.bytecode.crudnotas.repository.NotaRepository;
import com.bytecode.crudnotas.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private NotaService notaService;

    @GetMapping
    public ModelAndView mostrarNotas(){
        ModelAndView mav = new ModelAndView("notas");

        mav.addObject("notas", notaRepository.findAll());
        mav.addObject("nota", new Notas());

        return mav;
    }

    @PostMapping
    public String guardar(@ModelAttribute Notas nota){
        notaRepository.save(nota);

        return "redirect:/notas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id){

        notaRepository.deleteById(id);

        return "redirect:/notas";
    }

    /*@GetMapping("/eliminar/{id}")
    public String delete(@PathVariable long id){

        notaService.eliminarnota(id);

        return "redirect:/notas";
    }*/

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("formulario");

        Optional<Notas> notasOptional = notaRepository.findById(id);

        if (notasOptional.isPresent()){
            modelAndView.addObject("nota", notasOptional.get());
        } else {
            modelAndView.addObject("nota", new Notas());
        }

        return modelAndView;
    }

    public static final String login = "login";
    @GetMapping({"/login", "/"})
    private ModelAndView mostrarForm(@RequestParam String error, @RequestParam String logout){
        ModelAndView modelAndView = new ModelAndView(login);

        return modelAndView;
    }

    @GetMapping({"/loginsuccess"})
    public String loginCheck(){
        return "redirect:/notas";
    }
}
