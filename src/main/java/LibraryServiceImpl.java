package main.java;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibraryServiceImpl implements LibraryService {

    private final BookDAO dao;
	
    public LibraryServiceImpl(boolean carregaLib) {
		this.dao = new BookDAO();
		if ( carregaLib ) {
			this.dao.carregaBiblioteca(BookDAO.DEFAULT_PATH);
		}
	}
    
	@Override
	public BookModel getBookWithTitle(String tit) {
        return dao.obtemLivroComTitulo(tit);
	}

	@Override
	public List<BookModel> getSortedComputingBooksByTitle() {
        return dao.obtemListaDeLivrosComputacaoOrganizadaPorTitulo();
	}

	@Override
	public Optional<TopicEnum> mostPopularTopics() {
        return dao.topicoMaisPopular();
	}

	@Override
	public List<String> getBookTitles() {
        return dao.obtemTitulosDosLivros();
	}

	@Override
	public Map<TopicEnum, List<BookModel>> booksByTopic() {
        return dao.livrosAgrupadosPorTopico();
	}

	@Override
	public Map<TopicEnum, Long> bookCountByTopic() {
        return dao.contagemDeLivrosPorTopico();
	}

	@Override
	public int countBooks() {
        return dao.contagemDosLivros();
	}

	@Override
	public void add(BookModel bookModel) {
        this.dao.adiciona(bookModel);
	}

}
