package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList> lists;

}
