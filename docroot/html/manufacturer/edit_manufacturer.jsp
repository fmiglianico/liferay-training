<%@include file="/html/init.jsp"%>

<%
	Manufacturer manufacturer = null;

	long manufacturerId = ParamUtil.getLong(request, "manufacturerId");

	if (manufacturerId > 0) {
		manufacturer = ManufacturerLocalServiceUtil
				.getManufacturer(manufacturerId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header backURL="<%= redirect %>"
	title='<%= (manufacturer != null) ? manufacturer.getName() : "add-manufacturer" %>' />


<aui:model-context bean="<%= manufacturer %>"
	model="<%= Manufacturer.class %>" />

<portlet:actionURL
	name='<%= manufacturer == null ? "addManufacturer" : "updateManufacturer" %>'
	var="editManufacturerURL" 
	windowState="normal" />
	
	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />

<aui:form action="<%= editManufacturerURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="manufacturerId"
			value='<%= manufacturer == null ? "" : manufacturer.getManufacturerId() %>' />

		<liferay-ui:error key="manufacturername-required"
			message="manufacturername-required" />
		<aui:input name="name" />

		<liferay-ui:error key="manufactureremail-required"
			message="manufactureremail-required" />
		<liferay-ui:error key="manufactureremail-format-error"
			message="manufactureremail-format-error" />
		<aui:input name="emailAddress" />

		<aui:input name="website" />

		<liferay-ui:error key="manufacturerphonenumber-required"
			message="manufacturerphonenumber-required" />
		<liferay-ui:error key="manufacturerphonenumber-format-error"
			message="manufacturerphonenumber-format-error" />
		<aui:input name="phoneNumber" />
		
		 
        <liferay-ui:asset-categories-error />
		<liferay-ui:asset-tags-error />
	    <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="manufacturerCategorizationPanel" persistState="<%= true %>" title="categorization">
			<aui:fieldset>
				<aui:input name="categories" type="assetCategories" />

				<aui:input name="tags" type="assetTags" />
			</aui:fieldset>
		</liferay-ui:panel>

		<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="manufacturerAssetLinksPanel" persistState="<%= true %>" title="related-assets">
			<aui:fieldset>
				<liferay-ui:input-asset-links
					className="<%= Manufacturer.class.getName() %>"
					classPK="<%= manufacturerId %>"
				/>
			</aui:fieldset>
		</liferay-ui:panel>
	
	    


	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>