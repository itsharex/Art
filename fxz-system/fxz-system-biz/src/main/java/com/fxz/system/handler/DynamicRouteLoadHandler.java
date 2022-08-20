package com.fxz.system.handler;

import com.fxz.common.mq.redis.core.RedisMQTemplate;
import com.fxz.common.redis.constant.CacheConstants;
import com.fxz.system.mq.RouteMessage;
import com.fxz.system.service.RouteConfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Fxz
 * @version 1.0
 * @date 2022/8/20 14:17
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouteLoadHandler implements InitializingBean {

	private final RouteConfService routeConfService;

	private final RedisMQTemplate redisMQTemplate;

	@Override
	public void afterPropertiesSet() {
		loadRouteToRedis();
	}

	/**
	 * 加载路由信息到redis
	 */
	@Order
	@EventListener({ WebServerInitializedEvent.class })
	public void loadRouteToRedis() {
		// 发送消息告诉网关加载路由信息
		redisMQTemplate.send(new RouteMessage(routeConfService.list()));
	}

}