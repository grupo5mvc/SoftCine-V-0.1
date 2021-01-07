package com.grupo5.softCine.DAO;

import com.grupo5.softCine.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "Insert into cliente" +"(nome,login,senha,email)" + "values(?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getLogin());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getEmail());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cliente> Listartodos() {
        List<Cliente> lista = new ArrayList<Cliente>();
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from cliente;";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();
            while (retorno.next()) {
                int cod_cliente = retorno.getInt("cod_cliente");
                String nome = retorno.getString("nome");
                String login = retorno.getString("login");
                String senha = retorno.getString("senha");
                String email = retorno.getString("email");
                Cliente cliente = new Cliente(cod_cliente, nome,login,senha,email);
                lista.add(cliente);
            }
            retorno.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


    public void editar(Cliente cliente){
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "UPDATE cliente SET email=?,login=?,nome=?, senha=?"+ "WHERE cod_cliente=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getLogin());
            stmt.setString(3,cliente.getNome());
            stmt.setString(4,cliente.getSenha());
            stmt.setInt(5,cliente.getCod_cliente());
            stmt.execute();
            stmt.close();
            conexao.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void excluir(int cod_cliente){
        Connection conexao = FabricaDeConexao.getConnection();
        PreparedStatement stmt;
        String sql = "delete from cliente where cod_cliente = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,cod_cliente );
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente buscaPorId(int id) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from cliente where cod_cliente = ?;";
        Cliente cliente = null;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();
            retorno.next();
            Integer cod_cliente = retorno.getInt("cod_cliente");
            String nome = retorno.getString("nome");
            String login = retorno.getString("login");
            String senha = retorno.getString("senha");
            String email = retorno.getString("email");
            cliente = new Cliente(cod_cliente, nome, login,senha,email);
            stmt.close();
            conexao.close();
        } catch (

                SQLException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }



}
