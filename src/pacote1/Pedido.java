package pacote1;

import java.util.Date;

public class Pedido {
    private int codigo;
    private Date dataPedido;
    private String garcom;
    private float itens;

    public int getCodigo() {

        return codigo;
    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;
    }

    public Date getDataPedido() {

        return dataPedido;

    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getGarcom() {
        return garcom;
    }

    public void setGarcom(String garcom) {
        this.garcom = garcom;
    }

    public float getItens() {
        return itens;
    }

    public void setItens(float itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "" + "" + garcom + "\nData do Pedido : " + dataPedido + "";
    }

}
