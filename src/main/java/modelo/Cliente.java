package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CLIENTE")
@SequenceGenerator(name="SEQUENCIA_CLIENTE",
				   sequenceName="SEQ_CLIENTE",
				   allocationSize=1)
public class Cliente {
	
	private long id;
	private String nome;
	//private Endereco endereco;
	
	//  Um cliente possui um pedido
	//private Pedido pedido;
	
	// ********* Construtores *********
	
	/*public Cliente(String nome, Pedido pedido) {
		super();
		this.nome = nome;
		this.pedido = pedido;
	}*/
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	public Cliente() {
		super();
	}
	
	// ********* Métodos do Tipo Get *********
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_CLIENTE")
	@Column(name="ID")
	public long getId() {
		return id;
	}
	@Column(name="NOME")
	public String getNome() {
		return nome;
	}
	@Transient
	public String getNomeMasc() {
		return nome;
	}
	/*@Transient
	public Pedido getPedidoMasc() {
		return pedido;
	}*/
	
	// ********* Métodos do Tipo Set *********
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	// ********* Métodos para Associações *********

	/*
	 * Com o atributo mappedBy. Sem ele a JPA irá procurar pela tabela
	 * PEDIDO_ITEM. Com ele, ao se tentar recuperar um pedido e todos os seus
	 * itens, o join de PEDIDO e ITEM irá acontecer através da chave estrangeira
	 * existente em ITEM. Sem ele a JPA irá procurar pela tabela PEDIDO_ITEM.
	 */
	/*@OneToOne(fetch=FetchType.LAZY)
	@OrderBy
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}*/
	
}
