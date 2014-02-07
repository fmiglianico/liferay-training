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

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="mvcPath" value="/html/manufacturer/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="manufacturer" />

<%
	long manufacturerId = ParamUtil.getLong(renderRequest,
			"manufacturerId");
	Manufacturer mfg = ManufacturerLocalServiceUtil
			.getManufacturer(manufacturerId);
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
			Manufacturer.class.getName(), mfg.getManufacturerId());
	
	PortalUtil.addPortletBreadcrumbEntry(request, mfg.getName(), currentURL);

	PortalUtil.setPageSubtitle(mfg.getName(), request);
	PortalUtil.setPageDescription(mfg.getName(), request);

	List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(Manufacturer.class.getName(), mfg.getManufacturerId());
	PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), request);

				
%>

<h1><%=mfg.getName()%></h1>

<p>
<liferay-ui:message key="manufacturerEmail" />: <%=HtmlUtil.escape(mfg.getEmailAddress()) %> <br/>
<liferay-ui:message key="manufacturerWebsite" />: <%=HtmlUtil.escape(mfg.getWebsite()) %> <br/>
<liferay-ui:message key="manufacturerPhonenumber" />: <%=HtmlUtil.escape(mfg.getPhoneNumber()) %>
</p>

<liferay-ui:ratings className="<%=Manufacturer.class.getName()%>"
    classPK="<%=mfg.getManufacturerId()%>" type="stars" />

<c:if test="<%=themeDisplay.isSignedIn()%>">

	<liferay-ui:panel-container extended="<%=false%>"
		id="sloganCommentsPanelContainer" persistState="<%=true%>">
	
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>"
	        id="sloganCommentsPanel" persistState="<%=true%>"
	        title='<%=LanguageUtil.get(pageContext, "comments")%>'>
	
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />
	
			<liferay-ui:discussion className="<%=Manufacturer.class.getName()%>"
	            classPK="<%=mfg.getManufacturerId()%>"
	            formAction="<%=discussionURL%>" formName="fm2"
	            ratingsEnabled="<%=true%>" redirect="<%=currentURL%>"
	            subject="<%=mfg.getName()%>"
	            userId="<%=mfg.getUserId()%>" />
			
				<liferay-ui:asset-links
				assetEntryId="<%=(assetEntry != null) ? assetEntry
								.getEntryId() : 0%>"
				className="<%=Manufacturer.class.getName()%>"
				classPK="<%=mfg.getManufacturerId()%>"
				/>
	
		</liferay-ui:panel>
	
	</liferay-ui:panel-container>

</c:if>

	    