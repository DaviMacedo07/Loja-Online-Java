package Classes;

public class Pedido {
    public static final String STATUS_PENDENTE = "PENDENTE";
    public static final String STATUS_PROCESSANDO = "PROCESSANDO";
    public static final String STATUS_CONCLUIDO = "CONCLUIDO";
    public static final String STATUS_CANCELADO = "CANCELADO";

    private Carrinho carrinho;
    private String status;
    private Cliente cliente;

    public Pedido(Carrinho carrinho, Cliente cliente) {
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.status = STATUS_PENDENTE;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void processarPedido() {
        System.out.println("Processando pedido para " + cliente.getNome());
        this.status = STATUS_PROCESSANDO;
    }

    public void concluirPedido() {
        System.out.println("Pedido concluído.");
        this.status = STATUS_CONCLUIDO;
    }

    public void cancelarPedido() {
        System.out.println("Pedido cancelado.");
        this.status = STATUS_CANCELADO;
    }
}

