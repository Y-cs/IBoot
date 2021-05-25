package self.iboot.anno;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Y-cs
 * @date 2021/5/25 15:27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//@Import({WebContextDeferredImportSelector.class})
public @interface EnableWebContext {
}
