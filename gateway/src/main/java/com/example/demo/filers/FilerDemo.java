package com.example.demo.filers;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 测试拦截器
 *
 * @author xuke
 * @date 2021/08/23 14:08
 **/
@Configuration
@Slf4j
public class FilerDemo implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入gateway");
        log.info("请求头信息>>{}",JSONObject.toJSONString(exchange.getRequest().getHeaders()));
        log.info("请求参数信息>>{}", JSONObject.toJSONString(exchange.getRequest().getQueryParams()));

        //拦截器继续后续操作
        return chain.filter(exchange);
        //return exchange.getResponse().setComplete(); 拦截器终止后续操作
    }

    /**
     * 控制执行顺序
     * @return 顺序
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
