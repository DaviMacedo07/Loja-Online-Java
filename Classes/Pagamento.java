package Classes;

import abstractClass.Processavel;

public class Pagamento implements Processavel {
    private double valor;
    private String metodoPagamento;
    private Carrinho carrinho;

    public Pagamento(Carrinho carrinho, String metodoPagamento) {
        this.carrinho = carrinho;
        this.metodoPagamento = metodoPagamento;
        this.valor = carrinho.calcularTotal();
    }

    @Override
    public boolean processarPagamento() {
        System.out.println("Iniciando o processamento do pagamento...");
        if (validarPagamento()) {
            realizarPagamento();
            return true;
        } else {
            System.out.println("Pagamento inválido! Não é possível processar.");
            return false;
        }
    }

    @Override
    public boolean validarPagamento() {
        if (valor > 0) {
            System.out.println("Pagamento válido. Valor: R$ " + valor);
            return true;
        } else {
            System.out.println("Valor inválido para o pagamento.");
            return false;
        }
    }

    @Override
    public boolean realizarPagamento() {
        System.out.println("Pagamento realizado com sucesso!");
//        System.out.println("Método de pagamento: " + metodoPagamento);
//        System.out.println("Valor pago: R$ " + valor);
        return true;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
