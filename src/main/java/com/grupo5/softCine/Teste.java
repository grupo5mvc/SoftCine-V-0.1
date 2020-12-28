package com.grupo5.softCine;
import com.grupo5.softCine.DAO.CinemaDAO;
import com.grupo5.softCine.dominio.Cinema;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        CinemaDAO dao = new CinemaDAO();
        List<Cinema> lista = dao.Listartodos();
        for (Cinema cinema : lista) {
            System.out.println("Nome do cinema: " + cinema.getNome());
            System.out.println("CNPJ:" + cinema.getCnpj());
        }
    }


}
