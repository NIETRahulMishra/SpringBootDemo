package com.example.CurrencyConversionService.DBConnection;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class SpringBootJdbcController {  
	
    @Autowired  
    JdbcTemplate jdbc;
    
    @RequestMapping("/insert")  
    public String index(){  
        jdbc.execute("insert into student(id, name)values(5,'java@javatpoint.com')");  
        return"data inserted Successfully";  
    }  
}
