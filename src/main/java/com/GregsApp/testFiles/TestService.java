package com.GregsApp.testFiles;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class TestService {

    public void saveImage(MultipartFile imageFile) throws IOException {

        String folder = "/home/greghp/Pulpit/Parking-Sharing/src/main/resources/static/assets/uploads/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
