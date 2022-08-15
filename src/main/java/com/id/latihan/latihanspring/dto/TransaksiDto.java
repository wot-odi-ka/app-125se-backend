package com.id.latihan.latihanspring.dto;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

    @Data
    @ToString
    public class TransaksiDto {

        private int id_transaksi;
        private int id_barang;
        private int id_pembeli;
        private String keterangan;
        private Date tanggal;
        private String nama_barang;
        private String nama_pembeli;
        private int harga;

    }

