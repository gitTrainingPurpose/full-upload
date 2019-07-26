package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	@RequestMapping("/calc")
	public ModelAndView Calculate(@RequestParam("n1")String sn1, @RequestParam("n2")String sn2,@RequestParam("op")String op) {
			Double n1 = Double.parseDouble(sn1);
			Double n2 = Double.parseDouble(sn2); 
			Double result = 0.0;
			switch (op) {
			case "+":
				result = n1+n2;
				break;
			case "-":
				result = n1-n2;
				break;
			case "*":
				result = n1*n2;
				break;
			case "/":
				result = n1/n2;
				break;

			default:
				break;
			}
			String viewName = "calcview";
			Map<String, Object> attribues = new HashMap<String, Object>();
			attribues.put("result",result);
			return new ModelAndView(viewName, attribues);
	}
}
