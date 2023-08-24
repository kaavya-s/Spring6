package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Child;
import com.example.demo.Service.ChildService;

@RestController
public class ApiController {
	@Autowired
	ChildService cs;
	
	@PostMapping("addn")
	public List<Child> addDet(@RequestBody List<Child> c)
	{
		return cs.savedetails(c);
	}
	@GetMapping("sort{name}")
	public List<Child> showsortinfo(@PathVariable String name)
	{
		return cs.sortinfo(name);
	}
	@GetMapping("paging/{pageno}/{psize}/{name}")
	public List<Child> showpagesortinfo(@PathVariable int pageno,@PathVariable int psize,@PathVariable String name)
	{
		return cs.getPageSort(pageno,psize,name);
	}
	@GetMapping("paging/{pageno}/{psize}")
	public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int psize)
	{
		return cs.getPage(pageno,psize);
	}
	

}
