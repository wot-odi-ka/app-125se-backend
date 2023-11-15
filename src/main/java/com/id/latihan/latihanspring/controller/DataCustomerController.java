package com.id.latihan.latihanspring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.id.latihan.latihanspring.dto.DataCustomerDto;
import com.id.latihan.latihanspring.dto.DataUkuranBajuDto;
import com.id.latihan.latihanspring.dto.ResponseStatusDTO;
import com.id.latihan.latihanspring.model.DataCustomer;

import com.id.latihan.latihanspring.payload.response.MessageResponse;
import com.id.latihan.latihanspring.security.services.DataCustomerService;

@CrossOrigin(origins = "https://app-125se-backend.herokuapp.com/")
@RestController
@RequestMapping("/customer")
public class DataCustomerController {

    @Autowired
    private DataCustomerService service;


    @PostMapping("/add")
    public ResponseEntity<?> saveCustomer(@RequestBody DataCustomerDto data){

        service.addDataCustomer(data);
        return ResponseEntity.ok(new MessageResponse("succsess insert data to db"));
    }

    @GetMapping("/search/{Id}")
    public DataCustomer findByidCustomer(@PathVariable long Id){

        return service.searchByid(Id);
    }

    @GetMapping("/getAll")
    public List<DataCustomer> getDataAll(){
        return service.gCustomers();
    }

    @GetMapping("/search/nama")
    public List<DataCustomer> getDataByNama(@RequestParam String nama){
        return service.searchByname(nama);
    }

    @GetMapping("/search/warna")
    public List<DataCustomer> getDataByWarna(@RequestParam String warna){
        return service.searchBywarnaBaju(warna);
    }

    @GetMapping("/search/hitam")
    public long getDataByWarnaHitam(@RequestParam String hitam){
        return service.searchBywarnaBajuHitam(hitam);
    }
    @GetMapping("/search/biru")
    public long getDataByWarnaHijau(@RequestParam String biru){
        
        return service.searchBywarnaBajuHijau(biru);
    }
    @GetMapping("/search/putih")
    public long getDataByWarnaPutih(@RequestParam String putih){
        return service.searchBywarnaBajuPutih(putih);
    }
    @GetMapping("/search/total")
    public long getDataByWarnaTotal(){
        return service.searchByTotalbaju();
    }

    @GetMapping("/search/totalPendapatan")
    public long getDataByTotalpendapatan(){
        return service.searchByTotaPendapatan();
    }

    @GetMapping("/ukuran")
    public List <DataUkuranBajuDto> searchByUkuranPanjang(@RequestParam String warna,String jenis){
         return service.serchByUkuranBajuPanjang(warna, jenis);
        
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> dEntity(@PathVariable Long id){
        service.deletDatabajuById(id);
        return ResponseEntity.ok(new MessageResponse("delete data customer success" +id));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updaEntity(@RequestBody DataCustomerDto customerDto){
        service.updCustomer(customerDto);
        return ResponseEntity.ok(new MessageResponse("success update data"));
    }

    @PostMapping("/save/status")
     public ResponseEntity<?> savEntity(@RequestBody ResponseStatusDTO customerDto){
        service.saveStatus(customerDto);
        return ResponseEntity.ok(new MessageResponse("success update data"));
    }



}
