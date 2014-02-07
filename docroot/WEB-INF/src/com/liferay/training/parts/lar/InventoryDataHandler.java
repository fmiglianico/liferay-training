
package com.liferay.training.parts.lar;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BasePortletDataHandler;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.portal.kernel.lar.PortletDataHandlerControl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;
import com.liferay.training.parts.service.PartLocalServiceUtil;
import com.liferay.training.parts.service.persistence.ManufacturerUtil;
import com.liferay.training.parts.service.persistence.PartUtil;

import java.util.List;

import javax.portlet.PortletPreferences;

public class InventoryDataHandler extends BasePortletDataHandler {

	@Override
	public PortletDataHandlerControl[] getExportControls() {

		return new PortletDataHandlerControl[] {
			_parts
		};
	}

	@Override
	protected String doExportData(
		PortletDataContext portletDataContext, String portletId,
		PortletPreferences portletPreferences)
		throws Exception {

		Document document = SAXReaderUtil.createDocument();

		Element rootElement = document.addElement("inventory-manufacturer");

		rootElement.addAttribute(
			"group-id", String.valueOf(portletDataContext.getScopeGroupId()));

		List<Manufacturer> manufacturers =
			ManufacturerLocalServiceUtil.getManufacturersByGroupId(portletDataContext.getScopeGroupId());

		for (Manufacturer manufacturer : manufacturers) {

			exportManufacturer(portletDataContext, rootElement, manufacturer);
		}

		return document.formattedString();
	}

	public void exportManufacturer(
		PortletDataContext portletDataContext, Element rootElement,
		Manufacturer manufacturer)
		throws SystemException, PortalException {

		String path = getEntryPath(portletDataContext, manufacturer);

		if (!portletDataContext.isPathNotProcessed(path)) {
			return;
		}

		Element childElement = rootElement.addElement("manufacturer");

		childElement.addAttribute("path", path);

		manufacturer.setUserUuid(UserLocalServiceUtil.getUser(
			manufacturer.getUserId()).getUuid());

		portletDataContext.addZipEntry(path, manufacturer);

		if (portletDataContext.getBooleanParameter(_NAMESPACE, "exportParts")) {
			List<Part> parts =
				PartLocalServiceUtil.getPartsByManufacturer(manufacturer.getManufacturerId(), portletDataContext.getGroupId());

			for (Part part : parts) {
				exportPart(portletDataContext, rootElement, part);
			}
		}
	}

	protected String getEntryPath(
		PortletDataContext portletDataContext, Manufacturer manufacturer) {

		StringBundler sb = new StringBundler(4);

		sb.append(portletDataContext.getPortletPath("inventory"));
		sb.append("/manufacturers/");
		sb.append(manufacturer.getManufacturerId());
		sb.append(".xml");

		return sb.toString();
	}

	public void exportPart(
		PortletDataContext portletDataContext, Element rootElement, Part part)
		throws SystemException, PortalException {

		String path = getEntryPath(portletDataContext, part);

		if (!portletDataContext.isPathNotProcessed(path)) {
			return;
		}

		Element childElement = rootElement.addElement("part");

		childElement.addAttribute("path", path);

		part.setUserUuid(part.getUserUuid());

		part.setUserUuid(UserLocalServiceUtil.getUser(part.getUserId()).getUuid());

		portletDataContext.addZipEntry(path, part);
	}

	protected String getEntryPath(
		PortletDataContext portletDataContext, Part part) {

		StringBundler sb = new StringBundler(4);

		sb.append(portletDataContext.getPortletPath("inventory"));
		sb.append("/parts/");
		sb.append(part.getPartId());
		sb.append(".xml");

		return sb.toString();
	}
	
	@Override
	protected PortletPreferences doImportData(PortletDataContext portletDataContext, String portletId, PortletPreferences portletPreferences, String data) throws Exception {
		Document document = SAXReaderUtil.read(data);

		Element rootElement = document.getRootElement();

		for (Element childElement: rootElement.elements("manufacturer")) {
			String path = childElement.attributeValue("path");

			if (!portletDataContext.isPathNotProcessed(path)) {
				continue;
			}

			Manufacturer manufacturer = (Manufacturer) portletDataContext.getZipEntryAsObject(path);

			importManufacturer(portletDataContext, manufacturer);
		}

		for (Element childElement: rootElement.elements("part")) {
			String path = childElement.attributeValue("path");

			if (!portletDataContext.isPathNotProcessed(path)) {
				continue;
			}

			Part part = (Part) portletDataContext.getZipEntryAsObject(path);

			importPart(portletDataContext, part);
		}

		return null;
	}
	
	public void importManufacturer(PortletDataContext portletDataContext,
			Manufacturer manufacturer) throws SystemException, PortalException {

		long userId = portletDataContext.getUserId(manufacturer.getUserUuid());

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(portletDataContext.getScopeGroupId());
		serviceContext.setCompanyId(portletDataContext.getCompanyId());
		serviceContext.setUserId(userId);
		
		Manufacturer importedManufacturer = null;

		if (portletDataContext.isDataStrategyMirror()) {
			Manufacturer existingManufacturer = ManufacturerUtil.fetchByUUID_G(
					manufacturer.getUuid(),
					portletDataContext.getScopeGroupId());

			if (existingManufacturer == null) {
				serviceContext.setUuid(manufacturer.getUuid());
				manufacturer.setGroupId(portletDataContext.getScopeGroupId());
				manufacturer.setUserId(userId);

				importedManufacturer = ManufacturerLocalServiceUtil
						.addManufacturer(manufacturer, serviceContext);
			} else {
				importedManufacturer = ManufacturerLocalServiceUtil
						.updateManufacturer(manufacturer);
			}
		} else {
			manufacturer.setGroupId(portletDataContext.getScopeGroupId());
			manufacturer.setUserId(userId);
			importedManufacturer = ManufacturerLocalServiceUtil
					.addManufacturer(manufacturer, serviceContext);
		}
	}
	
	public void importPart(PortletDataContext portletDataContext, Part part)
			throws SystemException, PortalException {

		long userId = portletDataContext.getUserId(part.getUserUuid());

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(portletDataContext.getScopeGroupId());
		serviceContext.setCompanyId(portletDataContext.getCompanyId());
		serviceContext.setUserId(userId);

		Part importedPart = null;

		if (portletDataContext.isDataStrategyMirror()) {
			Part existingPart = PartUtil.fetchByUUID_G(part.getUuid(),
					portletDataContext.getScopeGroupId());

			if (existingPart == null) {
				serviceContext.setUuid(part.getUuid());

				part.setGroupId(portletDataContext.getScopeGroupId());
				part.setUserId(userId);

				importedPart = PartLocalServiceUtil.addPart(part, serviceContext);
			} else {
				importedPart = PartLocalServiceUtil.updatePart(part);
			}
		} else {
			part.setGroupId(portletDataContext.getScopeGroupId());
			part.setUserId(userId);

			importedPart = PartLocalServiceUtil.addPart(part, serviceContext);
		}
	}

	@Override
	public PortletDataHandlerControl[] getImportControls() {

		return new PortletDataHandlerControl[] {
			_parts
		};
	}

	private static Log _log = LogFactoryUtil.getLog(InventoryDataHandler.class);

	private static final String _NAMESPACE = "inventory";

	private static final PortletDataHandlerBoolean _parts =
		new PortletDataHandlerBoolean(_NAMESPACE, "exportParts", true);

}
