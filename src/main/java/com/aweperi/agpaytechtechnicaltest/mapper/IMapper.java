package com.aweperi.agpaytechtechnicaltest.mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IMapper<Entity, DTO> {

    public Entity toEntity(DTO dto);

    public DTO toDTO(Entity entity);

    public List<Entity> toEntity(List<DTO> iterDto);

    public List<DTO> toDTO(List<Entity> iterEntity);
}
