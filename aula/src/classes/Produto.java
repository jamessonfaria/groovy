package classes;

// 3 motivos para fazer essa classe em java:
// 1. Gerar uma classe em java e ver se eles gostam de voltar a digitar o que o  groovy faz.
// 2. Provar que funciona o mix de java e grovvy.
// 3. Usar o recurso de Direct field access operator.
public class Produto {
    
    private String nome;
    private double valor;
    
    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public String getNome() {
        System.out.println("getNome");
        return nome;
    }
    public void setNome(String nome) {
        System.out.println("setNome");
        this.nome = nome;
    }
    public double getValor() {
        System.out.println("getValor");
        return valor;
    }
    public void setValor(double valor) {
        System.out.println("setValor");
        this.valor = valor;
    }    
}



