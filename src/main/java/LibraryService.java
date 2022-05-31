package main.java;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LibraryService {

	public static LibraryService getService() { 
		return new LibraryServiceImpl(true); 
	}

	public static LibraryService getService(boolean loadLib) { 
		return new LibraryServiceImpl(loadLib); 
	}
	
	BookModel getBookWithTitle(String tit);
	
	List<BookModel> getSortedComputingBooksByTitle();
	
	Optional<TopicEnum> mostPopularTopics();
	
	List<String> getBookTitles();
	
	Map<TopicEnum, List<BookModel>> booksByTopic();
	
	Map<TopicEnum, Long> bookCountByTopic();
	
	int countBooks();
	
	void add(BookModel bookModel);
	
}
