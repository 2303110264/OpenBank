package kopo.aisw.hc.json;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class JsonKeyFilter implements Filter {

	private static final String API_KEY_HEADER = "Authorization";
	private String API_KEY_VALUE = "CBKey ";
	
	public String getKey(HttpSession session) {
		String key = (String) session.getAttribute("CBKey");
		return key;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String apiKey = httpRequest.getHeader(API_KEY_HEADER);

		if (API_KEY_VALUE.equals(apiKey)) {
			chain.doFilter(request, response);
		} else {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType("application/json");
			httpResponse.getWriter().write("{\"error\":\"Invalid API Key\"}");
		}

	}

}
