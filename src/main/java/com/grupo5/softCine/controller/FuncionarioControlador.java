package com.grupo5.softCine.controller;


import com.grupo5.softCine.DAO.FuncionarioDAO;
import com.grupo5.softCine.dominio.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FuncionarioControlador {

    FuncionarioDAO daoFuncionario= new FuncionarioDAO();

    @GetMapping("/exibeFuncionario")
    public String listaFuncionario(Model modelo) {
        List<Funcionario> listarTodos = daoFuncionario.Listartodos();
        modelo.addAttribute("listaFuncionario", listarTodos);
        return "exibeFuncionario";

    }
    @GetMapping("/exibe-cadastro-funcionario")
    public String exibeFuncionario(Model model) {
        model.addAttribute("funcionarios", new Funcionario());
        return "/cadastroFuncionario";
    }
    @PostMapping("/cadastra-funcionario")
    public String cadastraFuncionario(Funcionario funcionario) {
        if(funcionario.getCod_funcionario()==null) {
            daoFuncionario.inserir(funcionario);
        }
        else{
            daoFuncionario.editar(funcionario);
        }
        return "redirect:/exibeFuncionario";
    }

    @GetMapping("/excluir-funcionario")
    public String excluirFuncionario(@RequestParam(value = "cod_funcionario",required = false)Integer cod_funcionario){
        daoFuncionario.excluir(cod_funcionario);
        return "redirect:/exibeFuncionario";
    }

    @GetMapping("/editar-funcionario")
    public String editarFuncionario(@RequestParam(value = "cod_funcionario",required = false)Integer cod_funcionario, Model modelo){
    	Funcionario funcionario= daoFuncionario.buscaPorId(cod_funcionario);
        List<Funcionario> listarTodos = daoFuncionario.Listartodos();
        modelo.addAttribute("funcionarios",funcionario);
        modelo.addAttribute("lista", listarTodos);
        return "cadastroFuncionario";
    }
}
