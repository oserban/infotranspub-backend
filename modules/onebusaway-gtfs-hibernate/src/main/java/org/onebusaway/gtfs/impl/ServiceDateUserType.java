/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 * Copyright (C) 2011 Google, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.gtfs.impl;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.onebusaway.gtfs.model.calendar.ServiceDate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;

public class ServiceDateUserType implements UserType {

    private static final int[] SQL_TYPES = {Types.VARCHAR};

    public Class<?> returnedClass() {
        return ServiceDate.class;
    }

    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }

    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public boolean isMutable() {
        return false;
    }

    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }
        return new ServiceDate((ServiceDate) value);
    }

    public Object nullSafeGet(ResultSet rs, String[] names,
                              SharedSessionContractImplementor sharedSessionContractImplementor,
                              Object o) throws HibernateException, SQLException {
        String value = rs.getString(names[0]);

        if (rs.wasNull())
            return null;

        try {
            return ServiceDate.parseString(value);
        } catch (ParseException ex) {
            throw new SQLException("error parsing service date value: " + value, ex);
        }
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, SQL_TYPES[0]);
        } else {
            ServiceDate serviceDate = (ServiceDate) value;
            st.setString(index, serviceDate.getAsString());
        }
    }

    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return deepCopy(cached);
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        if (original == null)
            return null;
        return deepCopy(original);
    }
}
