package com.Desafio4_ConsultaVendas_JPQL.dto;

public class SaleSumDTO {
    private String sellerName;
    private Double sum;

    public SaleSumDTO(String sellerName, Double sum) {
        this.sellerName = sellerName;
        this.sum = sum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getSum() {
        return sum;
    }
}
