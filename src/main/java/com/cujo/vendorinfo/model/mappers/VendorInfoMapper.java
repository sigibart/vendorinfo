package com.cujo.vendorinfo.model.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

import com.cujo.vendorinfo.model.VendorInfo;
import com.cujo.vendorinfo.model.dao.VendorDao;

@Mapper
public interface VendorInfoMapper {
	
	String INSERT_SQL = "insert into vendor_info (vendor_id, vendor_info, createdat)"
			+ " values ("            
			+ " #{vendorId, jdbcType=NUMERIC},"
			+ " #{vendorInfo, jdbcType=VARCHAR},"                        
          + " #{createdAt, jdbcType=TIMESTAMP}"
          + " )";

	@Insert(INSERT_SQL)
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(VendorInfo data) throws PersistenceException;

}
