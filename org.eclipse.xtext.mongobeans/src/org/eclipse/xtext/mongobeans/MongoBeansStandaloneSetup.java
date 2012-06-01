
package org.eclipse.xtext.mongobeans;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MongoBeansStandaloneSetup extends MongoBeansStandaloneSetupGenerated{

	public static void doSetup() {
		new MongoBeansStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

