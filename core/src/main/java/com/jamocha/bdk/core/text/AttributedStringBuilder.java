/*
 * Copyright 2014 saden.
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
package com.jamocha.bdk.core.text;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Derived;
import com.jamocha.bdk.api.annotation.Optional;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Map;

/**
 *
 * @author saden
 */
public class AttributedStringBuilder {

    public IteratorBuilder text(AttributedCharacterIterator text) {
        return new IteratorBuilder(text);
    }

    public TextBuilder text(String text) {
        return new TextBuilder(text);
    }

    public static class IteratorBuilder implements Builder<AttributedString> {

        private final AttributedCharacterIterator text;
        private Integer begin;
        private Integer end;
        private AttributedCharacterIterator.Attribute[] attributes;

        private IteratorBuilder(AttributedCharacterIterator text) {
            this.text = text;
        }

        @Derived("text")
        @Optional
        public IteratorBuilder begin(int begin) {
            this.begin = begin;

            return this;
        }

        @Derived("text")
        @Optional
        public IteratorBuilder end(int end) {
            this.end = end;

            return this;
        }

        @Optional
        public IteratorBuilder attributes(
                AttributedCharacterIterator.Attribute... attributes) {
            this.attributes = attributes;

            return this;
        }

        @Override
        public AttributedString build() {
            if (begin == null) {
                begin = text.getBeginIndex();
            }

            if (end == null) {
                end = text.getEndIndex();
            }

            return new AttributedString(text, begin, end, attributes);
        }
    }

    public static class TextBuilder implements Builder<AttributedString> {

        private final String text;

        public TextBuilder(String text) {
            this.text = text;
        }

        @Optional
        public AttributeBulder attributes(
                Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
            return new AttributeBulder(text, attributes);
        }

        @Override
        public AttributedString build() {
            return new AttributedString(text);
        }
    }

    public static class AttributeBulder implements Builder<AttributedString> {

        private final String text;
        private final Map<? extends AttributedCharacterIterator.Attribute, ?> attributes;

        private AttributeBulder(String text,
                Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
            this.text = text;
            this.attributes = attributes;
        }

        @Override
        public AttributedString build() {
            return new AttributedString(text, attributes);
        }
    }

}
