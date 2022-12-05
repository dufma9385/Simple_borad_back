package com.minkyeong.studio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
