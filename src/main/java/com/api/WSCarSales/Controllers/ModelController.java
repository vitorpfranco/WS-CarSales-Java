package com.api.WSCarSales.Controllers;

import com.api.WSCarSales.Dtos.ModelDto;
import com.api.WSCarSales.Models.Model;
import com.api.WSCarSales.Services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("models")
public class ModelController {

    @Autowired
    ModelService modelService;

    @PostMapping
    public ResponseEntity<Model> saveModel(@RequestBody @Valid ModelDto modelDto){
        Model model= modelService.setBrand(modelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.saveModel(model));
}
    @GetMapping
    public ResponseEntity<List<Model>> getModels(){
        return ResponseEntity.status(HttpStatus.OK).body(modelService.getModels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(modelService.getModelById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable Integer id){
        Model model = modelService.getModelById(id);
        modelService.deleteModel(id);
        return ResponseEntity.status(HttpStatus.OK).body("Model deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Integer id, @RequestBody @Valid ModelDto modelDto){
        Model model= modelService.setBrand(modelDto);
        return ResponseEntity.status(HttpStatus.OK).body(modelService.updateModel(id,model));

    }
}