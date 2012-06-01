/**
 */
package org.eclipse.xtext.mongobeans.mongoBeans;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mongo Bean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansPackage#getMongoBean()
 * @model
 * @generated
 */
public interface MongoBean extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansPackage#getMongoBean_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.mongobeans.mongoBeans.MongoBean#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.mongobeans.mongoBeans.AbstractFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.eclipse.xtext.mongobeans.mongoBeans.MongoBeansPackage#getMongoBean_Features()
   * @model containment="true"
   * @generated
   */
  EList<AbstractFeature> getFeatures();

} // MongoBean
