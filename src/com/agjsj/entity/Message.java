package com.agjsj.entity;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private Integer userSendId;
	private Integer userReceiveId;
	private String messageContext;
	private String messageTime;
	private Integer messageTag;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Integer userSendId, Integer userReceiveId,
			String messageContext, String messageTime, Integer messageTag) {
		this.userSendId = userSendId;
		this.userReceiveId = userReceiveId;
		this.messageContext = messageContext;
		this.messageTime = messageTime;
		this.messageTag = messageTag;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getUserSendId() {
		return this.userSendId;
	}

	public void setUserSendId(Integer userSendId) {
		this.userSendId = userSendId;
	}

	public Integer getUserReceiveId() {
		return this.userReceiveId;
	}

	public void setUserReceiveId(Integer userReceiveId) {
		this.userReceiveId = userReceiveId;
	}

	public String getMessageContext() {
		return this.messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public String getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	public Integer getMessageTag() {
		return this.messageTag;
	}

	public void setMessageTag(Integer messageTag) {
		this.messageTag = messageTag;
	}

}