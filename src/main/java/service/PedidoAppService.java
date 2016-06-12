package service;

import dao.FabricaDeDAOs;
import dao.PedidoDAO;
import excecao.InfraestruturaException;
import modelo.Pedido;
import util.JPAUtil;

public class PedidoAppService {
	
	private static PedidoDAO pedidoDAO = FabricaDeDAOs.getDAO(PedidoDAO.class);
	
	public long inclui(Pedido umPedido) 
	{	try
		{	
			//inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = pedidoDAO.inclui(umPedido);

			// commitar a transa��o
			JPAUtil.commitTransaction();
			
			return numero;
		} 
		catch(InfraestruturaException e){	
			try{	
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do primeiro
			catch(InfraestruturaException ie){
				
			}
			// propago erro do primero
		    throw e;
		}
		finally{
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

}
