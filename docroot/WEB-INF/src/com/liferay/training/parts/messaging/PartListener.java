package com.liferay.training.parts.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;


public class PartListener implements MessageListener {

	public void receive(Message message) {

		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message)
		throws Exception {

		String partName = (String) message.get("partName");
		String partNumber = (String) message.get("partNumber");
		System.out.println("Part Added : " + partName + " " + partNumber);
	}

	private static Log _log = LogFactoryUtil.getLog(PartListener.class);


}
