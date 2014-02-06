<%@include file="/html/init.jsp"%>

<%
Part part = null;

long partId = ParamUtil.getLong(request, "partId");

if (partId > 0) {
	part = PartLocalServiceUtil.getPart(partId);
}

List<Manufacturer> manufacturers = ManufacturerLocalServiceUtil.getManufacturersByGroupId(scopeGroupId);

String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (part != null) ? part.getName(locale) : "add-part" %>'
/>

<aui:model-context bean="<%= part %>" model="<%= Part.class %>" />

<portlet:actionURL name='<%= part == null ? "addPart" : "updatePart" %>' 
				   var="editPartURL" 
				   windowState="normal" />

<aui:form action="<%= editPartURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="partId" value='<%= part == null ? "" : part.getPartId() %>'/>
		
		<liferay-ui:error key="partname-required" message="partname-required"/>
		<aui:input name="name" />

		<liferay-ui:error key="partnumber-required" message="partnumber-required"/>
		<aui:input name="partNumber" />	
		
		<liferay-ui:error key="orderdate-required" message="orderdate-required"/>
		<aui:input name="orderDate" />
		
		<liferay-ui:error key="quantity-required" message="quantity-required"/>
		<aui:input name="quantity"/>
		
		<liferay-ui:error key="manufacturer-required" message="manufacturer-required"/>
		<aui:select name="manufacturerId" showEmptyOption="<%= true %>" label="Manufacturer">

	 		<%
				for(Manufacturer manufacturer: manufacturers){
			%>
			<aui:option value="<%= manufacturer.getManufacturerId() %>" selected="<%= part != null && manufacturer.getManufacturerId() == part.getManufacturerId() %>"><%=manufacturer.getName()%></aui:option>
			<%
				}
			%>

		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>