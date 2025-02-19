package com.Desafio4_ConsultaVendas_JPQL.repositories;

import com.Desafio4_ConsultaVendas_JPQL.dto.SaleMinDTO;

import com.Desafio4_ConsultaVendas_JPQL.dto.SaleSumDTO;
import com.Desafio4_ConsultaVendas_JPQL.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {



        @Query("SELECT new com.Desafio4_ConsultaVendas_JPQL.dto.SaleMinDTO(obj.id, obj.date, obj.amount, obj.seller.name) " +
                "FROM Sale obj " +
                "WHERE obj.date BETWEEN :startDate AND :endDate " +
                "AND (:sellerName IS NULL OR LOWER(obj.seller.name) LIKE LOWER(CONCAT('%', :sellerName, '%')))")
        Page<SaleMinDTO> searchSalesReport(@Param("startDate") LocalDate startDate,
                                              @Param("endDate") LocalDate endDate,
                                              @Param("sellerName") String sellerName,
                                              Pageable pageable);

    @Query("SELECT new com.Desafio4_ConsultaVendas_JPQL.dto.SaleSumDTO(s.seller.name, SUM(s.amount)) " +
            "FROM Sale s " +
            "WHERE s.date BETWEEN :startDate AND :endDate " +
            "GROUP BY s.seller.name")
    List<SaleSumDTO> searchSalesSummary(@Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);
    }


