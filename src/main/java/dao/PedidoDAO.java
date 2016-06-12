package dao;

import java.util.List;

import excecao.ObjetoNaoEncontradoException;
import modelo.Pedido;


public interface PedidoDAO {

	public long inclui(Pedido umPedido); 

	public void altera(Pedido umPedido)
		throws ObjetoNaoEncontradoException; 
	
	public void exclui(long id) 
		throws ObjetoNaoEncontradoException; 
	
	public Pedido recuperaUmPedido(long numero) 
		throws ObjetoNaoEncontradoException; 
	
	public List<Pedido> recuperaProdutos();
}
