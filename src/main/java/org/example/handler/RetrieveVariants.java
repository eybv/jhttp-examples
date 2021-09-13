package org.example.handler;

import com.github.eybv.jhttp.HttpMethods;
import com.github.eybv.jhttp.MultipartBody;
import com.github.eybv.jhttp.annotation.RequestBody;
import com.github.eybv.jhttp.annotation.RequestHeader;
import com.github.eybv.jhttp.annotation.RequestMapping;
import com.github.eybv.jhttp.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class RetrieveVariants {

    @RequestMapping(method = HttpMethods.GET, path = "/retrieve/header")
    public String header(@RequestHeader("Authorization") String header) {
        return header;
    }

    @RequestMapping(method = HttpMethods.GET, path = "/retrieve/query/single")
    public String singleQueryParams(@RequestParam("category") String category, @RequestParam("sort") String sort) {
        return category + "," + sort;
    }

    @RequestMapping(method = HttpMethods.GET, path = "/retrieve/query/array")
    public List<String> arrayQueryParams(@RequestParam("id") List<String> ids) {
        return ids;
    }

    @RequestMapping(method = HttpMethods.POST, path = "/retrieve/body/text")
    public String textPlain(@RequestBody String body) {
        return body;
    }

    @RequestMapping(method = HttpMethods.POST, path = "/retrieve/body/urlencoded")
    public Map<?, ?> urlEncoded(@RequestBody Map<String, List<String>> body) {
        return body;
    }

    @RequestMapping(method = HttpMethods.POST, path = "/retrieve/body/json")
    public Map<?, ?> json(@RequestBody Map<String, List<String>> body) {
        return body;
    }

    /**
     * Accepts any content type including raw multipart/form-data
     * expect text/plain, application/x-www-urlencoded, application/json.
     */
    @RequestMapping(method = HttpMethods.POST, path = "/retrieve/body/octets")
    public String octetStream(@RequestBody InputStream body) throws IOException {
        return new String(body.readAllBytes());
    }

    @RequestMapping(method = HttpMethods.POST, path = "/retrieve/body/multipart")
    public Object multipart(MultipartBody body) {
        return body.getParts().stream()
                .map(x -> String.format("%s = %s\n", x.getName(), new String(x.getData())))
                .reduce(String::concat)
                .orElseThrow();
    }

}
