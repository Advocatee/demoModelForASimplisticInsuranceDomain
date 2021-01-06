package com.example.demo.mapper;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.CreatePolicyRequest;
import com.example.demo.model.BasePolicy;
import com.example.demo.model.Contract;
import com.example.demo.model.VehiclePolicy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract toModel(CreatePolicyRequest contractRequest);

//    default <T extends BasePolicyDto> T toPolicyModel(<T extends BasePolicy> policyRequest){
//        VehiclePolicy vehiclePolicy = new VehiclePolicy();
//        vehiclePolicy.setCoverageType(policyRequest.getCoverageType());
//        return vehiclePolicy;
//    }



    ContractDto toDto(Contract contract);

}
