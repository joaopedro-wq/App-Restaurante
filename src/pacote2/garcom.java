package pacote2;

public class garcom {
    private String nome;
    private int matricula;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {

        this.matricula = matricula;

    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "" + "Garçom: " + nome + "\nmatricula: " + matricula + "";
    }

}
