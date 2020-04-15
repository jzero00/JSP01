package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.util.ViewResolver;

public class MemberDisabledFilter implements Filter {
	private List<String> disabled = new ArrayList<String>();
	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
		
		if(excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		MemberVO loginUser = (MemberVO) httpReq.getSession().getAttribute("loginUser");
		
		if(loginUser.getEnabled() != 1) {
			String url = "common/disabled";
			ViewResolver.view(httpReq, httpResp, url);
		} else {
			chain.doFilter(request, response);			
		}
	}
	
	private boolean excludeCheck(String url) {
		for(String exURL : disabled) {
			if(url.contains(exURL)) {
				return false;
			}
		}
		return true;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String disabledURL = fConfig.getInitParameter("disabled");
		StringTokenizer st = new StringTokenizer(disabledURL,",");
		while(st.hasMoreTokens()) {
			disabled.add(st.nextToken());
		}
	}

}
