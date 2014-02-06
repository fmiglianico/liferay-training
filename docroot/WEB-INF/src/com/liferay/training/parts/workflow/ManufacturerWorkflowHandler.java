package com.liferay.training.parts.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class ManufacturerWorkflowHandler extends BaseWorkflowHandler {

	public String getClassName() {

        return CLASS_NAME;
    }


    public String getType(Locale locale) {

        return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);

    }

    public Object updateStatus(int status, Map<String, Serializable> workflowContext)
        throws PortalException, SystemException {

        long userId = GetterUtil.getLong(
            (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long manufacturerId = GetterUtil.getLong(
            (String)workflowContext.get(
                WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext)workflowContext.get(
            "serviceContext");

        return ManufacturerLocalServiceUtil.updateStatus(
            userId, manufacturerId, status, serviceContext);
    }

    public static final String CLASS_NAME = Manufacturer.class.getName();
	    

}
