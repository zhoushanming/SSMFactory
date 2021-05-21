package cn.edu.usts.cs2018.filter;

import cn.edu.usts.cs2018.entity.Staff;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/staff/*","/machine/*","/products/*"})
public class LoginFilter  extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session=httpServletRequest.getSession();
        Staff user=(Staff)session.getAttribute("user");
        if(user==null) {
            String redirectPath=httpServletRequest.getServletPath().replaceAll("/","%2F");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login?redirect="+redirectPath);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
