/**
 * Copyright 2022 Dominic (aka. BlockyDotJar)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.blocky.library.jda.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This is an annotation, which tells the developers, with which method/class a deprecated method/class should be replaced.
 *
 * @author BlockyDotJar
 * @version v1.1.1
 * @since v1.0.0-alpha.1
 */
@Retention(RUNTIME)
@Target( { TYPE, METHOD } )
public @interface ReplaceWith
{
    /**
     * @return The method, which should used instead
     */
    String method();

    /**
     * @return The class, which should used instead
     */
    String clazz();
}
