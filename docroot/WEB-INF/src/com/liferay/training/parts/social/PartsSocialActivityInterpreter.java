
package com.liferay.training.parts.social;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;
import com.liferay.training.parts.service.PartLocalServiceUtil;

public class PartsSocialActivityInterpreter
	extends BaseSocialActivityInterpreter {

	@Override
	public String[] getClassNames() {

		return _CLASS_NAMES;
	}

	@Override
	protected SocialActivityFeedEntry doInterpret(
		SocialActivity activity, ThemeDisplay themeDisplay)
		throws Exception {

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		Part part = PartLocalServiceUtil.getPart(activity.getClassPK());

		if (!permissionChecker.hasPermission(
			part.getGroupId(), Part.class.getName(), part.getPartId(),
			ActionKeys.VIEW)) {
			return null;
		}

		String link = StringPool.BLANK;
		String key = "activity-part-add-part";
		String keyWithGroup = "activity-part-add-part-in";
		String title =
			getTitle(
				activity, key, keyWithGroup, part.getName(), link, themeDisplay);
		Manufacturer mfg =
			ManufacturerLocalServiceUtil.getManufacturer(part.getManufacturerId());
		String body =
			StringUtil.shorten(
				HtmlUtil.escape(part.getName(themeDisplay.getLocale()) + " / " +
					mfg.getName() + ": " + part.getQuantity()), 200);

		return new SocialActivityFeedEntry(link, title, body);
	}

	protected String getTitle(
		SocialActivity activity, String key, String keyWithGroup,
		String content, String link, ThemeDisplay themeDisplay) {

		String userName = getUserName(activity.getUserId(), themeDisplay);
		String text =
			HtmlUtil.escape(StringUtil.shorten(
				HtmlUtil.extractText(content), 200));

		if (Validator.isNotNull(link)) {
			text = wrapLink(link, text);
		}

		String groupName = StringPool.BLANK;

		if (activity.getGroupId() != themeDisplay.getScopeGroupId()) {
			groupName = getGroupName(activity.getGroupId(), themeDisplay);
		}

		String pattern;

		if (Validator.isNotNull(groupName)) {
			pattern = keyWithGroup;
		}
		else {
			pattern = key;
		}

		return themeDisplay.translate(pattern, new Object[] {
			userName, text, groupName
		});
	}

	private static final String[] _CLASS_NAMES = new String[] {
		Part.class.getName()
	};

}
