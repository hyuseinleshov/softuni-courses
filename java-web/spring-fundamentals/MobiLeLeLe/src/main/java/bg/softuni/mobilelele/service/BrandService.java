package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.Brand;

import java.util.List;

public interface BrandService {
    Brand getById(Long id);
    List<Brand> getAll();
    Brand save(Brand brand);
    void delete(Long id);
}
