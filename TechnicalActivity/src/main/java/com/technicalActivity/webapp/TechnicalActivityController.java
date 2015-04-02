package com.technicalActivity.webapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TechnicalActivityController {
	
	private static final Logger logger = LoggerFactory.getLogger(TechnicalActivityController.class);
	
	/**
	 * Simply selects the search view and displays the message.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {			
		return "search";
	}
	
	
	/**
	 * Make AJAX call to validate the form and return the result
	 */
	@RequestMapping(value="/search",method=RequestMethod.POST)
    public @ResponseBody JsonResponse addUser(@ModelAttribute(value="searchBean") SearchBean searchBean, BindingResult result ){
	        JsonResponse res = new JsonResponse();
	        ValidationUtils.rejectIfEmpty(result, "inputList", "Input List can not be empty.");
	        ValidationUtils.rejectIfEmpty(result, "number", "Number cannot be empty");	     
	        
	        if(!result.hasErrors())
	        {	
	        	TechnicalActivityModel t = new TechnicalActivityModel();
	        	if(!t.checkInputStringValidity(searchBean.getInputList()))
	        	{
	        		 res.setStatus("RETRY");
	        		 res.setResult("Incorrect Format.Please enter a semicolon seperated list of integers.");	        		 
	        	}
	        	else
	        	{	
	        		ArrayList<Integer> finalList = new ArrayList<Integer>();
	        		finalList = t.createListAndRemoveDuplicates(searchBean.getInputList());
	        		 if(finalList.size()>0)
	 	            {
	 	            	int inputListSize = finalList.size();
	         			
	 		        	if(!t.checkNValidity(searchBean.getNumber(), inputListSize))
	 		        	{
	 		        		 res.setStatus("RETRY");
	 		        		 res.setResult("Please enter a valid integer greater than 0, and less than: " +inputListSize);
	 		        	}
	 		        	else
	 		        	{
	 		        		res.setStatus("SUCCESS");	 			            			            
	 			            int nthMaxNo = t.searchNthLargetElement(finalList, searchBean.getNumber());
	 			            searchBean.setResult(nthMaxNo+"");
	 			            res.setResult(searchBean);
	 		        	}
	 	            }
	 	            else
	 	            {
	 	            	res.setStatus("RETRY");
	 	        		 res.setResult("List is empty");
	 	            }
	        	}	            	          	           
	        }
	        else
	        {
	            res.setStatus("FAIL");
	            res.setResult(result.getAllErrors());
	        }
	        return res;
	    }
	
}
