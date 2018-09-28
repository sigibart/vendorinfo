package com.cujo.vendorinfo.model.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

import com.cujo.vendorinfo.model.Vendor;
import com.cujo.vendorinfo.model.dao.VendorDao;

@Mapper
public interface VendorMapper {
		
	String INSERT_SQL = "insert into vendor (vendorname, createdat)"
			+ " values ("            
            + " #{vendorName, jdbcType=VARCHAR},"                        
            + " #{createdAt, jdbcType=TIMESTAMP}"
            + " )";
	
	String FIND_ALL_SQL = 
			" SELECT agg1.vendorname, min(vendorinfo) as vendorinfo,  string_agg(k.keyword, ', ') AS keywordsStr "
					+" FROM ( "
					+"   SELECT "
					+"     v.id, "
					+"     v.vendorname, "
					+"     string_agg(vi.vendor_info, ' ||| ') AS vendorinfo "
					+"   FROM vendor v "
					+"     INNER JOIN vendor_info vi ON vi.vendor_id = v.id "
					+"   GROUP BY v.id, "
					+"     v.vendorName "
					+" ) agg1 "
					+" LEFT JOIN keywords k on k.vendor_id = agg1.id "
					+" GROUP BY agg1.vendorname ";
	
	String FIND_BY_NAME_SQL = 
			  " SELECT * "
			+ " FROM vendor v "
			+ " WHERE vendorname = #{vendorName}"
			;
	
	@Insert(INSERT_SQL)
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Vendor data) throws PersistenceException;
	
	@Select(FIND_ALL_SQL)
	List<VendorDao> findAll() throws PersistenceException;
	
	@Select(FIND_BY_NAME_SQL)
	Vendor findByName(@Param("vendorName") String vendorName) throws PersistenceException;

}
