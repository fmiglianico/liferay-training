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

<%@ include file="/html/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");

    String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" value="/html/parts/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

    <liferay-ui:header
        backURL="<%= redirect %>"
        title="search"
    />

    <%
    PortletURL portletURL = renderResponse.createRenderURL();

    portletURL.setParameter("mvcPath", "/html/parts/search.jsp");
    portletURL.setParameter("redirect", redirect);
    portletURL.setParameter("keywords", keywords);

    List<String> headerNames = new ArrayList<String>();

    headerNames.add("#");
    headerNames.add("partTitle");

    SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

    try {
        Indexer indexer = IndexerRegistryUtil.getIndexer(Part.class);

        SearchContext searchContext = SearchContextFactory.getInstance(request);

        searchContext.setEnd(searchContainer.getEnd());
        searchContext.setKeywords(keywords);
        searchContext.setStart(searchContainer.getStart());

        Hits results = indexer.search(searchContext);

        int total = results.getLength();

        searchContainer.setTotal(total);

        List resultRows = searchContainer.getResultRows();

        for (int i = 0; i < results.getDocs().length; i++) {
            Document doc = results.doc(i);

            ResultRow row = new ResultRow(doc, i, i);

            // Position

            row.addText(searchContainer.getStart() + i + 1 + StringPool.PERIOD);

            // Part

            long partId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

            Part part = null;

            try {
                part = PartLocalServiceUtil.getPart(partId);

                part = part.toEscapedModel();
            }
            catch (Exception e) {
                if (_log.isWarnEnabled()) {
                    _log.warn("Parts search index is stale and contains entry " + partId);
                }

                continue;
            }

            PortletURL rowURL = renderResponse.createRenderURL();

            rowURL.setParameter("mvcPath", "/html/parts/edit_part.jsp");
            rowURL.setParameter("redirect", currentURL);
            rowURL.setParameter("partId", String.valueOf(part.getPartId()));

            row.addText(part.getName(), rowURL);

            // Add result row

            resultRows.add(row);
        }
    %>

        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" value="<%= keywords %>" />

            <aui:button type="submit" value="search" />
        </span>

        <br /><br />

        <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

    <%
    }
    catch (Exception e) {
        _log.error(e.getMessage());
    }
    %>
</aui:form>

<%
if (Validator.isNotNull(keywords)) {
    PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("parts.docroot.html.search_jsp");
%>
