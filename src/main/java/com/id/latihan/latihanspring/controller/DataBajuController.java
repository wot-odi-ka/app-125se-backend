package com.id.latihan.latihanspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.latihan.latihanspring.model.DataBaju;
import com.id.latihan.latihanspring.payload.response.MessageResponse;
import com.id.latihan.latihanspring.security.services.DataBajuService;

@CrossOrigin(origins = "http://localhost:8022/")
@RestController
@RequestMapping("/baju")
public class DataBajuController {

    @Autowired
    private DataBajuService service;


    @PostMapping("/add")
    public ResponseEntity<?> addDataBaju(@RequestBody DataBaju data){
        service.saveDataBaju(data);
        return ResponseEntity.ok(new MessageResponse("Success insert Data to Db"));
    }

    @GetMapping("/search/{id}")
    public DataBaju searchId(@PathVariable long id){
        return service.SearchByid(id);
    }

    @GetMapping("/getAll")
    public List<DataBaju> gList(){
        return service.getDataAll();
    }
    
}
