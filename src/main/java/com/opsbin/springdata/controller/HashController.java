package com.opsbin.springdata.controller;

import com.opsbin.springdata.common.WebUI;
import com.opsbin.springdata.constants.UrlConstants;
import com.opsbin.springdata.model.HashCheck;
import com.opsbin.springdata.model.HashEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HashController extends AbstractController {

    @Autowired
    private WebUI webUI;

    protected static final String VIEW_HOME = "index";

    protected static final String MODEL_ATTRIBUTE_HASH_ENDCODE      = "hashEncode";
    protected static final String MODEL_ATTRIBUTE_HASH_CHECK        = "hashCheck";

    protected static final String FEEDBACK_MESSAGE_HASHED           = "hash.encode.message";
    protected static final String FEEDBACK_MESSAGE_CHECK_SUCCESS    = "hash.check.message.success";
    protected static final String FEEDBACK_MESSAGE_CHECK_FAIL       = "hash.check.message.fail";

    @GetMapping(UrlConstants.HOME)
    public String getHash(Model model) {
        HashEncode hashEncode = new HashEncode();
        HashCheck  hashCheck = new HashCheck();
        model.addAttribute(MODEL_ATTRIBUTE_HASH_ENDCODE, hashEncode);
        model.addAttribute(MODEL_ATTRIBUTE_HASH_CHECK, hashCheck);
        return VIEW_HOME;
    }

    @PostMapping(value = UrlConstants.HASH_GENERATE)
    public String postHashEncode(HashEncode hashEncode, RedirectAttributes attributes) {
        if ((hashEncode != null)) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashed = passwordEncoder.encode(hashEncode.getPlainText());
            webUI.addMessage(attributes, null, FEEDBACK_MESSAGE_HASHED, hashed);
        }
        return redirectTo(UrlConstants.HOME);
    }

    @PostMapping(value = UrlConstants.HASH_CHECK)
    public String postHashCheck(HashCheck hashCheck, RedirectAttributes attributes) {
        if (hashCheck != null) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(hashCheck.getPlainText(), hashCheck.getEncodedText())) {
                webUI.addMessageSuccess(attributes, FEEDBACK_MESSAGE_CHECK_SUCCESS);
            } else {
                webUI.addMessageFail(attributes, FEEDBACK_MESSAGE_CHECK_FAIL);
            }
        }
        return redirectTo(UrlConstants.HOME);
    }

}
