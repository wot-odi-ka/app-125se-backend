package com.id.latihan.latihanspring.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.latihan.latihanspring.dto.DataCustomerDto;
import com.id.latihan.latihanspring.model.DataBaju;
import com.id.latihan.latihanspring.model.DataCustomer;
import com.id.latihan.latihanspring.payload.response.DataBajuResponse;
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
        int total = baju.getHargaBaju() * customer.getJumlahBaju();
        customer.setTotalHarga(total);  
        return repository.save(customer);
    }

    public DataCustomer searchByid(Long Id){
        return repository.findById(Id).orElse(null);
    }

    public List<DataCustomer> gCustomers(){
        return repository.findAll();
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

    public long searchBywarnaBajuHijau(String hijau){
        return repository.findByWarnaBajuHijau(hijau);
    }

    public long searchByTotalbaju(){
        return repository.totalBajuTerjual();
    }

    public long searchByTotaPendapatan(){
        return repository.totalPendapatan();
    }

    public List<DataCustomer> searchBywarnaBaju(String warna){
        return repository.findByWarnaBaju(warna);
    }



    public String deletDatabajuById(Long id){
         repository.deleteById(id);

         return "remove data " +id;
    }

    public DataCustomer updCustomer(DataCustomerDto customer){
        DataBaju baju = bajuRepository.findById(customer.getId_Databaju()).orElse(null);
        DataCustomer data = repository.findById(customer.getId()).orElse(null);
        data.setNama(customer.getNama());
        data.setAlamat(customer.getAlamat());
        data.setGender(customer.getGender());
        data.setJumlahBaju(customer.getJumlahBaju());
        data.setNoHp(customer.getNoHp());
        baju.setId(customer.getId_Databaju());
        data.setDataBaju(baju);
        data.setJumlahBaju(customer.getJumlahBaju());
        int total = baju.getHargaBaju() * data.getJumlahBaju();
        data.setTotalHarga(total);  

        return repository.save(data);
    }
}
