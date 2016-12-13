package Views;

import Banco.BaseDeDados;
import Controllers.ClienteController;
import java.util.Scanner;
import Models.Cliente;

public class ClienteView {
    Scanner scan = new Scanner(System.in);

    public int Menu(){
        
        System.out.println("---------- CLIENTE ----------");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Alterar dados");
        System.out.println("3 - Excluir Cadastro");
        System.out.println("4 - Exibir dados cadastrais");
        System.out.println("5 - Agendar atendimento");
        System.out.println("6 - Voltar");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();
        
        return op;
        
    }
    
    public void exibirMenuCliente() {
        int opcao;
        do {
            opcao = Menu();
        
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    pesquisarClientePorCodigo();
                    break;
                case 5:
                    AtendimentoView.agendamentoAtendimento();
                case 6:
                    MenuPrincipalView.inicio();
            }
        } while (opcao != 6);
    }
    
    public void cadastrarCliente() {
        System.out.print("Digite o código do cliente: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scan.nextLine();

        ClienteController.adicionarCliente(codigo, nome, cpf);
    }

    public void exibirClientes() {

        System.out.println("---");

        for (Cliente c : BaseDeDados.getClientes()) {
            
            System.out.println("");
            System.out.println("Código cliente: " + c.getCodigo());
            System.out.println("Nome cliente: " + c.getNome());
            System.out.println("CPF cliente: " + c.getCpf());
            System.out.println("");
            
        }
    }

    private void pesquisarClientePorCodigo() {
        System.out.print("Digite o código do cliente: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        Cliente c = ClienteController.buscarPorCodigo(codigo);

        if (c != null) {
            System.out.println("");
            System.out.println("Código: " + c.getCodigo());
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("");
        } else {
            System.out.println("Cliente não encontrado");
        }

    }
    
    public static void alterarCliente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o código do cliente: ");
        int codigo = scan.nextInt();
        scan.nextLine();
        
        Cliente c = ClienteController.buscarPorCodigo(codigo);
        
        if (c != null) {
            System.out.print("Informe o novo código do cliente:" + c.getCodigo());
            int codLanche = scan.nextInt();
            scan.nextLine();
            c.setCodigo(codLanche);
            
            System.out.print("Informe o novo nome do cliente: " + c.getNome());
            String nomeCliente = scan.nextLine();
            c.setNome(nomeCliente);
            
            System.out.println("Informe o novo CPF do cliente:");
            String cpfCliente = scan.nextLine();
            c.setCpf(cpfCliente);
            
            System.out.println("ALTERAÇÃO BEM SUCEDIDA");
        }else{
            System.out.println("Cliente não cadastrado!!!");
        }
    }
    
    public static void excluirCliente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o código do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Cliente c = ClienteController.buscarPorCodigo(cod);

        if (c != null) {
            BaseDeDados.getClientes().remove(c);
            System.out.println("CLIENTE REMOVIDO COM SUCESSO");
        } else {
            System.out.println("Cliente não encontrado!!");
        }
    }
}
