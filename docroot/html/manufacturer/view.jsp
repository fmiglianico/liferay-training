
<%
	/**
	 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
%>
<%@include file="/html/init.jsp"%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	boolean hasAddPermission = permissionChecker.hasPermission(
			scopeGroupId, "com.liferay.training.parts.model",
			scopeGroupId, "ADD_MANUFACTURER");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, Group.class.getName(), scopeGroupId,
			ActionKeys.PERMISSIONS);
%>

<liferay-ui:success key="manufacturer-added"
	message="manufacturer-added-successfully" />
<liferay-ui:success key="manufacturer-updated"
	message="manufacturer-updated-successfully" />
<liferay-ui:success key="manufacturer-deleted"
	message="manufacturer-deleted-successfully" />

<aui:button-row cssClass="manufacturer-buttons">
	<c:if test='<%=hasAddPermission%>'>
		<portlet:renderURL var="addManufacturerURL"
			windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="mvcPath"
				value="/html/manufacturer/edit_manufacturer.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>
		<aui:script use="aui-button-item,aui-io">
			var buttonRow = A.one(".manufacturer-buttons");
			
			var buttonLabel = "<liferay-ui:message key="add-manufacturer" />";
			var contentPane = A.one("#<portlet:namespace/>manufacturer-dynamic-content");
			
			contentPane.plug(A.Plugin.IO, {
						uri: '<%=addManufacturerURL.toString()%>',
						autoLoad: false
						});
			
			var button = new A.ButtonItem({
				icon: 'plusthick',
				label: buttonLabel,
				handler: function(event) {
					contentPane.io.start();
				}
			})
				.render(buttonRow);
				
			A.getDoc().on('key', function() {
				button.fire('click');					
			},'down:77+alt+shift');
		</aui:script>

	</c:if>

	<c:if test='<%=hasConfigurePermission%>'>
		<liferay-security:permissionsURL
			modelResource="com.liferay.training.parts.model"
			modelResourceDescription="parts-top-level-actions"
			resourcePrimKey="<%=String.valueOf(scopeGroupId)%>"
			var="permissionsURL" />

		<aui:script use="aui-button-item">
			var buttonRow = A.one(".manufacturer-buttons");
			
			var buttonLabel = "<liferay-ui:message key="Permissions" />";
			
			new A.ButtonItem({
				icon: 'gear',
				label: buttonLabel,
				handler: function(event) {
					location.href =  "<%=permissionsURL%>";
				}
			})
				.render(buttonRow);
		</aui:script>
	</c:if>


</aui:button-row>

<aui:layout>
	<aui:column id="manufacturer-dynamic-content">
		<liferay-ui:search-container
			delta='<%=GetterUtil.getInteger(prefs.getValue(
								"rowsPerPage", "5"))%>'
			emptyResultsMessage="manufacturer-empty-results-message">
			<liferay-ui:search-container-results
				results="<%=ManufacturerLocalServiceUtil
								.getManufacturersByGroupId(scopeGroupId,
										searchContainer.getStart(),
										searchContainer.getEnd())%>"
				total="<%=ManufacturerLocalServiceUtil
								.getManufacturersCountByGroupId(scopeGroupId)%>" />

			<liferay-ui:search-container-row
				className="com.liferay.training.parts.model.Manufacturer"
				keyProperty="manufacturerId" modelVar="manufacturer"
				escapedModel="true">
				<portlet:renderURL windowState="maximized" var="rowURL">
      				<portlet:param name="mvcPath" value="/html/manufacturer/view_manufacturer.jsp" />
      				<portlet:param name="manufacturerId" value="<%= String.valueOf(manufacturer.getManufacturerId()) %>" />
    			</portlet:renderURL>
				<liferay-ui:search-container-column-text name="name"
					value="<%=manufacturer.getName()%>" href="<%=rowURL %>" />

				<liferay-ui:search-container-column-text name="email-address"
					property="emailAddress" href="<%=rowURL %>" />

				<liferay-ui:search-container-column-text name="phone-number"
					property="phoneNumber" href="<%=rowURL %>" />

				<liferay-ui:search-container-column-text name="website"
					property="website" href="<%=rowURL %>" />

				<liferay-ui:search-container-column-jsp align="right"
					path="/html/manufacturer/manufacturer_actions.jsp" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:column>
</aui:layout>