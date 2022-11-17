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

package com.art.system.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.amazonaws.services.s3.model.S3Object;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.art.common.file.OssProperties;
import com.art.common.file.service.OssTemplate;
import com.art.common.mp.result.Result;
import com.art.system.dto.FileDto;
import com.art.system.entity.File;
import com.art.system.mapper.FileMapper;
import com.art.system.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件管理表
 *
 * @author fxz
 * @date 2022-04-04
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

	private final FileMapper fileMapper;

	private final OssProperties ossProperties;

	private final OssTemplate minioTemplate;

	/**
	 * 上传文件
	 */
	@Override
	public Result<Object> addFile(MultipartFile file) {
		String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());

		Map<String, String> resultMap = new HashMap<>(4);

		resultMap.put("bucketName", ossProperties.getBucketName());
		resultMap.put("fileName", fileName);
		resultMap.put("url", String.format("/system/file/%s/%s", ossProperties.getBucketName(), fileName));

		try {
			minioTemplate.putObject(ossProperties.getBucketName(), fileName, file.getInputStream(),
					file.getContentType());
			// 记录到数据库
			fileLog(file, fileName);
		}
		catch (Exception e) {
			log.error("上传失败", e);
			return Result.failed();
		}

		return Result.success(resultMap);
	}

	/**
	 * 文件管理数据记录,收集管理追踪文件
	 * @param file 上传文件格式
	 * @param fileName 文件名
	 */
	private void fileLog(MultipartFile file, String fileName) {
		File sysFile = new File();

		sysFile.setFileName(fileName);
		sysFile.setOriginal(file.getOriginalFilename());
		sysFile.setFileSize(file.getSize());
		sysFile.setType(FileUtil.extName(file.getOriginalFilename()));
		sysFile.setBucketName(ossProperties.getBucketName());

		this.save(sysFile);
	}

	/**
	 * 修改
	 */
	@Override
	public Boolean updateFile(FileDto fileDto) {
		File file = new File();
		BeanUtils.copyProperties(fileDto, file);
		fileMapper.updateById(file);
		return Boolean.TRUE;
	}

	/**
	 * 分页
	 */
	@Override
	public IPage<File> pageFile(Page<File> pageParam, File file) {
		return fileMapper.selectPage(pageParam, Wrappers.emptyWrapper());
	}

	/**
	 * 获取单条
	 */
	@Override
	public File findById(Long id) {
		return fileMapper.selectById(id);
	}

	/**
	 * 获取全部
	 */
	@Override
	public List<File> findAll() {
		return fileMapper.selectList(Wrappers.emptyWrapper());
	}

	/**
	 * 删除文件
	 */
	@SneakyThrows
	@Override
	public Boolean deleteFile(Long id) {
		File file = fileMapper.selectById(id);
		minioTemplate.removeObject(file.getBucketName(), file.getFileName());
		fileMapper.deleteById(id);
		return Boolean.TRUE;
	}

	/**
	 * 下载文件
	 * @param bucket 桶名称
	 * @param fileName 文件名
	 * @param response 响应
	 */

	@Override
	public void getFile(String bucket, String fileName, HttpServletResponse response) {
		try (S3Object s3Object = minioTemplate.getObject(bucket, fileName)) {
			response.setContentType("application/octet-stream; charset=UTF-8");
			IoUtil.copy(s3Object.getObjectContent(), response.getOutputStream());
		}
		catch (Exception e) {
			log.error("文件读取异常: {}", e.getLocalizedMessage());
		}
	}

}