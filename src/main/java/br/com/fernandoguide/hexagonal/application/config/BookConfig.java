package br.com.fernandoguide.hexagonal.application.config;

import br.com.fernandoguide.hexagonal.domain.ports.api.BookServicePort;
import br.com.fernandoguide.hexagonal.domain.ports.spi.BookPersistencePort;
import br.com.fernandoguide.hexagonal.domain.service.BookServiceImpl;
import br.com.fernandoguide.hexagonal.infrastructure.adapters.BookJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence(){
        return new BookJpaAdapter();
    }

    @Bean
    public BookServicePort bookService(){
        return new BookServiceImpl(bookPersistence());
    }
}