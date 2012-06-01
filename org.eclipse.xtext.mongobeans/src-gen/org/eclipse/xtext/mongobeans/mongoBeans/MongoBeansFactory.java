/**
 */
package org.eclipse.xtext.mongobeans.mongoBeans;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansPackage
 * @generated
 */
public interface MongoBeansFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MongoBeansFactory eINSTANCE = org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mongo File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mongo File</em>'.
   * @generated
   */
  MongoFile createMongoFile();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Abstract Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Element</em>'.
   * @generated
   */
  AbstractElement createAbstractElement();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Mongo Bean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mongo Bean</em>'.
   * @generated
   */
  MongoBean createMongoBean();

  /**
   * Returns a new object of class '<em>Abstract Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Feature</em>'.
   * @generated
   */
  AbstractFeature createAbstractFeature();

  /**
   * Returns a new object of class '<em>Mongo Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mongo Property</em>'.
   * @generated
   */
  MongoProperty createMongoProperty();

  /**
   * Returns a new object of class '<em>Mongo Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mongo Operation</em>'.
   * @generated
   */
  MongoOperation createMongoOperation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MongoBeansPackage getMongoBeansPackage();

} //MongoBeansFactory
