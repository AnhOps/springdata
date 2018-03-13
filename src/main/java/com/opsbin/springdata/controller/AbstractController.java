package com.opsbin.springdata.controller;

public abstract class AbstractController {

    /**
     * Adding redirect pattern to url
     * @param url
     * @return
     */
    protected String redirectTo(String url) {
        return "redirect:" + url;
    }
}
