package org.eclipse.xtext.mongobeans.scoping;

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType;

import org.eclipse.xtext.mongobeans.mongoBeans.MongoBean;
import org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;

@SuppressWarnings("restriction")
public class MongoQualifiedNameProvider extends XbaseQualifiedNameProvider {

	public QualifiedName qualifiedName(MongoBean mongoBean) {
		PackageDeclaration packageDeclaration = getContainerOfType(mongoBean, PackageDeclaration.class);
		if(packageDeclaration != null) 
			return getFullyQualifiedName(packageDeclaration).append(mongoBean.getName());
		else
			return QualifiedName.create(mongoBean.getName());
	}
}
