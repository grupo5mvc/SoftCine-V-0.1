package com.grupo5.softCine.dominio;

public class Funcionario {
	
	private Integer cod_funcionario;
    private String nome_func;
    private String email;
    private String cargo;
    private Integer salario;
    
	public Funcionario(int cod_funcionario, String nome_func, String email, String cargo, int salario) {
		this.cod_funcionario = cod_funcionario;
		this.nome_func = nome_func;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public Funcionario(String nome_func, String email, String cargo, int salario) {
		this.nome_func = nome_func;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public Funcionario() {
	}

	public Integer getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(Integer cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public String getNome_func() {
		return nome_func;
	}

	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

}
