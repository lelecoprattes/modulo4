package modelos;

public class pedido {
	private int id;
	private String dataPedido;
	private int numPedido;

public pedido() {
	
}

public pedido(String dataPedido, int numPedido) {
	this.dataPedido = dataPedido;
	this.numPedido = numPedido;
}

public pedido(int id, String dataPedido, int numPedido) {
	this.id = id;
	this.dataPedido = dataPedido;
	this.numPedido = numPedido;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDataPedido() {
	return dataPedido;
}

public void setDataPedido(String dataPedido) {
	this.dataPedido = dataPedido;
}

public int getNumPedido() {
	return numPedido;
}

public void setNumPedido(int numPedido) {
	this.numPedido = numPedido;
}

@Override
public String toString() {
	return "pedido [id=" + id + ", dataPedido=" + dataPedido + ",numPedido=" + numPedido +"]";
}

}