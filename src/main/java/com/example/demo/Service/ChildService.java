package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Child;
import com.example.demo.Repository.ChildRepo;

@Service
public class ChildService {
	@Autowired
	ChildRepo cr;
	
	public List<Child> savedetails(List<Child> c)
	{
		return (List<Child>)cr.saveAll(c);
	}
	
	public List<Child> sortinfo(String s)
	{
		return cr.findAll(Sort.by(Sort.Direction.DESC,s));
	}
	
	public List<Child> getPage(int pageno,int psize)
	{
		Page<Child> p =cr.findAll(PageRequest.of(pageno,psize));
		return p.getContent();
	}
	public List<Child> getPageSort(int pageno,int psize,String s)
	{
		Page<Child> p =cr.findAll(PageRequest.of(pageno,psize,Sort.by(s)));
		return p.getContent();
	}

}
