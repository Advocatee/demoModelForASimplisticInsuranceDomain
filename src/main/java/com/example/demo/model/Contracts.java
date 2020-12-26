package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Contracts extends BaseEntity {

    private String phoneNumber;
    private Date dateOfInformation;
    private enum typeOfInsurance{
        АВТОКАСКО,
        АВТОГРАЖДАНКА
    }

}
