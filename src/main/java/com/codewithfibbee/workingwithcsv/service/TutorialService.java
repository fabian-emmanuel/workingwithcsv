package com.codewithfibbee.workingwithcsv.service;

import com.codewithfibbee.workingwithcsv.model.Tutorial;
import com.codewithfibbee.workingwithcsv.repository.TutorialRepo;
import com.codewithfibbee.workingwithcsv.util.CSVHelper;
import com.codewithfibbee.workingwithcsv.util.ExcelHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class TutorialService {
    TutorialRepo repository;

    public void saveFromCSV(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveFromExcel(MultipartFile file) {
        try {
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}
