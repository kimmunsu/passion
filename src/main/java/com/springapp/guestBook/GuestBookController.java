package com.springapp.guestBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuestBookController {
	@Autowired
	GuestBookService guestBookService;
	
	@RequestMapping("/guestbook/Write")
	public String executeWrite(@ModelAttribute GuestBook guestbook, ModelMap model){
		// interceptor 를 이용한 login session 체크가 우선...
		model.addAttribute("list", guestBookService.write(guestbook));
		return "/guestbook/list";
	}
	
	@RequestMapping("/guestbook/List")
	public String executeGetList(ModelMap model){
		model.addAttribute("list", guestBookService.getGuestBookList());
		return "/guestbook/list";
	}
	
	@RequestMapping("/guestbook/Update")
	public String executeUpdate(@ModelAttribute GuestBook guestbook, ModelMap model){
		// interceptor 를 이용한 login session 체크가 우선...
		try {
			guestBookService.updateGuestBookNGetList(guestbook);
			model.addAttribute("message", "수정되었습니다.");
		} catch (NotExistGuestBookException e) {
			model.addAttribute("message", e.getMessage());
		}
		return executeGetList(model);
	}
	
	@RequestMapping("/guestbook/Delete")
	public String executeDelete(@RequestParam int guestbookId, ModelMap model){
		// interceptor 를 이용한 login session 체크가 우선...
		try{
			guestBookService.deleteGuestBook(guestbookId);
			model.addAttribute("message", "삭제되었습니다.");
		}catch(NotExistGuestBookException e){
			model.addAttribute("message", e.getMessage());
		}
		return executeGetList(model);
	}
}