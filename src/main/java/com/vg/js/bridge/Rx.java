package com.vg.js.bridge;

import org.stjs.javascript.Array;
import org.stjs.javascript.Promise;
import org.stjs.javascript.annotation.Native;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.Template;
import org.stjs.javascript.dom.DOMEvent;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;
import org.stjs.javascript.functions.Function1;
import org.stjs.javascript.functions.Function2;
import org.stjs.javascript.functions.Function3;
import org.stjs.javascript.functions.Function4;

@STJSBridge
public class Rx {
    public static class Disposable {
        public static Disposable empty;

        public static native Disposable create(Callback0 action);

        public static native boolean isDisposable(Disposable d);

        public native void dispose();
    }

    public static class CompositeDisposable extends Disposable {
        public CompositeDisposable(Disposable... items) {
        }

        public boolean isDisposed;

        public int length;

        public native void add(Disposable item);

        public native boolean remove(Disposable item);

        public native Array<Disposable> toArray();
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

        public native static <T> Observable<T> from(T[] array);

        public native static <T> Observable<T> from(Array<T> array);

        public native static <T> Observable<T> fromEvent(Object video, String eventName, Function1<DOMEvent, T> object);

        public native static Observable<DOMEvent> fromEvent(Object video, String string);
        
        public native static <T> Observable<T> fromPromise(Promise<T> promise);

        @SafeVarargs
        public native static <T> Observable<T> merge(Observable<? extends T>... observables);

        @Template("prefix")
        public native static <T> Observable<T> $merge(Array<Observable<T>> observables);

        public native static <T> Observable<T> concat(Array<Observable<T>> map);

        public native static <T> Observable<T> create(Callback1<Observer<T>> observer);
        
        public native static <T> Observable<T> create(Function1<Observer<T>, Disposable> observer);

        @Template("prefix")
        public native static <T> Observable<T> $create(Function1<Observer<T>, Callback0> object);

        public native static <T> Observable<T> just(T object);

        public native static <T> Observable<T> of(T... arguments);

        public native <R> Observable<R> map(Function1<T, R> map);

        public native Observable<T> merge(Observable<T> other);

        public native Observable<T> concat(Observable<T> other);

        public native Observable<T> concat(Observable<T>... others);
        
        public native Observable<T> count(Function1<T, Boolean> condition);

        public native Observable<Integer> count();

        public native Disposable subscribe(Callback1<T> onNext);

        public native Disposable subscribe(Callback1<T> onNext, Callback1<?> onError);

        public native Disposable subscribe(Callback1<T> onNext, Callback1<?> onError, Callback0 onCompleted);

        public native Disposable subscribe(Observer<T> onbserver);

        public native Disposable subscribe(Observable<T> observable);

        public native Observable<T> debounce(int i);

        public native Observable<T> filter(Function1<T, Boolean> predicate);

        public native <R> Observable<R> flatMap(Function1<? super T, ? extends Observable<? extends R>> func);

        public native <R, RE> Observable<R> flatMapObserver(
                Function2<? super T, Integer, ? extends Observable<? extends R>> next,
                Function1<? super RE, ? extends Observable<? extends R>> error,
                Function0<? extends Observable<? extends R>> complete);

        public native <E> Observable<T> takeUntil(Observable<? extends E> other);

        public native Observable<T> take(int count);

        public native Observable<T> first(Function3<T, Integer, Observable<T>, Boolean> predicate);

        public native Observable<T> doOnNext(Callback1<T> onNext);

        public native Observable<T> doOnError(Callback1<Object> onError);

        public native Observable<T> doOnCompleted(Callback0 onNext);

        @Template("prefix")
        public native Observable<T> $finally(Callback0 object);

        public native Observable<T> distinct();

        public native <K> Observable<T> distinct(Function1<T, K> keySelector);

        public native <K> Observable<T> distinct(Function1<T, K> keySelector, Function2<K, K, Boolean> comparer);

        public native Observable<T> distinctUntilChanged();

