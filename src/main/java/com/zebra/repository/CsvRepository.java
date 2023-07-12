package com.zebra.repository;

import com.zebra.entity.Csv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRepository extends JpaRepository<Csv, Long> {

}
