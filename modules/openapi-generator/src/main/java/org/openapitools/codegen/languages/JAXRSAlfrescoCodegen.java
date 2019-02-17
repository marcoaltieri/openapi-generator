package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;

import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAXRSAlfrescoCodegen extends JavaJAXRSSpecServerCodegen implements CodegenConfig {
    public static final String PROJECT_NAME = "jaxrs-alfresco";

    static Logger LOGGER = LoggerFactory.getLogger(JAXRSAlfrescoCodegen.class);

    private boolean generatePom = true;

    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    public String getName() {
        return PROJECT_NAME;
    }

    public String getHelp() {
        return "Generates models for alfresco server.";
    }

    public JAXRSAlfrescoCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + PROJECT_NAME;
        modelTemplateFiles.put("model.mustache", ".java");
        apiTemplateFiles.put("api.mustache", ".java");
        embeddedTemplateDir = templateDir = PROJECT_NAME;
        apiPackage = File.separator + "Apis";
        modelPackage = File.separator + "Models";

        /* No options for now */
        cliOptions.clear();

	cliOptions.add(CliOption.newBoolean(GENERATE_POM, "Whether to generate pom.xml if the file does not already exist.").defaultValue(String.valueOf(generatePom)));
    }

    @Override
    public void processOpts() {
        super.processOpts();

        supportingFiles.clear(); // Don't need extra files provided by AbstractJAX-RS & Java Codegen
        writeOptional(outputFolder, new SupportingFile("README.mustache", "", "README.md"));
        if (generatePom) {
            writeOptional(outputFolder, new SupportingFile("pom.mustache", "", "pom.xml"));
        }
        writeOptional(outputFolder, new SupportingFile("RestApplication.mustache",
                (sourceFolder + '/' + invokerPackage).replace(".", "/"), "RestApplication.java"));
    }
}
