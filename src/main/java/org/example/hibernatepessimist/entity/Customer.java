package org.example.hibernatepessimist.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;

@Entity
@Data
@Audited
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE  CUSTOMER SET DELETED = TRUE WHERE ID = ? ,AND VERSION = ?")
public class Customer extends BaseEntity {

    String name;

    String surName;

    String phone;

    String email;

    Integer age;

    String gender;

    BigDecimal balance;

}