        public native <K> Observable<T> distinctUntilChanged(Function1<T, K> keySelector,
                Function2<K, K, Boolean> comparer);

        public native static <T> Observable<T> empty();

        public native Observable<T> onErrorResumeNext(Observable<T> second);

        @Template("prefix")
        public native Observable<T> $catch(Observable<T> second);

        public native Observable<T> repeat();

        public native Observable<T> repeat(int count);

        public native Observable<T> repeatWhen(Function1<Observable<?>, Observable<?>> notifier);
        
        public native Observable<T> retry();
        
        public native Observable<T> retry(int count);

        public native Observable<T> retryWhen(Function1<Observable<?>, Observable<?>> notifier);

        public native Observable<T> delay(long ms);

        public native static Observable<Integer> interval(long l);

        public native static Observable<Long> timer(long msec);
        
        public native static Observable<Long> timer(int dueMsec, int periodMsec);

        public native static Observable<Integer> range(int start, int count);

        @Template("prefix")
        public native static <T> Observable<T> $throw(Object errorNotification);

        public native Observable<T> throttle(long msec);

        public native Observable<T> takeWhile(Function1<T, Boolean> predicate);

        public native static <T> Observable<T> start(Function0<T> func);

        /**
         * accumulator (Function): An accumulator function to be invoked on each
         * element with the following arguments:
         *
         * acc: Any - the accumulated value.
         *
         * currentValue: Any - the current value
         *
         * index: Number - the current index
         *
         * source: Observable - the current observable instance
         *
         * [seed] (Any): The initial accumulator value.
         *
         * @param accumulator
         * @param seed
         * @return
         */

        public native <U> Observable<U> reduce(Function4<U, T, Integer, Observable<T>, U> accumulator, U seed);

        public native <U> Observable<U> reduce(Function2<U, T, U> accumulator, U seed);

        public native Observable<Array<T>> toArray();

        public native Observable<T> timeout(long msec);

        public native Observable<T> takeLast(int count);

        public native Observable<T> max();

        public native Observable<T> scan(Function2<T, T, T> accumulator);

        public native Observable<T> scan(Function4<T, T, Integer, Observable<T>, T> accumulator);

        public native <U> Observable<U> scan(Function2<U, T, U> accumulator, U seed);

        public native <U> Observable<U> scan(Function4<U, T, Integer, Observable<T>, U> accumulator, U seed);

        public native Observable<Array<T>> bufferWithCount(int count, int skip);

        public native Observable<Array<T>> bufferWithTime(int timeSpan);

        public native Observable<Array<T>> bufferWithTime(int timeSpan, int timeShift);

        public native Observable<T> skip(int count);

        public native Observable<T> skipLast(int count);

        public native <U> Observable<U> concatMap(Function1<T, Observable<U>> func);

        public native Observable<T> skipWhile(Function1<T, Boolean> predicate);

        public native <K> Observable<GroupedObservable<K, T>> groupBy(Function1<T, K> keySelector);

        public native Disposable subscribe();

        public native Observable<T> pausable(Observable<Boolean> pauser);

        public native Observable<T> pausableBuffered(Observable<Boolean> pauser);

        public native Observable<T> share();

        public native Observable<T> shareReplay();

        public native <O, R> Observable<R> zip(Observable<O> other, Function2<T, O, R> resultSelector);
        
        public native Observable<T> defaultIfEmpty(T defaultValue);
        
        public native Observable<Boolean> isEmpty();
        
        public native Promise<T> toPromise();
        
        public native Observable<T> ignoreElements();

        public native Observable<T> let(Function1<Observable<T>, Observable<T>> foo);

    }

    public static class GroupedObservable<K, V> extends Observable<V> {

        public K key;

    }

    public static class Subject<T> extends Observable<T> {
        public native void onNext(T var1);

        public native static <T> Subject<T> create(Observer<T> observer, Observable<T> observable);

        public native void onCompleted();

        public native void onError();

    }

    public static class BehaviorSubject<T> extends Subject<T> {
        @Native
        public BehaviorSubject(T initialValue) {

        }

        public native T getValue();

    }
}
