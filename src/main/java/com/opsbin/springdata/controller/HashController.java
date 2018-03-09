package com.opsbin.springdata.controller;

import com.opsbin.springdata.model.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HashController {

    @GetMapping("/hash")
    public String getHash(ModelMap model) {
        Hash hash = new Hash();
        model.addAttribute("hash", hash);
        return "index";
    }

    @RequestMapping(value = "/hash", method = RequestMethod.POST)
    public String postHash(Hash hash, ModelMap model) {
        if (hash != null) {
//            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String hashed = passwordEncoder.encode(hash.getPlainText());
            model.addAttribute("messageSuccess", "Test Test ");
        }
        return "index";
    }
}
