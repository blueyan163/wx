package com.bootdo.wx.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 宝贝描述
 * 
 * @author yanwen
 * @email blueyan163@163.com
 * @date 2018-06-27 17:22:41
 */
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long gid;
	//名称
	private String title;
	//描述
	private String content;
	//类型
	private String type;
	//标签
	private String tags;
	//分类
	private String categories;
	//总量
	private Integer totalNum;
	//余量
	private Integer surNum;
	//开启评论
	private Integer allowComment;
	//状态
	private Integer status;
	//单价
	private String price;
	//租赁单价
	private String rentPrice;
	//开始时间
	private Date beginTime;
	//结束时间
	private Date endTime;
	//创建人id
	private Long created;
	//最近修改人id
	private Long modified;
	//创建时间
	private Date gtmCreate;
	//修改时间
	private Date gtmModified;

	/**
	 * 设置：
	 */
	public void setGid(Long gid) {
		this.gid = gid;
	}
	/**
	 * 获取：
	 */
	public Long getGid() {
		return gid;
	}
	/**
	 * 设置：名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：名称
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：描述
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：描述
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：标签
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：分类
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * 获取：分类
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * 设置：总量
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * 获取：总量
	 */
	public Integer getTotalNum() {
		return totalNum;
	}
	/**
	 * 设置：余量
	 */
	public void setSurNum(Integer surNum) {
		this.surNum = surNum;
	}
	/**
	 * 获取：余量
	 */
	public Integer getSurNum() {
		return surNum;
	}
	/**
	 * 设置：开启评论
	 */
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	/**
	 * 获取：开启评论
	 */
	public Integer getAllowComment() {
		return allowComment;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：租赁单价
	 */
	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	/**
	 * 获取：租赁单价
	 */
	public String getRentPrice() {
		return rentPrice;
	}
	/**
	 * 设置：开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreated(Long created) {
		this.created = created;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getCreated() {
		return created;
	}
	/**
	 * 设置：最近修改人id
	 */
	public void setModified(Long modified) {
		this.modified = modified;
	}
	/**
	 * 获取：最近修改人id
	 */
	public Long getModified() {
		return modified;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGtmCreate(Date gtmCreate) {
		this.gtmCreate = gtmCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGtmCreate() {
		return gtmCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGtmModified(Date gtmModified) {
		this.gtmModified = gtmModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGtmModified() {
		return gtmModified;
	}
}
