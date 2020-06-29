package co.simplon.ocar.security;

import co.simplon.ocar.security.jwt.AuthEntryPointJwt;
import co.simplon.ocar.security.jwt.AuthTokenFilter;
import co.simplon.ocar.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* version h2 */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated();
//        http.headers().frameOptions().disable();
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                    .antMatchers("/api/auth/**").permitAll()
                    .antMatchers("/api/test/**").permitAll()
                    .antMatchers("/api/offers").permitAll()

                    .antMatchers("/api/offers/filter").permitAll()

                    .antMatchers(HttpMethod.GET,"/api/offers/*").permitAll()

                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
        web.ignoring().antMatchers("/h2-console/**/**");

        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/index.html");
        web.ignoring().antMatchers("/favicon.ico");
        web.ignoring().antMatchers("/main.js");
        web.ignoring().antMatchers("/polyfills.js");
        web.ignoring().antMatchers("/runtime.js");
        web.ignoring().antMatchers("/styles.js");
        web.ignoring().antMatchers("/vendor.js");
    }

//    .antMatchers("/swagger-ui.html","/configuration/**","/swagger-resources/**","/v2/**", "/webjars/**").permitAll()
//    .antMatchers("/api/users/**").permitAll()




}


