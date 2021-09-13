package org.example.handler;

import com.github.eybv.jhttp.HttpMethods;
import com.github.eybv.jhttp.annotation.RequestMapping;

import java.util.List;

public class ResponseVariants {

    @RequestMapping(method = HttpMethods.GET, path = "/response/nothing")
    public void nothing() {

    }

    @RequestMapping(method = HttpMethods.GET, path = "/response/numbers")
    public int numbers() {
        return 42;
    }

    @RequestMapping(method = HttpMethods.GET, path = "/response/strings")
    public String strings() {
        return "Hello World :)";
    }

    @RequestMapping(method = HttpMethods.GET, path = "/response/json")
    public DTO json() {
        return new DTO();
    }

    private static class DTO {

        private String entity = "comment";

        private List<Integer> ids = List.of(1, 2, 3);

    }

}
