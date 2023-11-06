package modelos;

public class passagem {
	private int id;
	private String destino;
	private String dataPassagem;
	
	Cliente cliente;
	pedido pedido;
	public passagem() {
	}
	public passagem(String destino, String dataPassagem, Cliente cliente, modelos.pedido pedido) {
		this.destino = destino;
		this.dataPassagem = dataPassagem;
		this.cliente = cliente;
		this.pedido = pedido;
	}
	public passagem(int id, String destino, String dataPassagem, Cliente cliente, modelos.pedido pedido) {
		this.id = id;
		this.destino = destino;
		this.dataPassagem = dataPassagem;
		this.cliente = cliente;
		this.pedido = pedido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDataPassagem() {
		return dataPassagem;
	}
	public void setDataPassagem(String dataPassagem) {
		this.dataPassagem = dataPassagem;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public pedido getPedido() {
		return pedido;
	}
	public void setPedido(pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "passagem [id=" + id + ", destino=" + destino + ", dataViajem=" + dataPassagem + ", cliente=" + cliente
				+ ", pedido=" + pedido + "]";
	}
	
	
}
