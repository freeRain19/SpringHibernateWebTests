package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class MyFilter implements Filter {
	private String encoding;
	private FilterConfig filterConfig = null;


	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		encoding = request.getCharacterEncoding();
		request.setCharacterEncoding("UTF-8");
		if (!"UTF-8".equalsIgnoreCase(encoding)){
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		}
		encoding = request.getCharacterEncoding();
		filterChain.doFilter(request, response);

	
	}

	@Override
	public void destroy() {

	}
}
