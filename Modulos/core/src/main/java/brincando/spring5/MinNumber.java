package brincando.spring5;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Indicated context and annotation can be applicable for
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
// Indicated how long annotations with the annotated type are to be retained.
@Retention(RetentionPolicy.RUNTIME)
//Its used to annotate athoer custom annotations that can be used by qualifier
@Qualifier
public @interface MinNumber {

}
