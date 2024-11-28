package Classes;

import abstractClass.Usuario;

public class Vendedor extends Usuario {

    private double comissao;
    private double valeReif;


    public Vendedor(String nome, String email, String senha, double comissao, double valeReif) {
        super(nome, email, senha);
        this.comissao = comissao;
        this.valeReif = valeReif;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getValeReif() {
        return valeReif;
    }

    public void setValeReif(double valeReif) {
        this.valeReif = valeReif;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome do Vendedor: " + getNome()
        + ", Email: " + getEmail()
        + ", Comissão do Vendedor: " + getComissao()
        + ", Total do Vale Refeição: " + getValeReif());
    }
}
