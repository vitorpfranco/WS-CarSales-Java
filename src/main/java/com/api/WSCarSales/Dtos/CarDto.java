package com.api.WSCarSales.Dtos;


import com.api.WSCarSales.Models.Car;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarDto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message= "modelo_id field is required")
    private Integer modelo_id;

    @Max(value = 2023,message = "ano must be above 2023")
    @Min(value = 1900,message = "ano must be above 1900")
    @NotNull(message= "ano field is required")
    private  Integer ano;

    @NotNull(message= "combustivel field is required")
    private String combustivel;

    @NotBlank(message= "num_portas field is required")
    @Max(value = 5,message = "num_portas can have the maximum value of 5.")
    @Min(value = 2,message = "num_portas can have the maximum value of 2.")
    private String num_portas;

    @NotBlank(message= "cor field is required")
    private String cor;

    private Integer id;
    private Integer marca_id;
    private String marca_nome;
    private String nome_modelo;
    private Double valor_fipe;
    private Long timestamp_cadastro;


    public CarDto() {
        super();
    }
    public CarDto(Car car){
        this.id = car.getId();
        this.marca_id = car.getModelo().getMarca().getId();
        this.marca_nome= car.getModelo().getMarca().getNome_marca();
        this.nome_modelo=car.getModelo().getNome();
        this.ano=car.getAno();
        this.combustivel = car.getCombustivel().getFuelType();
        this.num_portas = car.getNum_portas();
        this.valor_fipe = car.getModelo().getValor_fipe();
        this.cor= car.getCor();
        this.timestamp_cadastro= car.getTimestamp_cadastro();
    }
    public Integer getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Integer modelo_id) {
        this.modelo_id = modelo_id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }

    public String getMarca_nome() {
        return marca_nome;
    }

    public void setMarca_nome(String marca_nome) {
        this.marca_nome = marca_nome;
    }

    public String getNome_modelo() {
        return nome_modelo;
    }

    public void setNome_modelo(String nome_modelo) {
        this.nome_modelo = nome_modelo;
    }

    public Double getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(Double valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public Long getTimestamp_cadastro() {
        return timestamp_cadastro;
    }

    public void setTimestamp_cadastro(Long timestamp_cadastro) {
        this.timestamp_cadastro = timestamp_cadastro;
    }
}
