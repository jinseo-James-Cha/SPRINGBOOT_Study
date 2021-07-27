package com.chap2.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // getter를 생성해 준다
@RequiredArgsConstructor // 선언된 모든 final필드가 포함된 생성자를 만들어줌, final이 없이면 포함하지않는다.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
