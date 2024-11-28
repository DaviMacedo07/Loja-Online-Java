package Classes;

import abstractClass.Usuario;
import abstractClass.Vendas;

public class Cliente extends Usuario {

    private double desconto = 0.10;
    private String endereco;
    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome() +
                ", Email: " + getEmail() +
                ", Endereço: " + endereco);
    }
}
