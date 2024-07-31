package org.example.hibernatepessimist.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.hibernatepessimist.services.AuditRevisionListener;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "revinfo")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RevisionEntity(AuditRevisionListener.class)
public class AuditRevisionEntity extends DefaultRevisionEntity {
    @Column(name = "\"user\"")
    String user;


}
