package com.api.WSCarSales.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique=true)
    private String nome_marca;

    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    private List<Model> models = new ArrayList<>();

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }
}
