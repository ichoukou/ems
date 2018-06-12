package com.channelsoft.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg")
public class SysMessageController {

	@RequestMapping("/mailbox")
	public String gotoMsg(){
		return "sysMsg/mailbox";
	}
}
