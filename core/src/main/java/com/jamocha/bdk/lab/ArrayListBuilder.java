/*
 * Copyright 2013 Sharmarke Aden <www.github.com/saden1>.
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
package com.jamocha.bdk.lab;

import com.jamocha.bdk.api.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ArrayListBuilder implements Builder<ArrayList> {

    public ElementsBuilder elements(Collection elements) {
        return new ElementsBuilder(elements);
    }

    public IterableBuilder elements(Iterable elements) {
        return new IterableBuilder(elements);
    }

    public CapacityBuilder capacity(int capacity) {
        return new CapacityBuilder(capacity);
    }

    @Override
    public ArrayList build() {
        return new ArrayList();
    }

    public static class ElementsBuilder implements Builder<ArrayList> {

        private final Collection elements;

        private ElementsBuilder(Collection elements) {
            this.elements = elements;
        }

        @Override
        public ArrayList build() {
            return new ArrayList(elements);
        }

    }

    public static class CapacityBuilder implements Builder<ArrayList> {

        private final int capacity;

        private CapacityBuilder(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public ArrayList build() {
            return new ArrayList(capacity);
        }
    }

    public static class IterableBuilder implements Builder<ArrayList> {

        private final Iterable elements;

        private IterableBuilder(Iterable elements) {
            this.elements = elements;
        }

        public FilterBuilder filter(Filter filter) {
            return new FilterBuilder(elements, filter);
        }

        public TransformerBuilder transform(Transformer transformer) {
            return new TransformerBuilder(elements, transformer);
        }

        @Override

        public ArrayList build() {
            ArrayList result = new ArrayList();

            for (Iterator it = elements.iterator(); it.hasNext();) {
                result.add(it.next());
            }

            result.trimToSize();

            return result;
        }

    }

    public static class FilterBuilder implements Builder<ArrayList> {

        private final Iterable elements;
        private final Filter filter;

        private FilterBuilder(Iterable elements,
                Filter filter) {
            this.elements = elements;
            this.filter = filter;
        }

        public FilterTransformerBuilder transform(Transformer transformer) {
            return new FilterTransformerBuilder(elements, filter, transformer);
        }

        @Override
        public ArrayList build() {
            ArrayList result = new ArrayList();

            for (Iterator it = elements.iterator(); it.hasNext();) {
                Object value = it.next();

                if (filter.filter(value)) {
                    continue;
                }

                result.add(value);
            }

            result.trimToSize();

            return result;
        }

    }

    public static class TransformerBuilder implements Builder<ArrayList> {

        private final Iterable elements;
        private final Transformer transformer;

        private TransformerBuilder(Iterable elements,
                Transformer transformer) {
            this.elements = elements;
            this.transformer = transformer;
        }

        public TransformerFilterBuilder filter(Filter filter) {
            return new TransformerFilterBuilder(elements, filter, transformer);
        }

        @Override

        public ArrayList build() {
            ArrayList result = new ArrayList();

            for (Iterator it = elements.iterator(); it.hasNext();) {
                Object value = it.next();

                result.add(transformer.transform(value));
            }

            result.trimToSize();

            return result;
        }
    }

    public static class FilterTransformerBuilder implements Builder<ArrayList> {

        private final Iterable elements;
        private final Filter filter;
        private final Transformer transformer;

        private FilterTransformerBuilder(Iterable elements,
                Filter filter,
                Transformer transformer) {
            this.elements = elements;
            this.filter = filter;
            this.transformer = transformer;
        }

        @Override
        public ArrayList build() {
            ArrayList result = new ArrayList();

            for (Iterator it = elements.iterator(); it.hasNext();) {
                Object value = it.next();

                if (filter.filter(value)) {
                    continue;
                }

                result.add(transformer.transform(value));
            }

            result.trimToSize();

            return result;
        }
    }

    public static class TransformerFilterBuilder implements Builder<ArrayList> {

        private final Iterable elements;
        private final Filter filter;
        private final Transformer transformer;

        private TransformerFilterBuilder(Iterable elements,
                Filter filter,
                Transformer transformer) {
            this.elements = elements;
            this.filter = filter;
            this.transformer = transformer;
        }

        @Override
        public ArrayList build() {
            ArrayList result = new ArrayList();

            for (Iterator it = elements.iterator(); it.hasNext();) {
                Object value = it.next();

                value = transformer.transform(value);

                if (filter.filter(value)) {
                    continue;
                }

                result.add(value);
            }

            result.trimToSize();

            return result;
        }
    }

}
