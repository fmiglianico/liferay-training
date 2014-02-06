package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.model.impl.PartImpl;
import com.liferay.training.parts.service.PartLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * Portlet implementation class PartsPortlet
 */
public class PartsPortlet extends MVCPortlet {

	/**
	 * Convenience method to create a Part object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private Part partFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		int orderDateMonth = ParamUtil.getInteger(request, "orderDateMonth");
		int orderDateDay = ParamUtil.getInteger(request, "orderDateDay");
		int orderDateYear = ParamUtil.getInteger(request, "orderDateYear");

		Date orderDate = PortalUtil.getDate(orderDateMonth, orderDateDay, orderDateYear);
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(request, "name");

		Part part = new PartImpl();

		part.setPartId(ParamUtil.getLong(request, "partId"));
		part.setNameMap(nameMap);
		part.setPartNumber(ParamUtil.getString(request, "partNumber"));
		part.setOrderDate(orderDate);
		part.setQuantity(ParamUtil.getInteger(request, "quantity"));
		part.setManufacturerId(ParamUtil.getLong(request, "manufacturerId"));
		part.setCompanyId(themeDisplay.getCompanyId());
		part.setGroupId(themeDisplay.getScopeGroupId());
		part.setUserId(themeDisplay.getUserId());

		return part;
	}
	
	/**
	 * Adds a new part to the database.
	 * 
	 */
	public void addPart(ActionRequest request, ActionResponse response)
		throws Exception {

		ArrayList<String> errors = new ArrayList<String>();

		Part part = partFromRequest(request);

		if (PartValidator.validatePart(part, errors)) {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Part.class.getName(), request);
			PartLocalServiceUtil.addPart(part, serviceContext);
	    

			SessionMessages.add(request, "part-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/html/parts/edit_part.jsp");
		}
	}

	/**
	 * Deletes a part from the database.
	 * 
	 */
	public void deletePart(ActionRequest request, ActionResponse response)
		throws Exception {

		long partId = ParamUtil.getLong(request, "partId");

		if (Validator.isNotNull(partId)) {
			PartLocalServiceUtil.deletePart(partId);

			SessionMessages.add(request, "part-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}

	/**
	 * Updates the database record of an existing part.
	 *
	 */
	public void updatePart(ActionRequest request, ActionResponse response)
		throws Exception {

		Part part = partFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (PartValidator.validatePart(part, errors)) {
			PartLocalServiceUtil.updatePart(part);

			SessionMessages.add(request, "part-updated");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/html/parts/edit_part.jsp");			
		}
	}

	/**
	 * Sets the preferences for how many parts can be viewed per
	 * page and the format for the date.
	 * 
	 */
	public void setPartPref(ActionRequest request, ActionResponse response)
		throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rowsPerPage");
		String dateFormat = ParamUtil.getString(request, "dateFormat");

		ArrayList<String> errors = new ArrayList<String>();

		if (PartValidator.validatePreferences(rowsPerPage, dateFormat, errors)) {
			PortletPreferences prefs = request.getPreferences();

			prefs.setValue("rowsPerPage", rowsPerPage);
			prefs.setValue("dateFormat", dateFormat);

			prefs.store();
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
		}
	}

	
	
	//private static Log _log = LogFactoryUtil.getLog(PartsPortlet.class);


}
