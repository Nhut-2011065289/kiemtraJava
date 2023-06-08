package com.example.kiemtracanhan.services;

import com.example.kiemtracanhan.entity.phongBan;
import com.example.kiemtracanhan.repository.IphongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class phongBanService {
    @Autowired
    private IphongBanRepository phongbanRepository;
    public List<phongBan> getAllPHONGBANs(){
        return phongbanRepository.findAll();
    }
    public phongBan getPHONGBANById(String id){
        return phongbanRepository.findById(id).orElse(null);
    }
    public phongBan savePHONGBAN(phongBan phongban){
        return phongbanRepository.save(phongban);
    }
    public void deletePHONGBAN(String id){
        phongbanRepository.deleteById(id);
    }
}
