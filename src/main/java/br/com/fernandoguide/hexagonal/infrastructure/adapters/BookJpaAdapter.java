package br.com.fernandoguide.hexagonal.infrastructure.adapters;

import br.com.fernandoguide.hexagonal.domain.data.BookDto;
import br.com.fernandoguide.hexagonal.domain.ports.spi.BookPersistencePort;
import br.com.fernandoguide.hexagonal.infrastructure.entities.Book;
import br.com.fernandoguide.hexagonal.infrastructure.mappers.BookMapper;
import br.com.fernandoguide.hexagonal.infrastructure.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookJpaAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    @Override
    public BookDto addBook(BookDto bookDto) {

        Book book = bookMapper.asEntity(bookDto);

        Book bookSaved = bookRepository.save(book);

        return bookMapper.asDTO(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {

        List<Book> bookList = bookRepository.findAll();

        return bookMapper.asDTOList(bookList);
    }

    @Override
    public BookDto getBookById(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        return book.map(bookMapper::asDTO).orElse(null);

    }
}
