package pacote5;

public class caixa {
    private float calculo;
    private float qtdCal;
    private int codigo;
    private float finalCaixa;

    public float getfinalCaixa() {

        return finalCaixa;
    }

    public void setfinalCaixa(float finalCaixa) {

        this.finalCaixa = finalCaixa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getCalculo() {

        calculo = qtdCal * calculo;

        return calculo;
    }

    public void setCalculo(float calculo) {

        this.calculo = calculo;
    }

    public float getqtdCal() {

        return qtdCal;
    }

    public void setqtdCal(float qtdCal) {

        this.qtdCal = qtdCal;
    }

}
