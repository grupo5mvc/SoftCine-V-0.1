package com.grupo5.softCine.controller;
import com.grupo5.softCine.DAO.CinemaDAO;
import com.grupo5.softCine.dominio.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class CinemaControlador {

        @Autowired
        CinemaDAO daoCinema;

        @GetMapping("/exibeCinema")
        public String listaCinema(Model modelo) {
            List<Cinema> listarTodos = daoCinema.Listartodos();
            modelo.addAttribute("lista", listarTodos);
            return "exibeCinema";
        }
        @GetMapping("/exibe-form")
        public String exibeForm(Model model) {
            model.addAttribute("cinema", new Cinema());
            return "/cadastraCinema";
        }
        @PostMapping("/cadastra-cinema")
        public String cadastraCinema(Cinema cinema) {
            if(cinema.getCod_cinema()==null) {
                daoCinema.inserir(cinema);
            }
            else{
                daoCinema.editar(cinema);
            }
            return "redirect:/exibeCinema";
        }
        @GetMapping("/excluir-cinema")
        public String excluirCinema(@RequestParam(value = "cod_cinema",required = false)Integer cod){
            daoCinema.excluir(cod);
            return "redirect:/exibeCinema";
        }
        @GetMapping("/editar-cinema")
        public String editarCinema(@RequestParam(value = "cod_cinema",required = false)Integer cod, Model modelo){
            Cinema cinema= daoCinema.buscaPorId(cod);
            List<Cinema> listarTodos = daoCinema.Listartodos();
            modelo.addAttribute("cinema",cinema);
            modelo.addAttribute("lista", listarTodos);
            return "cadastraCinema";
        }
}