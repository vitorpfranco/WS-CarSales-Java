package com.api.WSCarSales.Services;

import com.api.WSCarSales.Dtos.ModelDto;
import com.api.WSCarSales.Exeptions.ResourceNotFoundException;
import com.api.WSCarSales.Models.Brand;
import com.api.WSCarSales.Models.Model;
import com.api.WSCarSales.Repositories.ModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    BrandService brandService;

    @Autowired
    ModelRepository modelRepository;


    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public Model setBrand(ModelDto modelDto){
        Brand brand = brandService.getBrandById(modelDto.getMarca_id());
        var model= new Model();
        BeanUtils.copyProperties(modelDto,model,"marca_id");
        model.setMarca(brand);
        return model;
    }

    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Integer id) {
        Optional<Model> model= modelRepository.findById(id);
        return model.orElseThrow(()-> new ResourceNotFoundException("Model not found for ID: "+id));
    }

    public void deleteModel(Integer id) {
        modelRepository.deleteById(id);
    }

    public Model updateModel(Integer id, Model model) {
        Model OldModel= getModelById(id);
        model.setId(OldModel.getId());
        return saveModel(model);
    }
}