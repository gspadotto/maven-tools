/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.maven.plugin.carbonui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.aether.repository.RemoteRepository;
import org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.WSO2MavenPluginConstants;

/**
 * This is the Maven Mojo used for generating a pom for a carbon ui artifact
 * from the old CApp project structure
 */
@Mojo(name="pom-gen")
public class CarbonUIPOMGenMojo extends AbstractBundlePOMGenMojo {

	@Parameter(defaultValue = "${project}")
	public MavenProject project;

	/**
	 * Maven ProjectHelper.
	 */
	@Component
	public MavenProjectHelper projectHelper;

	/**
	 * The path of the location to output the pom
	 */
	@Parameter(defaultValue = "${project.build.directory}/artifacts")
	public File outputLocation;

	/**
	 * The resulting extension of the file
	 */
	@Parameter
	public File artifactLocation;

	/**
	 * POM location for the module project
	 */
	@Parameter(defaultValue = "${project.build.directory}/pom.xml")
	public File moduleProject;

	/**
	 * Group id to use for the generated pom
	 */
	@Parameter
	public String groupId;

	/**
	 * Comma separated list of "artifact_type=extension" to be used when creating dependencies for other capp artifacts
	 */
	@Parameter
	public String typeList;

	/**
	 * A list of projects in eclipse workspace which can be referred using maven groupid, artifactid, version
	 */
	@Parameter
	private List<String> projects;

	@Parameter(defaultValue = "${project.remoteArtifactRepositories}")
    private List<RemoteRepository> remoteRepositories;


	private static final String ARTIFACT_TYPE="lib/carbon/ui";

	private BundlesDataInfo bundlesDataInfo;

    private List<String> artifactProjects;

	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}

	protected List<String> getProjectMapStrings() {
		return projects;
	}

	public List<?> getRemoteRepositories() {
		return remoteRepositories;
	}

	protected String getBundleActivatorClass(Artifact artifact) {
		return null;
	}

	protected void addPlugins(MavenProject artifactMavenProject, Artifact artifact) {
		Plugin pluginAxis2 =
		                     CAppMavenUtils.createPluginEntry(artifactMavenProject,
		                                                      "org.wso2.maven",
		                                                      "maven-carbon-ui-plugin",
		                                                      WSO2MavenPluginConstants.MAVEN_CARBON_UI_PLUGIN_VERSION,
		                                                      true);
//		PluginExecution executionAxis2 = new PluginExecution();
//		executionAxis2.setId("package-war");
//		executionAxis2.setPhase("package");
//		List goalsAxis2 = new ArrayList<String>();
//		goalsAxis2.add("package-war");
//		executionAxis2.setGoals(goalsAxis2);
//		pluginAxis2.addExecution(executionAxis2);

		Xpp3Dom config = (Xpp3Dom) pluginAxis2.getConfiguration();
		Xpp3Dom artifactItems = CAppMavenUtils.createConfigurationNode(config, "artifact");
		String relativePath =
		                      org.wso2.developerstudio.eclipse.utils.file.FileUtils.getRelativePath(new File(
		                                                                                                  artifact.getFile()
		                                                                                                          .getParentFile()
		                                                                                                          .getParentFile()
		                                                                                                          .getParentFile()
		                                                                                                          .getParentFile()
		                                                                                                          .getParentFile()
		                                                                                                          .getPath() +
		                                                                                                          File.separator +
		                                                                                                          "target" +
		                                                                                                          File.separator +
		                                                                                                          "capp" +
		                                                                                                          File.separator +
		                                                                                                          "artifacts" +
		                                                                                                          File.separator +
		                                                                                                          artifactMavenProject.getArtifactId()),
		                                                                                         artifact.getFile());
		artifactItems.setValue(relativePath);
	}

	protected BundlesDataInfo getBundlesDataInfo(File targetProjectLocation, Artifact artifact)throws FactoryConfigurationError {
		if (bundlesDataInfo==null) {
			try {
				bundlesDataInfo = new BundlesDataInfo();
				bundlesDataInfo.setProjects(getProjectMappings());
				List<String> artifactProjects = getArtifactProjects();
				for (String artifactProject : artifactProjects) {
					String[] artifactProjectData = artifactProject.split(":");
					if (artifactProjectData.length==2 && artifactProjectData[0].equals(artifact.getName())){
						String[] projectNames = artifactProjectData[1].split(",");
						for (String projectName : projectNames) {
							bundlesDataInfo.addProjectToList(projectName, null);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bundlesDataInfo;
	}

	public List<String> getArtifactProjects() {
		if (artifactProjects==null){
			artifactProjects=new ArrayList<String>();
		}
		return artifactProjects;
	}

//	public void execute() throws MojoExecutionException, MojoFailureException {
//		//Nothing to do. No need to generate a pom.
//	}

	protected MavenProject createMavenProjectForCappArtifact(Artifact artifact,
	                                                         List<Artifact> artifacts,
	                                                         File projectLocation)
	                                                                              throws MojoExecutionException {
        	return null;
	}

}
