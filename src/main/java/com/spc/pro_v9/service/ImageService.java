package com.spc.pro_v9.service;

import com.spc.pro_v9.entity.Image;
import com.spc.pro_v9.repository.ImageRepository;
import com.spc.pro_v9.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Image image = imageRepository.save(Image.builder()
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        if (image != null){
            return "File uploaded successfuly : " + file.getOriginalFilename();
        }
        return null;
    }


    public byte[] downloadImage(String filename){
        return imageRepository.findByImageName(filename)
                .map(img -> ImageUtil.decompressImage(img.getImageData()))
                .orElseThrow((() -> new RuntimeException("Image not found: " + filename)));

    }

}
