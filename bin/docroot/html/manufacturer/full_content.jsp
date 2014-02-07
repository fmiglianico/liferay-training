<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@include file="/html/init.jsp"%>

<%
Manufacturer mfg = (Manufacturer)request.getAttribute("MANUFACTURER ENTRY");
%>

<h1><%=mfg.getName() %></h1>

<p>
	<liferay-ui:message key="manufacturerEmail" />: <%=HtmlUtil.escape(mfg.getEmailAddress()) %> <br/>
	<liferay-ui:message key="manufacturerWebsite" />: <%=HtmlUtil.escape(mfg.getWebsite()) %> <br/>
	<liferay-ui:message key="manufacturerPhonenumber" />: <%=HtmlUtil.escape(mfg.getPhoneNumber()) %>
</p>
	    