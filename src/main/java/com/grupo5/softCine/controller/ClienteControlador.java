package com.grupo5.softCine.controller;


import com.grupo5.softCine.DAO.ClienteDAO;
import com.grupo5.softCine.dominio.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClienteControlador {

    ClienteDAO daoCliente= new ClienteDAO();

    @GetMapping("/exibeCliente")
    public String listaCliente(Model modelo) {
        List<Cliente> listarTodos = daoCliente.Listartodos();
        modelo.addAttribute("listaCliente", listarTodos);
        return "exibeCliente";

    }
    @GetMapping("/exibe-cadastro")
    public String exibeCliente(Model model) {
        model.addAttribute("clientes", new Cliente());
        return "/cadastroCliente";
    }
    @PostMapping("/cadastra-cliente")
    public String cadastraCliente(Cliente cliente) {
        if(cliente.getCod_cliente()==null) {
            daoCliente.inserir(cliente);
        }
        else{
            daoCliente.editar(cliente);
        }
        return "redirect:/exibeCliente";
    }

    @GetMapping("/excluir-cliente")
    public String excluirCliente(@RequestParam(value = "cod_cliente",required = false)Integer cod_cliente){
        daoCliente.excluir(cod_cliente);
        return "redirect:/exibeCliente";
    }

    @GetMapping("/editar-cliente")
    public String editarCliente(@RequestParam(value = "cod_cliente",required = false)Integer cod_cliente, Model modelo){
        Cliente cliente= daoCliente.buscaPorId(cod_cliente);
        List<Cliente> listarTodos = daoCliente.Listartodos();
        modelo.addAttribute("clientes",cliente);
        modelo.addAttribute("lista", listarTodos);
        return "cadastroCliente";
    }
}
