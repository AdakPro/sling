/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.api.resource;

/**
 * Exception thrown by
 * <code>{@link ResourceAccessGate#sanitizeQuery(String, String, org.apache.sling.auth.core.spi.AuthenticationInfo)}</code>
 * if the query is not allowed or illegal.
 */
public class AccessGateException extends Exception {

    private static final long serialVersionUID = -8388988380137140280L;

    /**
     * Constructs a new instance of this class with <code>null</code> as its
     * detail message.
     */
    public AccessGateException() {
        super();
    }

    /**
     * Constructs a new instance of this class with the specified detail
     * message.
     *
     * @param message the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public AccessGateException(String message) {
        super(message);
    }

    /**
     * Constructs a new instance of this class with the specified detail message
     * and root cause.
     *
     * @param message the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     * @param rootCause root failure cause
     */
    public AccessGateException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    /**
     * Constructs a new instance of this class with the specified root cause.
     *
     * @param rootCause root failure cause
     */
    public AccessGateException(Throwable rootCause) {
        super(rootCause);
    }
}
