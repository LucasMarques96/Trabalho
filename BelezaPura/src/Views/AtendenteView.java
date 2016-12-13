package Views;

import Banco.BaseDeDados;
import Controllers.AtendenteController;
import Models.Atendente;
import java.util.Scanner;
import Views.MenuPrincipalView;

public class AtendenteView {
    Scanner scan = new Scanner(System.in);

    public int Menu(){
        
        System.out.println("--------------------");;
        System.out.println("1 - Cadastrar Atendente");
        System.out.println("2 - Exibir Atendentes cadastrados");
        System.out.println("3 - Alterar Atendente");
        System.out.println("4 - Excluir Atendente");
        System.out.println("5 - Pesquisar Atendentes");
        System.out.println("6 - Exibir Atendimentos");
        System.out.println("7 - Sair");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();
        
        return op;
        
    }
    
    public void exibirMenuAtendente() {
        
        int opcao = 0;
        
        do {
            opcao = Menu();
        
            switch (opcao) {
                case 1:
                    cadastroAtendente();
                    break;
                case 2:
                    exibicaoAtendente();
                    break;
                case 3:
                    alteracaoAtendente();
                    break;
                case 4:
                    exclusaoAtendente();
                    break;
                case 5:
                    pesquisaAtendentePorCodigo();
                    break;
                case 6:
                    AtendimentoView.exibirAtendimentos();
                case 7:
                    MenuPrincipalView.inicio();
            }
        } while (opcao != 7);
    }
    
    private void cadastroAtendente() {
        System.out.print("Digite o código do Atendente: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do Atendente: ");
        String nome = scan.nextLine();

        System.out.print("Digite o CPF do Atendente: ");
        String cpf = scan.nextLine();
        
        System.out.println("Informe o tipo do Atendente:");
        String tipo = scan.nextLine();

        AtendenteController.adicionarAtendente(codigo , nome , cpf , tipo);
    }

    private void exibicaoAtendente() {

        System.out.println("----------");

        for (Atendente a : BaseDeDados.getAtendentes()) {

            System.out.println("Código Atendente: " + a.getCodigo());
            System.out.println("Nome Atendente: " + a.getNome());
            System.out.println("CPF Atendente: " + a.getCpf());
            System.out.println("Tipo de Atendente:" + a.getTipo());
            System.out.println("");
        }
        System.out.println("---------");
    }

    private void pesquisaAtendentePorCodigo() {
        System.out.print("Digite o código do Atendente: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        Atendente a = AtendenteController.buscarPorCodigo(codigo);

        if (a != null) {
            System.out.println("");
            System.out.println("Código: " + a.getCodigo());
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("Tipo: " + a.getTipo());
            System.out.println("");
        } else {
            System.out.println("Atendente não cadastrado");
        }

    }
    
    private static void alteracaoAtendente() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Informe o código do atendente: ");
        int codigo = scan.nextInt();
        scan.nextLine();
        
        Atendente a = AtendenteController.buscarPorCodigo(codigo);
        
        if (a != null) {
            System.out.print("Informe o novo código do Atendente:" + a.getCodigo());
            int codigoAtendente = scan.nextInt();
            scan.nextLine();
            a.setCodigo(codigoAtendente);
            
            System.out.print("Informe o novo nome do Atendente:" + a.getNome());
            String nomeAtendente = scan.nextLine();
            a.setNome(nomeAtendente);
            
            System.out.println("Informe o novo CPF do atendente:" + a.getCpf());
            String cpfAtendente = scan.nextLine();
            a.setCpf(cpfAtendente);
            
            System.out.println("Informe o novo tipo do atendente: " + a.getTipo());
            String tipoAtendente = scan.nextLine();
            a.setTipo(tipoAtendente);
            
        }else{
            System.out.println("Atendente não cadastrado!!!");
        }
    }
    
    private static void exclusaoAtendente() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite o código do atendente: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        Atendente a = AtendenteController.buscarPorCodigo(codigo);

        if (a != null) {
            BaseDeDados.getAtendentes().remove(a);
            System.out.println("Atendente removido com sucesso");
        } else {
            System.out.println("Atendente não encontrado!!");
        }
    }
}
