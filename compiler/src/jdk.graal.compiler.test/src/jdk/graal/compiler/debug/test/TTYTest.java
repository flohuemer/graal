/*
 * Copyright (c) 2022, 2025, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jdk.graal.compiler.debug.test;

import jdk.graal.compiler.debug.TTY;
import org.junit.Test;

public class TTYTest {

    @Test
    public void testTTYFiltered() throws Exception {
        try (AutoCloseable _ = new TTY.Filter()) {
            printAll();
        }
    }

    @Test
    public void testTTYNoFilter() {
        // This test exists to get coverage of the non-filter paths in TTY
        // so its console output cannot be suppressed. As such, the source
        // of the console output should be made clear.
        TTY.printf("<%s.testTTYNoFilter>%n", TTYTest.class.getName());
        printAll();
        TTY.printf("%n</%s.testTTYNoFilter>%n", TTYTest.class.getName());
    }

    private static void printAll() {
        TTY.print(Integer.MAX_VALUE);
        TTY.print('A');
        TTY.print(Long.MAX_VALUE);
        TTY.print(Float.MAX_VALUE);
        TTY.print(Double.MAX_VALUE);
        TTY.print(true);

        TTY.println();
        TTY.println(Integer.MAX_VALUE);
        TTY.println('A');
        TTY.println(Long.MAX_VALUE);
        TTY.println(Float.MAX_VALUE);
        TTY.println(Double.MAX_VALUE);
        TTY.println(true);

        TTY.fillTo(10);

        TTY.flush();
    }
}
