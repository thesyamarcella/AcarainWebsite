package com.acarainservices.acarainservices.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acarainservices.acarainservices.dto.ResponseData;
import com.acarainservices.acarainservices.dto.SearchData;

@RestController
@RequestMapping("/api/students")
public class UserController {

    @Autowired
    private UserServices studentsServices;

    @PostMapping
    // public Students postStudent(@Valid @RequestBody Students students, Errors errors) {
    public ResponseEntity<ResponseData<User>> postStudent(@Valid @RequestBody User students, Errors errors) {
        ResponseData<User> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                // System.out.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

            // throw new RuntimeException("Validation Error")
        }

        try {
            responseData.setResult(true);
            List<User> value = new ArrayList<>();
            value.add(studentsServices.save(students));
            responseData.setData(value);    
        } catch (Exception e) {
            responseData.setData(null);
            responseData.setResult(false);
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
        }
        
        return ResponseEntity.ok(responseData);
        // return studentsServices.save(students);
    }

    @GetMapping
    // public Iterable<Students> fetchStudent(){
    public ResponseEntity<ResponseData<User>> fetchStudent() {
        // return studentsServices.findAll();
        ResponseData<User> responseData = new ResponseData<>();
        try {
            Iterable<User> values = studentsServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    // public Students fetchStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<User>> fetchStudentById(@PathVariable("id") int id) {
        // return studentsServices.findOne(id);
        ResponseData<User> responseData = new ResponseData<>();

        try {
            User values = studentsServices.findOne(id);
            List<User> result = new ArrayList<>();
            result.add(values);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    // public Students updateStudent(@RequestBody Students students){
    public ResponseEntity<ResponseData<User>> updateStudent(@Valid @RequestBody User students, Errors errors) {
        ResponseData<User> responseData = new ResponseData<>();

        if (students.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            

            try {
                responseData.setResult(true);
                List<User> value = new ArrayList<>();
                value.add(studentsServices.save(students));
                responseData.setData(value);
                
            } catch (Exception e) {
                responseData.setData(null);
                responseData.setResult(false);
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
            }

            return ResponseEntity.ok(responseData);    

        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        
    }

    @DeleteMapping("/{id}")
    //public void deleteStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<User>> deleteStudentById(@PathVariable("id") int id){    
        ResponseData<User> responseData = new ResponseData<>();
        if(id != 0){
            try {
                studentsServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        }else{
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        
    }


    @PostMapping("/search")
    public ResponseEntity<ResponseData<User>> getStudentByName(@RequestBody SearchData searchData){
        ResponseData<User> responseData = new ResponseData<>();
        try {
            Iterable<User> values = studentsServices.findByName(searchData.getSearchKey());
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}
