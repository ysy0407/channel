package com.dongxin.channel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@MapperScan("com.dongxin.channel.mapper")
public class ChannelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {
			//这样的语句需要 Modules-sources-language level 大于1.7
			//当页面的状态码为LOCKED:423时,会跳转为指定页面
			ErrorPage error404Page = new ErrorPage(HttpStatus.LOCKED, "/lock.html");
			container.addErrorPages(error404Page);
		});
	}
}
