package br.com.fernandoguide.hexagonal.infrastructure.mappers;

import br.com.fernandoguide.hexagonal.domain.data.BookDto;
import br.com.fernandoguide.hexagonal.infrastructure.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper extends  GenericMapper<Book,BookDto>{

    @Override
    @Mapping(target = "id",ignore = true)
    Book asEntity(BookDto dto);

}
