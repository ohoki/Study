package com.yedam.exam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SlipController {
	
	private static final Logger logger = LoggerFactory.getLogger(SlipController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Autowired
	private SlipService slipService;
	
	// 비동기 통신을 처리하는 컨트롤러
	@PostMapping("insertSlip")
	@ResponseBody
	public Map<String, String> insertSlip(@RequestBody List<Slip> slipList, Model model) {
		String result = null;
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			map = slipService.insertSlip(slipList);
			result = "true";
		} catch (Exception e) {
			result = "false";
		}	
		
		map.put("result", result);
		
		return map;
	}
}
