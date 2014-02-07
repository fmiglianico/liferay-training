
package com.liferay.training.parts.asset;

import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.permission.ManufacturerPermission;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ManufacturerAssetRenderer extends BaseAssetRenderer {

	public ManufacturerAssetRenderer(Manufacturer mfg) {

		_mfg = mfg;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		return ManufacturerPermission.contains(
			permissionChecker, _mfg, ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {

		return ManufacturerPermission.contains(
			permissionChecker, _mfg, ActionKeys.VIEW);
	}

	@Override
	public long getClassPK() {

		return _mfg.getPrimaryKey();
	}

	@Override
	public long getGroupId() {

		return _mfg.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {

		return com.liferay.portal.kernel.util.HtmlUtil.escape(_mfg.getName() +
			": " + _mfg.getPhoneNumber() + ": " + _mfg.getEmailAddress());

	}

	@Override
	public String getTitle(Locale locale) {

		return _mfg.getName();
	}

	@Override
	public long getUserId() {

		return _mfg.getUserId();
	}

	@Override
	public String getUserName() {

		return _mfg.getUserName();
	}

	@Override
	public String getUuid() {

		return _mfg.getUuid();
	}

	@Override
	public String render(
		RenderRequest request, RenderResponse response, String template)
		throws Exception {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("MANUFACTURER ENTRY", _mfg);
			return "/html/manufacturer/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) { 
	
		return themeDisplay.getPathThemeImages() + "/common/assign_user_roles.png"; 
		
	}

	private Manufacturer _mfg;
}
