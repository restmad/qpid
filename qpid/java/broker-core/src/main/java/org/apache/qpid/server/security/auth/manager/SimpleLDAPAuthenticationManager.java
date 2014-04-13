/*
 *
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
 *
 */
package org.apache.qpid.server.security.auth.manager;

import org.apache.qpid.server.model.AuthenticationProvider;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.TrustStore;

@ManagedObject( category = false, type = "SimpleLDAP" )
public interface SimpleLDAPAuthenticationManager<X extends SimpleLDAPAuthenticationManager<X>> extends AuthenticationProvider<X>
{
    @ManagedAttribute( automate = true )
    String getProviderUrl();

    @ManagedAttribute( automate = true )
    String getProviderAuthUrl();

    @ManagedAttribute( automate = true )
    String getSearchContext();

    @ManagedAttribute( automate = true )
    String getSearchFilter();

    @ManagedAttribute( automate = true )
    String getLdapContextFactory();

    @ManagedAttribute( automate = true )
    TrustStore getTrustStore();
}
