package main.java;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BookModel {

	private final String titulo;
    private final int nrDePaginas;
    private final TopicEnum topico;
    private final Year dataPublicacao;
    private final List<String> autores;

    public BookModel(String titulo, int nrDePaginas, TopicEnum topico, Year dataPublicacao, String... autores) {
        this.titulo = titulo;
        this.nrDePaginas = nrDePaginas;
        this.topico = topico;
        this.dataPublicacao = dataPublicacao;
        this.autores = Arrays.asList(autores);
    }

	public String titulo() {
		return titulo;
	}

	public int nrDePaginas() {
		return nrDePaginas;
	}

	public TopicEnum topico() {
		return topico;
	}

	public Year dataPublicacao() {
		return dataPublicacao;
	}

	public List<String> autores() {
		return autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autores, dataPublicacao, nrDePaginas, titulo, topico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		return Objects.equals(autores, other.autores) && Objects.equals(dataPublicacao, other.dataPublicacao)
				&& nrDePaginas == other.nrDePaginas && Objects.equals(titulo, other.titulo) && topico == other.topico;
	}

	@Override
	public String toString() {
		return "BookModel [titulo=" + titulo + ", nrDePaginas=" + nrDePaginas + ", topico=" + topico
				+ ", dataPublicacao=" + dataPublicacao + ", autores=" + autores + "]";
	}
    
}
