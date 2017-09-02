package com.helloblog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Strlist {
    public static List<Pojo> list = Collections.synchronizedList(new ArrayList<>());
    public static Map<String,String> map = new ConcurrentHashMap<>();
}
