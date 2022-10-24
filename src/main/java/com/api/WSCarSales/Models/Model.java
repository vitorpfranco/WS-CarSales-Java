package com.api.WSCarSales.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double valor_fipe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    private Brand marca;

    @JsonIgnore
    @OneToMany(mappedBy = "modelo")
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Brand getMarca() {
        return marca;
    }

    public void setMarca(Brand marca) {
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Double getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(Double valor_fipe) {
        this.valor_fipe = valor_fipe;
    }
}
