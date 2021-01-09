package com.grupo5.softCine.DAO;

import com.grupo5.softCine.dominio.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "Insert into funcionario" +"(nome_func,email,cargo,salario)" + "values(?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome_func());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCargo());
            stmt.setInt(4, funcionario.getSalario());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Funcionario> Listartodos() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from funcionario;";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet retorno = stmt.executeQuery();
            while (retorno.next()) {
                int cod_funcionario = retorno.getInt("cod_funcionario");
                String nome_func = retorno.getString("nome_func");
                String email = retorno.getString("email");
                String cargo = retorno.getString("cargo");
                int salario = retorno.getInt("salario");
                Funcionario funcionario = new Funcionario(cod_funcionario,nome_func,email,cargo,salario);
                lista.add(funcionario);
            }
            retorno.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


    public void editar(Funcionario funcionario){
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "UPDATE funcionario SET email=?,cargo=?,nome_func=?, salario=? WHERE cod_funcionario=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, funcionario.getEmail());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3,funcionario.getNome_func());
            stmt.setInt(4,funcionario.getSalario());
            stmt.setInt(5,funcionario.getCod_funcionario());
            stmt.execute();
            stmt.close();
            conexao.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void excluir(int cod_funcionario){
        Connection conexao = FabricaDeConexao.getConnection();
        PreparedStatement stmt;
        String sql = "delete from funcionario where cod_funcionario = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,cod_funcionario );
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Funcionario buscaPorId(int id) {
        Connection conexao = FabricaDeConexao.getConnection();
        String sql = "select * from funcionario where cod_funcionario = ?;";
        Funcionario funcionario = null;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet retorno = stmt.executeQuery();
            retorno.next();
            Integer cod_funcionario = retorno.getInt("cod_funcionario");
            String nome_func = retorno.getString("nome_func");
            String email = retorno.getString("email");
            String cargo = retorno.getString("cargo");
            Integer salario = retorno.getInt("salario");
            funcionario = new Funcionario(cod_funcionario, nome_func, email,cargo,salario);
            stmt.close();
            conexao.close();
        } catch (

                SQLException e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }



}
