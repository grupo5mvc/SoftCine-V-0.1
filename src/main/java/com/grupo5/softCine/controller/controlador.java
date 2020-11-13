package com.grupo5.softCine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controlador {
  @RequestMapping("/home")
   public String home(){

      return "home";
    }


    @RequestMapping("/listaFilmes")
    public String listaFilme(){

        return "listaFilmes";
    }

    @RequestMapping("/pagamento1")
    public String pgmt1(){

        return "pagamento1";
    }

    @RequestMapping("/pagamento2")
    public String pgmt2(){

        return "pagamento2";
    }
    @RequestMapping("/login")
    public String login(){

        return "login";
    }
    @RequestMapping("/esqueceuSenha")
    public String esqueceuSenha() {

        return "esqueceuSenha";
    }

    @RequestMapping("/cadastro")
    public String cadastro() {

        return "cadastro";
    }
    @RequestMapping("/filmeBilleTed")
    public String filmeBilleTed() {

        return "filmeBilleTed";
    }

    @RequestMapping("/filmeJovensBruxas")
    public String filmeJovensBruxas() {

        return "filmeJovensBruxas";
    }
    @RequestMapping("/filmeDestruicaoFinal")
    public String filmeDestruicaoFinal() {

        return "filmeDestruicaoFinal";
    }

    @RequestMapping("/filmeScooby")
    public String filmeScooby() {

        return "filmeScooby";
    }
    @RequestMapping("/filmeAmizadeMaldita")
    public String filmeAmizadeMaldita() {

        return "filmeAmizadeMaldita";
    }
    @RequestMapping("/filmeConvencaoBruxas")
    public String filmeConvencaoBruxas() {

        return "filmeConvencaoBruxas";
    }
    @RequestMapping("/filmeTenet")
    public String filmeTenet() {

        return "filmeTenet";
    }

    @RequestMapping("/filmeGodzilla")
    public String filmeGodzilla() {

        return "filmeGodzilla";
    }
    @RequestMapping("/filmeNovosMutantes")
    public String filmeNovosMutantes() {

        return "filmeNovosMutantes";
    }

}
