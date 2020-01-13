package kr.ac.kopo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.model.Item;

@Controller
public class RootController {
	
	ArrayList<Item> list = new ArrayList<Item>();
	
	@RequestMapping("/")
	String index(Model model) {
		
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	String upload(Item item) { //uploadFile은 input태그의 name과 대소문자나 -_까지 완벽히 똑같아야한다
		
		if(item.transferTo("d://upload/")) {
			list.add(item);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/ajax")
	String ajax(Model model) {
		
		model.addAttribute("list", list);
		
		return "ajax";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/upload", method=RequestMethod.POST, produces="application/json; charset=utf8")
	String ajax_upload(Item item) { //uploadFile은 input태그의 name과 대소문자나 -_까지 완벽히 똑같아야한다
		
		if(item.transferTo("d://upload/")) {
			list.add(item);
			
			return "{\"result\": true, \"filename\": \"" + item.getFilename() + "\", \"size\": " + item.getSize() + "}";
		}
		
		return "{result: false}";
	}

}
