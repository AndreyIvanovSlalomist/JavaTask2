package task2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import task2.models.Employee;
import task2.repositories.EmployeeRepository;
import task2.services.LoadFromFileService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import static task2.config.FindProperty.getParentDirectoryFromJar;
import static task2.config.FindProperty.getProperty;

@Service
public class LoadFromFileServiceImpl implements LoadFromFileService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void loadFromFile(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String uploadPath = getProperty("upload.path");
            if (uploadPath.equals("")) {
                uploadPath = getParentDirectoryFromJar() + File.separator;
            }
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = uploadDir + File.separator + UUID.randomUUID().toString() + "." + file.getOriginalFilename();
            byte[] bytes = new byte[0];
            try (BufferedOutputStream stream =
                         new BufferedOutputStream(new FileOutputStream(new File(fileName)));) {
                bytes = file.getBytes();

                stream.write(bytes);

                System.out.println("Вы удачно загрузили " + fileName);
            } catch (Exception e) {
                System.out.println("Вам не удалось загрузить " + fileName + " => " + e.getMessage());
            }

            addFromFile(fileName);
        }

    }

    private void addFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                addEmployeeFromString(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Не удалось загрузить " + fileName + " => " + e.getMessage());
        }
    }

    private void addEmployeeFromString(String paramString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
            String[] strings = paramString.split(";");
            employeeRepository.save(
                    Employee.builder()
                            .name(strings[0])
                            .job(strings[1])
                            .hireDate(LocalDate.parse(strings[2], formatter))
                            .salary(Double.valueOf(strings[3]))
                            .build());
        } catch (Exception e) {
            System.out.println("Не удалось создать сотрудника из строки " + paramString + " => " + e.getMessage());
        }
    }
}
