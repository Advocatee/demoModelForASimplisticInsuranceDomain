package com.example.demo.mapper;

import com.example.demo.dto.ContractDto;
import com.example.demo.model.BasePolicy;
import com.example.demo.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    ContractDto toDto(BasePolicy basePolicy);

    ContractDto toDto(Contract contract);
}
