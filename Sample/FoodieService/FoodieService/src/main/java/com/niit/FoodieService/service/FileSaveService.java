package com.niit.FoodieService.service;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileSaveService {
    public void init();

    public String save(MultipartFile file);

    public Resource load(String filename);
}
