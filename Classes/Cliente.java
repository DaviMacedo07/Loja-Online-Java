package Classes;

import abstractClass.Usuario;

public class Cliente extends Usuario {
    private String endereco;

    public Cliente(String nome, String email, String senha, String endereco) {
        super(nome, email, senha);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome() + ", Email: " + getEmail() +
                ", Endereço: " + endereco);
    }
}

