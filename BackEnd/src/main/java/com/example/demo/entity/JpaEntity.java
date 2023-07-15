package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.LastModifiedDate;



import java.util.Date;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class JpaEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    protected String id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    protected Date createAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    protected Date modifiedAt;

}
