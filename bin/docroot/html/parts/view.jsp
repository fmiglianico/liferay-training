
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
themeDisplay.setIncludeServiceJs(true);
%>

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
<liferay-ui:error key="outstanding-parts-error-deleting"
	message="outstanding-parts-error-deleting" />        

<aui:button-row cssClass="parts-buttons">
	<c:if test='<%= hasAddPermission %>'>
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
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
			modelResource="com.liferay.training.parts.model"
			modelResourceDescription="parts-top-level-actions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
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

<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" value="/html/parts/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL %>" method="get" name="fm0">
    <liferay-portlet:renderURLParams varImpl="searchURL" />
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <aui:input name="groupId" type="hidden" value="<%= String.valueOf(scopeGroupId) %>" />

    <div class="portlet-toolbar search-form">

            <span class="aui-search-bar">
                <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

                <aui:button type="submit" value="search" />
            </span>

     </div>

</aui:form>


<aui:layout>
	<aui:column width="100" id="parts-dynamic-content">

<liferay-ui:search-container
	emptyResultsMessage="part-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= PartLocalServiceUtil.getPartsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PartLocalServiceUtil.getPartsCountByGroupId(scopeGroupId) %>" />

	<liferay-ui:search-container-row
		className="com.liferay.training.parts.model.Part" keyProperty="partId"
		modelVar="part" escapedModel="true" >
		<liferay-ui:search-container-column-text name="name"
			value="<%= part.getName(locale) %>" />

		<liferay-ui:search-container-column-text name="part-number"
			property="partNumber" />

		<liferay-ui:search-container-column-text name="quantity"
			property="quantity" />

		<%
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		%>

		<liferay-ui:search-container-column-text name="order-date"
			value="<%= dateFormat.format(part.getOrderDate()) %>" />

				<%
			String manufacturerName = "<span class=\"manufacturerId\" data-manufacturerId=\"" + part.getManufacturerId() + "\">";

					try {
						manufacturerName = manufacturerName +  ManufacturerLocalServiceUtil
								.getManufacturer(part.getManufacturerId())
								.getName();
					} catch (Exception ex) {
					}
					manufacturerName = manufacturerName + "</span>";
		%>


		<liferay-ui:search-container-column-text name="manufacturer"
			value="<%= manufacturerName %>" />
			
					<%
            int numOrders = PurchaseOrderLocalServiceUtil.countByPart(part.getPartId(), false);
        %>
        <liferay-ui:search-container-column-text name="open-orders"
            value="<%= String.valueOf(numOrders)%>"/>

		<liferay-ui:search-container-column-jsp align="right"
			path="/html/parts/part_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

	</aui:column>
</aui:layout>
<aui:script use="aui-tooltip">

	var mfgTip = new A.Tooltip({
		trigger: '.manufacturerId',
		bodyContent: 'Loading...',
		width: 200,
		height: 100,
		after: {
			show: function(event) {
				
                var instance = this;
				
                var currentNode = instance.get('currentNode');
                
                var manufacturerId = currentNode.attr('data-manufacturerId');
				
                var params = {
                    groupId: Liferay.ThemeDisplay.getScopeGroupId(),
                    manufacturerId: manufacturerId
                };	
                
                var serviceCallback = function(json) {
                	var manufacturerDetails = 'Name:  ' + json.name + '<br/> Email Address:  ' + json.emailAddress  + '<br/> Phone Number:  ' + json.phoneNumber  + '<br/> Website:  ' + json.website;
                	instance.set('bodyContent', manufacturerDetails);
                };

                Liferay.Service.Inventory.Manufacturer.getManufacturer(params, serviceCallback);
            }
		}
	})
	.render();
</aui:script>

