package com.api.WSCarSales.Enums;

public enum FuelType {
    FLEX("flex"),
    GASOLINA("gasolina"),
    ALCOOL("álcool"),
    DIESEL("diesel"),
    HIBRIDO("híbrido"),
    ELETRICO("elétrico");

    private String fuelType;
    FuelType(String fuelType){
    this.fuelType=fuelType;
    }

    public  String getFuelType() {
        return fuelType;
    }


    public static FuelType toEnum(String cod) {
        for(FuelType type : FuelType.values()) {
            if(cod.equals(type.getFuelType())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid type for combustível, try: flex,gasolina,álcool,diesel,híbrido or elétrico");
    }
}
