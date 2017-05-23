/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.migration.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyProducerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyProducerClp extends BaseModelImpl<LegacyProducer>
	implements LegacyProducer {
	public LegacyProducerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyProducer.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyProducer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idNum", getIdNum());
		attributes.put("homeDir", getHomeDir());
		attributes.put("userId", getUserId());
		attributes.put("hostId", getHostId());
		attributes.put("facilityId", getFacilityId());
		attributes.put("numberOfProductions", getNumberOfProductions());
		attributes.put("approved", getApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String idNum = (String)attributes.get("idNum");

		if (idNum != null) {
			setIdNum(idNum);
		}

		String homeDir = (String)attributes.get("homeDir");

		if (homeDir != null) {
			setHomeDir(homeDir);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Long numberOfProductions = (Long)attributes.get("numberOfProductions");

		if (numberOfProductions != null) {
			setNumberOfProductions(numberOfProductions);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyProducerRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdNum() {
		return _idNum;
	}

	@Override
	public void setIdNum(String idNum) {
		_idNum = idNum;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setIdNum", String.class);

				method.invoke(_legacyProducerRemoteModel, idNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHomeDir() {
		return _homeDir;
	}

	@Override
	public void setHomeDir(String homeDir) {
		_homeDir = homeDir;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setHomeDir", String.class);

				method.invoke(_legacyProducerRemoteModel, homeDir);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legacyProducerRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_legacyProducerRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyProducerRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumberOfProductions() {
		return _numberOfProductions;
	}

	@Override
	public void setNumberOfProductions(long numberOfProductions) {
		_numberOfProductions = numberOfProductions;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfProductions",
						long.class);

				method.invoke(_legacyProducerRemoteModel, numberOfProductions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApproved() {
		return _approved;
	}

	@Override
	public void setApproved(int approved) {
		_approved = approved;

		if (_legacyProducerRemoteModel != null) {
			try {
				Class<?> clazz = _legacyProducerRemoteModel.getClass();

				Method method = clazz.getMethod("setApproved", int.class);

				method.invoke(_legacyProducerRemoteModel, approved);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyProducerRemoteModel() {
		return _legacyProducerRemoteModel;
	}

	public void setLegacyProducerRemoteModel(
		BaseModel<?> legacyProducerRemoteModel) {
		_legacyProducerRemoteModel = legacyProducerRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _legacyProducerRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_legacyProducerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyProducerLocalServiceUtil.addLegacyProducer(this);
		}
		else {
			LegacyProducerLocalServiceUtil.updateLegacyProducer(this);
		}
	}

	@Override
	public LegacyProducer toEscapedModel() {
		return (LegacyProducer)ProxyUtil.newProxyInstance(LegacyProducer.class.getClassLoader(),
			new Class[] { LegacyProducer.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyProducerClp clone = new LegacyProducerClp();

		clone.setId(getId());
		clone.setIdNum(getIdNum());
		clone.setHomeDir(getHomeDir());
		clone.setUserId(getUserId());
		clone.setHostId(getHostId());
		clone.setFacilityId(getFacilityId());
		clone.setNumberOfProductions(getNumberOfProductions());
		clone.setApproved(getApproved());

		return clone;
	}

	@Override
	public int compareTo(LegacyProducer legacyProducer) {
		long primaryKey = legacyProducer.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyProducerClp)) {
			return false;
		}

		LegacyProducerClp legacyProducer = (LegacyProducerClp)obj;

		long primaryKey = legacyProducer.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", idNum=");
		sb.append(getIdNum());
		sb.append(", homeDir=");
		sb.append(getHomeDir());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", numberOfProductions=");
		sb.append(getNumberOfProductions());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyProducer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNum</column-name><column-value><![CDATA[");
		sb.append(getIdNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homeDir</column-name><column-value><![CDATA[");
		sb.append(getHomeDir());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfProductions</column-name><column-value><![CDATA[");
		sb.append(getNumberOfProductions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _idNum;
	private String _homeDir;
	private long _userId;
	private String _userUuid;
	private long _hostId;
	private long _facilityId;
	private long _numberOfProductions;
	private int _approved;
	private BaseModel<?> _legacyProducerRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}