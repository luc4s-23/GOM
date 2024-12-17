package model;

import java.util.Date;

public class OS {
	private int id_os;
	private double total_divida;
	private Date data;
	private int qnt_itens;
	private String descricao;
	private double valor_unitario;
	private double valor_total;
	private int id_veiculo;
	
	public OS(int id_os, double total_divida, Date data, int qnt_itens, String descricao, double valor_unitario,
			double valor_total, int id_veiculo) {
		super();
		this.id_os = id_os;
		this.total_divida = total_divida;
		this.data = data;
		this.qnt_itens = qnt_itens;
		this.descricao = descricao;
		this.valor_unitario = valor_unitario;
		this.valor_total = valor_total;
		this.id_veiculo = id_veiculo;
	}
	public int getId_os() {
		return id_os;
	}
	public void setId_os(int id_os) {
		this.id_os = id_os;
	}
	public double getTotal_divida() {
		return total_divida;
	}
	public void setTotal_divida(double total_divida) {
		this.total_divida = total_divida;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQnt_itens() {
		return qnt_itens;
	}
	public void setQnt_itens(int qnt_itens) {
		this.qnt_itens = qnt_itens;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	
}

