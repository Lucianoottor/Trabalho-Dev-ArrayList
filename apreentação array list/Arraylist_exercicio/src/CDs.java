// Classe que representa um CD
class CDs {
    String artista;
    String nome_album;
    int ano_publicacao;
    int quantidade_estoque;
    double preco;

    // Construtor para inicializar um CD
    public CDs(String artista, String nome_album, int ano_publicacao, int quantidade_estoque, Double preco){
        this.artista = artista;
        this.nome_album = nome_album;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_estoque = quantidade_estoque;
        this.preco = preco;
    }

    // Métodos para obter informações do CD
    String get_nome_album(){
        return nome_album;
    }

    String get_artista(){
        return artista;
    }

    int get_ano_publicacao(){
        return ano_publicacao;
    }

    int get_quantidade_estoque(){
        return quantidade_estoque;
    }

    double get_preco(){
        return preco;
    }

    boolean get_estoque_disponivel(){
        return quantidade_estoque > 0; // Retorna true se houver estoque, senão false
    }
}