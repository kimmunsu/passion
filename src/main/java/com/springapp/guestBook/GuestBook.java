package com.springapp.guestBook;

import org.joda.time.DateTime;

public class GuestBook {
	private int guestBookId;
	private String userId;
	private String content;
	private DateTime regDate;
	
	public GuestBook(int guestBookId, String userId, String content) {
		super();
		this.guestBookId = guestBookId;
		this.userId = userId;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(DateTime regDate) {
		this.regDate = regDate;
	}

	public int getGuestBookId() {
		return guestBookId;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + guestBookId;
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuestBook other = (GuestBook) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (guestBookId != other.guestBookId)
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuestBook [guestBookId=" + guestBookId + ", userId=" + userId + ", content=" + content + ", regDate=" + regDate + "]";
	}
}