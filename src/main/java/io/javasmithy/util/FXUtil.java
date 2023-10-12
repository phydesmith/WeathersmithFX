package io.javasmithy.util;

import java.util.function.Consumer;

public class FXUtil {

    public static <T> T build(T node, Consumer<T> initializer){
        initializer.accept(node);
        return node;
    }

}
