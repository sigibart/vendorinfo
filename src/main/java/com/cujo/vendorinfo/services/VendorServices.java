package com.cujo.vendorinfo.services;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cujo.vendorinfo.model.Keyword;
import com.cujo.vendorinfo.model.Vendor;
import com.cujo.vendorinfo.model.VendorInfo;
import com.cujo.vendorinfo.model.dao.VendorDao;
import com.cujo.vendorinfo.model.mappers.KeywordMapper;
import com.cujo.vendorinfo.model.mappers.VendorInfoMapper;
import com.cujo.vendorinfo.model.mappers.VendorMapper;

@Component
public class VendorServices {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	VendorMapper vendorMapper;
	
	@Resource
	VendorInfoMapper vendorInfoMapper;
	
	@Resource
	KeywordMapper keywordMapper;
	
	public void insert(VendorDao vendorDao) throws Exception {
		
		try {
			
			Vendor vendor = vendorMapper.findByName(vendorDao.getVendorName());
			if (vendor == null) {
				vendor = new Vendor();
				vendor.setVendorName(vendorDao.getVendorName());
				vendor.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				vendorMapper.insert(vendor);
			}
			
			if (vendorDao.getKeywordsStr() != null) {
				String[] keywords = vendorDao.getKeywordsStr().split("---");
				for (String keyword : keywords) {
					keyword = keyword.replace("---", "");
					keyword = keyword.replace("×", "");
					Keyword existing = keywordMapper.findExisting(vendor.getId(), keyword);
					if (existing != null)
						continue;
					Keyword kw = new Keyword();
					kw.setKeyword(keyword);
					kw.setVendorId(vendor.getId());
					kw.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					keywordMapper.insert(kw);
				}
			}

			VendorInfo vendorInfo = new VendorInfo();
			vendorInfo.setVendorInfo(vendorDao.getVendorInfo());			
			vendorInfo.setVendorId(vendor.getId());
			vendorInfo.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			vendorInfoMapper.insert(vendorInfo);
				
		} catch (Exception e) {
			log.error("Failed to insert vendor record: ", e);
			throw new Exception("Internal error");
		}
	}

	public List<VendorDao> findAll() {
		try {
			return vendorMapper.findAll();
		} catch (Exception e) {
			log.error("Failed to findAll ", e);
			return null;
		}
	}

}
