package org.dr.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingDTO {
	
	private int page;
	private int amount;

	public PagingDTO() {
		this.page = 1;
		this.amount = 10;
	}

	public PagingDTO(String pageStr, String amountStr) {
		// pageStr
		try {
			this.page = Integer.parseInt(pageStr);
		} catch (Exception e) {
			page = 1;
		}
		// amountStr
		try {
			this.amount = Integer.parseInt(amountStr);
		} catch (Exception e) {
			amount = 10;
		}
	}

	public void setPage(int page) {
		// 0일 때 아무것도 안하게
		if (page <= 0) {
			return;
		}
		this.page = page;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}

}
