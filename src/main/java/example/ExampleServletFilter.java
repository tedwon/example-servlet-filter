package example;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ExampleServletFilter implements Filter {

   private final static Logger LOGGER = Logger.getLogger(ExampleServletFilter.class.toString());

   private int output;

   public void init(FilterConfig filterConfig) throws ServletException {
      this.output = Integer.parseInt(filterConfig.getInitParameter("output"));
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      if (!(response instanceof HttpServletResponse)) {
         chain.doFilter(request, response);
         return;
      }

      HttpServletResponse res = (HttpServletResponse) response;
      res.setBufferSize(this.output);
      //LOGGER.info("res.setBufferSize(" + this.output + ");");
      chain.doFilter(request, res);
   }

   public void destroy() {

   }
}
