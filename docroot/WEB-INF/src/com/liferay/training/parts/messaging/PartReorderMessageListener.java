package com.liferay.training.parts.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.training.parts.service.PartLocalServiceUtil;

public class PartReorderMessageListener extends BaseMessageListener {

    protected void doReceive(Message message) throws Exception {
        PartLocalServiceUtil.reorderParts();
    }
}
