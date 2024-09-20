package com.example.pettoyresale.controller;

import com.example.pettoyresale.model.PetToy;
import com.example.pettoyresale.service.PetToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/pet-toys")
public class PetToyController {

    @Autowired
    private PetToyService petToyService;

    @PostMapping
    public ResponseEntity<PetToy> createPetToy(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("condition") String condition,
            @RequestParam("seller") String seller,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        System.out.println("Received request to create pet toy:");
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Condition: " + condition);
        System.out.println("Seller: " + seller);
        System.out.println("Image: " + (image != null ? image.getOriginalFilename() : "No image"));

        PetToy petToy = new PetToy();
        petToy.setName(name);
        petToy.setDescription(description);
        petToy.setPrice(price);
        petToy.setCondition(condition);
        petToy.setSeller(seller);

        if (image != null && !image.isEmpty()) {
            String imageUrl = petToyService.saveImage(image);
            petToy.setImageUrl(imageUrl);
        }

        PetToy savedPetToy = petToyService.savePetToy(petToy);
        return ResponseEntity.ok(savedPetToy);
    }

    @GetMapping
    public List<PetToy> getAllPetToys() {
        return petToyService.getAllPetToys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetToy> getPetToyById(@PathVariable Long id) {
        return petToyService.getPetToyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetToy> updatePetToy(@PathVariable Long id, @RequestBody PetToy petToyDetails) {
        return petToyService.getPetToyById(id)
                .map(petToy -> {
                    petToy.setName(petToyDetails.getName());
                    petToy.setDescription(petToyDetails.getDescription());
                    petToy.setPrice(petToyDetails.getPrice());
                    petToy.setCondition(petToyDetails.getCondition());
                    petToy.setSeller(petToyDetails.getSeller());
                    return ResponseEntity.ok(petToyService.savePetToy(petToy));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePetToy(@PathVariable Long id) {
        return petToyService.getPetToyById(id)
                .map(petToy -> {
                    petToyService.deletePetToy(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<PetToy> searchPetToys(@RequestParam String keyword) {
        return petToyService.searchPetToys(keyword);
    }



}