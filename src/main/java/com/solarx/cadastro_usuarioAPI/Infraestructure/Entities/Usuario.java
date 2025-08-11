package com.solarx.cadastro_usuarioAPI.Infraestructure.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok this gives us all our getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder //readable object construction, especially useful when there are many fields or optional values
@Table(name = "usuario") // the table name the database will create
@Entity //have to use this so JPA knows its an entity
public class Usuario {

    // Must have ID and Generated value to the database will automatically generate the ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "email", unique = true) // unique so there wont be 2 emails the same...
    private String email;

    private Integer age;


}
