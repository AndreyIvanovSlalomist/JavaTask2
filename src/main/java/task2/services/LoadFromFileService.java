package task2.services;

import org.springframework.web.multipart.MultipartFile;

public interface LoadFromFileService {
    public void loadFromFile(MultipartFile file);
}
