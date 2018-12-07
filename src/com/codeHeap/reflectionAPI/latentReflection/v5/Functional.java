package com.codeHeap.reflectionAPI.latentReflection.v5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Functional {
    static <T> T reduce(Iterable<T> iterable, Combiner<T> combiner){
        Iterator<T> iterator = iterable.iterator();
        if(iterator.hasNext()){
            T result = iterator.next();
            while(iterator.hasNext()){
                result = combiner.combine(result, iterator.next());
            }
            return result;
        }
        return null;
    }

    static <T> Collector<T> forEach(Iterable<T> iterable, Collector<T> collector){
        for (T item : iterable) {
            collector.function(item);
        }
        return collector;
    }

    static <R,T> List<R> transform(Iterable<T> iterable, UnaryFunction<R,T> function){
        List<R> result = new ArrayList<>();
        for (T item : iterable) {
            result.add(function.function(item));
        }
        return result;
    }

    static <T> List<T> filter(Iterable<T> iterable, UnaryPredicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T item : iterable) {
            if(predicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
