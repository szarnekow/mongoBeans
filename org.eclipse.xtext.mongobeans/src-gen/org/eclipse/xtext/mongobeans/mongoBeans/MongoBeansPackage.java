/**
 */
package org.eclipse.xtext.mongobeans.mongoBeans;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansFactory
 * @model kind="package"
 * @generated
 */
public interface MongoBeansPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mongoBeans";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/mongobeans/MongoBeans";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mongoBeans";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MongoBeansPackage eINSTANCE = org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoFileImpl <em>Mongo File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoFileImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoFile()
   * @generated
   */
  int MONGO_FILE = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_FILE__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Mongo File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_FILE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractElementImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getAbstractElement()
   * @generated
   */
  int ABSTRACT_ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Abstract Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.ImportImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.PackageDeclarationImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__ELEMENTS = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeanImpl <em>Mongo Bean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeanImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoBean()
   * @generated
   */
  int MONGO_BEAN = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_BEAN__NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_BEAN__FEATURES = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mongo Bean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_BEAN_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractFeatureImpl <em>Abstract Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractFeatureImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getAbstractFeature()
   * @generated
   */
  int ABSTRACT_FEATURE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FEATURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoPropertyImpl <em>Mongo Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoPropertyImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoProperty()
   * @generated
   */
  int MONGO_PROPERTY = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_PROPERTY__NAME = ABSTRACT_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_PROPERTY__TYPE = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inline Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_PROPERTY__INLINE_TYPE = ABSTRACT_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_PROPERTY__MANY = ABSTRACT_FEATURE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mongo Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_PROPERTY_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoOperationImpl <em>Mongo Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoOperationImpl
   * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoOperation()
   * @generated
   */
  int MONGO_OPERATION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_OPERATION__NAME = ABSTRACT_FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_OPERATION__RETURN_TYPE = ABSTRACT_FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_OPERATION__PARAMETERS = ABSTRACT_FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_OPERATION__BODY = ABSTRACT_FEATURE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mongo Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONGO_OPERATION_FEATURE_COUNT = ABSTRACT_FEATURE_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoFile <em>Mongo File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo File</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoFile
   * @generated
   */
  EClass getMongoFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoFile#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoFile#getElements()
   * @see #getMongoFile()
   * @generated
   */
  EReference getMongoFile_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.mongobeans.mongoBeans.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Element</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.AbstractElement
   * @generated
   */
  EClass getAbstractElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.PackageDeclaration#getElements()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean <em>Mongo Bean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo Bean</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBean
   * @generated
   */
  EClass getMongoBean();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getName()
   * @see #getMongoBean()
   * @generated
   */
  EAttribute getMongoBean_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getFeatures()
   * @see #getMongoBean()
   * @generated
   */
  EReference getMongoBean_Features();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature <em>Abstract Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Feature</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature
   * @generated
   */
  EClass getAbstractFeature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature#getName()
   * @see #getAbstractFeature()
   * @generated
   */
  EAttribute getAbstractFeature_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty <em>Mongo Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo Property</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty
   * @generated
   */
  EClass getMongoProperty();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#getType()
   * @see #getMongoProperty()
   * @generated
   */
  EReference getMongoProperty_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#getInlineType <em>Inline Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inline Type</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#getInlineType()
   * @see #getMongoProperty()
   * @generated
   */
  EReference getMongoProperty_InlineType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoProperty#isMany()
   * @see #getMongoProperty()
   * @generated
   */
  EAttribute getMongoProperty_Many();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation <em>Mongo Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mongo Operation</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation
   * @generated
   */
  EClass getMongoOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getReturnType()
   * @see #getMongoOperation()
   * @generated
   */
  EReference getMongoOperation_ReturnType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getParameters()
   * @see #getMongoOperation()
   * @generated
   */
  EReference getMongoOperation_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoOperation#getBody()
   * @see #getMongoOperation()
   * @generated
   */
  EReference getMongoOperation_Body();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MongoBeansFactory getMongoBeansFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoFileImpl <em>Mongo File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoFileImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoFile()
     * @generated
     */
    EClass MONGO_FILE = eINSTANCE.getMongoFile();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_FILE__ELEMENTS = eINSTANCE.getMongoFile_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.ImportImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractElementImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getAbstractElement()
     * @generated
     */
    EClass ABSTRACT_ELEMENT = eINSTANCE.getAbstractElement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.PackageDeclarationImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__ELEMENTS = eINSTANCE.getPackageDeclaration_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeanImpl <em>Mongo Bean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeanImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoBean()
     * @generated
     */
    EClass MONGO_BEAN = eINSTANCE.getMongoBean();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONGO_BEAN__NAME = eINSTANCE.getMongoBean_Name();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_BEAN__FEATURES = eINSTANCE.getMongoBean_Features();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractFeatureImpl <em>Abstract Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.AbstractFeatureImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getAbstractFeature()
     * @generated
     */
    EClass ABSTRACT_FEATURE = eINSTANCE.getAbstractFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_FEATURE__NAME = eINSTANCE.getAbstractFeature_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoPropertyImpl <em>Mongo Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoPropertyImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoProperty()
     * @generated
     */
    EClass MONGO_PROPERTY = eINSTANCE.getMongoProperty();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_PROPERTY__TYPE = eINSTANCE.getMongoProperty_Type();

    /**
     * The meta object literal for the '<em><b>Inline Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_PROPERTY__INLINE_TYPE = eINSTANCE.getMongoProperty_InlineType();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONGO_PROPERTY__MANY = eINSTANCE.getMongoProperty_Many();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoOperationImpl <em>Mongo Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoOperationImpl
     * @see org.eclipse.xtext.mongobeans.mongoBeans.impl.MongoBeansPackageImpl#getMongoOperation()
     * @generated
     */
    EClass MONGO_OPERATION = eINSTANCE.getMongoOperation();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_OPERATION__RETURN_TYPE = eINSTANCE.getMongoOperation_ReturnType();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_OPERATION__PARAMETERS = eINSTANCE.getMongoOperation_Parameters();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MONGO_OPERATION__BODY = eINSTANCE.getMongoOperation_Body();

  }

} //MongoBeansPackage
