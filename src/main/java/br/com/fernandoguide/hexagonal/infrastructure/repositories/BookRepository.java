package br.com.fernandoguide.hexagonal.infrastructure.repositories;

import br.com.fernandoguide.hexagonal.infrastructure.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
