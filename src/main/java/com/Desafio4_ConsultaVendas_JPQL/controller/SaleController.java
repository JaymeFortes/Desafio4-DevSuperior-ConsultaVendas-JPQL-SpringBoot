package com.Desafio4_ConsultaVendas_JPQL.controller;

import com.Desafio4_ConsultaVendas_JPQL.dto.SaleMinDTO;
import com.Desafio4_ConsultaVendas_JPQL.dto.SaleSumDTO;
import com.Desafio4_ConsultaVendas_JPQL.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
        SaleMinDTO dto = saleService.findByID(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/report")
    public ResponseEntity<Page<SaleMinDTO>> searchSalesReport(
            @RequestParam(value = "minDate", required = false) String minDate,
            @RequestParam(value = "maxDate", required = false) String maxDate,
            @RequestParam(value = "name", required = false) String sellerName,
            Pageable pageable) {

        Page<SaleMinDTO> result = saleService.getSalesReport(minDate, maxDate, sellerName, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<SaleSumDTO>> searchSalesSummary(
            @RequestParam(value = "minDate", required = false) String minDate,
            @RequestParam(value = "maxDate", required = false) String maxDate
    ) {
        List<SaleSumDTO> result = saleService.searchSalesSum(minDate, maxDate);
        return ResponseEntity.ok(result);
    }
}

