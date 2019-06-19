package com.looboo.kafkasql.ui;

import com.looboo.kafkasql.assemble.Constant;
import jline.console.completer.Completer;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class KeywordsCompleter implements Completer {

    private static Set<String> keywords;

    static {
        keywords = KeywordsCompleter.listKeywords();
    }

    @Override
    public int complete(String buffer, int cursor, List<CharSequence> candidates) {
        int length = 0;
        if (buffer.length() > 0 && cursor > 0) {

            String[] words = buffer.substring(0, cursor).split("\\s");

            if (words == null || words.length == 0) {
                return cursor;
            }

            String substring = words[words.length - 1];
            length = substring.length();

            keywords.stream().filter(k -> {
                String keywordUpper = k.toUpperCase();
                return keywordUpper.startsWith(substring.toUpperCase());
            }).forEach(k -> candidates.add(k.toLowerCase()));
        }
        return cursor - length;
    }

    private static Set<String> listKeywords() {
        Field[] fields = Constant.class.getDeclaredFields();

        Set<String> result = new HashSet<>();
        for (Field field : fields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == String.class) {
                field.setAccessible(true);
                try {
                    result.add((String) field.get(null));
                } catch (IllegalAccessException e) {
                    log.error("IllegalAccessException {}", e.getLocalizedMessage());
                }
            }
        }
        return result;
    }
}

