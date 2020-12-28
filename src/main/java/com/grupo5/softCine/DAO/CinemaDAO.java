package com.grupo5.softCine.DAO;

import com.grupo5.softCine.dominio.Cinema;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CinemaDAO {
    public void inserir(Cinema cinema) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "Insert into cinema" +"(nome,cnpj)" + "values(?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cinema.getNome());
            stmt.setString(2, cinema.getCnpj());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Cinema> Listartodos() {
        List<Cinema> lista = new ArrayList<Cinema>();
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from cinema;";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();
            while (retorno.next()) {
                int cod_cinema = retorno.getInt("cod_cinema");
                String nome = retorno.getString("nome");
                String cnpj = retorno.getString("cnpj");
                Cinema cinema = new Cinema(cod_cinema, nome, cnpj);
                lista.add(cinema);
            }
            retorno.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    public void editar(Cinema cinema){
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "UPDATE cinema SET nome=?,cnpj=?" + "WHERE cod_cinema=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cinema.getNome());
            stmt.setString(2, cinema.getCnpj());
            stmt.setInt(3,cinema.getCod_cinema());
            stmt.execute();
            stmt.close();
            conexao.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void excluir(int cod){
        Connection conexao = FabricaDeConexao.getConnection();
        PreparedStatement stmt;
        String sql = "delete from cinema where cod_cinema = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,cod );
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Cinema buscaPorId(int id) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from cinema where cod_cinema = ?;";
        Cinema cinema = null;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();
            retorno.next();
            int cod_cinema = retorno.getInt("cod_cinema");
            String nome = retorno.getString("nome");
            String cnpj = retorno.getString("cnpj");
            cinema = new Cinema ( cod_cinema, nome,cnpj);
            stmt.close();
            conexao.close();
        } catch (

                SQLException e) {
            System.out.println(e.getMessage());
        }
        return cinema;
    }


}
