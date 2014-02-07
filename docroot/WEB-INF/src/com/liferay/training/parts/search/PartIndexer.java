package com.liferay.training.parts.search;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.PartLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class PartIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		Part.class.getName()
	};

	public static final String PORTLET_ID = "parts-portlet";

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		Part part = (Part) obj;
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, part.getPrimaryKey());

		
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.deleteDocument(searchEngineId, 
			part.getCompanyId(), document.get(Field.UID));
	}

		@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		Part part = (Part) obj;
		long groupId = getParentGroupId(part.getGroupId());
		long scopeGroupId = part.getGroupId();
		String description = part.getName();

		Document document = getBaseModelDocument(PORTLET_ID, part);

		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addText(Field.DESCRIPTION, description);

		return document;
	}


	@Override
	protected void doReindex(Object obj)
		throws Exception {

		Part part = (Part) obj;
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocument(searchEngineId, part.getCompanyId(), getDocument(part));
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		Part part = PartLocalServiceUtil.getPart(classPK);

		doReindex(part);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		doReindexAll(companyId);
	}

	private void doReindexAll(long companyId)
		throws Exception {

		int count = PartLocalServiceUtil.getPartsCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexParts(companyId, start, end);
		}
	}

	protected void reindexParts(long companyId, int start, int end)
		throws Exception {

		List<Part> parts = PartLocalServiceUtil.getParts(start, end);

		if (parts.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (Part part : parts) {
			Document document = getDocument(part);

			documents.add(document);
		}

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	public Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletURL portletURL) {

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		String partId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("mvcPath", "/html/parts/view_part.jsp");
		portletURL.setParameter("partId", partId);

		return new Summary(title, content, portletURL);
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}
}

