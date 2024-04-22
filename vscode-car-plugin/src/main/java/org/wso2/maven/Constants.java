/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.maven;

import java.io.File;

class Constants {
    static final String ARTIFACTS = "artifacts";
    static final String ARTIFACT = "artifact";
    static final String KEY = "key";
    static final String API_DIR_NAME = "apis";
    static final String ENDPOINTS_DIR_NAME = "endpoints";
    static final String INBOUND_DIR_NAME = "inbound-endpoints";
    static final String LOCAL_ENTRIES_DIR_NAME = "local-entries";
    static final String MSG_PROCESSORS_DIR_NAME = "message-processors";
    static final String MSG_STORES_DIR_NAME = "message-stores";
    static final String PROXY_SERVICES_DIR_NAME = "proxy-services";
    static final String SEQUENCES_DIR_NAME = "sequences";
    static final String TASKS_DIR_NAME = "tasks";
    static final String TEMPLATES_DIR_NAME = "templates";
    static final String DATASOURCE_DIR_NAME = "datasources";
    static final String DATASERVICES_DIR_NAME = "dataservices";
    static final String METADATA_DIR_NAME = "metadata";
    static final String CONNECTORS_DIR_NAME = "connectors";
    static final String REGISTRY_DIR_NAME = "registry";
    static final String API_TYPE = "synapse/api";
    static final String ENDPOINT_TYPE = "synapse/endpoint";
    static final String INBOUND_TYPE = "synapse/inbound-endpoint";
    static final String LOCAL_ENTRY_TYPE = "synapse/local-entry";
    static final String MESSAGE_PROCESSOR_TYPE = "synapse/message-processors";
    static final String MESSAGE_STORE_TYPE = "synapse/message-store";
    static final String PROXY_SERVICE_TYPE = "synapse/proxy-service";
    static final String SEQUENCE_TYPE = "synapse/sequence";
    static final String TASK_TYPE = "synapse/task";
    static final String TEMPLATE_TYPE = "synapse/template";
    static final String DATASOURCE_TYPE = "datasource/datasource";
    static final String DATASERVICE_TYPE = "service/dataservice";
    static final String REG_RESOURCE_TYPE = "registry/resource";
    static final String CONNECTOR_TYPE = "synapse/lib";
    static final String METADATA_TYPE = "synapse/metadata";
    static final String CAPP_TYPE = "carbon/application";
    static final String CLASS_MEDIATOR_TYPE = "lib/synapse/mediator";
    static final String ARTIFACTS_FOLDER_PATH = "src" + File.separator + "main" + File.separator
            + "wso2mi" + File.separator + "artifacts";
    static final String RESOURCES_FOLDER_PATH = "src" + File.separator + "main" + File.separator
            + "wso2mi" + File.separator + "resources";
    static final String SERVER_ROLE_EI = "EnterpriseIntegrator";
    static final String SERVER_ROLE_DSS = "EnterpriseServiceBus";
    static final String GOV_REG_PREFIX = "/_system/governance";
    static final String CONF_REG_PREFIX = "/_system/config";
    static final String GOV_FOLDER= "gov";
    static final String CONF_FOLDER = "conf";
    static final String REG_INFO_FILE = "registry-info.xml";
    static final String DEFAULT_TARGET_FOLDER = "target";
    static final String VERSION = "version";
    static final String TYPE = "type";
    static final String SERVER_ROLE = "serverRole";
    static final String NAME = "name";
    static final String FILE = "file";
    static final String ITEM = "item";
    static final String COLLECTION = "collection";
    static final String DIRECTORY = "directory";
    static final String PATH = "path";
    static final String DEPENDENCY = "dependency";
    static final String INCLUDE = "include";
    static final String RESOURCES = "resources";
    static final String ARCHIVE_EXCEPTION_MSG = "Error occurred while creating CAR file.";
    static final String ARTIFACT_XML = "artifact.xml";
    static final String EMPTY_STRING = "";
    static final String MAIN_SEQUENCE = "mainSequence";
    static final String TEMP_TARGET_DIR_NAME = "tmp";

    private Constants() {
    }
}