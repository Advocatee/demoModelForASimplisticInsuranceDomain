package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Contacts extends BaseEntity {

    private String phoneNumber;
    private Date dateOfInformation;

}
//    по сущностям:
//        люди
//        транспорт
//        контракты(как минимум с полем для времени действия,
//        т.к. написано что временный, и полем енам из автограданки и каско)