package com.screw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //配置认证用户信息和权限
    //这块虽然只添加了addOeder，但是认证后菜单都能访问，问题暂不清楚后续再研究。
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加管理员权限admin
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("admin");
        //添加普通权限user
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").authorities("user");
    }

    //配置拦截请求资源
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置菜单，都允许那些权限访问
                .antMatchers("/api/queryOrder").hasAnyAuthority("admin","user")
                .antMatchers("/api/addOrder").hasAnyAuthority("admin")
                .antMatchers("/api/delOrder").hasAnyAuthority("admin")
                .antMatchers("/**").fullyAuthenticated().and().formLogin();
                //.antMatchers("/**").permitAll(); 不需要登录可访问

    }

    //因为2.0加了安全措施，默认不允许明文密码，需要加密。所以让其会退到可以使用明文密码
    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
