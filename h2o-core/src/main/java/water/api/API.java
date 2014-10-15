package water.api;

import java.lang.annotation.*;

/** API Annotation
 *
 *  API annotations are used to document field behaviors for the external REST API.  Each
 *  field is described by a matching Java field, plus these annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface API {

  /** Is a given field an input, an output, or both? */
  enum Direction {INPUT, OUTPUT, INOUT}

  /** How important is it to specify a given field to get a useful result? */
  enum Level {critical, secondary, expert}

  /**
   *  A short help description to appear alongside the field in a UI.
   */
  String help();

  /**
   * The label that should be displayed for the field if the name is insufficient.
   */
  String label() default "";

  /**
   * Is this field required, or is the default value generally sufficient?
   */
  boolean required() default false;

  /**
   * How important is this field?  The web UI uses the level to do a slow reveal of the parameters.
   */
  Level level() default Level.critical;

  /**
   * Is this field an input, output or inout?
   */
  Direction direction() default Direction.INPUT; // TODO: should this be INOUT?

  // The following are markers for *input* fields.

  /**
   * For enum-type fields the allowed values are specified using the values annotation.
   * This is used in UIs to tell the user the allowed values, and for validation.
   */
  String[] values() default {};

  /**
   * Should this field be rendered in the JSON representation?
   */
  boolean json() default true;
}
