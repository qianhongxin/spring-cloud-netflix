/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.netflix.zuul;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Import;

/**
 * Sets up a Zuul server endpoint and installs some reverse proxy filters in it, so it can
 * forward requests to backend servers. The backends can be registered manually through
 * configuration or via DiscoveryClient.
 *
 * @see EnableZuulServer for how to get a Zuul server without any proxying
 *
 * @author Spencer Gibb
 * @author Dave Syer
 * @author Biju Kunjummen
 */
// 这个@EnableZuulProxy注解其实干了两件事情，第一件事情就是启用一个zuul server，这个东西可以接收所有的http请求，都会被他给拦截，所以这块我们可以想象一下，这里的zuul一定是搞了一个类似与servlet、filter、spring boot拦截器的东西
//
//这个东西一定会拦截所有的http请求，他来处理
//
//第二件事情，就是给那个zuul server（拦截器，servlet，filter）加入一些内置的filter，过滤器，就是我们之前看到的各种过滤器
@EnableCircuitBreaker
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ZuulProxyMarkerConfiguration.class)
public @interface EnableZuulProxy {

}
