package com.yd.service.dao;

import java.util.List;
import java.lang.Integer;
import org.apache.ibatis.annotations.Param;
import com.yd.service.bean.ActIqiyi;

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
public interface ActIqiyiDao {

	public ActIqiyi findActIqiyiById(Integer id);
	
	public Integer insert(ActIqiyi param);
	
	public Integer getActIqiyiCount(ActIqiyi param);
	
	public List<ActIqiyi> findActIqiyisByPage(@Param("param")ActIqiyi param,@Param("offset")Integer offset,@Param("rows")Integer rows);
	
	//if not use,pls delete it
	public Integer deleteActIqiyiById(Integer id);

	public List<ActIqiyi> getWaitList(@Param("limit")int limit);

	public void notifyIqiyiOrder(@Param("id")int id, @Param("orderStatus")String orderStatus, @Param("failedCode")String failedCode, @Param("failedReason")String failedReason, @Param("billNo")String billNo);

	public void updateStatus(@Param("id")Integer id, @Param("status")String status);

	public List<ActIqiyi> getWaitSendSms();

	public int updateSmsStatus(@Param("id")Integer id);

	public List<ActIqiyi> getNeedQueryConfirmStatusList();
}