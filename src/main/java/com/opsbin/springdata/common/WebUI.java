package com.opsbin.springdata.common;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Locale;

@Component
public class WebUI {

    public static final String MESSAGE          = "message";
    public static final String MESSAGE_SUCCESS  = "messageSuccess";
    public static final String MESSAGE_FAIL     = "messageFail";

    @Resource
    private MessageSource messageSource;

    public String getMessage(String code, Object... params) {
        Locale current = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, params, current);
    }

    public void addMessageSuccess(RedirectAttributes redirectAttributes, String code, Object... params) {
        addMessage(redirectAttributes, MESSAGE_SUCCESS, code, params);
    }

    public void addMessageFail(RedirectAttributes redirectAttributes, String code, Object... params) {
        addMessage(redirectAttributes, MESSAGE_FAIL, code, params);
    }

    public void addMessage(RedirectAttributes redirectAttributes, String code, Object... params) {
        addMessage(redirectAttributes, MESSAGE, code, params);
    }

    private void addMessage(RedirectAttributes redirectAttributes, String messageDef, String code, Object... params) {
        String localizedFeedbackMessage = getMessage(code, params);
        if (messageDef == null || messageDef.isEmpty()) {
            redirectAttributes.addFlashAttribute(MESSAGE, localizedFeedbackMessage);
        } else {
            redirectAttributes.addFlashAttribute(messageDef, localizedFeedbackMessage);
        }
    }
}
