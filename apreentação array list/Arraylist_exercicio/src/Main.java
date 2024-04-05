import java.util.ArrayList;
import java.util.Scanner;
// Classe principal para gerenciar a loja de CDs
public class Main {
    // ArrayList para armazenar a coleção de CDs
    static ArrayList<CDs> colecaoCDs = new ArrayList<>();

    // Método para exibir o menu da loja
    public static void menu(){
        System.out.println("Bem-vindo à loja de CDs:");
        System.out.println("[1] Adicionar CD (ADD)");
        System.out.println("[2] Remover CD (REMOVE)");
        System.out.println("[3] Explodir a loja (CLEAR)");
        System.out.println("[4] Vender CD");
        System.out.println("[5] Exibir coleção completa (GET & SIZE)");
        System.out.println("[6] Modificar nome do album (SET)");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        colecaoCDs.add(new CDs("Michael Jackson", "Thriller", 1982, 10, 25.0));
        colecaoCDs.add(new CDs("The Beatles", "Abbey Road", 1969, 15, 30.0));
        colecaoCDs.add(new CDs("Pink Floyd", "The Dark Side of the Moon", 1973, 20, 35.0));

        int opcao;
        do {
            menu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarCD(scanner);
                    break;
                case 2:
                    removerCD(scanner);
                    break;
                case 3:
                    explodirLoja();
                    break;
                case 4:
                    venderCD(scanner);
                    break;
                case 5:
                    exibirColecao();
                    break;
                case 6:
                    modificarNomeAlbum(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Método para adicionar um novo CD à coleção
    public static void adicionarCD(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Informe o nome do artista: ");
        String artista = scanner.nextLine();
        System.out.print("Informe o nome do álbum: ");
        String nome_album = scanner.nextLine();
        System.out.print("Informe o ano de publicação: ");
        int ano_publicacao = scanner.nextInt();
        System.out.print("Informe a quantidade em estoque: ");
        int quantidade_estoque = scanner.nextInt();
        System.out.print("Informe o preço do álbum: ");
        double preco = scanner.nextDouble();
        CDs cd = new CDs(artista, nome_album, ano_publicacao, quantidade_estoque, preco);  // MÉTODO ADD
        colecaoCDs.add(cd);
        System.out.println("CD adicionado com sucesso!");
    }

    // Método para remover um CD da coleção
    public static void removerCD(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Informe o nome do álbum do CD a ser removido: ");
        String nomeAlbum = scanner.nextLine();
        boolean removido = false;
        for (int i = 0; i < colecaoCDs.size(); i++) {
            CDs cd = colecaoCDs.get(i);
            if (cd.nome_album.equalsIgnoreCase(nomeAlbum)) {
                colecaoCDs.remove(i);                                                   // MÉTODO REMOVE
                System.out.println("CD removido com sucesso!");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("CD não encontrado na coleção.");
        }
    }

    // Método para limpar toda a coleção de CDs
    public static void explodirLoja() {
        colecaoCDs.clear();
        System.out.println("A loja foi explodida! Todos os CDs foram removidos.");
    }

    // Método para vender um CD
    public static void venderCD(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Informe o nome do álbum a ser vendido: ");
        String nomeAlbum = scanner.nextLine();
        boolean vendido = false;
        for (CDs cd : colecaoCDs) {
            if (cd.nome_album.equalsIgnoreCase(nomeAlbum)) {
                if (cd.quantidade_estoque > 0) {
                    cd.quantidade_estoque--;
                    System.out.println("CD vendido com sucesso por R$" + cd.preco);
                    vendido = true;
                } else {
                    System.out.println("Desculpe, o CD não está disponível para venda.");
                }
                break;
            }
        }
        if (!vendido) {
            System.out.println("CD não encontrado na coleção.");
        }
    }

    // Método para exibir todos os CDs na coleção
    public static void exibirColecao() {
        System.out.println("");
        System.out.println("Coleção de CDs:");
        for (int i = 0; i < colecaoCDs.size(); i++) {
            CDs cd = colecaoCDs.get(i);                                                                 // MÉTODO GET
            exibirDetalhesCD(cd);
            System.out.println("---------------------------------");
        }
        System.out.printf("Quantidade de álbuns diferentes na loja: %d\n", colecaoCDs.size());   // MÉTODO SIZE
    }

    public static void modificarNomeAlbum(Scanner scanner) {
        scanner.nextLine();
        System.out.println();
        System.out.print("Informe o nome do álbum a ser modificado: ");
        String nomeAntigo = scanner.nextLine();
        System.out.print("Informe o novo nome do álbum: ");
        String novoNome = scanner.nextLine();
    
        boolean encontrado = false; // Variável para controlar se o álbum foi encontrado
    
        for (int i = 0; i < colecaoCDs.size(); i++) {
            CDs cd = colecaoCDs.get(i);
            if (cd.nome_album.equalsIgnoreCase(nomeAntigo)) {
                cd.nome_album = novoNome;
                colecaoCDs.set(i, cd);                                                                // MÉTODO SET
                System.out.println("Nome do álbum " + nomeAntigo + " modificado para " + novoNome);
                encontrado = true; // Indicar que o álbum foi encontrado
                break; // Retornar do método após modificar o nome do álbum
            }
        }
    
        if (!encontrado) {
            System.out.println("Álbum não encontrado na coleção.");
        }
    }

    // Método para exibir os detalhes de um CD
    public static void exibirDetalhesCD(CDs cd) {
        System.out.println("Artista: " + cd.artista);
        System.out.println("Álbum: " + cd.nome_album);
        System.out.println("Ano de Publicação: " + cd.ano_publicacao);
        System.out.println("Quantidade em Estoque: " + cd.quantidade_estoque);
        System.out.println("Preço: R$" + cd.preco);
    }
}