package com.example.kiemtracanhan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="nhanvien")
public class nhanVien {
    @Id
    private String maNv;

    @Column(name="tenNv")
    private String tenNv;

    @Column(name="Phai")
    private String Phai;

    @Column(name="noiSinh")
    private String noiSinh;

    @Column(name="luong")
    private int luong;

    @ManyToOne
    @JoinColumn(name ="maPhong")
    private phongBan phongban;
}
