package com.api.WSCarSales.Dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModelDto {

    @NotBlank(message = "marca_id field is required")
    private String nome;

    @NotNull(message = "marca_id field is required")
    private Integer marca_id;

    @NotNull(message="valor_fipe is required")
    @Min(value = 0L, message = "The value must be positive")
    private Double valor_fipe;

    public Integer getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Integer marca_id) {
        this.marca_id = marca_id;
    }

    public Double getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(Double valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}