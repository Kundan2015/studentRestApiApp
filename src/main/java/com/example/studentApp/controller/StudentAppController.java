package com.example.studentApp.controller;


import com.example.studentApp.exception.ResourceNotFoundException;
import com.example.studentApp.model.StudentModel;
import com.example.studentApp.repository.StdRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentAppController {
	 @Autowired 
	 StdRepository stdRepository;
	
	 // Get All Students
	 @GetMapping("/stds")
	 public List<StudentModel> getAllNotes() {
	     return stdRepository.findAll();
	 }
		 
	 // Get a Single Student
	 @GetMapping("/stds/{student_id}")
	 public Optional<StudentModel> viewNote(@PathVariable(value = "student_id") Long student_id) {
	     return stdRepository.findById(student_id);
	 }
	 
	 // Create a new Note
	 @PostMapping("/stds")
	 public StudentModel createNote(@Valid @RequestBody StudentModel stdDetails) {
	     return stdRepository.save(stdDetails);
	 }
	
	// Update Student
	 @PutMapping("/stds/{id}")
	public StudentModel updateNote(@PathVariable(value = "student_id") Long stdId,
	                                  @Valid @RequestBody StudentModel stdDetails) {

		StudentModel stdModel = stdRepository.findById(stdId)
		             .orElseThrow(() -> new ResourceNotFoundException("StudentModel", "student_id", stdId));

		stdModel.setStudent_name(stdDetails.getStudent_name());
		stdModel.setStudent_addr(stdDetails.getStudent_addr());
		stdModel.setAge(stdDetails.getAge());
		stdModel.setStudent_qual(stdDetails.getStudent_qual());
		stdModel.setStudent_percent(stdDetails.getStudent_percent());
		stdModel.setStudent_year_passed(stdDetails.getStudent_year_passed());
		StudentModel updatedNote = stdRepository.save(stdModel);
		
		return updatedNote;
	}
	 
	@DeleteMapping("/stds/{id}")
	 public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long stdId) {
		StudentModel stdModel = stdRepository.findById(stdId)
	             .orElseThrow(() -> new ResourceNotFoundException("StudentModel", "student_id", stdId));

		stdRepository.delete(stdModel);

	     return ResponseEntity.ok().build();
	 }
}
