package ru.study.study.mapper;

public interface Merger<T,S> {
    T merge(T target, S source);

}
