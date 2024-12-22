package model;

public class ItensOS {
private int id_item;
private String descricao;
private double valor_unitario;
private int quantidade;
private int fk_id_OS;

public ItensOS(int id_item, String descricao, double valor_unitario, int quantidade, int fk_id_OS) {
super();
this.id_item = id_item;
this.descricao = descricao;
this.valor_unitario = valor_unitario;
this.quantidade = quantidade;
this.fk_id_OS = fk_id_OS;


}

public ItensOS(){

}

public int getId_item() {
return id_item;
}
public void setId_item(int id_item) {
this.id_item = id_item;
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
public int getQuantidade() {
return quantidade;
}
public void setQuantidade(int quantidade) {
this.quantidade = quantidade;
}
public int getFk_id_OS() {
return fk_id_OS;
}
public void setFk_id_OS(int fk_id_OS) {
this.fk_id_OS = fk_id_OS;
}


}