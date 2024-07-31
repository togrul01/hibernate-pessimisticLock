package org.example.hibernatepessimist.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.OffsetDateTime;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    static final Boolean DEFAULT_DELETED_VALUE = false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Version
    Long version;

    @Column(name = "created_at", updatable = false, nullable = false)
    OffsetDateTime created;

    @Column(name = "updated_at", nullable = false)
    OffsetDateTime updatedAt;

    Boolean deleted = DEFAULT_DELETED_VALUE;

    @PrePersist
    public void  prePersist(){
        this.created=OffsetDateTime.now();
        this.updatedAt=OffsetDateTime.now();
    }
}
