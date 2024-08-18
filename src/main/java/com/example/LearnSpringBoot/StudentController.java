package com.example.LearnSpringBoot;

import com.example.LearnSpringBoot.model.Student;
import com.example.LearnSpringBoot.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    // Save into database using Autowired
    @Autowired
    private StudentRepository repository;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/find")
    public Student findByEmail(@RequestParam("email") String email) {
        return repository.findByEmail(email);
    }

    @GetMapping("/findByDomain")
    public List<Student> findByDomain(@RequestParam("domain") String domain) {
        return repository.findByDomain(domain);
    }

    @PatchMapping("/update")
    public Student findAndUpdateStudent(@RequestParam("student_id") String id, @RequestParam("new_email") String email) {
        // Note: Optional because id can be missing or not provided
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            Student studentObj = student.get();
            studentObj.setEmail(email);
            return repository.save(studentObj);
        }
        return null;
    }
}
