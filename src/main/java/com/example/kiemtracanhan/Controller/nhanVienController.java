package com.example.kiemtracanhan.Controller;

import com.example.kiemtracanhan.entity.nhanVien;
import com.example.kiemtracanhan.services.nhanVienService;
import com.example.kiemtracanhan.services.phongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class nhanVienController {
    @Autowired
    private nhanVienService nhanvienService;

    @Autowired
    private phongBanService phongbanService;
    @GetMapping
    public String showAllNHANVIENs(Model model){
        List<nhanVien> nhanviens = nhanvienService.getAllNHANVIENs();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNHANVIENForm(Model model){
        model.addAttribute("nhanVIEN", new nhanVien());
        model.addAttribute("phongBAN", phongbanService.getAllPHONGBANs());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNHANVIEN(@Valid @ModelAttribute("nhanvien") nhanVien nhanvien, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("phongBAN",phongbanService.getAllPHONGBANs());
            return "nhanvien/add";
        }
        nhanvienService.addNHANVIEN(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteNHANVIEN(@PathVariable("id") String id, Model model){
        nhanVien nhanvien = nhanvienService.getNHANVIENById(id);
        nhanvienService.deleteNHANVIEN(id);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String maNV, Model model){
        model.addAttribute("nhanVIEN",  nhanvienService.getNHANVIENById(maNV));
        model.addAttribute("phongBAN", phongbanService.getAllPHONGBANs());
        return "nhanvien/edit";

    }
    @PostMapping("/edit")
    public String edit(@Valid nhanVien editNhanVien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("nhanVIEN", editNhanVien);
            model.addAttribute("phongBAN",phongbanService.getAllPHONGBANs());
            return "nhanvien/edit";
        }
        nhanvienService.updateNHANVIEN(editNhanVien);
        return "redirect:/nhanviens";
    }


}
