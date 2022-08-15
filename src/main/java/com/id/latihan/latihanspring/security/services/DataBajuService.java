package com.id.latihan.latihanspring.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.latihan.latihanspring.model.DataBaju;
import com.id.latihan.latihanspring.repository.DataBajuRepository;


@Service
public class DataBajuService {

    @Autowired
    private DataBajuRepository repository;


    public DataBaju saveDataBaju(DataBaju data){

        return repository.save(data);
    }

    public DataBaju SearchByid(long id){
        return repository.findById(id).orElse(null);
    }

    public List<DataBaju> getDataAll(){

        return repository.findAll();
    }
    
}
