/*
 * COPYRIGHT (C) 2022 Art AUTHORS(fxzcloud@gmail.com). ALL RIGHTS RESERVED.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.art.common.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author fxz
 **/
@SuppressWarnings("all")
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

	SUCCESS("00000", "一切ok"),

	SYSTEM_EXECUTION_ERROR("A0500", "系统执行出错");

	private String code;

	private String msg;

	public static ResultCode getValue(String code) {
		return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst().orElse(SYSTEM_EXECUTION_ERROR);
	}

}
