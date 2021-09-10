package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 23:59:24
 */
@Data
@TableName("QRTZ_SCHEDULER_STATE")
public class QrtzSchedulerStateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String instanceName;
	/**
	 * 
	 */
	private Long lastCheckinTime;
	/**
	 * 
	 */
	private Long checkinInterval;

}