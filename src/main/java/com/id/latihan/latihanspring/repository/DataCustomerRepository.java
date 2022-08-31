package com.id.latihan.latihanspring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.id.latihan.latihanspring.dto.DataUkuranBajuDto;
import com.id.latihan.latihanspring.model.DataCustomer;



@Repository
public interface DataCustomerRepository extends JpaRepository<DataCustomer,Long> {

    @Query(value = "select * from customer a where a.nama like %:nama%", nativeQuery = true)
    List<DataCustomer> findByName(@Param("nama") String nama);

    @Query(value = "select * from customer b join baju a on a.id = b.id_databaju where a.warna_baju like %:warna%", nativeQuery = true)
    List<DataCustomer> findByWarnaBaju(@Param("warna") String warna);

    @Query(value = "select coalesce(sum(b.jumlah_baju),0) as jumlah_baju  from customer b join baju a on a.id =b.id_databaju", nativeQuery = true)
    Long totalBajuTerjual();

    @Query(value = "select coalesce(sum(b.jumlah_baju),0) as jumlah_baju  from customer b join baju a on a.id =b.id_databaju where a.warna_baju like %:hitam%", nativeQuery = true)
    long findByWarnaBajuHitam(@Param("hitam") String hitam);

    @Query(value = "select coalesce(sum(b.jumlah_baju),0) as jumlah_baju  from customer b join baju a on a.id =b.id_databaju where a.warna_baju like %:putih%", nativeQuery = true)
    long findByWarnaBajuPutih(@Param("putih") String putih);

    @Query(value = "select coalesce(sum(b.jumlah_baju),0) as jumlah_baju  from customer b join baju a on a.id =b.id_databaju where a.warna_baju like %:hijau%", nativeQuery = true)
    long findByWarnaBajuHijau(@Param("hijau") String hijau);

    @Query(value = "select coalesce(sum(b.total_harga),0) as totalHarga  from customer b join baju a on a.id =b.id_databaju", nativeQuery = true)
    long totalPendapatan();

    @Query(value = "select a.ukuran_baju ,coalesce(sum(b.jumlah_baju),0) as jumlah_baju from customer b join baju a on a.id =b.id_databaju where a.warna_baju like %:warna% and a.jenis_baju like %:jenis% group by a.ukuran_baju", nativeQuery = true)
    List <DataUkuranBajuDto> totalUkuranBajuHitamPanajang(@Param("warna") String warna,@Param("jenis") String jenis);
    
    @Query(value = "select * from customer c order by c.created_dt asc ", nativeQuery = true)
    List<DataCustomer> DataCustomerList();
}
