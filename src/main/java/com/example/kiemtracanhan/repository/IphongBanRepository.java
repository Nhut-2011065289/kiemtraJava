package com.example.kiemtracanhan.repository;

import com.example.kiemtracanhan.entity.phongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IphongBanRepository extends JpaRepository<phongBan, String>{
}
