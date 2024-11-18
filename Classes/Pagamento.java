package Classes;

import abstractClass.Processavel;

public class Pagamento implements Processavel {
    private double valor;
    private String metodoPagamento;

    public Pagamento(double valor, String metodoPagamento) {
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public boolean processarPagamento(double valor) {
        return false;
    }

    @Override
    public boolean validarPagamento() {
        return false;
    }

    @Override
    public boolean realizarPagamento() {
        if (metodoPagamento.equalsIgnoreCase("cartao")) {
            System.out.println("Processando pagamento com cartão no valor de R$" + valor + "...");
            return true;
        } else if (metodoPagamento.equalsIgnoreCase("boleto")) {
            System.out.println("Gerando boleto no valor de R$" + valor + "...");
            return true;
        } else {
            System.out.println("Método de pagamento não aceito.");
            return false;
        }
    }
}
