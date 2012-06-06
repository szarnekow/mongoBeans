package org.eclipse.xtext.mongobeans.validation;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.mongobeans.jvmmodel.MongoTypes;
import org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansPackage;
import org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;
 

public class MongoBeansJavaValidator extends AbstractMongoBeansJavaValidator {

	@Inject
	private MongoTypes mongoTypes;
	
	@Check
	public void checkMongoProperty(MongoProperty property) {
		if(Strings.equal(property.getName(), "_dbObject")) 
			error("Illegal property name 'dbObject'", MongoBeansPackage.Literals.ABSTRACT_FEATURE__NAME);
		JvmTypeReference type = property.getType();
		if(type != null) {
			if(!mongoTypes.isMongoType(type)) 
				error("Only MongoBeans and mappable types are allowed", MongoBeansPackage.Literals.MONGO_PROPERTY__TYPE);
		} else if(property.getInlineType() == null) {
			error("Type must be set", MongoBeansPackage.Literals.ABSTRACT_FEATURE__NAME);			
		}
	}

}
