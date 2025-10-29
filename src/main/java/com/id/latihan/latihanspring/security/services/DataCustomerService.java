package com.id.latihan.latihanspring.security.services;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.id.latihan.latihanspring.dto.DataCustomerDto;
import com.id.latihan.latihanspring.dto.DataUkuranBajuDto;
import com.id.latihan.latihanspring.model.DataBaju;
import com.id.latihan.latihanspring.model.DataCustomer;
import com.id.latihan.latihanspring.repository.DataBajuRepository;
import com.id.latihan.latihanspring.repository.DataCustomerRepository;

@Service
public class DataCustomerService {
    
    @Autowired
    private DataCustomerRepository repository;

    @Autowired
    private DataBajuRepository bajuRepository;



    public DataCustomer addDataCustomer(DataCustomerDto data){
        DataBaju baju = bajuRepository.findById(data.getId_Databaju()).orElse(null);
        DataCustomer customer = new DataCustomer();
        customer.setNama(data.getNama());
        customer.setAlamat(data.getAlamat());
        customer.setGender(data.getGender());
        customer.setNoHp(data.getNoHp());
        baju.setId(data.getId_Databaju());
        customer.setDataBaju(baju);
        customer.setJumlahBaju(data.getJumlahBaju());
        if(customer.getJumlahBaju() >= 5 && customer.getJumlahBaju() < 12){
            int discond5 = baju.getHargaBaju() - 15000;
            int total = discond5 * customer.getJumlahBaju();
            customer.setTotalHarga(total); 
        }else if(customer.getJumlahBaju() >=12){
            int discond12 = baju.getHargaBaju() - 25000;
            int total = discond12 * customer.getJumlahBaju();
            customer.setTotalHarga(total); 
        }else if(customer.getJumlahBaju() <= 4){
            int total = baju.getHargaBaju() * customer.getJumlahBaju();

            customer.setTotalHarga(total); 
        }
            customer.setCreatedDt(new Timestamp(System.currentTimeMillis()));
            customer.setCreatedBy(data.getUsername());

        

        return repository.save(customer);
    }

    public DataCustomer searchByid(Long Id){
        return repository.findById(Id).orElse(null);
    }

    public List<DataCustomer> gCustomers(){
        return repository. DataCustomerList();
    }

    public List<DataCustomer> searchByname(String nama){
        return repository.findByName(nama);
    }

    public long searchBywarnaBajuHitam(String hitam){
        return repository.findByWarnaBajuHitam(hitam);
    }

    public long searchBywarnaBajuPutih(String putih){
        return repository.findByWarnaBajuPutih(putih);
    }

    public long searchBywarnaBajuHijau(String biru){
        return repository.findByWarnaBajuHijau(biru);
    }

    public long searchByTotalbaju(){
        return repository.totalBajuTerjual();
    }

    public long searchByTotaPendapatan(){
        return repository.totalPendapatan();
    }
    public List <DataUkuranBajuDto> serchByUkuranBajuPanjang(String warna,String jenis){
        return repository.totalUkuranBajuHitamPanajang(warna, jenis);
    }

    public List<DataCustomer> searchBywarnaBaju(String warna){
        return repository.findByWarnaBaju(warna);
    }



    public String deletDatabajuById(Long id){
         repository.deleteById(id);

         return "remove data " +id;
    }

    public DataCustomer updCustomer(DataCustomerDto customer){
        DataCustomer data = repository.findById(customer.getId()).orElse(null);
        DataBaju baju = bajuRepository.findById(customer.getId_Databaju()).orElse(null);
        data.setNama(customer.getNama());
        data.setAlamat(customer.getAlamat());
        data.setGender(customer.getGender());
        data.setJumlahBaju(customer.getJumlahBaju());
        data.setNoHp(customer.getNoHp());
        baju.setId(customer.getId_Databaju());
        data.setDataBaju(baju);
        data.setJumlahBaju(customer.getJumlahBaju());
        if(data.getJumlahBaju() >= 5 && data.getJumlahBaju() < 12){
            int discond5 = baju.getHargaBaju() - 15000;
            int total = discond5 * data.getJumlahBaju();
            data.setTotalHarga(total); 
        }else if(data.getJumlahBaju() >=12){
            int discond12 = baju.getHargaBaju() - 25000;
            int total = discond12 * data.getJumlahBaju();
            data.setTotalHarga(total); 
        }else if(data.getJumlahBaju() <= 4){
            int total = baju.getHargaBaju() * data.getJumlahBaju();

            data.setTotalHarga(total); 
        }  
        data.setChangedDt(new Timestamp(System.currentTimeMillis()));
        data.setChangedBy(customer.getUsername());

        return repository.save(data);
    }
}
