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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="PEDIDO")
@SequenceGenerator(name="SEQUENCIA_PEDIDO",
				   sequenceName="SEQ_PEDIDO",
				   allocationSize=1)
public class Pedido {
	
	private Long id;
	
	// Um Pedido se refere a um único cliente
	
	//private Cliente cliente;
	
	//  Um pedido possui itens
	private List<Item> itens = new ArrayList<Item>();	
	
	// ********* Construtores *********

	public Pedido() {
		super();
	}

	public Pedido(Cliente cliente, List<Item> itens) {
		// TODO Auto-generated constructor stub
		this.itens = itens;
		//this.cliente = cliente;
	}
	
	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCIA_PEDIDO")
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	/*@Transient
	public Cliente getClienteMasc() {
		return cliente;
	}*/
	
	@Transient
	public List<Item> getItensMasc() {
		return itens;
	}

	// ********* Métodos do Tipo Set *********
	
	public void setId(Long id) {
		this.id = id;
	}

	// ********* Métodos para Associações *********

		/* 
		 * Com o atributo mappedBy. Sem ele a  JPA irá procurar  pela 
		 * tabela PEDIDO_ITEM. Com ele, ao se  tentar recuperar  um  
		 * pedido  e  todos  os  seus  itens, o  join de PEDIDO  e 
		 * ITEM irá acontecer através da chave estrangeira existente
		 * em  ITEM.  Sem  ele  a  JPA  irá  procurar  pela   tabela 
		 * PEDIDO_ITEM.
		 */
	
	/*
	 * this error happened:
	 * ERROR: object references an unsaved transient instance - save the transient instance before flushing
	 * You should include cascade="all" (if using xml) or cascade=CascadeType.ALL (if using annotations) 
	 * on your collection mapping.
	 * This happens because you have a collection in your entity, 
	 * and that collection has one or more items which are not present in the database. 
	 * By specifying the above options you tell hibernate to save them to the database 
	 * when saving their parent.
	 */
	
	@OneToMany(mappedBy="pedido", cascade={CascadeType.ALL})
	@OrderBy
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	/*@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/



}
