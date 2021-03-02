package dat3.jpademoflow2.entities;

import dat3.jpademoflow2.entities.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-02T16:13:57")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Integer> yeer;
    public static volatile SingularAttribute<Person, Address> address;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Long> p_id;

}