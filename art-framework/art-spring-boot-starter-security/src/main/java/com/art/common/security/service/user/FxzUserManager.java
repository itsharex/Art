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

package com.art.common.security.service.user;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.art.common.core.constant.SecurityConstants;
import com.art.system.entity.SystemUser;
import com.art.system.feign.RemoteMenuService;
import com.art.system.feign.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Fxz
 * @version 0.0.1
 * @date 2021-11-28 15:53
 */
@Service
@RequiredArgsConstructor
public class FxzUserManager {

	private final RemoteUserService userService;

	private final RemoteMenuService menuService;

	public SystemUser findByName(String username) {
		return userService.findByName(username, SecurityConstants.FROM_IN);
	}

	public SystemUser findByMobile(String mobile) {
		return userService.findByMobile(mobile, SecurityConstants.FROM_IN);
	}

	public String findUserPermissions(String username) {
		return String.join(StringPool.COMMA, menuService.findUserPermissions(username, SecurityConstants.FROM_IN));
	}

}