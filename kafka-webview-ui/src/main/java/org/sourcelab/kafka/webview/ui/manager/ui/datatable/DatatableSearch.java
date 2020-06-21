/**
 * MIT License
 *
 * Copyright (c) 2017, 2018, 2019 SourceLab.org (https://github.com/SourceLabOrg/kafka-webview/)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.sourcelab.kafka.webview.ui.manager.ui.datatable;

/**
 * Represents a searchable field on a datatable.
 */
public class DatatableSearch {
    private final String label;
    private final String field;
    private final String currentSearchTerm;

    /**
     * Constructor.
     * @param label Human readable display label.
     * @param field The underlying field to search over.
     * @param currentSearchTerm The current search term if defined in a request.
     */
    public DatatableSearch(final String label, final String field, final String currentSearchTerm) {
        this.label = label;
        this.field = field;
        this.currentSearchTerm = currentSearchTerm;
    }

    public String getLabel() {
        return label;
    }

    public String getField() {
        return field;
    }

    public String getCurrentSearchTerm() {
        return currentSearchTerm;
    }

    @Override
    public String toString() {
        return "DatatableSearch{"
            + "label='" + label + '\''
            + ", field='" + field + '\''
            + '}';
    }
}
