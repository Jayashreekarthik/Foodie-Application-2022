package com.niit.FoodieService.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
//import org.synchronoss.cloud.nio.multipart.Multipart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
public class User {

    @Id
    private String email;
    private String password;
    private String name;
    private long phoneNo;
    private String accountType;

    private String profileImage;

}
