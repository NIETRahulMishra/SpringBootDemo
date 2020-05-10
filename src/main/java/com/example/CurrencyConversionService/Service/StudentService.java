package com.example.CurrencyConversionService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CurrencyConversionService.DAO.StudentDAO;
import com.example.CurrencyConversionService.Vo.StudentVo;


@Service
public class StudentService implements StudentServiceImpl{
	@Autowired
	StudentDAO studentDAO; 

	@Override
	public List<StudentVo> findAll() {
		// TODO Auto-generated method stub
		List<StudentVo> studentVoList = studentDAO.findAll();
		return studentVoList;
	}

}
