// Clase NUEVA: CategoriaMapper
package com.skillmap.backend.mapper;

import com.skillmap.backend.dto.CategoriaDTO;
import com.skillmap.backend.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    Categoria toEntity(CategoriaDTO dto);
    CategoriaDTO toDTO(Categoria entity);
}
