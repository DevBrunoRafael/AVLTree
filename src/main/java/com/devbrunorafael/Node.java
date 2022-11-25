package com.devbrunorafael;

import java.time.LocalDateTime;

public class Node {

    LocalDateTime key;
    String pubDescription;
    int height;
    Node left, right;

    Node(Publication d) {
        key = d.getCreatedAt();
        height = 1;
        pubDescription = d.getDescription();
    }
}