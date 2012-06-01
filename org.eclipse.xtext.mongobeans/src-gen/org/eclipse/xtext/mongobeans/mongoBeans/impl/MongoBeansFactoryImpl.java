/**
 */
package org.eclipse.xtext.mongobeans.mongoBeans.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.mongobeans.mongoBeans.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MongoBeansFactoryImpl extends EFactoryImpl implements MongoBeansFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MongoBeansFactory init()
  {
    try
    {
      MongoBeansFactory theMongoBeansFactory = (MongoBeansFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/mongobeans/MongoBeans"); 
      if (theMongoBeansFactory != null)
      {
        return theMongoBeansFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MongoBeansFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoBeansFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MongoBeansPackage.MONGO_FILE: return createMongoFile();
      case MongoBeansPackage.IMPORT: return createImport();
      case MongoBeansPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case MongoBeansPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case MongoBeansPackage.MONGO_BEAN: return createMongoBean();
      case MongoBeansPackage.ABSTRACT_FEATURE: return createAbstractFeature();
      case MongoBeansPackage.MONGO_PROPERTY: return createMongoProperty();
      case MongoBeansPackage.MONGO_OPERATION: return createMongoOperation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoFile createMongoFile()
  {
    MongoFileImpl mongoFile = new MongoFileImpl();
    return mongoFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement createAbstractElement()
  {
    AbstractElementImpl abstractElement = new AbstractElementImpl();
    return abstractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoBean createMongoBean()
  {
    MongoBeanImpl mongoBean = new MongoBeanImpl();
    return mongoBean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractFeature createAbstractFeature()
  {
    AbstractFeatureImpl abstractFeature = new AbstractFeatureImpl();
    return abstractFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoProperty createMongoProperty()
  {
    MongoPropertyImpl mongoProperty = new MongoPropertyImpl();
    return mongoProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoOperation createMongoOperation()
  {
    MongoOperationImpl mongoOperation = new MongoOperationImpl();
    return mongoOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MongoBeansPackage getMongoBeansPackage()
  {
    return (MongoBeansPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MongoBeansPackage getPackage()
  {
    return MongoBeansPackage.eINSTANCE;
  }

} //MongoBeansFactoryImpl
