package main.java;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookDAO {

    public static Path DEFAULT_PATH = Paths.get("src/main/resources/books.csv");
    private List<BookModel> biblioteca = new ArrayList<>();

    public List<BookModel> obtemListaDeLivrosComputacaoOrganizadaPorTitulo() {
        return biblioteca.stream()
                .filter(b -> b.topico() == TopicEnum.COMPUTING)
                .sorted(Comparator.comparing(BookModel::titulo))
                .collect(Collectors.toList());
    }

    public Optional<TopicEnum> topicoMaisPopular() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(BookModel::topico, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public BookModel obtemLivroComTitulo(String title) {
        for (BookModel livro : biblioteca) {
            if (livro.titulo().equals(title)) {
                return livro;
            }
        }
        return null;
    }

    public List<String> obtemTitulosDosLivros() {
        return biblioteca.stream()
                .map(BookModel::titulo)
                .collect(Collectors.toList());
    }

    public Map<TopicEnum, List<BookModel>> livrosAgrupadosPorTopico() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(BookModel::topico));
    }

    public Map<TopicEnum, Long> contagemDeLivrosPorTopico() {
        return biblioteca.stream()
                .collect(Collectors.groupingBy(BookModel::topico, Collectors.counting()));
    }

    public void carregaBiblioteca(Path caminho) {
        this.biblioteca = Utils.carregaBiblioteca(caminho);
    }

    public List<BookModel> obtemBiblioteca() {
        return Collections.unmodifiableList(biblioteca);
    }

    public static void main(String[] args) {
        final BookDAO bookDAO = new BookDAO();
        bookDAO.carregaBiblioteca(DEFAULT_PATH);
    }

    public int contagemDosLivros() {
        return biblioteca.size();
    }

    public void adiciona(BookModel livro) {
        this.biblioteca.add(livro);
    }
	
	
}
