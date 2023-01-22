import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.file1.Test;
import org.example.file1.Tests;
import org.example.file2.Values;
import org.example.file3.Report;
import org.example.file3.Reports;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
//        String json1 = readFile("C:\\Users\\Алина\\IdeaProjects\\task3\\tests.json");
        String json1 = readFile(args[0]);
        ObjectMapper objectMapper = new ObjectMapper();
        Tests tests;
        try {
            tests = objectMapper.readValue(json1, Tests.class);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
//        String json2 = readFile("C:\\Users\\Алина\\IdeaProjects\\task3\\values.json");
        String json2 = readFile(args[1]);
        Values values;
        try {
            values = objectMapper.readValue(json2, Values.class);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

        Reports reports = new Reports();
        reports.setReports(new ArrayList<>());
        tests.getTests().forEach(test -> reports.getReports().add(createReport(test, values)));

        writeFile("report.json", reports);
    }

    public static Report createReport(Test test, Values values) {
        Report report = new Report();
        report.setId(test.getId());
        report.setTitle(test.getTitle());
        report.setValue(values.findById(test.getId()));
        if (test.getValues() != null && !test.getValues().isEmpty()) {
            ArrayList<Report> reports = new ArrayList<>();
            for (Test nestedTest : test.getValues()) {
                reports.add(createReport(nestedTest, values));
            }
            report.setValues(reports);
        }
        return report;
    }

    public static String readFile(String path) {
        Path writeFilePath = Paths.get(path);
        String content;
        try {
            content = Files.readString(writeFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static void writeFile(String path, Object object){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String toPretty(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
