package com.id.latihan.latihanspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.id.latihan.latihanspring.model.DataCustomer;


@Repository
public interface DataCustomerRepository extends JpaRepository<DataCustomer,Long> {

    @Query(value = "select * from customer a where a.nama like %:nama%", nativeQuery = true)
    List<DataCustomer> findByName(@Param("nama") String nama);

    @Query(value = "select * from customer b join baju a on a.id = b.id_databaju where a.warna_baju like %:warna%", nativeQuery = true)
    List<DataCustomer> findByWarnaBaju(@Param("warna") String warna);
    
}
