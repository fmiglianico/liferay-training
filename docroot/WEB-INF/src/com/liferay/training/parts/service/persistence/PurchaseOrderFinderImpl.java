package com.liferay.training.parts.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.model.PurchaseOrder;
import com.liferay.training.parts.model.impl.PurchaseOrderImpl;
import com.liferay.training.parts.model.impl.PurchaseOrderModelImpl;
import com.liferay.training.parts.service.PartLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PurchaseOrderFinderImpl extends PurchaseOrderPersistenceImpl implements PurchaseOrderFinder {

	// IDs of the custom SQL specified in custom-sql/default.xml
	
	public static String COUNT_BY_PART = PurchaseOrderFinder.class.getName() + ".countByPart";
	
	// FinderPath objects are the keys to the finder cache

	public static final FinderPath FINDER_PATH_COUNT_BY_PART = 
		new FinderPath(
				PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
				PurchaseOrderPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByPart",
				new String[] {
						Long.class.getName()
				});

	public int countByPart(long partId, boolean useCustomSQL) throws PortalException, SystemException {

		// Build the key values to interface with the finder cache

		Object[] finderArgs = new Object[] {
				partId
		};

		// Get the finder result from finder cache using finder path and finder
		// args

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PART,
				finderArgs, this);

		if (count == null) {
			System.out.println(
				"countByPart: count for partId:" + partId + " from cache is null");

			// Open database session

			Session session = null;


				session = openSession();

				if (useCustomSQL) {
					System.out.println("countByPart: using Custom SQL ");
					String sql = CustomSQLUtil.get(COUNT_BY_PART);

					SQLQuery q = session.createSQLQuery(sql);

					q.addScalar("COUNT_VALUE", Type.LONG);

					QueryPos qPos = QueryPos.getInstance(q);

					qPos.add(partId);

					Iterator<Long> itr = q.list().iterator();

					if (itr.hasNext()) {
						count = itr.next();
					}
				} else {
					System.out.println("countByPart: using Dynamic Query");
					DynamicQuery dq = DynamicQueryFactoryUtil.forClass(PurchaseOrder.class)
						.add(RestrictionsFactoryUtil.eq("partId", partId))
						.add(RestrictionsFactoryUtil.eq("closed", Boolean.FALSE))
						.setProjection(ProjectionFactoryUtil.rowCount());
					count = purchaseOrderPersistence.countWithDynamicQuery(dq);
				}
	
		} else {
			System.out.println(
					"countByPart: count for partId:" + partId + " from cache is " + count);
		}

		return count.intValue();
	}
	
	
	public static String COUNT_BY_USER = PurchaseOrderFinder.class.getName()
			+ ".countByUser";
	public static String FIND_BY_USER = PurchaseOrderFinder.class.getName()
			+ ".findByUser";

	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(
			PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED,
			Long.class,
			PurchaseOrderPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUser", new String[] { Long.class.getName() });

	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(
			PurchaseOrderModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOrderModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOrderImpl.class,
			PurchaseOrderPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUser", new String[] { Long.class.getName(),
					Long.class.getName(), Long.class.getName(),
					"java.lang.Integer", "java.lang.Integer" });

	public int countByUser(long userId, long companyId, long groupId,
			boolean useCustomSQL) throws PortalException, SystemException {

		// Build the key values to interface with the finder cache

		Object[] finderArgs = new Object[] { userId, companyId, groupId };

		// Get the finder result from finder cache using finder path and finder
		// args

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_USERID, finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = CustomSQLUtil.get(COUNT_BY_USER);

				SQLQuery q = session.createSQLQuery(sql);

				q.addScalar("COUNT_VALUE", Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);
				qPos.add(groupId);
				qPos.add(userId);

				Iterator<Long> itr = q.list().iterator();

				if (itr.hasNext()) {
					count = itr.next();
				}
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					// Convert the count to a meaningful value

					count = Long.valueOf(0);
				}

				// Store the result in the finder cache

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
						finderArgs, count);

				// Close database session

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public List<PurchaseOrder> findByUser(long userId, long companyId,
			long groupId, boolean useCustomSQL, int start, int end)
			throws PortalException, SystemException {

		// Build the key values to interface with the finder cache

		Object[] finderArgs = new Object[] { userId, companyId, groupId, start,
				end };

		// Get the finder result from finder cache using finder path and finder
		// args

		List<PurchaseOrder> list = (List<PurchaseOrder>) FinderCacheUtil
				.getResult(FINDER_PATH_FIND_BY_USERID, finderArgs, this);

		if (list == null) {
			System.out
					.println("findByUser: PurchaseOrder list from cache is null");

			// Open database session

			Session session = null;


				session = openSession();

				if (useCustomSQL){
					System.out.println("findByUser: using Custom SQL ");
					String sql = CustomSQLUtil.get(FIND_BY_USER);

					SQLQuery q = session.createSQLQuery(sql);

					q.addScalar("orderId", Type.LONG);
					q.addScalar("orderDate", Type.DATE);
					q.addScalar("partId", Type.LONG);
					q.addScalar("partNumber", Type.STRING);
					q.addScalar("partName", Type.STRING);
					q.addScalar("manufacturerId", Type.LONG);

					QueryPos qPos = QueryPos.getInstance(q);

					qPos.add(companyId);
					qPos.add(groupId);
					qPos.add(userId);

					List<Object[]> rows =  (List<Object[]>) QueryUtil.list(q, getDialect(), start, end);

					list = assembleOrders(rows);
				} else {
					System.out.println("findByUser: using Dynamic Query");
					DynamicQuery dq = DynamicQueryFactoryUtil.forClass(PurchaseOrder.class)
						.add(RestrictionsFactoryUtil.eq("closed", Boolean.FALSE))
						.add(RestrictionsFactoryUtil.eq("userId", userId))
						.add(RestrictionsFactoryUtil.eq("companyId", companyId))
						.add(RestrictionsFactoryUtil.eq("groupId", groupId));
					list = purchaseOrderPersistence.findWithDynamicQuery(dq,
						start, end);
					list = populateOrders(list);
				}
	
		} else {
			System.out
					.println("findByUser: PurchaseOrder list from cache has size: "
							+ list.size());
			populateOrders(list);
		}

		printOrders(list);

		return list;
	}

	private List<PurchaseOrder> assembleOrders(List<Object[]> rows) {

		List<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();

		for (Object[] columns : rows) {
			PurchaseOrderImpl order = new PurchaseOrderImpl();

			order.setOrderId((Long) columns[0]);
			order.setOrderDate((Date) columns[1]);
			order.setPartId((Long) columns[2]);
			order.setPartNumber((String) columns[3]);
			order.setPartName((String) columns[4]);
			order.setManufacturerId((Long) columns[5]);

			orders.add(order);
		}

		return orders;
	}

	private List<PurchaseOrder> populateOrders(List list)
			throws SystemException, PortalException {
		List<PurchaseOrder> orders = list;
		for (Object o : list) {
			PurchaseOrder purchaseOrder = (PurchaseOrder) o;
			Part part = PartLocalServiceUtil.getPart(purchaseOrder.getPartId());
			purchaseOrder.setPartName(part.getName());
			purchaseOrder.setPartNumber(part.getPartNumber());
			purchaseOrder.setManufacturerId(part.getManufacturerId());
		}
		return orders;
	}

	private void printOrders(List<PurchaseOrder> list) {
		if (list != null) {
			System.out.println("PurchaseOrder list ...");
			for (PurchaseOrder order : list) {
				System.out.println("order id: " + order.getOrderId()
						+ ", partId: " + order.getPartId() + ", manufacturer: "
						+ order.getManufacturerId() + ",part name: "
						+ order.getPartName());
			}
		}
	}

	

}
	