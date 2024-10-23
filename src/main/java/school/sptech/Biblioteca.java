package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
    }

    ;

    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
                if (livro.getAutor() != null && !livro.getAutor().isBlank()) {
                    if (livro.getDataPublicacao() != null) {
                        livros.add(livro);
                    }
                }
            }
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                break;
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosBusca = new ArrayList<>();
        for(Livro livro : livros){
            if (livro.getDataPublicacao().getYear() <= ano){
                livrosBusca.add(livro);
            }
        }
        return livrosBusca;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> listaTop = new ArrayList<>();

        for (Livro livro : livros) {
            if (listaTop.size() < 5) {
                listaTop.add(livro);
            } else {
                listaTop.sort((l1, l2) -> Double.compare(l2.calcularMediaAvaliacoes(), l1.calcularMediaAvaliacoes()));
                if (livro.calcularMediaAvaliacoes() > listaTop.get(4).calcularMediaAvaliacoes()) {
                    listaTop.remove(4);
                    listaTop.add(livro);
                }
            }
        }
        listaTop.sort((l1, l2) -> Double.compare(l2.calcularMediaAvaliacoes(), l1.calcularMediaAvaliacoes()));

        return listaTop;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", Livros=" +livros +
                '}';
    }
}
