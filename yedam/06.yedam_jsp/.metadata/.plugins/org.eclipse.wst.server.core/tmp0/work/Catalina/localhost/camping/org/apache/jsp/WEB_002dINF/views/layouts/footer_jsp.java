/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-06-22 04:51:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.layouts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	/* 다크모드 css */\r\n");
      out.write("	html, body{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        .wrap{\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("        }\r\n");
      out.write("        body[data-darkmode=on] {\r\n");
      out.write("            background-color: #1e1f21;\r\n");
      out.write("            color: #e8e8e8 !important;\r\n");
      out.write("        }\r\n");
      out.write("        /* Darkmode Toggle */\r\n");
      out.write("        body[data-darkmode=on] .darkmode > .inner{\r\n");
      out.write("            background-color: rgba(255,255,255,0.25);\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode > .inner{\r\n");
      out.write("            position: relative;\r\n");
      out.write("            display: inline-flex;\r\n");
      out.write("            padding: 5px;\r\n");
      out.write("            border-radius: 1.5em;\r\n");
      out.write("            background-color: rgba(0,0,0,0.1);\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode label {\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode label:first-of-type{\r\n");
      out.write("            padding: 5px 5px 5px 10px;\r\n");
      out.write("            border-radius: 50% 0 0 50%;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode label:last-of-type{\r\n");
      out.write("            padding: 5px 10px 5px 5px;\r\n");
      out.write("            border-radius: 0 50% 50% 0;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode i{\r\n");
      out.write("            font-size: 1.5em;\r\n");
      out.write("            color: #aaa;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode input[type=radio]{\r\n");
      out.write("            display: none;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode input[type=radio]:checked + label > i {\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            transition: all 0.35s ease-in-out;\r\n");
      out.write("        }\r\n");
      out.write("        .darkmode .darkmode-bg{\r\n");
      out.write("            width: 39px;\r\n");
      out.write("            height: 34px;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 5px;\r\n");
      out.write("            border-radius: 50px 15px 15px 50px;\r\n");
      out.write("            z-index: -1;\r\n");
      out.write("            transition: all 0.35s ease-in-out;\r\n");
      out.write("            background-color: #03a9f4;\r\n");
      out.write("        }\r\n");
      out.write("        #toggle-radio-dark:checked ~ .darkmode-bg{\r\n");
      out.write("            border-radius: 15px 50px 50px 15px;\r\n");
      out.write("            top: 5px;\r\n");
      out.write("            left: 44px;\r\n");
      out.write("        }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- ======= Footer ======= -->\r\n");
      out.write("	<section id=\"contact\" class=\"contact section-bg\">\r\n");
      out.write("		<div align=\"center\">\r\n");
      out.write("			<img src=\"assets/img/favicon.png\" alt=\"로고\" width=\"40px\">\r\n");
      out.write("			<p>caping everywhere</p>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"contact_info\">\r\n");
      out.write("			<p>\r\n");
      out.write("				<strong>CUSTOMMER INFO</strong>\r\n");
      out.write("			</p>\r\n");
      out.write("			<p>053-123-4567</p>\r\n");
      out.write("			<p>평일: 오전09:00 ~ 오후06:00</p>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"contact_info\">\r\n");
      out.write("			<p>\r\n");
      out.write("				<strong>ADDRESS</strong>\r\n");
      out.write("			</p>\r\n");
      out.write("			<P>대구광역시 중구 중앙대로 403 (남일동 135-1, 5층)</P>\r\n");
      out.write("			<p>대표 : 최영호</p>\r\n");
      out.write("		<div id=\"google_translate_element\" class=\"hd_lang\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("	<footer id=\"footer\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"copyright\">Copyright &copy; GropBy.4 all right\r\n");
      out.write("				resesrved</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</footer>\r\n");
      out.write("	<script>\r\n");
      out.write("	function googleTranslateElementInit() {\r\n");
      out.write("		new google.translate.TranslateElement({\r\n");
      out.write("			pageLanguage: 'ko,en',\r\n");
      out.write("			includedLanguages: 'ko,zh-CN,ja,en',\r\n");
      out.write("			layout: google.translate.TranslateElement.InlineLayout.SIMPLE,\r\n");
      out.write("			autoDisplay: false\r\n");
      out.write("		}, 'google_translate_element');\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
