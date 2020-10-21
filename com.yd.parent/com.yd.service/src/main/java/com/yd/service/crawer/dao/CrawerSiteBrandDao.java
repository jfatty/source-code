package com.yd.service.crawer.dao;

import java.util.List;
import java.lang.Integer;
import org.apache.ibatis.annotations.Param;
import com.yd.service.crawer.bean.CrawerSiteBrand;
import com.yd.api.crawer.req.CrawerSiteBrandReq;

/**
 *
 * This tools just a simple useful tools, gen table to javabean
 *
 * "I hope this tools can save your time"
 *
 * Generated by <tt>Generate</tt> 
 *
 * @author com.ypn.mapi.generate
 * @version v1.0
 */
public interface CrawerSiteBrandDao {

	public CrawerSiteBrand findCrawerSiteBrandById(Integer id);
	
	public Integer insert(CrawerSiteBrand param);
	
	public Integer getCrawerSiteBrandCount(CrawerSiteBrandReq req);
	
	public List<CrawerSiteBrand> findCrawerSiteBrandsByPage(@Param("req")CrawerSiteBrandReq req,@Param("offset")Integer offset,@Param("rows")Integer rows);
	
	//if not use,pls delete it
	public Integer deleteCrawerSiteBrandById(Integer id);
}