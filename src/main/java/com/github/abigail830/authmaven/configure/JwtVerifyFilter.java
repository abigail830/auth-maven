package com.github.abigail830.authmaven.configure;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
public class JwtVerifyFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String jwtToken = req.getHeader("authorization");
        logger.info(jwtToken);

        if (jwtToken != null && jwtToken.contains("Bearer")) {
            Claims claims = Jwts.parser()
                    .setSigningKey(JwtLoginFilter.SEED)
                    .parseClaimsJws(jwtToken.replace("Bearer", ""))
                    .getBody();

            String username = claims.getSubject();//获取当前登录用户名
            List<GrantedAuthority> authorities =
                    AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(token);

            filterChain.doFilter(req, servletResponse);
        } else {
            servletResponse.setContentType("application/json;charset=utf-8");

            PrintWriter out = servletResponse.getWriter();
            out.write("登录失败!");
            out.flush();
            out.close();
        }

    }
}
