package org.sample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class ReRunAuto implements IAnnotationTransformer {

	public void transform(ITestAnnotation a, Class testClass, Constructor testConstructor, Method testMethod) {
		
		IRetryAnalyzer gr = a.getRetryAnalyzer();
		if (gr==null) {
			a.setRetryAnalyzer(ReRunFailed.class);
			
		}
	}

}
