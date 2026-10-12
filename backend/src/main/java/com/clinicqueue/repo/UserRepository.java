package com.clinicqueue.repo;
import com.clinicqueue.model.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface UserRepository extends JpaRepository<AppUser,Long>{Optional<AppUser> findByEmail(String email); List<AppUser> findByRole(Role role);}
