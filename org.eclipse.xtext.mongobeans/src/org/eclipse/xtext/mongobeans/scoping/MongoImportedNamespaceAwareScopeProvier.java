package org.eclipse.xtext.mongobeans.scoping;

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class MongoImportedNamespaceAwareScopeProvier extends XbaseImportedNamespaceScopeProvider {

	@Inject
	private IQualifiedNameConverter nameConverter;
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	
	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(
			EObject context, boolean ignoreCase) {
		List<ImportNormalizer> resolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		if(!(context instanceof PackageDeclaration)) {
			PackageDeclaration packageDeclaration = getContainerOfType(context, PackageDeclaration.class);
			if(packageDeclaration != null) 
				resolvers.add(createImportedNamespaceResolver(nameConverter.toString(
						nameProvider.getFullyQualifiedName(packageDeclaration)), false));
		}
		return resolvers;
	}
}
