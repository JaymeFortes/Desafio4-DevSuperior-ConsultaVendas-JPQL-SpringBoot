package com.Desafio4_ConsultaVendas_JPQL.service;

import com.Desafio4_ConsultaVendas_JPQL.dto.SaleMinDTO;
import com.Desafio4_ConsultaVendas_JPQL.dto.SaleSumDTO;
import com.Desafio4_ConsultaVendas_JPQL.entities.Sale;
import com.Desafio4_ConsultaVendas_JPQL.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleMinDTO findByID(Long id) {
        Sale sale = repository.findById(id).orElse(null);
        return new SaleMinDTO(sale);
    }

    public Page<SaleMinDTO> getSalesReport(String minDate, String maxDate, String sellerName, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        // Definir data final como hoje, caso não seja informada
        LocalDate endDate = (maxDate == null || maxDate.isEmpty()) ? today : LocalDate.parse(maxDate);

        // Definir data inicial como 1 ano antes da data final, caso não seja informada
        LocalDate startDate = (minDate == null || minDate.isEmpty()) ? endDate.minusYears(1) : LocalDate.parse(minDate);

        // Se o nome for nulo ou vazio, definir como null para a JPQL tratar corretamente
        String sellerFilter = (sellerName == null || sellerName.isEmpty()) ? null : sellerName;

        return repository.searchSalesReport(startDate, endDate, sellerFilter, pageable);
    }

    public List<SaleSumDTO> searchSalesSum(String minDate, String maxDate) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        // Definir data final como hoje, caso não seja informada
        LocalDate endDate = (maxDate == null || maxDate.isEmpty()) ? today : LocalDate.parse(maxDate);

        // Definir data inicial como 1 ano antes da data final, caso não seja informada
        LocalDate startDate = (minDate == null || minDate.isEmpty()) ? endDate.minusYears(1) : LocalDate.parse(minDate);

       return repository.searchSalesSummary(startDate,endDate);
    }

}
