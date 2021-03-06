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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Coordinator service. Represents a row in the &quot;LG_Coordinator&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.CoordinatorImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Coordinator
 * @see de.uhh.l2g.plugins.model.impl.CoordinatorImpl
 * @see de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl
 * @generated
 */
public interface CoordinatorModel extends BaseModel<Coordinator> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a coordinator model instance should use the {@link Coordinator} interface instead.
	 */

	/**
	 * Returns the primary key of this coordinator.
	 *
	 * @return the primary key of this coordinator
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this coordinator.
	 *
	 * @param primaryKey the primary key of this coordinator
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the coordinator ID of this coordinator.
	 *
	 * @return the coordinator ID of this coordinator
	 */
	public long getCoordinatorId();

	/**
	 * Sets the coordinator ID of this coordinator.
	 *
	 * @param coordinatorId the coordinator ID of this coordinator
	 */
	public void setCoordinatorId(long coordinatorId);

	/**
	 * Returns the institution ID of this coordinator.
	 *
	 * @return the institution ID of this coordinator
	 */
	public long getInstitutionId();

	/**
	 * Sets the institution ID of this coordinator.
	 *
	 * @param institutionId the institution ID of this coordinator
	 */
	public void setInstitutionId(long institutionId);

	/**
	 * Returns the office ID of this coordinator.
	 *
	 * @return the office ID of this coordinator
	 */
	public long getOfficeId();

	/**
	 * Sets the office ID of this coordinator.
	 *
	 * @param officeId the office ID of this coordinator
	 */
	public void setOfficeId(long officeId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Coordinator coordinator);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.Coordinator> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.Coordinator toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.Coordinator toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}