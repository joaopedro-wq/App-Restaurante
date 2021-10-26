package pacote3;

public class itens {
    private float quantidade;
    private String produto;
    private int cod;
    private boolean finalizada;

    public boolean isFinalizada() {

        return finalizada;

    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "itens:" + "Quantidade: " + quantidade + "\n" + produto + "";
    }

}
