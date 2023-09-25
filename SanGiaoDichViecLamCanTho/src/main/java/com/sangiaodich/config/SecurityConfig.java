package com.sangiaodich.config;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sangiaodich.entity.TaiKhoanDoanhNghiep;
import com.sangiaodich.entity.TaiKhoanNguoiLaoDong;
import com.sangiaodich.service.TaiKhoanDoanhNghiepService;
import com.sangiaodich.service.TaiKhoanNguoiLaoDongService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	TaiKhoanDoanhNghiepService tkDoanhNghiepservice;

	@Autowired
	TaiKhoanNguoiLaoDongService tkLaoDongservice;

	@Autowired
	BCryptPasswordEncoder pe;

	// Cung cấp nguồn dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {

				String password = null;
				String roles = null;
				String hoten = null;

				TaiKhoanDoanhNghiep tkDoanhNghiep = tkDoanhNghiepservice.loginDoanhNghiep(username);

				TaiKhoanNguoiLaoDong tkNLD = tkLaoDongservice.loginNLD(username);

				if (tkDoanhNghiep == null) {
					if (tkNLD.getIDTAIKHOAN() != null) {
						TaiKhoanNguoiLaoDong tk = tkLaoDongservice.findById(tkNLD.getIDTAIKHOAN());
						System.out.println(tk.getHOVATEN());
						hoten = tk.getHOVATEN();
						password = pe.encode(tk.getMATKHAU());
						roles = "NLD";
					}
				} else {
					if (tkDoanhNghiep.getIDTAIKHOANDN() != null) {
						TaiKhoanDoanhNghiep tk = tkDoanhNghiepservice.findById(tkDoanhNghiep.getIDTAIKHOANDN());
						System.out.println(tk.getHOVATEN());
						hoten = tk.getHOVATEN();
						password = pe.encode(tk.getMATKHAU());
						roles = "DOANHNGHIEP";
					}
				}

				return User.withUsername(hoten).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}

	/*--Phân quyền sử dụng và hình thức đăng nhập--*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF, CORS
		http.csrf().disable();
		// Phân quyền sử dụng
		http.authorizeRequests().antMatchers("/order/**").authenticated().antMatchers("/qlisan")
				.hasAnyRole("DOANHNGHIEP").antMatchers("/qlibaiviet").hasRole("DOANHNGHIEP").anyRequest().permitAll(); // anonymous
		// Giao diện đăng nhập
		http.formLogin().loginPage("/security/login/form").loginProcessingUrl("/security/login") // [/login]
				.defaultSuccessUrl("/success", false).failureUrl("/errorlogin");

		http.rememberMe().tokenValiditySeconds(86400);

		// Điều khiển lỗi truy cập không đúng vai trò
		http.exceptionHandling().accessDeniedPage("/security/unauthoritied"); // [/error]
		// Đăng xuất
		http.logout().logoutUrl("/logoff") // [/logout]
				.logoutSuccessUrl("/logoffSuccess");
	}

	// cơ chế mã hóa mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Cho phép truy xuất RESR API từ bên ngoài(domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
