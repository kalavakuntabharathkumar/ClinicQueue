package com.clinicqueue.model;
import jakarta.persistence.*;
@Entity @Table(name="users", indexes=@Index(name="idx_user_email",columnList="email",unique=true))
public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false) private String name;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role;
 protected AppUser(){}
 public AppUser(String name,String email,String password,Role role){this.name=name;this.email=email;this.password=password;this.role=role;}
 public Long getId(){return id;} public String getEmail(){return email;} public String getPassword(){return password;} public String getName(){return name;} public Role getRole(){return role;}
}
