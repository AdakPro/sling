<%--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
--%><%@page session="false" %><%
%><%@page import="org.apache.sling.api.resource.Resource,
                org.apache.sling.api.resource.ResourceResolver,
                org.apache.sling.api.resource.ResourceUtil,
                org.apache.sling.api.resource.ValueMap,
                org.apache.sling.api.request.ResponseUtil,
                org.apache.sling.sample.slingshot.Constants,
                java.util.Iterator"%><%
%><%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling/1.0" %><%
%><sling:defineObjects/><%
    final ValueMap attributes = ResourceUtil.getValueMap(resource);
    final String name = resource.getName();
    final ResourceResolver resolver = resource.getResourceResolver();
%><html>
  <head>
    <title>Tag <%= ResponseUtil.escapeXml(name) %></title>
  </head>
  <body>
<h1>Tag <%=ResponseUtil.escapeXml(name) %></h1>
<div class="photolist">
<%
    int i = 0;
    final Iterator<Resource> fi = resolver.findResources("SELECT * FROM nt:file WHERE jcr:path LIKE '/slingshot/albums/%' AND slingshot:tags='" + name + "'", "sql");
    while ( fi.hasNext()) {
        final Resource current = fi.next();
        if ( current.isResourceType(Constants.RESOURCETYPE_PHOTO) 
                && Constants.includeAsMedia(current)) {
          %>
        <sling:include resource="<%= current %>" resourceType="slingshot/Photo" replaceSelectors="main"/>
          <%
        }
    }
%>
</div>
</body>
</html>