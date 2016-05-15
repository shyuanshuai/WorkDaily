package com.ys.workdaily.pojo;

import java.util.Date;
import java.util.UUID;

public class Schedule {

	private String id;
	private String type;
	private String content;
	private String status;
	private String level;
	private String operator;
	private String assignUser;
	private Date createTime;
	private Date executeTime;
	private Date completeTime;
	private String note;

	public Schedule() {
		this.id = UUID.randomUUID().toString();
		this.status = "待办事项";
		this.createTime = new Date();
		this.executeTime = null;
		this.completeTime = null;
	}

	public Schedule(String type, String content, String level, String operator, String assignUser, String note) {
		this.id = UUID.randomUUID().toString();
		this.type = type;
		this.content = content;
		this.status = "待办事项";
		this.level = level;
		this.operator = operator;
		this.assignUser = assignUser;
		this.createTime = new Date();
		this.executeTime = null;
		this.completeTime = null;
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
