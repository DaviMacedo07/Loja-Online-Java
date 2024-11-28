package Classes;

import abstractClass.Produto;

public class Pedido {
    public static final String EM_PROCESSAMENTO = "Em Processamento";
    public static final String CONCLUIDO = "Concluído";
    public static final String CANCELADO = "Cancelado";

    private Carrinho carrinho;
    private String status;
    private Cliente cliente;

    public Pedido(Cliente cliente, Carrinho carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.status = EM_PROCESSAMENTO; // Status inicial
    }

    public void processarPedido() {
        if (status.equals(EM_PROCESSAMENTO)) {
            System.out.println("Processando o pedido de " + cliente.getNome() + "...");
            // Lógica para processar o pedido
            // Por exemplo, verificar o pagamento ou validar estoque
        } else {
            System.out.println("Não é possível processar o pedido, pois ele já foi " + status);
        }
    }


    public void concluirPedido() {
        if (status.equals(EM_PROCESSAMENTO)) {
            this.status = CONCLUIDO;
            System.out.println("Pedido concluído com sucesso!");
            // Lógica para concluir o pedido (enviar para expedição, etc.)
        } else {
            System.out.println("Não é possível concluir o pedido, pois o status atual é: " + status);
        }
    }


    public void cancelarPedido() {
        if (status.equals(EM_PROCESSAMENTO)) {
            this.status = CANCELADO;
            System.out.println("Pedido cancelado.");
            // Lógica para cancelar o pedido (devolver produtos, por exemplo)
        } else {
            System.out.println("Não é possível cancelar o pedido, pois o status atual é: " + status);
        }
    }


    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
