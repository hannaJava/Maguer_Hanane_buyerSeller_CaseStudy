package com.hananemaguer.buyerseller.Exception;

import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//implementing ErrorController Interface otherwise get error telling that method already mapped if we map /error with simple controller
public class BuyerSellerException implements ErrorController{
private static final String PATH="/error";
//@Override
@RequestMapping(PATH)
@ResponseBody
public String getErrorPath() {
	return "No Mapping Found...customized error message";
}
}
