package com.api.WSCarSales.Models;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Long timestamp_cadastro;
    @ManyToOne
    @JoinColumn(name = "modelo_id", referencedColumnName = "id")
    private Model modelo;

    @Column(nullable = false)
    private  Integer ano;

    @Column(nullable = false)
    private String combustivel;

    @Column(nullable = false)
    private String num_portas;

    @Column(nullable = false)
    private String cor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimestamp_cadastro() {
        return timestamp_cadastro;
    }

    public void setTimestamp_cadastro(Long timestamp_cadastro) {
        this.timestamp_cadastro = timestamp_cadastro;
    }

    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(String num_portas) {
        this.num_portas = num_portas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
