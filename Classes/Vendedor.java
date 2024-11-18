package Classes;

import abstractClass.Usuario;

public class Vendedor extends Usuario {
    private String cnpj;
    private double comissao;

    public Vendedor(String nome, String email, String senha, String cnpj, double comissao) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.comissao = comissao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Vendedor: " + getNome() + ", Email: " + getEmail() +
                ", CNPJ: " + cnpj + ", Comissão: " + comissao + "%");
    }
}
