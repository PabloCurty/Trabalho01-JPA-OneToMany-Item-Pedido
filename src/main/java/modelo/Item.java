package modelo;

/*
 * Alguns detalhes sobre o código:
 *
 *@Entity indica para nosso Provider que essa classe deve ser persistida em nosso banco de dados.
 *
 *@Table define o nome da tabela a ser utilizada no banco de dados. 
 *Caso não tenha definida nenhum nome utilizando a chave name, o padrão será o nome exato da classe.
 *
 *@Id mostra qual o nome do id de nossa classe.
 *
 *GeneratedValue é a chave utilizada para que o valor do nosso id seja gerada por algum tipo de padrão.
 * 
 *@Column define o atributo como uma coluna. Poderíamos também definir um nome pelo atributo name, 
 *como foi feito com a chave da tabela (@Table).
 *
 *http://uaihebert.com/tutorial-hibernate-3-com-jpa-2/
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ITEM")
@SequenceGenerator(name="SEQUENCIA_ITEM", 
		           sequenceName="SEQ_ITEM",
		           allocationSize=1)
public class Item {
	
	private Long id;
	private String nome;
	
	// Um Item se refere a um único pedido
	
	private Pedido pedido;
	
	// ********* Construtores *********
	
	public Item() {
		super();
	}

	public Item(String nomeItem, Pedido pedido) {
		// TODO Auto-generated constructor stub
		this.nome = nomeItem;
		this.pedido = pedido;
	}
	
	public Item(String nomeItem) {
		// TODO Auto-generated constructor stub
		this.nome = nomeItem;;
	}
	
	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_ITEM")
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}
	
	@Transient
	public String getNomeMasc() {
		return nome;
	}
	
	// ********* Métodos do Tipo Set *********

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// ********* Métodos para Associações *********
		//DEFAULT JPA E HIBERNATE É EAGER (QUANDO TRAZ COLEÇÃO É DEFAULT LAZY)
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PEDIDO_ID")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
