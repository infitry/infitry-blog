package com.infitry.blog.result;

import lombok.Data;

/**
 * @since 2020. 3. 31.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : 통신에 대한 결과 값 클래스
 */
@Data
public class TransResult {
	boolean isSuccess;
	String errorMessage;
	
	public TransResult(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
