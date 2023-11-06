package modelos;

public class Cliente {

	// Atributos
	private int id;
	private String nome;
	private String contato;
	
	//construtor
	public Cliente() {
		
	}

	public Cliente(String nome, String contato) {
		this.nome = nome;
		this.contato = contato;
	}

	public Cliente(int id, String nome, String contato) {
		this.id = id;
		this.nome = nome;
		this.contato = contato;
	}
	
	// getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	//toString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", contato=" + contato + "]";
	}

	public void add(Cliente cliente) {
		
	}	
}