package com.api.WSCarSales.Dtos;

import javax.validation.constraints.NotBlank;

public class BrandDto {

    @NotBlank(message= "nome_marca field is required")
    private String nome_marca;

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }
}
