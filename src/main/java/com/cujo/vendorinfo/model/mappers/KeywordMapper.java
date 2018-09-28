package com.cujo.vendorinfo.model.mappers;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

import com.cujo.vendorinfo.model.Keyword;

@Mapper
public interface KeywordMapper {
	String INSERT_SQL = "insert into keywords (vendor_id, keyword, createdat)"
			+ " values ("            
			+ " #{vendorId, jdbcType=NUMERIC},"
			+ " #{keyword, jdbcType=VARCHAR},"                        
          + " #{createdAt, jdbcType=TIMESTAMP}"
          + " )";
	
	String FIND_BY_VENDOR_AND_KEYWORD_SQL = 
			  " SELECT * "
			+ " FROM keywords "
			+ " WHERE vendor_id = #{vendorId} "
			+ " AND keyword = #{keyword}"
			;
	@Select(FIND_BY_VENDOR_AND_KEYWORD_SQL)
	Keyword findExisting(@Param("vendorId") BigDecimal vendorId, @Param("keyword") String keyword) throws PersistenceException;

	@Insert(INSERT_SQL)
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Keyword data) throws PersistenceException;
}
