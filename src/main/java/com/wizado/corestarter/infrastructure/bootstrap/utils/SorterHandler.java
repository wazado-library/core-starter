package com.wizado.corestarter.infrastructure.bootstrap.utils;

import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class SorterHandler {
    public static Sort sortBy(String sorter) {
        if(!StringUtils.hasText(sorter)) {
            return Sort.unsorted();
        }
        String[] split = sorter.split("_");
        if(Objects.equals(split.length, 1)) {
            return Sort.by(split[0]);
        }
        if(Objects.equals(split.length, 2)) {
            String direction = split[1];
            switch (direction.toLowerCase()) {
                case "asc" -> Sort.by(split[0]).ascending();
                case "desc" -> Sort.by(split[0]).descending();
            }
        }
        return Sort.unsorted();
    }
}
