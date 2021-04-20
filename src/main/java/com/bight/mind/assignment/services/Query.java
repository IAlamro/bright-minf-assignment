package com.bight.mind.assignment.services;

public interface Query<T, R>{

    R retrieve(T t);
}
