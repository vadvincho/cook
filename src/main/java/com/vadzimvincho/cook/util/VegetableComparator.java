package com.vadzimvincho.cook.util;

import com.vadzimvincho.cook.model.vegetable.Vegetable;

import java.util.List;
import java.util.stream.Collectors;

public enum VegetableComparator {
    SORT_BY_CALORIES{
        @Override
        public List<Vegetable> sort(List<Vegetable> vegetables) {
            return vegetables
                    .stream()
                    .sorted((o1, o2) -> Integer.compare(o1.getCalories(), o2.getCalories()))
                    .collect(Collectors.toList());
        }
    },
    SORT_BY_NAME {
        @Override
        public List<Vegetable> sort(List<Vegetable> vegetables) {
            return vegetables
                    .stream()
                    .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                    .collect(Collectors.toList());
        }
    };

    public abstract List<Vegetable> sort(List<Vegetable> vegetables);
}