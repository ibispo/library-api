package test.java.pesquisa_livro;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import main.java.BookModel;
import main.java.LibraryService;
import main.java.TopicEnum;

import java.util.Optional;

import org.junit.Assert;

public class DefinicaoPassos {
	
	private LibraryService service;
	private BookModel book;
	private Optional<TopicEnum> topic;

	@Dado("Que a minha biblioteca esta inicializada")
	public void queAMinhaBibliotecaEstaInicializada() {
		service = LibraryService.getService();
	}
	
	@Quando("Eu pesquiso o livro {string}")
	public void euPesquisoOLivro(String bookTitle) {
		book = service.getBookWithTitle(bookTitle);
	}
	
	@Entao("Eu encontro esse livro")
	public void euEncontroEsseLivro() {
		Assert.assertNotNull(book);
	}
	
	
	@Quando("Eu pesquiso o livro mais popular")
	public void euPesquisoOLivroMaisPopular() {
		topic = service.mostPopularTopics();
	}
	
	@Quando("Eu encontro o topico {}")
	public void euEncontroOTopico(TopicEnum topic) {
		Assert.assertEquals(topic, this.topic.get());
	}
	
	@E("Encontro topico {}")
	public void encontroTopico(TopicEnum topic) {
		Assert.assertEquals(topic, this.topic.get());
	}
	
	
	
	
	
	
	
}
