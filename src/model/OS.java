package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OS {
	private int id_os;
	private Date data;
	private int qnt_itens;
	private double valor_total;
	private int fk_id_veiculo;
	private String forma_pagamento;
	private List<ItensOS> itens = new ArrayList<>();

	public OS() {
		super();
	}

	public OS(int id_os, Date data, int qnt_itens, double valor_total, int id_veiculo, String fPagamento) {
		super();
		this.id_os = id_os;
		this.data = data;
		this.qnt_itens = qnt_itens;
		this.valor_total = valor_total;
		this.fk_id_veiculo = id_veiculo;
	}

	public int getId_os() {
		return id_os;
	}

	public void setId_os(int id_os) {
		this.id_os = id_os;
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

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public int getFk_Id_veiculo() {
		return fk_id_veiculo;
	}

	public void setFk_Id_veiculo(int fk_id_veiculo) {
		this.fk_id_veiculo = fk_id_veiculo;
	}

	public String getfPagamento() {
		return forma_pagamento;
	}

	public void setfPagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public List<ItensOS> getItens() {
		return itens;
	}

	public void setItens(List<ItensOS> itens) {
		this.itens = itens;
	}

	
	
}
