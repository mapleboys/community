package com.example.communication.advice;

import com.example.communication.exception.CustomizeErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomizeErrorException.class)
    @ResponseBody
    ModelAndView handleControllerException(HttpServletRequest request, Model model, Throwable ex) {
        HttpStatus status = getStatus(request);
        //model.addAttribute("message", ex.getMessage());
        ModelAndView error = new ModelAndView("error");
        error.addObject("message", ex.getMessage());
        return error;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}