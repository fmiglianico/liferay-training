/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.parts;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Joe Bloggs
 */
public class NoSuchPurchaseOrderException extends NoSuchModelException {

	public NoSuchPurchaseOrderException() {
		super();
	}

	public NoSuchPurchaseOrderException(String msg) {
		super(msg);
	}

	public NoSuchPurchaseOrderException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchPurchaseOrderException(Throwable cause) {
		super(cause);
	}

}