package com.example.pettoyresale.service;

import com.example.pettoyresale.model.PetToy;
import com.example.pettoyresale.repository.PetToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PetToyService {

    @Autowired
    private PetToyRepository petToyRepository;

    public PetToy savePetToy(PetToy petToy) {
        return petToyRepository.save(petToy);
    }

    public List<PetToy> getAllPetToys() {
        return petToyRepository.findAll();
    }

    public Optional<PetToy> getPetToyById(Long id) {
        return petToyRepository.findById(id);
    }

    public void deletePetToy(Long id) {
        petToyRepository.deleteById(id);
    }

    public List<PetToy> searchPetToys(String keyword) {
        // 이 메서드는 PetToyRepository에 구현해야 합니다.
        return petToyRepository.searchByKeyword(keyword);
    }

    public String saveImage(MultipartFile image) {
        // 이미지 저장 로직을 구현해야 합니다.
        // 예를 들어, 파일 시스템에 저장하고 URL을 반환할 수 있습니다.
        // 이 예제에서는 간단히 파일 이름만 반환합니다.
        return image.getOriginalFilename();
    }
}