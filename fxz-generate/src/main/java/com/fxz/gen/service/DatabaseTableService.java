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

package com.fxz.gen.service;

import com.fxz.gen.entity.DatabaseColumn;
import com.fxz.gen.entity.DatabaseTable;

import java.util.List;

/**
 * @author Fxz
 * @version 0.0.1
 * @date 2022-03-03 15:55
 */
public interface DatabaseTableService {

	/**
	 * 获取表基本信息
	 */
	DatabaseTable findByTableName(String tableName, String dsName);

	/**
	 * 获取表的列信息
	 */
	List<DatabaseColumn> findColumnByTableName(String tableName, String dsName);

}
