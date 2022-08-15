package com.id.latihan.latihanspring.constant;

public class Constant {
    private Constant() {
        throw new IllegalStateException("Constants class");
    }

    public static final String JWT_SECRET        = "jwt.secret";
    public static final String JWT_PREFIX        = "jwt.prefix";
    public static final String JWT_EXPIRED       = "jwt.expired";
    public static final String KAFKA_TOPIC       = "spring.kafka.topics";

    public static final String NOT_FOUND        = " tidak ditemukan";
    public static final String STATUS_SUCCESS_CODE        = "00";
    public static final String STATUS_ERROR_CODE        = "06";

    public static final String MESSAGE_SUCCESS        = "SUCCESS";
    public static final String MESSAGE_ERROR        = "ERROR";

    public static final String VALUE_YES        = "Y";
    public static final String VALUE_NO        = "N";

    public static final String VALUE_KAFKA        = "KAFKA";

    public static final String HEADER_NAME_AF_API_KEY        = "AF-API-KEY";
    public static final String REQUEST_HEADER        = "header";
    public static final String REQUEST_DATA        = "data";


    public static final String STATUS_APLIKASI_BRANCH_DONE = "STATUS_APLIKASI_BRANCH_DONE";
    public static final String STATUS_APLIKASI_BRANCH_WAITING = "STATUS_APLIKASI_BRANCH_WAITING";
    public static final String STATUS_APLIKASI_DAKOR = "STATUS_APLIKASI_DAKOR";
    public static final String STATUS_APLIKASI_DISBURSE = "STATUS_APLIKASI_DISBURSE";
    public static final String STATUS_APLIKASI_IN_PROGRESS = "STATUS_APLIKASI_IN_PROGRESS";
    public static final String STATUS_APLIKASI_NEED_DAKOR = "STATUS_APLIKASI_NEED_DAKOR";
    public static final String STATUS_APLIKASI_NEED_REVISI = "STATUS_APLIKASI_NEED_REVISI";
    public static final String STATUS_APLIKASI_NEW = "STATUS_APLIKASI_NEW";
    public static final String STATUS_APLIKASI_PENDING_RAPINDO = "STATUS_APLIKASI_PENDING_RAPINDO";
    public static final String STATUS_APLIKASI_PENDING_VERTEL = "STATUS_APLIKASI_PENDING_VERTEL";
    public static final String STATUS_APLIKASI_REVISI = "STATUS_APLIKASI_REVISI";

    public static final String VERTEL_RULE_RULE_VALUE = "RULE_VALUE";
    public static final String VERTEL_RULE_RULE_DIFF_BASTK = "RULE_DIFF_BASTK";



    public static final String ACTION_MODE_CLAIM = "CLAIM";
    public static final String ACTION_MODE_SAVE_TEMPORARY = "SAVE_TEMPORARY";
    public static final String ACTION_MODE_NEED_REVISE = "NEED_REVISE";
    public static final String ACTION_MODE_NEED_DAKOR = "NEED_DAKOR";
    public static final String ACTION_MODE_SEND_TO_BRANCH = "SEND_TO_BRANCH";
    public static final String ACTION_MODE_BRANCH_DONE = "BRANCH_DONE";
    public static final String ACTION_MODE_PENDING_VERTEL = "PENDING_VERTEL";
    public static final String ACTION_MODE_PENDING_RAPINDO = "PENDING_RAPINDO";
    public static final String ACTION_MODE_SAVE_DRAFT = "SAVE_DRAFT";
    public static final String ACTION_MODE_DISBURSE = "DISBURSE";

    public static final String ACTION_MODE_INVOICING_SAVE_DRAFT = "SAVE_DRAFT";
    public static final String ACTION_MODE_INVOICING_SEND_INVOICE = "SEND_INVOICE";

    public static final String INVOICE_STATUS_SENT = "INVOICE_STATUS_SENT";
    public static final String INVOICE_STATUS_DRAFT = "INVOICE_STATUS_DRAFT";
    public static final String INVOICE_STATUS_REVISI = "INVOICE_STATUS_REVISI";
    public static final String INVOICE_DP_NONE = "INVOICE_DP_NONE";

    public static final String SECTION_CODE_OBJECT = "OBJECT";
    public static final String SECTION_CODE_KAROSERI = "KAROSERI";
    public static final String SECTION_CODE_KETERANGAN_PEMBIAYAAN = "KETERANGAN_PEMBIAYAAN";
    public static final String SECTION_CODE_JAMINAN_PROPERTY = "JAMINAN_PROPERTY";
    public static final String SECTION_CODE_JAMINAN_OTOMOTIF = "JAMINAN_OTOMOTIF";
    public static final String SECTION_CODE_ASURANSI = "ASURANSI";
    public static final String SECTION_CODE_DOKUMEN = "DOKUMEN";
    public static final String SECTION_CODE_NASABAH_PERORANGAN = "NASABAH_PERORANGAN";
    public static final String SECTION_CODE_NASABAH_KELEMBAGAAN = "NASABAH_KELEMBAGAAN";
    public static final String SECTION_CODE_PENJAMIN = "PENJAMIN";
    public static final String SECTION_CODE_KELUARGA = "KELUARGA";
    public static final String SECTION_CODE_MANAGEMENT_PIC = "MANAJEMEN PIC";
    public static final String SECTION_CODE_TAGIHAN = "TAGIHAN";
    public static final String SECTION_CODE_STRUKTUR_KREDIT = "STRUKTUR_KREDIT";
    public static final String SECTION_CODE_BIAYA = "BIAYA";
    public static final String SECTION_CODE_NDCR = "NDCR";

    public static final String PARAMETER_CODE_DISBURSE_NEW = "VALIDATION_DISBURSE_NEW";
    public static final String PARAMETER_CODE_DISBURSE_SECOND = "VALIDATION_DISBURSE_SECOND";
    public static final String PARAMETER_CODE_DISBURSE_PROPERTY = "VALIDATION_DISBURSE_PROPERTY";
    public static final String PARAMETER_CODE_DISBURSE_DURABLE = "VALIDATION_DISBURSE_DURABLE";
    public static final String PARAMETER_CODE_SYSTEM = "SYSTEM";


    public static final String MAXIMUM_DAYS_SEARCH_PERIOD = "MAXIMUM_DAYS_SEARCH_PERIOD";
    public static final String DOCUMENT_ID_KONFIRMASI_CABANG = "DOCUMENT_ID_KONFIRMASI_CABANG";


    public static final String DOCUMENT_MANDATORY = "DOCUMENT_MANDATORY";
    public static final String DOCUMENT_ADDITIONAL= "DOCUMENT_ADDITIONAL";
    public static final String DOCUMENT_OTHERS = "DOCUMENT_OTHERS";

    public static final String FORMAT_DATE_YYYYMMDD_1 = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYYYMMDD_2 = "yyyyMMdd";
    public static final String FORMAT_DATE_YYYYMMDD_3 = "yyyy/MM/dd";

    public static final String FORMAT_DATE_DDMMYYYY_1 = "dd-MM-yyyy";
    public static final String FORMAT_DATE_DDMMYYYY_2 = "ddMMyyyy";
    public static final String FORMAT_DATE_DDMMYYYY_3 = "dd/MM/yyyy";


}
