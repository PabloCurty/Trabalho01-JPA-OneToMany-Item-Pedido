package dao;

import java.util.List;

import javax.persistence.EntityManager;

import excecao.InfraestruturaException;
import excecao.ObjetoNaoEncontradoException;
import modelo.Pedido;
import util.JPAUtil;



public class PedidoDAOImpl implements PedidoDAO{

	@Override
	public long inclui(Pedido umPedido) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.persist(umPedido);
			
			return umPedido.getId();
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	@Override
	public void altera(Pedido umPedido) throws ObjetoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(long id) throws ObjetoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido recuperaUmPedido(long numero) throws ObjetoNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> recuperaProdutos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
