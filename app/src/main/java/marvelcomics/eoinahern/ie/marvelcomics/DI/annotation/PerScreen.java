package marvelcomics.eoinahern.ie.marvelcomics.DI.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerScreen {
}
