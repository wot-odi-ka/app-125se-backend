package com.id.latihan.latihanspring.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.latihan.latihanspring.dto.DataBajuDto;
import com.id.latihan.latihanspring.model.DataBaju;
import com.id.latihan.latihanspring.repository.DataBajuRepository;


@Service
public class DataBajuService {

    @Autowired
    private DataBajuRepository repository;


    public DataBaju saveDataBaju(DataBajuDto data){
        DataBaju dbBaju = new DataBaju();

            dbBaju.setId(data.getId());
            dbBaju.setHargaBaju(data.getHargaBaju());
            dbBaju.setJenisBaju(data.getJenisBaju());
            dbBaju.setNamaBaju(data.getNamaBaju());
            dbBaju.setUkuranBaju(data.getUkuranBaju());
            dbBaju.setWarnaBaju(data.getJenisBaju());
            return repository.save(dbBaju);
      
    }

    public DataBaju SearchByid(long id){
        return repository.findById(id).orElse(null);
    }

    public List<DataBaju> getDataAll(){

        return repository.findAll();
    }


    
}
