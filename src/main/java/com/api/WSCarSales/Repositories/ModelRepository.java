package com.api.WSCarSales.Repositories;

import com.api.WSCarSales.Models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
}