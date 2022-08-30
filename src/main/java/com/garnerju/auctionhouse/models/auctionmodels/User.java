package com.garnerju.auctionhouse.models.auctionmodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {

    @Id
    @Column(name="user_id")
    private Double id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
}
