/* *******************************************************************
 * Copyright (c) 2021 Contributors
 * All rights reserved.
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v 2.0
 * which accompanies this distribution and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.txt
 * ******************************************************************/
package org.aspectj.testing;

import org.aspectj.util.LangUtil;

/**
 * Makes sure tests are running on the right level of JDK.
 *
 * @author Alexander Kriegisch
 */
public abstract class XMLBasedAjcTestCaseForJava18Only extends XMLBasedAjcTestCase {

	@Override
	public void setUp() throws Exception {
		// Activate this block after upgrading to JDT Core Java 19
		/*
		throw new IllegalStateException(
			"These tests need a Java 18 level AspectJ compiler " +
				"(e.g. because they use version-specific preview features). " +
				"This compiler does not support preview features of a previous version anymore."
		);
		*/
		// Activate this block before upgrading to JDT Core Java 19
		if (!LangUtil.is18VMOrGreater() || LangUtil.is19VMOrGreater()) {
			throw new IllegalStateException(
				"These tests should be run on Java 18 only " +
				"(e.g. because they use version-specific preview features)"
			);
		}
		super.setUp();
	}

}