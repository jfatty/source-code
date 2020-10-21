package code.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityUtil {
	
	private static final Logger	LOG	= Logger.getLogger(VelocityUtil.class);
	
	private static VelocityEngine getVelocityEngine() {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve;
	}
	
	public static String exportContent(String templateName, VelocityContext context)
																					throws Exception {
		
		VelocityEngine ve = getVelocityEngine();
		
		final String templatePath = "templates/" + templateName;
		
		LOG.info(templatePath);
		
		InputStream input = VelocityUtil.class.getClassLoader().getResourceAsStream(templatePath);
		if (input == null) {
			throw new IOException("Template file doesn't exist");
		}
		
		InputStreamReader reader = new InputStreamReader(input, "UTF-8");
		
		StringWriter writer = new StringWriter();
		
		if (!ve.evaluate(context, writer, templatePath, reader)) {
			throw new Exception("Failed to convert the template into html.");
		}
		
		//		template.merge(context, writer);
		
		writer.flush();
		writer.close();
		
		return writer.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(VelocityUtil.exportContent("result.vm", new VelocityContext()));
		
	}
}
