package com.example.CurrencyConversionService.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.CurrencyConversionService.Vo.StudentVo;

@Component
public class StudentDAO implements StudentDAOImpl{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<StudentVo> findAll() {
		// TODO Auto-generated method stub
        List <StudentVo> studentVo = jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<StudentVo>(StudentVo.class));
        System.out.println("----Size-----"+studentVo.size());
        return studentVo;
	}

}
