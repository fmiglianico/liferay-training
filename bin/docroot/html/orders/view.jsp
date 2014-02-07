<%
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
%>

<%@include file="/html/init.jsp" %>

<%
    String redirect = PortalUtil.getCurrentURL(renderRequest);

    long userId = user.getUserId();
    long companyId = company.getCompanyId();
%>

<liferay-ui:search-container delta="5" emptyResultsMessage="no-orders-found">
    <liferay-ui:search-container-results>
        <%
            results = PurchaseOrderLocalServiceUtil.findByUser(userId, companyId, scopeGroupId, false,
                    searchContainer.getStart(), searchContainer.getEnd());
            total = PurchaseOrderLocalServiceUtil.countByUser(userId, companyId, scopeGroupId, true);

            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    </liferay-ui:search-container-results>
    <liferay-ui:search-container-row className="com.liferay.training.parts.model.PurchaseOrder"
                                     keyProperty="orderId" modelVar="purchaseOrder" escapedModel="true">

        <liferay-ui:search-container-column-text name="order-id" property="orderId"/>
        <liferay-ui:search-container-column-text name="partTitle"
                                                 value="<%= purchaseOrder.getPartName(locale) %>"/>

        <liferay-ui:search-container-column-text name="part-number"
                                                 property="partNumber"/>

        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy/MM/dd");
        %>

        <liferay-ui:search-container-column-text name="order-date"
                                                 value="<%= dateFormat.format(purchaseOrder.getOrderDate()) %>"/>

        <%
            String manufacturerName = "";

            try {
                manufacturerName = ManufacturerLocalServiceUtil
                        .getManufacturer(purchaseOrder.getManufacturerId())
                        .getName();
            } catch (Exception ex) {
            }
        %>

        <liferay-ui:search-container-column-text name="manufacturerTitle"
                                                 value="<%= manufacturerName %>"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

	