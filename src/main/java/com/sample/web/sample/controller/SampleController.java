package com.sample.web.sample.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.web.sample.service.SampleService;
import com.sample.web.sample.vo.SampleVo;
import com.util.common.CommonUtil;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService SampleService;
	
	/**
	 * main È­¸é
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value="/select.do", method = RequestMethod.GET)
	public String sampleSelect(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		logger.info("{} {}", CommonUtil.ipInfoLog(request), "sampleSelect");
		List<SampleVo> sampleVo = new ArrayList<>();	
		sampleVo = SampleService.getDeptTable();
		model.addAttribute("list", sampleVo);
		return "views/select";
	}
	
}
