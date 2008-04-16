/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *
 */
package org.apache.qpid.server.security.access.plugins;

import org.apache.qpid.framing.AMQMethodBody;
import org.apache.qpid.server.protocol.AMQProtocolSession;
import org.apache.qpid.server.security.access.ACLPlugin;
import org.apache.qpid.server.security.access.ACLManager;
import org.apache.qpid.server.security.access.AccessResult;
import org.apache.qpid.server.security.access.Accessable;
import org.apache.qpid.server.security.access.Permission;
import org.apache.commons.configuration.Configuration;
import org.apache.log4j.Logger;

public class AllowAll implements ACLPlugin
{

    private static final Logger _logger = ACLManager.getLogger();

    public AccessResult authorise(AMQProtocolSession session, Permission permission, AMQMethodBody body, Object... parameters)
    {
        if (_logger.isDebugEnabled())
        {
            _logger.debug("Allowing user:" + session.getAuthorizedID() + " for :" + permission.toString()
                                        + " on " + body.getClass().getSimpleName()
                                        + (parameters == null || parameters.length == 0 ? "" : "-" + accessablesToString(parameters)));
        }

        return new AccessResult(this, AccessResult.AccessStatus.GRANTED);
    }

    public static String accessablesToString(Object[] accessObject)
    {
        StringBuilder sb = new StringBuilder();

        for (Object access : accessObject)
        {
            sb.append(access.getClass().getSimpleName() + ":" + access.toString() + ", ");
        }

        return sb.delete(sb.length() - 2, sb.length()).toString();
    }

    public String getPluginName()
    {
        return "AllowAll";
    }

    public void setConfiguaration(Configuration config)
    {
        //no-op
    }

}
