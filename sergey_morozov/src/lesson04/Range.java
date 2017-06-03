package lesson04;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Target(value=ElementType.FIELD)
public @interface Range {

	public int min() default 0;
	public int max() default 100;
}
