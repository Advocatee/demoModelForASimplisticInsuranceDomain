package com.example.demo.mapper;

import com.example.demo.dto.BasePolicyDto;
import com.example.demo.dto.PolicyDto;
import com.example.demo.model.BasePolicy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ClientMapper.class})
public interface PolicyMapper {

    PolicyMapper INSTANCE = Mappers.getMapper(PolicyMapper.class);


    @Mapping(source = "id", target = "id")
    PolicyDto toDto(BasePolicy basePolicy);

    List<BasePolicyDto> toDto(List<BasePolicy> policyList);

    BasePolicyDto toBaseDto(BasePolicy basePolicy);


}
