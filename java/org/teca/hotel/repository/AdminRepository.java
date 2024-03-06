package org.teca.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teca.hotel.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
   Admin findByAdminemailidAndAdminpassword(String emailid,String password);

}
