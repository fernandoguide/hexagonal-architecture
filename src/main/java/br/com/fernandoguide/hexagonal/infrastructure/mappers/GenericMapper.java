package br.com.fernandoguide.hexagonal.infrastructure.mappers;

import java.util.List;

public interface GenericMapper<E, D> {
    E asEntity(D dto);

    D asDTO(E entity);

    List<E> asEntityList(List<D> dtoList);

    List<D> asDTOList(List<E> entityList);

}
