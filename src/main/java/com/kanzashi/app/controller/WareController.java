package com.kanzashi.app.controller;

import com.kanzashi.app.editors.CatalogEditor;
import com.kanzashi.app.model.CatalogBean;
import com.kanzashi.app.model.WareBean;
import com.kanzashi.app.service.WareManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/ware-module")
@SessionAttributes("ware")
public class WareController
{
	@Autowired
	WareManager manager;

	private Validator validator;

	//Bind custom validator for submitted form
	public WareController()
	{
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	/**
	 * Bind CatalogEditor to CatalogBean; Look at JSP file for clearer picture
	 * */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(CatalogBean.class, new CatalogEditor());
    }
	/**
	 * Bind all departments
	 * */
	@ModelAttribute("allDepartments")
    public List<CatalogBean> populateDepartments()
    {
        List<CatalogBean> departments = manager.getAllDepartments();
        return departments;
    }
	
	/**
	 * Bind all wares list
	 * */
	@ModelAttribute("allWares")
    public List<WareBean> populateWares()
    {
        List<WareBean> wares = manager.getAllWares();
        return wares;
    }
	
	/**
	 * Method will be called in initial page load at GET /ware-module
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) 
	{
		WareBean wareVO = new WareBean();
		model.addAttribute("ware", wareVO);
		return "listWareView";
	}

	/**
	 * Method will be called on submitting add ware form POST /ware-module
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("ware") WareBean wareVO,
			BindingResult result, SessionStatus status) {

		Set<ConstraintViolation<WareBean>> violations = validator.validate(wareVO);
		
		for (ConstraintViolation<WareBean> violation : violations)
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("ware", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }

		if (result.hasErrors()) {
			return "listWareView";
		}
		// Store the ware information in database
		manager.addEmployee(wareVO);
		
		// Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
		status.setComplete();
		return "redirect:ware-module";
	}

}