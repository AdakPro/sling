/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.ide.eclipse.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;

public class ConfigurationHelper {

	public static void convertToContentPackageProject(IProject aContentProject,
			IProgressMonitor monitor, String jcr_root) throws CoreException {
		IProjectFacet slingContentFacet = ProjectFacetsManager.getProjectFacet("sling.content");
		IFacetedProject fp2 = ProjectFacetsManager.create(aContentProject, true, null);
		fp2.installProjectFacet(slingContentFacet.getLatestVersion(), null, null);
		
		ProjectUtil.setSyncDirectoryPath(aContentProject, jcr_root);
	}

	public static void convertToBundleProject(IProject aBundleProject)
			throws CoreException {
		IProjectFacet slingContentFacet = ProjectFacetsManager.getProjectFacet("sling.bundle");
		IFacetedProject fp2 = ProjectFacetsManager.create(aBundleProject, true, null);
		fp2.installProjectFacet(slingContentFacet.getLatestVersion(), null, null);
	}

}
