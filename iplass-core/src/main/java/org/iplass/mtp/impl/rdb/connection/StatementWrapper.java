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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatementWrapper implements Statement {

	private static Logger logger = LoggerFactory.getLogger(StatementWrapper.class);
//	private double warnLogThreshold = ServiceRegistry.getRegistry().getService(TransactionService.class).getWarnLogThreshold();

	private Statement wrapped;
	private ConnectionWrapper con;
	protected int warnLogThreshold;
	
	protected AdditionalWarnLogInfo additionalWarnLogInfo;

	StatementWrapper(Statement wrapped, ConnectionWrapper con, int warnLogThreshold) {
		this.wrapped = wrapped;
		this.con = con;
		this.warnLogThreshold = warnLogThreshold;
	}
	
	public AdditionalWarnLogInfo getAdditionalWarnLogInfo() {
		return additionalWarnLogInfo;
	}

	public void setAdditionalWarnLogInfo(AdditionalWarnLogInfo additionalWarnLogInfo) {
		this.additionalWarnLogInfo = additionalWarnLogInfo;
	}

	public final void addBatch(String sql) throws SQLException {
		logger.debug("addBatch: {}", sql);
		wrapped.addBatch(sql);
	}

	public final void cancel() throws SQLException {
		wrapped.cancel();
	}

	public final void clearBatch() throws SQLException {
		wrapped.clearBatch();
	}

	public final void clearWarnings() throws SQLException {
		wrapped.clearWarnings();
	}

	public final void close() throws SQLException {
		wrapped.close();
	}

	public final boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		long start = System.currentTimeMillis();
		try {
			return wrapped.execute(sql, autoGeneratedKeys);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final boolean execute(String sql, int[] columnIndexes) throws SQLException {
		long start = System.currentTimeMillis();
		try {
			return wrapped.execute(sql, columnIndexes);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final boolean execute(String sql, String[] columnNames)
			throws SQLException {
		long start = System.currentTimeMillis();
		try {
			return wrapped.execute(sql, columnNames);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final boolean execute(String sql) throws SQLException {
		long start = System.currentTimeMillis();
		try {
			return wrapped.execute(sql);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("execute time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public int[] executeBatch() throws SQLException {

		long start = System.currentTimeMillis();

		try {
			return wrapped.executeBatch();
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("batch time =" + queryTime + " ms.");
					} else {
						logger.warn("batch time =" + queryTime + " ms. -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("batch time =" + queryTime + " ms.");
					} else {
						logger.debug("batch time =" + queryTime + " ms. -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final ResultSet executeQuery(String sql) throws SQLException {

		long start = System.currentTimeMillis();

		try {
			return new ResultSetWrapper(wrapped.executeQuery(sql), this);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("query time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("query time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("query time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("query time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		long start = System.currentTimeMillis();

		try {
			return wrapped.executeUpdate(sql, autoGeneratedKeys);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		long start = System.currentTimeMillis();

		try {
			return wrapped.executeUpdate(sql, columnIndexes);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		long start = System.currentTimeMillis();

		try {
			return wrapped.executeUpdate(sql, columnNames);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final int executeUpdate(String sql) throws SQLException {
		long start = System.currentTimeMillis();

		try {
			return wrapped.executeUpdate(sql);
		} finally {
			long queryTime = System.currentTimeMillis() - start;
			if (warnLogThreshold > 0  && queryTime > warnLogThreshold) {
				if (logger.isWarnEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.warn("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					if (additionalWarnLogInfo == null) {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql);
					} else {
						logger.debug("update time =" + queryTime + " ms. sql=" + sql + " -- " + additionalWarnLogInfo);
					}
				}
			}
		}
	}

	public final Connection getConnection() throws SQLException {
		return con;
	}

	public final int getFetchDirection() throws SQLException {
		return wrapped.getFetchDirection();
	}

	public final int getFetchSize() throws SQLException {
		return wrapped.getFetchSize();
	}

	public final ResultSet getGeneratedKeys() throws SQLException {
		return new ResultSetWrapper(wrapped.getGeneratedKeys(), this);
	}

	public final int getMaxFieldSize() throws SQLException {
		return wrapped.getMaxFieldSize();
	}

	public final int getMaxRows() throws SQLException {
		return wrapped.getMaxRows();
	}

	public final boolean getMoreResults() throws SQLException {
		return wrapped.getMoreResults();
	}

	public final boolean getMoreResults(int current) throws SQLException {
		return wrapped.getMoreResults(current);
	}

	public final int getQueryTimeout() throws SQLException {
		return wrapped.getQueryTimeout();
	}

	public final ResultSet getResultSet() throws SQLException {
		return new ResultSetWrapper(wrapped.getResultSet(), this);
	}

	public final int getResultSetConcurrency() throws SQLException {
		return wrapped.getResultSetConcurrency();
	}

	public final int getResultSetHoldability() throws SQLException {
		return wrapped.getResultSetHoldability();
	}

	public final int getResultSetType() throws SQLException {
		return wrapped.getResultSetType();
	}

	public final int getUpdateCount() throws SQLException {
		return wrapped.getUpdateCount();
	}

	public final SQLWarning getWarnings() throws SQLException {
		return wrapped.getWarnings();
	}

	public final boolean isClosed() throws SQLException {
		return wrapped.isClosed();
	}

	public final boolean isPoolable() throws SQLException {
		return wrapped.isPoolable();
	}

	public final boolean isWrapperFor(Class<?> iface) throws SQLException {
		return wrapped.isWrapperFor(iface);
	}

	public final void setCursorName(String name) throws SQLException {
		wrapped.setCursorName(name);
	}

	public final void setEscapeProcessing(boolean enable) throws SQLException {
		wrapped.setEscapeProcessing(enable);
	}

	public final void setFetchDirection(int direction) throws SQLException {
		wrapped.setFetchDirection(direction);
	}

	public final void setFetchSize(int rows) throws SQLException {
		wrapped.setFetchSize(rows);
	}

	public final void setMaxFieldSize(int max) throws SQLException {
		wrapped.setMaxFieldSize(max);
	}

	public final void setMaxRows(int max) throws SQLException {
		wrapped.setMaxRows(max);
	}

	public final void setPoolable(boolean poolable) throws SQLException {
		wrapped.setPoolable(poolable);
	}

	public final void setQueryTimeout(int seconds) throws SQLException {
		wrapped.setQueryTimeout(seconds);
	}

	public final <T> T unwrap(Class<T> iface) throws SQLException {
		return wrapped.unwrap(iface);
	}

	//for JDBC 4.1
	public void closeOnCompletion() throws SQLException {
		wrapped.closeOnCompletion();
	}

	public boolean isCloseOnCompletion() throws SQLException {
		return wrapped.isCloseOnCompletion();
	}

}
