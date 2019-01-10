Execute mvn command to build:

~~~
$ mvn clean package
~~~

Then, put example-servlet-filter.jar in WEB-INF/lib of your web application.

And add servlet filter to web.xml
~~~
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
    <filter>
        <filter-name>ExampleServletFilter</filter-name>
        <filter-class>example.ExampleServletFilter</filter-class>
        <init-param>
            <param-name>output</param-name>
            <param-value>65536</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>ExampleServletFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <distributable/>
</web-app>
~~~