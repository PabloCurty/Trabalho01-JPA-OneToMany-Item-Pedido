package trabalho01;

/*
 * Create a gitIgnore manually on windows
 * 1 Create the text file gitignore.txt
 * 2 Open it in a text editor and add your rules, then save and close
 * 3 Hold SHIFT, right click the folder you're in, then select Open command window here
 * 4 Then rename the file in the command line, with ren gitignore.txt .gitignore
 */

import java.util.ArrayList;
import java.util.List;

import corejava.Console;
import modelo.Cliente;
import modelo.Item;
import modelo.Pedido;
import service.PedidoAppService;


public class Principal {
	public static void main(String[] args) {
		
		Pedido umPedido;
		List<Item> itens = new ArrayList<Item>();
		Cliente cliente;
		PedidoAppService pedidoAppService = new PedidoAppService();
		int opcao = 0;
		
		boolean continua = true;
		
		while(continua){
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um pedido");
			//System.out.println("2. Alterar um pedido");
			//System.out.println("3. Remover um pedido");
			//System.out.println("4. Listar todos os pedido");
			System.out.println("5. Sair");
			
			opcao = Console.readInt('\n' + "Digite um número entre 1 e 5:");
			
		
		
			switch (opcao){	
				case 1:	{
					
					umPedido = new Pedido();
					//cliente = new Cliente(Console.readLine('\n' + "Informe o nome do Cliente:"), umPedido);
					itens = pegaListaDeItens(umPedido);
					umPedido.setItens(itens);
					//umPedido.setCliente(cliente);
					long numero = pedidoAppService.inclui(umPedido);
					System.out.println('\n' + "Pedido número " + numero + " incluído com sucesso!");	
					break;
				}
				case 5:{	
					continua = false;
					break;
				}
				default:
					System.out.println('\n' + "Opção inválida!");
			}
		}
	}	

	private static List<Item> pegaListaDeItens(Pedido umPedido) {
		// TODO Auto-generated method stub
		boolean continua = true;
		String nomeItem;
		Item umItem;
		List<Item> itens = new ArrayList<Item>();
		int opcao = 0;
		while(continua){
			nomeItem= Console.readLine('\n' +	"Informe o nome do Item: ");
			umItem = new Item(nomeItem, umPedido);
			itens.add(umItem);
			System.out.println('\n' + "Quer continuar o cadastro de intens do pedido?");
			System.out.println("6. Para continuar");
			System.out.println("7. Volar ao menu anterior");
		
			opcao = Console.readInt('\n' + "Digite 6 ou 7:");
			
			switch (opcao) {
			case 6:
				break;
			case 7:
				continua = false;
				break;
			default:
				System.out.println('\n' + "Opção inválida!");
				break;
			}
		}
		return itens;
	}

}
