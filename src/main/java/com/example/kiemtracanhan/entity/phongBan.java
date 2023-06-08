package com.example.kiemtracanhan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="phongban")
public class phongBan {
    @Id
    private String maPhong;

    @Column(name="tenPhong")
    private String tenPhong;

    @OneToMany(mappedBy= "phongban", cascade = CascadeType.ALL)
    private List<nhanVien> nhanviens;
}