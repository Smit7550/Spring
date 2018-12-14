package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDao;
import com.vo.RegVo;

@Controller
public class RegController 
{
	@Autowired
	RegDao regdao;
	
	@RequestMapping(value="load",method=RequestMethod.GET)
	public ModelAndView loadInsert()
	{
		return new ModelAndView("insert","x",new RegVo());
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ModelAndView dataInsert(@ModelAttribute RegVo r)
	{
		this.regdao.insert(r);
		return new ModelAndView("redirect:load.htm");
	}
	
	@RequestMapping(value="/display",method=RequestMethod.GET)
	public ModelAndView displaytable(RegVo r)
	{
		List ls = regdao.search(r);
		return new ModelAndView("table","List",ls);
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(RegVo r, @RequestParam("id")int i)
	{
		r.setId(i);
		this.regdao.delete(r);
		return new ModelAndView("redirect:load.htm");
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView update(RegVo r, @RequestParam("id")int i, HttpServletRequest request)
	{
		r.setId(i);
		List ls = regdao.search1(r);
		return new ModelAndView("edit", "data", (RegVo)ls.get(0));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute RegVo r,@RequestParam("id")int i ,HttpServletRequest request)
	{
		r.setId(i);
		this.regdao.edit(r);
		return new ModelAndView("redirect:load.htm");
	}
}
