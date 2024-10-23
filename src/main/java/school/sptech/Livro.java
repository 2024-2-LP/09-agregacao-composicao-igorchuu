package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro(){};

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if ((qtdEstrelas != null ) && descricao != null && !descricao.isBlank()) {

                if (qtdEstrelas >= 0 && qtdEstrelas <= 5) {
                    Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrelas);
                    avaliacoes.add(avaliacao);

            }
        }
    }

    public Double calcularMediaAvaliacoes(){
        Double soma = 0.0;
        if(avaliacoes.size() == 0){
            return 0.0;
        }else {
            for (Avaliacao avaliacao : avaliacoes){
                soma += avaliacao.getQtdEstrelas();
            }
        }
        Double media = soma / avaliacoes.size();
        return media;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
