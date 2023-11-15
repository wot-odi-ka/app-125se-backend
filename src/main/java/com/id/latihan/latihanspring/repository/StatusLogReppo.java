package com.id.latihan.latihanspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.id.latihan.latihanspring.model.StatusLog;

@Repository
public interface StatusLogReppo extends JpaRepository<StatusLog,Long> {
  
}
