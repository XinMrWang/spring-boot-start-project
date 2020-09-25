package com.halink.scaffold.config.springsecurity;


import com.halink.scaffold.modular.service.impl.MyUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * EnableGlobalMethodSecurity(prePostEnabled = true)
 * 表示开启全局方法注解，可在指定方法上面添加注解指定权限，需含有指定权限才可调用(基于表达式的权限控制)
 *
 * @author halink
 * @date 2019/11/27 11:15 上午
 */
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 未登陆时返回 JSON 格式的数据给前端（否则为 html）
     */
    private final AjaxAuthenticationEntryPoint authenticationEntryPoint;
    /**
     * 登录成功返回的 JSON 格式数据给前端（否则为 html）
     */
    private final AjaxAuthenticationSuccessHandler authenticationSuccessHandler;
    /**
     * 登录失败返回的 JSON 格式数据给前端（否则为 html）
     */
    private final AjaxAuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
     */
    private final AjaxLogoutSuccessHandler logoutSuccessHandler;
    /**
     * 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
     */
    private final AjaxAccessDeniedHandler accessDeniedHandler;
    /**
     * 自定义user
     */
    private final MyUserDetailsServiceImpl userDetailsService;

    /**
     * JWT 拦截器
     */
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        //auth.authenticationProvider(provider);
        //这里使用自定义的加密方式(不使用加密)，security提供了 BCryptPasswordEncoder 加密可自定义或使用这个
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 请根据自身业务进行扩展
        // 去掉 CSRF
        http.csrf().disable()
                //关闭session管理，使用token机制处理
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                //.and().antMatcher("/login")
                // 自定义权限校验  RBAC 动态 url 认证
                //.and().authorizeRequests().anyRequest().access("@rbacauthorityservice.hasPermission(request,authentication)")
                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/test").hasAuthority("test:list")
                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/test").hasAuthority("test:add")
                .and().authorizeRequests().antMatchers(HttpMethod.PUT, "/test").hasAuthority("test:update")
                .and().authorizeRequests().antMatchers(HttpMethod.DELETE, "/test").hasAuthority("test:delete")
                .and().authorizeRequests().antMatchers("/test/*").hasAuthority("test:manager")
                //放行login(这里使用自定义登录)
                .and().authorizeRequests().antMatchers("/login").permitAll()
                .and().authorizeRequests().antMatchers("/swagger-ui/*").permitAll()
                //permitAll表示不需要认证
                .and().authorizeRequests().antMatchers("/hello").permitAll();
        //微信小程序登录不给予账号密码，关闭
//                .and()
        //开启登录, 定义当需要用户登录时候，转到的登录页面、这是使用security提供的formLogin，不需要自己实现登录登出逻辑、但需要实现相关方法
//                .formLogin()
        //可不指定，使用security自带的登录页面
//                .loginPage("/test/login.html")
        //登录地址
//                .loginProcessingUrl("/login")
        // 登录成功处理
//                .successHandler(authenticationSuccessHandler)
        // 登录失败处理
//                .failureHandler(authenticationFailureHandler)
//                .permitAll()

//                .and()
        //默认注销行为为logout
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(logoutSuccessHandler)
//                .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(userDetailsService).tokenValiditySeconds(1000);

        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        //remove the ROLE_ prefix
        return new GrantedAuthorityDefaults("");
    }
}
