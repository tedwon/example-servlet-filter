package example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ExampleServletFilter implements Filter {

   private int output;

   public ExampleServletFilter() {

   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      this.output = Integer.parseInt(filterConfig.getInitParameter("output"));
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

      if (!(response instanceof HttpServletResponse)) {
         chain.doFilter(request, response);
         return;
      }

      HttpServletResponse res = (HttpServletResponse) response;
      res.setBufferSize(this.output);
//      response.setBufferSize(65536);
      chain.doFilter(request, res);
      System.out.println("res.setBufferSize(65536)");
   }

   @Override
   public void destroy() {

   }
}
