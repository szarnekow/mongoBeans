/*
 * generated by Xtext
 */
package org.eclipse.xtext.mongobeans;

import org.eclipse.xtext.mongobeans.scoping.MongoImportedNamespaceAwareScopeProvier;
import org.eclipse.xtext.mongobeans.scoping.MongoQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MongoBeansRuntimeModule extends org.eclipse.xtext.mongobeans.AbstractMongoBeansRuntimeModule {

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return MongoQualifiedNameProvider.class;
	}
	
	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
			.annotatedWith(Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
			.to(MongoImportedNamespaceAwareScopeProvier.class);
	}
}
