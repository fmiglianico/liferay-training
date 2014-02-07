package com.liferay.training.parts.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;


public class ManufacturerAssetRendererFactory extends BaseAssetRendererFactory {

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		Manufacturer mfg = ManufacturerLocalServiceUtil.getManufacturer(classPK);
		return new ManufacturerAssetRenderer (mfg);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isLinkable() {
		return true;
	}
	
	@Override
	public boolean isCategorizable() {
		return true;
	}
	
	public static final String CLASS_NAME = Manufacturer.class.getName();
	public static final String TYPE = "manufacturer";
	    

}
