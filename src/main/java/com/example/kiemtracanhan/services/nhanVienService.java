package com.example.kiemtracanhan.services;

import com.example.kiemtracanhan.entity.nhanVien;
import com.example.kiemtracanhan.repository.InhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class nhanVienService {
    @Autowired
    private InhanVienRepository nhanvienRepository;

    public List<nhanVien> getAllNHANVIENs(){
        return nhanvienRepository.findAll();
    }

    public nhanVien getNHANVIENById(String id){
        return nhanvienRepository.findById(id).orElse(null);
    }

    public void addNHANVIEN(nhanVien nhanvien){
        nhanvienRepository.save(nhanvien);
    }

    public void deleteNHANVIEN(String id){
        nhanvienRepository.deleteById(id);
    }

    public void updateNHANVIEN(nhanVien nhanvien){
        nhanvienRepository.save(nhanvien);
    }
}

