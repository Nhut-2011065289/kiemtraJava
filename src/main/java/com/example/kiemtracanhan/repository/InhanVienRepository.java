package com.example.kiemtracanhan.repository;

import com.example.kiemtracanhan.entity.nhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InhanVienRepository extends JpaRepository<nhanVien, String> {
}
