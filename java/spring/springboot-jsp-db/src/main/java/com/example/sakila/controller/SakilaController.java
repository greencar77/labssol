package com.example.sakila.controller;

import com.example.sakila.repository.ActorRepository;
import com.example.sakila.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SakilaController {

    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    public SakilaController(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/actors")
    public String listActors(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        return "actors";
    }

    @GetMapping("/films")
    public String listFilms(Model model) {
        model.addAttribute("films", filmRepository.findAll());
        return "films";
    }
}
