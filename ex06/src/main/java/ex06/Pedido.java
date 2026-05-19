package ex06;

public class Pedido {
    private final int id;
    private final double valorTotal;
    private String status;

    public Pedido(int id, double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.status = "PENDENTE";
    }

    public int getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
