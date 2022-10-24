package com.api.WSCarSales.Controllers;

import com.api.WSCarSales.Dtos.BrandDto;
import com.api.WSCarSales.Models.Brand;
import com.api.WSCarSales.Services.BrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping
    public ResponseEntity<Object> saveBrand(@RequestBody @Valid BrandDto brandDto){
        var brand= new Brand();
        BeanUtils.copyProperties(brandDto,brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.saveBrand(brand));
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getBrands(){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getBrands());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBrandById(@PathVariable Integer id){
        Brand brand = brandService.getBrandById(id);
        return ResponseEntity.status(HttpStatus.OK).body(brand);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBrand(@PathVariable Integer id){
        Brand brand = brandService.getBrandById(id);
        brandService.deleteBrand(id);
        return ResponseEntity.status(HttpStatus.OK).body("Brand deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBrand(@PathVariable Integer id, @RequestBody @Valid BrandDto brandDto){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(id,brandDto));
    }}



