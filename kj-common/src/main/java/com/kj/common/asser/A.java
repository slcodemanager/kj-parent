package com.kj.common.asser;


import com.kj.common.exp.E;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;


/**
 * 伪 断言
 *
 * @author quan
 * @date 2020-11-27 14:36
 */

@SuppressWarnings("Duplicates")
public class A {
    private A() {
    }

    public static void of(boolean expression, String message) {
        if (!expression) {
            throw new E(message);
        }
    }

    public static void of(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new E(message);
        }
    }

    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new E(message);
        }
    }

    public static void isNull(Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new E(message);
        }
    }

    public static void notNull(Object object, Supplier<String> messageSupplier) {
        if (object == null) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void notNull(String text, String message) {
        if (StringUtils.isBlank(text)) {
            throw new E(message);
        }
    }

    public static void notNull(String text, Supplier<String> messageSupplier) {
        if (StringUtils.isBlank(text)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }

    public static void isNull(String text, String message) {
        if (StringUtils.isNotBlank(text)) {
            throw new E(message);
        }
    }

    public static void isnNull(String text, Supplier<String> messageSupplier) {
        if (StringUtils.isNotBlank(text)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (StringUtils.length(textToSearch) != 0 && StringUtils.length(substring) != 0 && textToSearch.contains(substring)) {
            throw new E(message);
        }
    }

    public static void doesNotContain(String textToSearch, String substring, Supplier<String> messageSupplier) {
        if (StringUtils.length(textToSearch) != 0 && StringUtils.length(substring) != 0 && textToSearch.contains(substring)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void notEmpty(Object[] array, String message) {
        if (ArrayUtils.isEmpty(array)) {
            throw new E(message);
        }
    }

    public static void notEmpty(Object[] array, Supplier<String> messageSupplier) {
        if (ArrayUtils.isEmpty(array)) {
            throw new E(nullSafeGet(messageSupplier));
        }

    }


    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            Object[] var2 = array;
            int var3 = array.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object element = var2[var4];
                if (element == null) {
                    throw new E(message);
                }
            }
        }

    }

    public static void noNullElements(Object[] array, Supplier<String> messageSupplier) {
        if (array != null) {
            Object[] var2 = array;
            int var3 = array.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                Object element = var2[var4];
                if (element == null) {
                    throw new E(nullSafeGet(messageSupplier));
                }
            }
        }

    }


    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new E(message);
        }
    }

    public static void notEmpty(Collection<?> collection, Supplier<String> messageSupplier) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void noNullElements(Collection<?> collection, String message) {
        if (collection != null) {
            Iterator var2 = collection.iterator();

            while (var2.hasNext()) {
                Object element = var2.next();
                if (element == null) {
                    throw new E(message);
                }
            }
        }

    }

    public static void noNullElements(Collection<?> collection, Supplier<String> messageSupplier) {
        if (collection != null) {
            Iterator var2 = collection.iterator();

            while (var2.hasNext()) {
                Object element = var2.next();
                if (element == null) {
                    throw new E(nullSafeGet(messageSupplier));
                }
            }
        }

    }

    public static void notEmpty(Map<?, ?> map, String message) {
        if (A.isEmpty(map)) {
            throw new E(message);
        }
    }

    public static void notEmpty(Map<?, ?> map, Supplier<String> messageSupplier) {
        if (A.isEmpty(map)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }

    public static void isEmpty(Map<?, ?> map, String message) {
        if (!A.isEmpty(map)) {
            throw new E(message);
        }
    }

    public static void isEmpty(Map<?, ?> map, Supplier<String> messageSupplier) {
        if (!A.isEmpty(map)) {
            throw new E(nullSafeGet(messageSupplier));
        }
    }


    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, (String) "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, message);
        }

    }

    public static void isInstanceOf(Class<?> type, Object obj, Supplier<String> messageSupplier) {
        notNull(type, (String) "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            instanceCheckFailed(type, obj, nullSafeGet(messageSupplier));
        }
    }

    public static void isInstanceOf(Class<?> type, Object obj) {
        isInstanceOf(type, obj, "");
    }


    private static void instanceCheckFailed(Class<?> type, Object obj, String msg) {
        String className = obj != null ? obj.getClass().getName() : "null";
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.length(msg) != 0) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, className);
                defaultMessage = false;
            }
        }

        if (defaultMessage) {
            result = result + "Object of class [" + className + "] must be an instance of " + type;
        }

        throw new E(result);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    private static boolean endsWithSeparator(String msg) {
        return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
    }

    private static String messageWithTypeName(String msg, Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }


    private static String nullSafeGet(Supplier<String> messageSupplier) {
        return messageSupplier != null ? (String) messageSupplier.get() : null;
    }
}
