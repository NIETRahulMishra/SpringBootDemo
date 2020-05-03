package com.example.CurrencyConversionService.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurrencyConversionService.Vo.FilterVo;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("Filter")
public class FilterController {

	@GetMapping(path="/getFilter")
	public MappingJacksonValue getFilter() {
		 System.out.println("----Filter--------");
		 FilterVo filterVo=new FilterVo("Rahul","Salman","Lalit");
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter1","filter2");
		 FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
				 
		 MappingJacksonValue mapping = new MappingJacksonValue(filterVo);
		 mapping.setFilters(provider);
		 
		 return mapping;
	}
	
	@GetMapping(path="/getFilterList")
	public MappingJacksonValue getFilterList() {
		 System.out.println("----getFilterList--------");
		 List<FilterVo> list= Arrays.asList(new FilterVo("Rahul","Salman","Lalit"),new FilterVo("Rahul","Salman","Lalit"));
		 
		 //FilterVo filterVo=new FilterVo("Rahul","Salman","Lalit");
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filter2","filter2");
		 FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
				 
		 MappingJacksonValue mapping = new MappingJacksonValue(list);
		 mapping.setFilters(provider);
		 
		 return mapping;
	
	}

}
