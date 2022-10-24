package com.api.WSCarSales.Services;

import com.api.WSCarSales.Dtos.BrandDto;
import com.api.WSCarSales.Exeptions.ResourceNotFoundException;
import com.api.WSCarSales.Models.Brand;
import com.api.WSCarSales.Repositories.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Integer id) {
        Optional<Brand> brand=brandRepository.findById(id);

        return brand.orElseThrow(()-> new ResourceNotFoundException("Brand not found for ID: "+id));
    }

    public void deleteBrand(Integer id){
        brandRepository.deleteById(id);
    }

    public Brand updateBrand(Integer id, BrandDto brandDto){
        Brand oldBrand = getBrandById(id);
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandDto,brand);
        brand.setId(oldBrand.getId());
        return saveBrand(brand);
    }
}
