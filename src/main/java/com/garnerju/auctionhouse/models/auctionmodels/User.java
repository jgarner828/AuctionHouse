package com.garnerju.auctionhouse.models.auctionmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {

    @Id
    @Column(name="email")
    private Double email;
    @Column(name="name")
    private String name;

}
