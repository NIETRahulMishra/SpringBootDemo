package com.example.CurrencyConversionService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurrencyConversionService.Service.StudentService;
import com.example.CurrencyConversionService.Vo.StudentVo;

@RestController
@RequestMapping("/Student")
public class StudentController {
@Autowired
StudentService studentService;
 
@GetMapping(path="/findAllStudent")
public List<StudentVo> findAllStudent(){
	 
	return studentService.findAll();
 }
}
