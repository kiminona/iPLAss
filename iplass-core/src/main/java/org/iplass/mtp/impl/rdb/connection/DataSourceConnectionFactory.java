/*
 * Copyright (C) 2011 INFORMATION SERVICES INTERNATIONAL - DENTSU, LTD. All Rights Reserved.
 * 
 * Unless you have purchased a commercial license,
 * the following license terms apply:
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package org.iplass.mtp.impl.rdb.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.iplass.mtp.spi.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataSourceConnectionFactory extends AbstractConnectionFactory {
	private static final String JNDI_ENV_PREFIX = "jndienv.";
	
	private static Logger logger = LoggerFactory.getLogger(DataSourceConnectionFactory.class);

	//TODO @Resourceアノテーションを使う？jndi名は固定となるが。
	private DataSource dataSource;

	@Override
	protected Connection getConnectionInternal() {

		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new ConnectionException("can not get DataSource Connection:", e);
		}
	}

	public void destroy() {
		dataSource = null;
	}

	public void init(Config config) {
		super.init(config);

		String dsName = "java:comp/env/jdbc/defaultDS";
		if (config.getValue("dataSourceName") != null) {
			dsName = config.getValue("dataSourceName");
		}
		
		//jndi env
		Hashtable<String, Object> jndiEnv = new Hashtable<>();
		for (String n: config.getNames()) {
			if (n.startsWith(JNDI_ENV_PREFIX)) {
				jndiEnv.put(n.substring(JNDI_ENV_PREFIX.length()), config.getValue(n));
			}
		}

		InitialContext context = null;
		try {
			if (jndiEnv.size() > 0) {
				context = new InitialContext(jndiEnv);
			} else {
				context = new InitialContext();
			}
			dataSource = (DataSource) context.lookup(dsName);
		} catch (NamingException e) {
			throw new ConnectionException("can not create DataSource:" + dsName, e);
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					logger.warn("InitialContext.close() fail.maybe leak... " + e, e);
				}
			}
		}
	}

}
