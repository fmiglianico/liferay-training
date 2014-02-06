
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
			scopeGroupId, "ADD_PART");
	boolean hasConfigurePermission = permissionChecker.hasPermission(
			scopeGroupId, Group.class.getName(), scopeGroupId,
			ActionKeys.PERMISSIONS);
%>

<liferay-ui:success key="part-added" message="part-added-successfully" />
<liferay-ui:success key="part-deleted"
	message="part-deleted-successfully" />
<liferay-ui:success key="part-updated"
	message="part-updated-successfully" />

<aui:button-row cssClass="parts-buttons">
	<c:if test='<%=hasAddPermission%>'>
		<portlet:renderURL var="addPartURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="mvcPath" value="/html/parts/edit_part.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<aui:script use="aui-button-item,aui-io">
			var buttonRow = A.one(".parts-buttons");
			
			var buttonLabel = "<liferay-ui:message key="add-part" />";
			var contentPane = A.one("#<portlet:namespace/>parts-dynamic-content");
			
			contentPane.plug(A.Plugin.IO, {
						uri: '<%=addPartURL.toString()%>',
						autoLoad: false
						});
			 
			var button = new A.ButtonItem({
				icon: 'wrench',
				label: buttonLabel,
				handler: function(event) {
					contentPane.io.start();
				}
			})
				.render(buttonRow);
				
			A.getDoc().on('key', function() {
				button.fire('click');					
			},'down:80+alt+shift');
		</aui:script>
	</c:if>
	<c:if test='<%=hasConfigurePermission%>'>
		<liferay-security:permissionsURL
			modelResource="com.liferay.training.parts.model"
			modelResourceDescription="parts-top-level-actions"
			resourcePrimKey="<%=String.valueOf(scopeGroupId)%>"
			var="permissionsURL" />

		<aui:script use="aui-button-item">
			var buttonRow = A.one(".parts-buttons");
			
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
	<aui:column width="100" id="parts-dynamic-content">
		<liferay-ui:search-container
			delta='<%=new Integer(prefs
								.getValue("rowsPerPage", "5"))%>'
			emptyResultsMessage="part-empty-results-message">
			<liferay-ui:search-container-results
				results="<%=PartLocalServiceUtil.getPartsByGroupId(
								scopeGroupId, searchContainer.getStart(),
								searchContainer.getEnd())%>"
				total="<%=PartLocalServiceUtil
								.getPartsCountByGroupId(scopeGroupId)%>" />

			<liferay-ui:search-container-row
				className="com.liferay.training.parts.model.Part"
				keyProperty="partId" modelVar="part" escapedModel="true">
				<liferay-ui:search-container-column-text name="name"
					value="<%=part.getName(locale)%>" />

				<liferay-ui:search-container-column-text name="part-number"
					property="partNumber" />

				<liferay-ui:search-container-column-text name="quantity"
					property="quantity" />

				<%
					SimpleDateFormat dateFormat = new SimpleDateFormat(
											prefs.getValue("dateFormat", "yyyy/MM/dd"));
				%>

				<liferay-ui:search-container-column-text name="order-date"
					value="<%=dateFormat.format(part.getOrderDate())%>" />

				<%
					String manufacturerName = "";

									try {
										manufacturerName = HtmlUtil
												.escape(ManufacturerLocalServiceUtil
														.getManufacturer(
																part.getManufacturerId())
														.getName());
									} catch (Exception ex) {
									}
				%>

				<liferay-ui:search-container-column-text name="manufacturer"
					value="<%=manufacturerName%>" />

				<liferay-ui:search-container-column-jsp align="right"
					path="/html/parts/part_actions.jsp" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</aui:column>
</aui:layout>

