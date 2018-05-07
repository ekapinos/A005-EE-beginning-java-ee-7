package local.kapinos.chapter06.part01;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-07T23:34:44.252+0300")
@StaticMetamodel(C06_P01_Customer.class)
public class C06_P01_Customer_ {
	public static volatile SingularAttribute<C06_P01_Customer, Long> id;
	public static volatile SingularAttribute<C06_P01_Customer, String> firstName;
	public static volatile SingularAttribute<C06_P01_Customer, String> lastName;
	public static volatile SingularAttribute<C06_P01_Customer, String> email;
	public static volatile SingularAttribute<C06_P01_Customer, C06_P01_Address> address;
}
