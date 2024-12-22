package model;

public class VeiculoComModelo {
	 private Veiculo veiculo;
	    private Modelo modelo;

	    public VeiculoComModelo(Veiculo veiculo, Modelo modelo) {
	        this.veiculo = veiculo;
	        this.modelo = modelo;
	    }

	    public Veiculo getVeiculo() {
	        return veiculo;
	    }

	    public Modelo getModelo() {
	        return modelo;
	    }
	}