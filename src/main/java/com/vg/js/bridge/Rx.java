package com.vg.js.bridge;

import org.stjs.javascript.Array;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.Template;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;
import org.stjs.javascript.functions.Function1;
import org.stjs.javascript.functions.Function2;
import org.stjs.javascript.functions.Function3;

@STJSBridge
public class Rx {
    public static class Disposable {
        public native void dispose();
    }

    public static class Observer<T> {

        public native static <T> Observer<T> create(Callback1<T> handler);

        public native static <T> Observer<T> create(Callback1<T> onNext, Callback1<Object> onError,
                Callback0 onCompleted);

        public native void onNext(T item);

        public native void onCompleted();

        public native void onError(Object err);

    }

    public static class ReplaySubject<T> extends Subject<T> {
        public ReplaySubject(int i) {
        }

        public ReplaySubject() {
        }

        public native void onNext(T obj);

    }

    public static class Observable<T> {

        public native static <T> Observable<T> from(Array<T> array);

        public native static <T> Observable<T> fromEvent(Object video, String eventName, Function1<DOMEvent, T> object);

        public native static Observable<DOMEvent> fromEvent(Object video, String string);

        @SafeVarargs
        public native static <T> Observable<T> merge(Observable<? extends T>... observables);

        public native static <T> Observable<T> concat(Array<Observable<T>> map);

        public native static <T> Observable<T> create(Callback1<Observer<T>> observer);

        @Template("prefix")
        public native static <T> Observable<T> $create(Function1<Observer<T>, Callback0> object);

        public native static <T> Observable<T> just(T object);

        public native <R> Observable<R> map(Function1<T, R> map);

        public native Observable<T> merge(Observable<T> other);

        public native Observable<T> concat(Observable<T>... others);

        public native Disposable subscribe(Callback1<T> onNext);

        public native Disposable subscribe(Callback1<T> onNext, Callback1<?> onError);

        public native Disposable subscribe(Callback1<T> onNext, Callback1<?> onError, Callback0 onCompleted);

        public native Observable<T> debounce(int i);

        public native Observable<T> filter(Function1<T, Boolean> predicate);

        public native <R> Observable<R> flatMap(Function1<? super T, ? extends Observable<? extends R>> func);

        public native <E> Observable<T> takeUntil(Observable<? extends E> other);

        public native Observable<T> take(int count);

        public native Observable<T> first(Function3<T, Integer, Observable<T>, Boolean> predicate);

        public native Observable<T> doOnNext(Callback1<T> onNext);

        public native Observable<T> doOnError(Callback1<Object> onError);

        public native Observable<T> doOnCompleted(Callback0 onNext);

        @Template("prefix")
        public native Observable<T> $finally(Callback0 object);

        public native Observable<T> distinct();

        public native <K> Observable<T> distinct(Function1<T, K> keySelector, Function2<K, K, Boolean> comparer);

        public native Observable<T> distinctUntilChanged();

        public native <K> Observable<T> distinctUntilChanged(Function1<T, K> keySelector,
                Function2<K, K, Boolean> comparer);

        public native static <T> Observable<T> empty();

        public native Observable<T> onErrorResumeNext(Observable<T> second);

        @Template("prefix")
        public native Observable<T> $catch(Observable<T> second);

        public native Observable<T> retry(int count);

        public native Observable<T> retryWhen(Function1<Observable<?>, Observable<?>> notifier);

        public native Observable<T> delay(long ms);

        public native static Observable<Integer> interval(long l);

        public native static Observable<Long> timer(long msec);

        public native static Observable<Integer> range(int start, int count);

        @Template("prefix")
        public native static Observable<?> $throw(Object errorNotification);

        public native Observable<T> throttle(long msec);

        public native Observable<T> takeWhile(Function1<T, Boolean> predicate);

        public native static <T> Observable<T> start(Function0<T> func);
    }

    public static class Subject<T> extends Observable<T> {
        public native void onNext(T var1);

        public native static <T> Subject<T> create(Observer<T> observer, Observable<T> observable);

        public native void onCompleted();

    }
}
