package com.cujo.vendorinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cujo.vendorinfo.model.Keyword;
import com.cujo.vendorinfo.model.dao.VendorDao;
import com.cujo.vendorinfo.services.VendorServices;

@RestController
@Transactional
public class VendorInfoController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private VendorServices vendorServices;

	@RequestMapping(value = "/vendor/insert", method = RequestMethod.POST)
	public ResponseInfo insert(HttpServletRequest request, @RequestBody VendorDao vendorDao) {
		
		if (vendorDao == null || StringUtils.isEmpty(vendorDao.getVendorName()) || StringUtils.isEmpty(vendorDao.getVendorInfo()))
			return ResponseInfo.failure("Some input fields are missing");
		
        try {
        	vendorServices.insert(vendorDao);
        	return ResponseInfo.success(null);
        } catch (Exception e) {
        	return ResponseInfo.failure(e.getMessage());
        }
    }
	
	@RequestMapping(value = "/vendor/all", method = RequestMethod.GET)
	public ResponseInfo allVendors() {
		
        List<VendorDao> vendors = vendorServices.findAll();
        
        if (vendors == null) 
        	return ResponseInfo.failure("Vendors not found");
        
        return ResponseInfo.success(vendors);

	}
}
